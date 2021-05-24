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
public class PublicConstructorTest {

    private String name;
    private int age;

    public PublicConstructorTest() {
    }

    public PublicConstructorTest(String name) {
        this.name = name;
    }

    public PublicConstructorTest(String name, int age) {
        this.name = name;
        this.age = age;
    }
}