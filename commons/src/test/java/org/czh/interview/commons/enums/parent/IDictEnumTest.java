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
public class IDictEnumTest {

    @Test
    public void test() {
        System.out.println(InteriorDictEnum.NONE.getValue());
        System.out.println(InteriorDictEnum.NONE.value);

        Assert.assertEquals(
                "getValue() show equals value field",
                InteriorDictEnum.NONE.getValue(),
                InteriorDictEnum.NONE.value
        );
    }

    enum InteriorDictEnum implements IDictEnum<Integer, String> {

        NONE(0, "Value"),

        // 预留扩展位
        ;

        @Getter
        public final Integer key;
        @Getter
        public final String value;

        InteriorDictEnum(Integer key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
