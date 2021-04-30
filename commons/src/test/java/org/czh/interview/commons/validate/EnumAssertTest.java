package org.czh.interview.commons.validate;

import org.czh.interview.commons.enums.parent.IBaseEnum;
import org.junit.Test;

/**
 * @author : czh
 * description :
 * date : 2021-04-29
 * email 916419307@qq.com
 */
public class EnumAssertTest {

    @Test
    public void test() {
        EnumAssert.isEnum(TestEnum.class);
        EnumAssert.isNotEnum(Object.class);
    }

    enum TestEnum implements IBaseEnum {
    }

}
