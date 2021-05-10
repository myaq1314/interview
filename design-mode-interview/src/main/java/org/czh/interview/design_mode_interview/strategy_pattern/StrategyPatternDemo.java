package org.czh.interview.design_mode_interview.strategy_pattern;

import lombok.Data;

/**
 * @author : czh
 * description :
 * date : 2021-05-10
 * email 916419307@qq.com
 */
public class StrategyPatternDemo {

    public static void main(String[] args) {
        // 厨房
        Context context = new Context();

        // 顾客点了清蒸大闸蟹
        // 那么选择 清蒸大闸蟹，制作方法
        IStrategy strategy = new IStrategy.ConcreteStrategyA();
        context.setStrategy(strategy);

        // 厨房制作大闸蟹
        context.strategyMethod();
        System.out.println("-----------------");

        // 顾客点了红烧大闸蟹
        // 那么选择 红烧大闸蟹，制作方法
        strategy = new IStrategy.ConcreteStrategyB();
        context.setStrategy(strategy);

        // 厨房制作大闸蟹
        context.strategyMethod();
    }


    // 抽象策略类 大闸蟹
    public interface IStrategy {
        // 策略方法
        void strategyMethod();

        // 具体策略类A 清蒸大闸蟹
        class ConcreteStrategyA implements IStrategy {
            public void strategyMethod() {
                System.out.println("具体策略A的策略方法被访问！");
            }
        }

        // 具体策略类B 红烧大闸蟹
        class ConcreteStrategyB implements IStrategy {
            public void strategyMethod() {
                System.out.println("具体策略B的策略方法被访问！");
            }
        }
    }

    // 环境类 厨房
    @Data
    public static class Context {

        private IStrategy strategy;

        public void strategyMethod() {
            this.strategy.strategyMethod();
        }
    }

}
