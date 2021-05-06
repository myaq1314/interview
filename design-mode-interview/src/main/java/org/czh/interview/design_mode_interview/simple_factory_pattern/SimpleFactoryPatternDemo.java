package org.czh.interview.design_mode_interview.simple_factory_pattern;

/**
 * @author : czh
 * description :
 * date : 2021-05-05
 * email 916419307@qq.com
 */
public class SimpleFactoryPatternDemo {

    public static void main(String[] args) {
        IProduct product1 = SimpleFactory.makeProduct(Const.PRODUCT1);
        assert product1 != null;
        product1.show();

        IProduct product2 = SimpleFactory.makeProduct(Const.PRODUCT2);
        assert product2 != null;
        product2.show();
    }

    // 抽象产品
    public interface IProduct {
        void show();
    }

    // 具体产品1
    public static class ConcreteProduct1 implements IProduct {
        public void show() {
            System.out.println("具体产品1显示...");
        }
    }

    // 具体产品2
    public static class ConcreteProduct2 implements IProduct {
        public void show() {
            System.out.println("具体产品2显示...");
        }
    }

    // 枚举，标识产品1、产品2的类型
    public static final class Const {
        public static final int PRODUCT1 = 0;
        public static final int PRODUCT2 = 1;
    }

    static class SimpleFactory {
        public static IProduct makeProduct(int kind) {
            switch (kind) {
                case Const.PRODUCT1:
                    return new ConcreteProduct1();
                case Const.PRODUCT2:
                    return new ConcreteProduct2();
            }
            return null;
        }
    }
}
