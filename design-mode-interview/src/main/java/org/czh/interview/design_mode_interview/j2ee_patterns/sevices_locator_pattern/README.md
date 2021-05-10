# 服务定位器 模式

## 角色

    1、服务（Service）
        实际处理请求的服务。对这种服务的引用可以在 JNDI 服务器中查找到。
    2、Context / 初始的 Context
        JNDI Context 带有对要查找的服务的引用。
    3、服务定位器（Service Locator）
        服务定位器是通过 JNDI 查找和缓存服务来获取服务的单点接触。
    4、缓存（Cache） 
        缓存存储服务的引用，以便复用它们。
    5、客户端（Client） 
        Client 是通过 ServiceLocator 调用服务的对象。

## 代码

[代码入口](ServicesLocatorPatternDemo.java)
