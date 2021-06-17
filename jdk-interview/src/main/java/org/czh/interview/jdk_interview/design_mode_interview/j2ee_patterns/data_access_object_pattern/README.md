# 数据访问对象 模式

## 角色

    1、数据访问对象接口（Data Access Object Interface）
        该接口定义了在一个模型对象上要执行的标准操作。
    2、数据访问对象实体类（Data Access Object concrete class）
        该类实现了上述的接口。该类负责从数据源获取数据，数据源可以是数据库，也可以是 xml，或者是其他的存储机制。
    3、模型对象/数值对象（Model Object/Value Object）
        该对象是简单的 POJO，包含了 get/set 方法来存储通过使用 DAO 类检索到的数据。

## 代码

[代码入口](DataAccessObjectPatternDemo.java)
