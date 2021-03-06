package org.czh.interview.commons.validate;

import org.czh.interview.commons.exceptions.CommonException;
import org.junit.Test;

/**
 * @author : czh
 * description :
 * date : 2021-04-28
 * email 916419307@qq.com
 */
public class MobileAssertTest {

    @Test
    public void test() {
        MobileAssert.isMobile("18354171596");
        try {
            MobileAssert.isMobile("1835417159");
        } catch (CommonException e) {
            FlagAssert.isTrue(e.getMessage().equals("[Assertion failed] - this mobile argument must be a mobile "));
        }
    }
}
