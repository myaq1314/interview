package org.czh.interview.jdk_interview.design_mode_interview.structural_patterns.decorator_pattern;

import lombok.AllArgsConstructor;

/**
 * @author : czh
 * description :
 * date : 2021-05-07
 * email 916419307@qq.com
 */
public class DecoratorPatternDemo {

    public static void main(String[] args) {
        IComponent p = new IComponent.ConcreteComponent();
        p.operation();
        System.out.println("---------------------------------");

        IComponent d = new IComponent.Decorator.ConcreteDecorator(p);
        d.operation();
        System.out.println("---------------------------------");
    }


    // 抽象构件角色
    public interface IComponent {
        void operation();

        // 具体构件角色
        class ConcreteComponent implements IComponent {
            public ConcreteComponent() {
                System.out.println("创建具体构件角色");
            }

            public void operation() {
                System.out.println("调用具体构件角色的方法operation()");
            }
        }

        // 抽象装饰角色
        @AllArgsConstructor
        class Decorator implements IComponent {
            private final IComponent component;

            public void operation() {
                component.operation();
            }

            // 具体装饰角色
            static class ConcreteDecorator extends Decorator {
                public ConcreteDecorator(IComponent component) {
                    super(component);
                }

                public void operation() {
                    super.operation();
                    addedFunction();
                }

                public void addedFunction() {
                    System.out.println("为具体构件角色增加额外的功能addedFunction()");
                }
            }
        }
    }
}
