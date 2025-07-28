package org.czh.interview.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author : CZH
 * description : 树 实体 顶层基类
 * datetime : 2025/7/25
 * email : 916419307@qq.com
 */
@SuppressWarnings("unused")
public interface IBaseTreeEntity<T extends IBaseTreeEntity<T>> extends IBaseEntity {

    List<T> getChildren();

    void setChildren(List<T> children);

    default void addChild(T child) {
        List<T> children = this.getChildren();
        if (children == null) {
            children = new ArrayList<>();
            this.setChildren(children);
        }
        children.add(child);
    }

    default void addChildren(Collection<T> children) {
        if (this.getChildren() == null) {
            setChildren(new ArrayList<>(children));
            return;
        }

        this.getChildren().addAll(children);
    }

    default void addChildren(T[] children) {
        Arrays.stream(children).forEach(this::addChild);
    }
}
