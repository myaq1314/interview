package org.czh.interview.enums;

/**
 * @author : CZH
 * description : 字典 枚举 顶层基类
 * datetime : 2025/7/25
 * email : 916419307@qq.com
 */
@SuppressWarnings("unused")
public interface IDictEnum<K, V> extends IKeyEnum<K> {

    /**
     * 获取 枚举属性
     */
    V getValue();

}
