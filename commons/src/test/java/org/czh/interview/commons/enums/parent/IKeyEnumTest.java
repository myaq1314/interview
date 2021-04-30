package org.czh.interview.commons.enums.parent;

import lombok.Getter;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author : czh
 * description :
 * date : 2021-04-28
 * email 916419307@qq.com
 */
public class IKeyEnumTest {

    @Test
    public void test() {
        System.out.println(InteriorKeyEnum.NONE.getKey());
        System.out.println(InteriorKeyEnum.NONE.key);

        Assert.assertEquals(
                "getKey() show equals key field",
                InteriorKeyEnum.NONE.getKey(),
                InteriorKeyEnum.NONE.key
        );
    }

    enum InteriorKeyEnum implements IKeyEnum<Integer> {

        NONE(0),

        // 预留扩展位
        ;

        @Getter
        public final Integer key;

        InteriorKeyEnum(Integer key) {
            this.key = key;
        }
    }
}
