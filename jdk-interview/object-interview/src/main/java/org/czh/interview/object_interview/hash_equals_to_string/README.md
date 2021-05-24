## 1、hashCode

    hashCode 是 Object 中的函数，所有类都拥有的一个函数

    主要返回每个对象的hash值

    主要用于哈希表中，如HashMap、HashTable、HashSet

### 1.1、哈希码 通用约定

    1、在Java程序执行过程中，在一个对象没有被改变的前提下，多次调用hashCode()方法，都会返回相同的整数值。
    2、如果两个对象，使用equals()进行比较并且相同的话，那么这两个对象的hashCode值也必须相同。
    3、根据equals()方法，得到两个对象不相等，那么这两个对象的hashCode值不需要必须不相同。
        但是不相等的两个对象，不同的hashCode值，可以提高哈希表的性能。

### 1.2、哈希码 计算方法

    1、初始值 result = 1;
    2、计算非数组的值的hashCode
        2.1、先拿到非数组的值的hashCode element.hashCode()
        2.2、与上一个步骤的结果 * 31 的值累加
            result = 31 * result + element.hashCode();
            之所以使用31，是因为31 * result 等价于 result << 5 - result，这样计算快速，简单，冲突率低
        2.3、多个非数组的值，重复2步骤
    3、计算数组的值的hashCode result = 31 * result + Arrays.hashCode(aArray); 
        Arrays.hashCode(aArray) 重复 1、2步骤
        多个数组，总是重复1、2步骤，在重复累加2.2步骤

## 2、equals

    equals 是 Object 中的函数，所有类都拥有的一个函数

    主要比较两个对象是否相等

    Object提供的equals()方法，是比较两个对象的内存地址

    我们自己的类，需要重写这个equals()方法，进行值的比较

### 2.1、equals 原则

    1、自反性：
        x.equals(x)   // 结果一定要为 true
    2、对称性：
        x.equals(y) == y.equals(x) // 结果一定要为 true
    3、传递性：
        如果：x.equals(y) == true && y.equals(z) ==  true
        那么：x.equals(z) // 结果一定要为 true
    4、一致性：
        只要对象没有被修改，多次调用 equals() 方法，结果相同
        x.equals(y) == x.equals(y) // 结果一定要为 true
    5、非空性
        对任何不是null的对象，调用 x.equals(null)，
        x.equals(null) // 结果一定要为 false

### 2.2、比较方法

    1、基本数据类型，使用 == 比较两个值
        其中 float 与 double，会使用 compare进行比较，防止 1.0 != 1.00 这种情况发生

    2、包装类型，使用包装类的 重写 equals方法，拆包，再 == 比较两个值
        其中 Float 与 Double，会在拆包后，转化为代表浮点数的位，再 == 比较两个值

    3、数组类型，使用Arrays.equals()方法，先比较是不是同一个数组，再排空，再依次比较每一个值

    4、其它对象，使用重写的equals()方法进行比较，
        如果没有重写，那么最终会使用Object的equals()方法，进行地址比较

## 3、toString

    toString 是 Object 中的函数，所有类都拥有的一个函数

    主要是输出对象的文本格式

    我们自己的类，需要重写这个 toString() 方法，打印或输出我们需要的信息

### 3.1、格式规则

    1、基本数据类型，直接使用
    2、包装类型，及其他的非数组类型，使用重写的 toString() 方法
    3、数组类型，使用 java.util.Arrays.toString(array) 方法
    4、如果没有重写 toString() 方法，那么最终会使用 Object 的 toString() 方法，打印类完整路径 加 地址

## 4、clone

    要重写 clone() 方法，需要实现 java.lang.Cloneable 接口，
        以指示该类的 clone() 方法可以合法的对该类实例进行按字段复制。
        没有实现 java.lang.Cloneable 接口，调用 clone()方法 时，抛出 CloneNotSupporteddException 异常

    除了可以通过重写 clone() 方法可以进行类实例克隆，
    还可以通过复制构造器进行克隆，（clone()方法是native的本地方法，不走构造器）
    具体请看 构造器章节

### 4.1 clone 原则

创建并克隆此对象的一个副本，对于任何对象，需要满足以下几点

    1、x.clone() != x // 地址不同的两个对象
    2、x.clone().getClass() == x.getClass() // 同属一个类
    3、x.clone().equals(x) // 一般情况为true，但不是必须要满足的要求
