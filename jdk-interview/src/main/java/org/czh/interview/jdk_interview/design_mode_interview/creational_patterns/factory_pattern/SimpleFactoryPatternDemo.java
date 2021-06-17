package org.czh.interview.jdk_interview.design_mode_interview.creational_patterns.factory_pattern;

/**
 * @author : czh
 * description :
 * date : 2021-05-06
 * email 916419307@qq.com
 */
public class SimpleFactoryPatternDemo {

    public static void main(String[] args) {
        IProduct product1 = SimpleFactory.makeProduct(1);
        product1.show();

        IProduct product2 = SimpleFactory.makeProduct(2);
        product2.show();
    }

    public interface IProduct {
        void show();

        class ConcreteProduct1 implements IProduct {
            @Override
            public void show() {
                System.out.println("具体产品1\n");
            }
        }

        class ConcreteProduct2 implements IProduct {
            @Override
            public void show() {
                System.out.println("具体产品2\n");
            }
        }
    }

    public static class SimpleFactory {
        public static IProduct makeProduct(int kind) {
            switch (kind) {
                case 1:
                    return new IProduct.ConcreteProduct1();
                case 2:
                    return new IProduct.ConcreteProduct2();
                default:
                    throw new RuntimeException("未知的产品类型");
            }
        }
    }
}
