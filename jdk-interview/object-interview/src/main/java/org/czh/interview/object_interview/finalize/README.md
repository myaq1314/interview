# finalize

    finalize() 是 Object 中的函数，所有类都拥有的一个函数

    重写了 finalize方法，JVM会在这个对象被GC之前执行对象的 finalize方法。

## 工作原理
    
    一旦垃圾回收器准备释放对象占用的内存空间,将首先调用finalize方法,
    并且在下一次垃圾回收动作发生,才会真正的回收该对象占用的内存,
    也就是finalize方法会在垃圾回收器真正回收对象之前调用

## 流程
    
### f类注册到 Finalizer 

    一个类重写了 finalize() 方法，并且方法体不为空，类加载时JVM会给这个类加上标记，表示这是一个 finalizer类，简称f类
    创建的是 f类对象，默认会在调用构造方法返回之前调用 register 方法，参数就是当前对象
    如果设置了 -XX:-RegisterFinalizersAtInit，会在调用构造方法之前调用 register 方法
    clonse 一个 f类对象，会在clone完成时调用 register 方法。
        Finalizer.register(finalizee) 创建Finalizer对象并加入对象链。

### 守护线程将 Finalizer 加入 ReferenceQueue

    Reference 的 静态代码块会创建一个守护线程 ReferenceHandler，循环执行 tryHandlePending 方法
    tryHandlePending方法 执行时，如果 pending 为空，会调用 lock.wait()，释放锁对象并让线程进入阻塞状态。

    GC时，GC算法会判断对象是否只被 Finalizer类引用了
    如果是，JVM会把 Finalizer对象 赋给 Reference 的 pending属性，并调用 lock.notify()
    守护线程 ReferenceHandler 将被唤醒，将Finalizer对象加入 ReferenceQueue
    
### 守护线程 将 Finalizer 从 ReferenceQueue 中取出，并最终调用 f类自身的 finalize() 方法
    Finalizer 的 静态代码块 会创建一个守护线程 FinalizerThread，
    run方法 会循环从 ReferenceQueue 中 取出 Finalizer对象，执行 runFinalizer() 方法。
    runFinalizer()方法，会将对象传递给本地方法 invokeFinalizeMethod()，最终调用 f类对象自身的 finalize()方法

## 内存泄漏

    对象至少会在第二次GC时才能被回收
    finalizer 可以是对象在被回收之前执行一些 收拾性 的逻辑操作
    f类对象因为 Finalizer的引用而变成了一个临时的强引用，无法被立即回收。
    f类对象只有在 FinalizerThread 守护线程执行完 finalize() 后的下一次GC才能被回收，这期间可能经历多次GC了。
    CPU资源稀缺时，FinalizerThread 有可能因为优先级较低而延迟执行f类对象的finalize()方法。
    因为f类对象的finalize()迟迟没有执行，有可能会导致大部分f对象进入老年代，引发老年代GC甚至full GC，GC暂停时间明显变长。





        
    