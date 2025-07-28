package org.czh.interview.enums;

/**
 * @author : CZH
 * description : 单属性 枚举 顶层基类
 * datetime : 2025/7/25
 * email : 916419307@qq.com
 */
@SuppressWarnings("unused")
public interface IKeyEnum<K> extends IBaseEnum {

    /**
     * 获取 枚举编码
     */
    K getKey();

}
