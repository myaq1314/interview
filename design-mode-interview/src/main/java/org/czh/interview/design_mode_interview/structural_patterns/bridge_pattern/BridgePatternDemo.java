package org.czh.interview.design_mode_interview.structural_patterns.bridge_pattern;

import lombok.AllArgsConstructor;
import lombok.Setter;

/**
 * @author : czh
 * description :
 * date : 2021-05-07
 * email 916419307@qq.com
 */
public class BridgePatternDemo {

    public static void main(String[] args) {
        IImplementorColor implementorYellow = new IImplementorColor.ConcreteImplementorYellow();
        IImplementorColor implementorRed = new IImplementorColor.ConcreteImplementorRed();

        AbstractionBag abstractionWallet = new AbstractionBag.RefinedAbstractionWallet(implementorYellow);
        System.out.printf("%s \n\n", abstractionWallet.getName());


        abstractionWallet.setImplementor(implementorRed);
        System.out.printf("%s \n\n", abstractionWallet.getName());

        AbstractionBag abstractionHandBag = new AbstractionBag.RefinedAbstractionHandBag(implementorYellow);
        System.out.printf("%s \n\n", abstractionHandBag.getName());

        abstractionHandBag.setImplementor(implementorRed);
        System.out.printf("%s \n\n", abstractionHandBag.getName());
    }


    // 实现化角色：颜色
    interface IImplementorColor {
        String getColor();

        // 具体实现化角色：黄色
        class ConcreteImplementorYellow implements IImplementorColor {
            public String getColor() {
                System.out.println("具体实现化(Concrete Implementor)角色被访问");
                return "yellow";
            }
        }

        // 具体实现化角色：红色
        class ConcreteImplementorRed implements IImplementorColor {
            public String getColor() {
                System.out.println("具体实现化(Concrete Implementor)角色被访问");
                return "red";
            }
        }
    }

    // 抽象化角色：包
    @AllArgsConstructor
    static abstract class AbstractionBag {

        @Setter
        protected IImplementorColor implementor;

        public abstract String getName();

        // 扩展抽象化角色：挎包
        static class RefinedAbstractionHandBag extends AbstractionBag {
            protected RefinedAbstractionHandBag(IImplementorColor implementor) {
                super(implementor);
            }

            public String getName() {
                System.out.println("扩展抽象化(Refined Abstraction)角色被访问");
                return implementor.getColor() + "HandBag";
            }
        }

        // 扩展抽象化角色：钱包
        static class RefinedAbstractionWallet extends AbstractionBag {
            protected RefinedAbstractionWallet(IImplementorColor implementor) {
                super(implementor);
            }

            public String getName() {
                System.out.println("扩展抽象化(Refined Abstraction)角色被访问");
                return implementor.getColor() + "Wallet";
            }
        }
    }
}
