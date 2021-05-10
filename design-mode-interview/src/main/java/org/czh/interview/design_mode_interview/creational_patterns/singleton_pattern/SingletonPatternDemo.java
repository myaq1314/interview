package org.czh.interview.design_mode_interview.creational_patterns.singleton_pattern;

import lombok.Getter;
import org.czh.interview.commons.validate.EmptyAssert;

/**
 * @author : czh
 * description :
 * date : 2021-05-07
 * email 916419307@qq.com
 */
public class SingletonPatternDemo {

    public static void main(String[] args) {
        President president = President.getInstance("特朗普");
        president.show();

        president = President.getInstance("拜登");
        president.show();
    }

    /**
     * 总统，单例模式
     */
    public static class President {
        private static volatile President instance;
        @Getter
        private final String name;

        private President(String name) {
            System.out.println("选举产生了一个总统！");
            this.name = name;
        }

        public static President getInstance(String name) {
            EmptyAssert.isNotBlank(name);

            if (instance == null) {
                synchronized (President.class) {
                    if (instance == null) {
                        instance = new President(name);
                    }
                }
            } else {
                System.out.println("总统已经选举出来了，不能产生新总统");
            }
            return instance;
        }

        public void show() {
            System.out.printf("大家好，我是 %s\n", this.name);
        }
    }
}
