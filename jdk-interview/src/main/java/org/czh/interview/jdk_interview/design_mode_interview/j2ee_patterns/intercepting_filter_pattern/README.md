# 拦截过滤器 模式

## 角色

    1、过滤器（Filter）
        过滤器在请求处理程序执行请求之前或之后，执行某些任务。
    2、过滤器链（Filter Chain）
        过滤器链带有多个过滤器，并在 Target 上按照定义的顺序执行这些过滤器。
    3、Target 
        Target 对象是请求处理程序。
    4、过滤管理器（Filter Manager） 
        过滤管理器管理过滤器和过滤器链。
    5、客户端（Client）
        Client 是向 Target 对象发送请求的对象。

## 代码

[代码入口](InterceptingFilterPatternDemo.java)
