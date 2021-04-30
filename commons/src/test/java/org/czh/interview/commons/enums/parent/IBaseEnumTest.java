package org.czh.interview.commons.enums.parent;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author : czh
 * description :
 * date : 2021-04-28
 * email 916419307@qq.com
 */
public class IBaseEnumTest {

    @Test
    public void test() {
        System.out.println(InteriorBaseEnum.NONE);
        System.out.println(InteriorBaseEnum.NONE.getName());
        System.out.println(InteriorBaseEnum.NONE.name());

        Assert.assertEquals(
                "getName() show equals name()",
                InteriorBaseEnum.NONE.getName(),
                InteriorBaseEnum.NONE.name()
        );
    }

    enum InteriorBaseEnum implements IBaseEnum {

        NONE,

        // 预留扩展位
        ;
    }
}
