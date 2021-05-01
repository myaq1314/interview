package org.czh.interview.commons.entity;

import org.czh.interview.commons.entity.parent.IBaseEntity;
import org.junit.Assert;
import org.junit.Test;

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

    @Test
    default void test() {
        Assert.assertEquals("Person", new PersonTest() {
            @Override
            public void test() {

            }
        }.type());
    }
}
