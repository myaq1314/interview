package org.czh.interview.commons.entity;

/**
 * @author : czh
 * description :
 * date : 2021-05-02
 * email 916419307@qq.com
 */
@SuppressWarnings("unused")
public interface PersonTest extends java.io.Serializable {

    default String getType() {
        return "Person";
    }

}
