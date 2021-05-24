
## 步骤
    
    A线程取得锁，执行wait()，释放锁
    B线程取得锁，完成业务后执行notify(),再释放锁
    B线程释放锁之后，A线程取得锁，继续执行wait()之后的代码

## 场景

    线程A wait() 释放锁，等待唤醒
    线程B 获取锁，启动线程C，唤醒线程A，沉睡10秒钟后，释放锁
    线程C 等待锁

### 1、线程A 在 wait() 时做了什么

    ObjectWaiter对象存在于WaitSet、EntryList、cxq等集合中，或者正在这些集合中移动
    
    1.1、将当前线程包装成 ObjectWaiter 对象，状态为 TS_WAIT （使用 jstack -l pid 查看 当前线程状态）
    
    1.2、这个 ObjectWaiter 对象 被放入了 _WaitSet中，_WaitSet 是一个环形双向链表（cicular doubly linked list）

    1.3、当前线程通过 Self->_ParkEvent->park 方法，开始挂起（suspend）

```
"thread-A" #10 prio=5 os_prio=31 tid=0x00007ff09e20d000 nid=0x3c03 in Object.wait() [0x0000700002258000]
   java.lang.Thread.State: WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	- waiting on <0x00000007956c20e0> (a java.lang.Object)
	at java.lang.Object.wait(Object.java:502)
	at org.czh.interview.object_interview.wait.NotifyDemo.lambda$startThreadA$0(NotifyDemo.java:38)
	- locked <0x00000007956c20e0> (a java.lang.Object)
	at org.czh.interview.object_interview.wait.NotifyDemo$$Lambda$1/1595428806.run(Unknown Source)
	at java.lang.Thread.run(Thread.java:748)
```
    
### 2、线程C启动后，由于线程B持有锁，线程C在做什么

    2.1、无锁状态，CAS竞争锁
    2.2、有锁状态，检查是不是当前线程持有，如果是，就继续持有锁（偏向锁）
    2.3、for循环，获取 ObjectMonitor 对象
        重量级锁，就通过 mark->monitor() 方法取得 ObjectMonitor 指针再返回
        处于膨胀中状态（其它线程正在膨胀中），就调用 ReadStableMark() 方法进行等待，执行完毕，再通过continue继续for循环
        轻量级锁，可以开始膨胀了
            锁膨胀就是通过 CAS 将监视器对象 ObjectMonitor 的状态设置为 INFLATING（膨胀中状态），
            如果 CAS 失败，通过continue继续for循环
            如果 CAS 成功，会继续设置 ObjectMonitor 中的 header、owner等字段，
            然后 返回监视器对象 ObjectMonitor
            然后 立刻执行 ObjectMonitor 的 enter 方法，开始竞争锁
    2.4、执行 ObjectMonitor 的 enter 方法，开始竞争锁
        通过 CAS 将 ObjectMonitor 的 _owner 设置为当前线程
        如果设置成功，那么意味着竞争锁成功
        如果设置失败，那么进入无限循环，反复调用 EnterI 方法
    2.5、EnterI 方法
        构造一个 ObjectWaiter对象 node
        在 for(;;) 循环 代码块中用 CAS 将 _cxq 地址放入 node的next，也就是把 node 放到 _cxq 队列的首部
            如果 CAS 失败，就表示其它线程把 node 放入到 _cxq 的首位了，继续for循环
            如果 CAS 成功，此 node 就一定在最新的 _cxq 队列的首位。
    2.6、又一个for循环
        进入循环后，先调用 TryLock 方法，竞争一次锁，
            如果成功了，就退出循环，
            如果失败了，就调用 Self->_ParkEvent->park 方法，使线程挂起。
            如果 park方法带了时间参数，就会在挂起一段时间后自动唤醒，进行自旋锁
            如果 park方法不带参数，就会一直挂起等待被其它条件唤醒
        线程被唤醒后又会执行 TryLock方法，竞争一次锁，竞争不到，就继续这个循环

```
"thread-C" #13 prio=5 os_prio=31 tid=0x00007ff09d933800 nid=0x4203 waiting for monitor entry [0x000070000245e000]
   java.lang.Thread.State: BLOCKED (on object monitor)
	at org.czh.interview.object_interview.wait.NotifyDemo.lambda$startThreadC$2(NotifyDemo.java:66)
	- waiting to lock <0x00000007956c20e0> (a java.lang.Object)
	at org.czh.interview.object_interview.wait.NotifyDemo$$Lambda$3/760211238.run(Unknown Source)
	at java.lang.Thread.run(Thread.java:748)
```

### 3、线程B notify 唤醒线程A时，做了什么
    
    3.1、对Policy赋值，然后 调用 DequeueWaiter() 方法，将_WaitSet队列的第一个值取出并返回
            所有的wait的线程都被包装成ObjectWaiter对象存放在_WaitSet队列里面（详见A线程wait步骤）
        Policy == 0，放入 _EntryList队列的排头位置
        Policy == 1，放入 _EntryList队列的末尾位置
        Policy == 2，_EntryList队列为空就放入 _EntryList，否则放入 _cxq队列的排头位置
        Policy == 3，放入 _cxq队列中末尾位置
        Policy等于其它值，立即唤醒 ObjectWaiter对应的线程

        通过编译JVM源码，打印 Policy的值，Policy 值为 2
            线程A从等待队列 _WaitSet中被取出来，又因为 _EntryList为空，所以A放入了 _EntryList的首位
            BLOCKING状态的线程C 在 _cxq，所以A和C放在不同的队列中。

```
"thread-B" #12 prio=5 os_prio=31 tid=0x00007ff09d011800 nid=0x3e03 waiting on condition [0x000070000235b000]
   java.lang.Thread.State: TIMED_WAITING (sleeping)
	at java.lang.Thread.sleep(Native Method)
	at org.czh.interview.object_interview.wait.NotifyDemo.sleep(NotifyDemo.java:75)
	at org.czh.interview.object_interview.wait.NotifyDemo.lambda$startThreadB$1(NotifyDemo.java:54)
	- locked <0x00000007956c20e0> (a java.lang.Object)
	at org.czh.interview.object_interview.wait.NotifyDemo$$Lambda$2/1043364877.run(Unknown Source)
	at java.lang.Thread.run(Thread.java:748)
```

### 4、线程B释放锁时做了什么

    4.1、偏向锁逻辑
        命中后，偏向次数减一后 直接返回
    4.2、根据QMode的不同，不同的处理方式
        QMode = 2，并且 _cxq非空，取 _cxq队列排头位置的 ObjectWaiter对象，
            调用 ExitEpilog方法，该方法会唤醒 ObjectWaiter对象的线程，立即返回
        QMode = 3，并且 _cxq非空，把 _cxq队列首元素放入 _EntryList 的尾部
        QMode = 4，并且 _cxq非空，把 _cxq队列首元素放入 _EntryList 的头部
        QMode = 0，不做什么
        QMode = 2，提前返回，0、3、4继续向下执行

        如果 _EntryList的首元素非空，就取出来调用 ExitEpilog 方法，该方法会唤醒 ObjectWaiter 对象的线程，立即返回；
        如果 _EntryList的首元素为空，就取 _xcq的首元素，放入 _EntryList，
            然后再从 _EntryList中取出来执行 ExitEpilog方法，该方法会唤醒 ObjectWaiter 对象的线程，立即返回；
        如果取处的元素为空，就执行循环操作

        通过编译JVM源码，打印 QMode 的值，QMode 值为 0
            依次从 _EntryList中取出线程来唤醒，由于 A 放在 _EntryList中，所以 A总是先唤醒

### 5、整体流程
    
    5.1、线程B持有锁
    5.2、线程A在wait的时候被唤醒，进入 _EntryList队列（Policy等于2的逻辑）
    5.3、线程C抢不到锁，进入 _cxq队列；
    5.4、线程B释放锁的时候，从 _EntryList中取出线程A唤醒，A竞争锁（QMode等于0时的逻辑）
    5.5、线程A释放锁的时候，_EntryList中为空，所以从_cxq中取出线程C唤醒，C竞争锁（QMode等于0时的逻辑）


