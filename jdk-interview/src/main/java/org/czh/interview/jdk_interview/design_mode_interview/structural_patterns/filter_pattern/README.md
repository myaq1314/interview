# 过滤器模式

    又叫作标准模式

    开发人员使用不同的标准来过滤一组对象，通过逻辑运算以解耦的方式把它们连接起来

## 角色

    1、AbstractFilter（抽象过滤器角色）：
        在客户端可以调用它的方法，在抽象过滤器角色中可以知道相关的（一个或者多个）子系统的功能和责任；
        在正常情况下，它将所有从客户端发来的请求委派到相应的实现类去，传递给相应的实现类对象处理。
    2、ConcreteFilter（具体滤器角色）：
        在客户端可以调用它的方法，在具体滤器角色会对目标对象集合进行逻辑过滤，最后再返回一个过滤后的集合。
    3、Subject（被过滤角色）：
        在软件系统中可以有一个或者多个目标角色，在具体过滤器中会对目标角色进行逻辑处理以查看是否是我想要的。

## 场景

    1、当需要对某一组对象进行筛选的时候（比如女澡堂只让女生进，男澡堂只让男生进）

## 代码

[代码入口](FilterPatternDemo.java)
