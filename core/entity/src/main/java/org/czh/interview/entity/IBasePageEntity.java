package org.czh.interview.entity;

/**
 * @author : CZH
 * description : 分页 实体 顶层基类
 * datetime : 2025/7/25
 * email : 916419307@qq.com
 */
@SuppressWarnings("unused")
public interface IBasePageEntity extends IBaseEntity {

    /**
     * 获取当前页码
     */
    Integer getCurrent();

    /**
     * 设置当前页码
     */
    void setCurrent(Integer current);

    /**
     * 获取每页数量
     */
    Integer getSize();

    /**
     * 设置每页数量
     */
    void setSize(Integer size);

}