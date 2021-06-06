package org.czh.interview.commons.annotations.tag;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * @author : czh
 * description :
 * date : 2021-06-01
 * email 916419307@qq.com
 */
@Documented
@Target(PARAMETER)
@Retention(SOURCE)
public @interface ChildLengthTag {

    int min() default 0;

    int max() default Integer.MAX_VALUE;

}