# 访问者模式

    将作用于某种数据结构中的各元素的操作分离出来封装成独立的类，
    使其在不改变数据结构的前提下可以添加作用于这些元素的新的操作，
    为数据结构中的每个元素提供多种访问方式。

## 角色

    1、抽象访问者（Visitor）角色：
        定义一个访问具体元素的接口，为每个具体元素类对应一个访问操作 visit() ，该操作中的参数类型标识了被访问的具体元素。
    2、具体访问者（ConcreteVisitor）角色：
        实现抽象访问者角色中声明的各个访问操作，确定访问者访问一个元素时该做什么。
    3、抽象元素（Element）角色：
        声明一个包含接受操作 accept() 的接口，被接受的访问者对象作为 accept() 方法的参数。
    4、具体元素（ConcreteElement）角色：
        实现抽象元素角色提供的 accept() 操作，其方法体通常都是 visitor.visit(this) ，
        另外具体元素中可能还包含本身业务逻辑的相关操作。
    5、对象结构（Object Structure）角色：
        是一个包含元素角色的容器，提供让访问者对象遍历容器中的所有元素的方法，通常由 List、Set、Map 等聚合类实现。

## 场景

    1、对象结构相对稳定，但其操作算法经常变化的程序。
    2、对象结构中的对象需要提供多种不同且不相关的操作，而且要避免让这些操作的变化影响对象的结构。
    3、对象结构包含很多类型的对象，希望对这些对象实施一些依赖于其具体类型的操作。

## 代码

[代码入口](VisitorPatternDemo.java)