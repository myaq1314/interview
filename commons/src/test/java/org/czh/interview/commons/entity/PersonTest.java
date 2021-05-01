package org.czh.interview.commons.entity;

import org.czh.interview.commons.entity.parent.IBaseEntity;

/**
 * @author : czh
 * description :
 * date : 2021-05-02
 * email 916419307@qq.com
 */
@SuppressWarnings("unused")
public interface PersonTest extends IBaseEntity {

    default String type() {
        return "Person";
    }

}
