# 传输对象 模式

## 角色

    1、业务对象（Business Object）
        为传输对象填充数据的业务服务。
    2、传输对象（Transfer Object）
        简单的 POJO，只有设置/获取属性的方法。
    3、客户端（Client） 
        客户端可以发送请求或者发送传输对象到业务对象。

## 代码

[代码入口](TransferObjectPatternDemo.java)
