package org.czh.interview.object_interview.hash_equals_to_string;

/**
 * @author : czh
 * description :
 * date : 2021-05-18
 * email 916419307@qq.com
 */
public class ObjectLearn {

    public static void main(String[] args) throws CloneNotSupportedException {
        equalsLearn();
        hashCodeLearn();
        toStringLearn();
        cloneLearn();
    }

    private static void equalsLearn() {
        /*
            重写 equals() 方法情况
         */
        Bean1 bean11 = Bean1.getDefaultBean();
        Bean1 bean12 = Bean1.getDefaultBean();
        System.out.println(bean11.equals(bean12)); // true

        /*
            使用 Object equals() 方法情况
         */
        Bean2 bean21 = Bean2.getDefaultBean();
        Bean2 bean22 = Bean2.getDefaultBean();

        System.out.println(bean21.equals(bean22)); // false
    }

    private static void hashCodeLearn() {
        /*
            重写 hashCode() 方法情况
         */
        Bean1 bean11 = Bean1.getDefaultBean();
        Bean1 bean12 = Bean1.getDefaultBean();
        System.out.println(bean11.hashCode() == bean12.hashCode()); // true

        /*
            使用 Object hashCode() 方法情况
         */
        Bean2 bean21 = Bean2.getDefaultBean();
        Bean2 bean22 = Bean2.getDefaultBean();

        System.out.println(bean21.hashCode() == bean22.hashCode()); // true
    }

    private static void toStringLearn() {
        /*
            重写 toString() 方法情况
         */
        Bean1 bean1 = Bean1.getDefaultBean();
        // Bean1{anInt=1, bInt=2, aFloat=3.0, bFloat=4.1, doubles1=[5.2, 6.3], doubles2=[null, 7.4, 8.5], aList=[true, false, null, true, false], bigDecimal=9.6}
        System.out.println(bean1.toString());

        /*
            使用 Object toString() 方法情况
         */
        Bean2 bean2 = Bean2.getDefaultBean();
        // org.czh.interview.object_interview.hash_equals_to_string.Bean2@2b193f2d
        System.out.println(bean2.toString());
    }

    private static void cloneLearn() throws CloneNotSupportedException {
        Bean1 bean11 = Bean1.getDefaultBean();
        // 深拷贝
        Bean1 bean12 = bean11.clone();
        System.out.println(bean11.equals(bean12)); // true

        // 浅拷贝
        Bean1 bean13 = new Bean1(bean11);
        System.out.println(bean11.equals(bean13)); // true

        // 深拷贝，两个对象，有两个不同的数组
        // 向数组中，更改一个值，再次equals，应该为false
        bean11.getDoubles1()[bean11.getDoubles1().length - 1] = 4.5D;
        System.out.println(bean11.equals(bean12)); // false

        // 浅拷贝，两个对象，关联同一个数组属性
        // 向数组中，更改一个值，再次equals，应该为true
        System.out.println(bean11.equals(bean13)); // true
    }

}
