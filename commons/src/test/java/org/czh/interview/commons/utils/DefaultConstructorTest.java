package org.czh.interview.commons.utils;

import lombok.Data;
import lombok.ToString;

/**
 * @author : czh
 * description :
 * date : 2021-05-21
 * email 916419307@qq.com
 */
@Data
@ToString
public class DefaultConstructorTest {

    private String name;
    private int age;

    DefaultConstructorTest() {
    }

    DefaultConstructorTest(String name) {
        this.name = name;
    }

    DefaultConstructorTest(String name, int age) {
        this.name = name;
        this.age = age;
    }
}