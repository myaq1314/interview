package org.czh.interview.jdk_interview.design_mode_interview.creational_patterns.factory_pattern;

/**
 * @author : czh
 * description :
 * date : 2021-05-06
 * email 916419307@qq.com
 */
public class AbstractFactoryPatternDemo {

    public static void main(String[] args) {
        IFactory factory1 = new IFactory.ConcreteFactory1();
        IProduct1 product11 = factory1.newProduct1();
        product11.show();

        IProduct2 product21 = factory1.newProduct2();
        product21.show();

        IFactory factory2 = new IFactory.ConcreteFactory2();
        IProduct1 product12 = factory2.newProduct1();
        product12.show();

        IProduct2 product22 = factory2.newProduct2();
        product22.show();
    }

    public interface IFactory {
        // 养殖畜牧
        IProduct1 newProduct1();

        // 种植作物
        IProduct2 newProduct2();

        // 韶关农场
        class ConcreteFactory1 implements IFactory {
            @Override
            public IProduct1 newProduct1() {
                System.out.println("韶关农场 培育 肉牛");
                return new IProduct1.ConcreteProduct11();
            }

            @Override
            public IProduct2 newProduct2() {
                System.out.println("韶关农场 种植 蔬菜");
                return new IProduct2.ConcreteProduct21();
            }
        }

        // 上饶农场
        class ConcreteFactory2 implements IFactory {
            @Override
            public IProduct1 newProduct1() {
                System.out.println("上饶农场 培育 肉猪");
                return new IProduct1.ConcreteProduct12();
            }

            @Override
            public IProduct2 newProduct2() {
                System.out.println("上饶农场 种植 水果");
                return new IProduct2.ConcreteProduct22();
            }
        }
    }

    // 畜牧 种类
    public interface IProduct1 {
        void show();

        // 牛类
        class ConcreteProduct11 implements IProduct1 {
            @Override
            public void show() {
                System.out.println("肉牛出栏\n");
            }
        }

        // 猪类
        class ConcreteProduct12 implements IProduct1 {
            @Override
            public void show() {
                System.out.println("肉猪出卷\n");
            }
        }
    }

    // 种植 种类
    public interface IProduct2 {

        void show();

        // 蔬菜
        class ConcreteProduct21 implements IProduct2 {
            @Override
            public void show() {
                System.out.println("蔬菜外销\n");
            }
        }

        // 水果
        class ConcreteProduct22 implements IProduct2 {
            @Override
            public void show() {
                System.out.println("水果自营\n");
            }
        }
    }
}
