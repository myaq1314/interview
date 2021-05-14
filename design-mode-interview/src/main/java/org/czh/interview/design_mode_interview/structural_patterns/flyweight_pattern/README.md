# 享元模式

    运用共享技术来有效地支持大量细粒度对象的复用。
    它通过共享已经存在的对象来大幅度减少需要创建的对象数量、避免大量相似类的开销，从而提高系统资源的利用率。

## 角色

    1、抽象享元角色（Flyweight）：
        是所有的具体享元类的基类，为具体享元规范需要实现的公共接口，
        非享元的外部状态以参数的形式通过方法传入。
    2、具体享元（Concrete Flyweight）角色：
        实现抽象享元角色中所规定的接口。
    3、非享元（Unsharable Flyweight)角色：
        是不可以共享的外部状态，它以参数的形式注入具体享元的相关方法中。
    4、享元工厂（Flyweight Factory）角色：
        负责创建和管理享元角色。
        当客户对象请求一个享元对象时，享元工厂检査系统中是否存在符合要求的享元对象，
        如果存在则提供给客户；如果不存在的话，则创建一个新的享元对象。

## 场景

    1、对分层结构系统构建时，使用外观模式定义子系统中每层的入口点可以简化子系统之间的依赖关系。
    2、当一个复杂系统的子系统很多时，外观模式可以为系统设计一个简单的接口供外界访问。
    3、当客户端与多个子系统之间存在很大的联系时，引入外观模式可将它们分离，从而提高子系统的独立性和可移植性。

## 代码

[代码入口](FlyweightPatternDemo.java)