# CAS (Compare and swap)

比较和替换

简单来说，比较和替换时使用一个期望值和一个变量的当前值进行比较，

如果当前变量的值与我们期望的值相等，就使用一个新值替换当前变量的值。

## check and act 模式

先检查后操作模式

非原子级操作

在代码中首先检查一个变量的值，然后再基于这个值做一些操作。

## 原子级操作

使用 java.util.concurrent.atomic 包中的原子类，进行原子级操作

```java
import java.util.concurrent.atomic.AtomicBoolean;

public static class MyLock {

    private AtomicBoolean locked = new AtomicBoolean(false);

    public boolean lock() {
        return locked.compareAndSet(false, true);
    }

    public boolean unlock() {
        return locked.compareAndSet(true, false);
    }
}
```

## CAS 自旋 volatile 变量

```java
public class AtomicInteger {

    public final int getAndIncrement() {
        for (; ; ) {
            int current = get(); // 取得AtomicInteger存储的数值
            int next = current + 1; // 加1
            if (compareAndSet(current, next)) { // 调用 compareAndSet 执行原子级更新操作
                return current;
            }
        }
    }
}
```


