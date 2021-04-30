package org.czh.interview.commons.validate;

import org.czh.interview.commons.enums.parent.IBaseEnum;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author : czh
 * description :
 * date : 2021-04-29
 * email 916419307@qq.com
 */
public class EnumValidateTest {

    @Test
    public void test() {
        Assert.assertTrue(EnumValidate.isEnum(TestEnum.class));
        Assert.assertFalse(EnumValidate.isNotEnum(TestEnum.class));
    }

    enum TestEnum implements IBaseEnum {
    }
}
