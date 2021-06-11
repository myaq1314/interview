## Thread.sleep()

Thread类的静态方法，使当前线程休眠，进入阻塞状态（暂停执行）

如果线程在睡眠状态被中断，将会抛出 InterruptedException 中断异常

a、sleep(long millis) 线程睡眠 millis 毫秒

    在指定的毫秒数内，让当前正在执行的线程休眠（暂停执行），此操作受到系统计时器和调度程序精度和准确性的影响。

b、sleep(long millis, int nanos) 线程睡眠 millis 毫秒 + nanos 纳秒

    在指定的毫秒数加指定的纳秒数内，让当前正在执行的线程休眠（暂停执行），此操作受到系统计时器和调度程序精度和准确度的影响。

使用方法

    在哪个线程里面调用 Thread.sleep() 方法，就阻塞哪个线程。

如果线程是通过继承Thread实现的，可以通过调用Thread.sleep()方法，暂停当前线程

如果线程时通过实现Runnable接口来实现的，不能直接使用Thread.sleep()

    必须使用Thread.currentThread()来得到当前线程的引用才可以调用sleep()

## Thread.sleep() 和 Object.wait() 区别

1、sleep