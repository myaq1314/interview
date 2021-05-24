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
public class PrivateConstructorTest {

    private String name;
    private int age;

    private PrivateConstructorTest() {
    }

    private PrivateConstructorTest(String name) {
        this.name = name;
    }

    private PrivateConstructorTest(String name, int age) {
        this.name = name;
        this.age = age;
    }
}