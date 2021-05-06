package org.czh.interview.commons.entity.parent;

import org.czh.interview.commons.validate.EmptyValidate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : czh
 * description :
 * date : 2021-04-30
 * email 916419307@qq.com
 */
public interface IBaseTreeEntity<T extends IBaseTreeEntity<T>> extends IBaseEntity {

    List<T> getChildren();

    void setChildren(List<T> children);

    default void addChild(T t) {
        List<T> children = getChildren();
        if (EmptyValidate.isNull(children)) {
            children = new ArrayList<>();
            setChildren(children);
        }
        children.add(t);
    }
}
