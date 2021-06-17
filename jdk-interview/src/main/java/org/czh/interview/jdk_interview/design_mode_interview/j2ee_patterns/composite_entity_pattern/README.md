# 组合实体 模式

## 角色

    1、组合实体（Composite Entity）
        它是主要的实体 bean。它可以是粗粒的，或者可以包含一个粗粒度对象，用于持续生命周期。
    2、粗粒度对象（Coarse-Grained Object）
        该对象包含依赖对象。它有自己的生命周期，也能管理依赖对象的生命周期。
    3、依赖对象（Dependent Object）
        依赖对象是一个持续生命周期依赖于粗粒度对象的对象。
    4、策略（Strategies） 
        策略表示如何实现组合实体。

## 代码

[代码入口](CompositeEntityPatternDemo.java)
