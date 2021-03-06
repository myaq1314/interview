package org.czh.interview.commons.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.czh.interview.commons.entity.parent.IBaseEntity;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author : czh
 * description :
 * date : 2021-05-02
 * email 916419307@qq.com
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class EntityTest implements IBaseEntity {

    private Long id;
    private String name;
    private int age;
    private Double price;

    @Test
    public void test() {
        Assert.assertEquals(0, new EntityTest().getAge());
    }
}
