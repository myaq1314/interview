package org.czh.interview.design_mode_interview.structural_patterns.flyweight_pattern;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : czh
 * description :
 * date : 2021-05-07
 * email 916419307@qq.com
 */
public class FlyweightPatternDemo {

    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();

        IFlyweight f01 = factory.getFlyweight("a");
        IFlyweight f02 = factory.getFlyweight("a");
        IFlyweight f03 = factory.getFlyweight("a");
        IFlyweight f11 = factory.getFlyweight("b");
        IFlyweight f12 = factory.getFlyweight("b");

        f01.operation(new UnsharedConcreteFlyweight("第1次调用a。"));
        f02.operation(new UnsharedConcreteFlyweight("第2次调用a。"));
        f03.operation(new UnsharedConcreteFlyweight("第3次调用a。"));
        f11.operation(new UnsharedConcreteFlyweight("第1次调用b。"));
        f12.operation(new UnsharedConcreteFlyweight("第2次调用b。"));
    }

    // 抽象享元角色
    public interface IFlyweight {
        void operation(UnsharedConcreteFlyweight state);

        // 具体享元角色
        class ConcreteFlyweight implements IFlyweight {
            private final String key;

            ConcreteFlyweight(String key) {
                this.key = key;
                System.out.println("具体享元" + key + "被创建！");
            }

            public void operation(UnsharedConcreteFlyweight outState) {
                System.out.print("具体享元" + key + "被调用，");
                System.out.println("非享元信息是:" + outState.getInfo());
            }
        }
    }

    // 非享元角色
    @Data
    @AllArgsConstructor
    public static class UnsharedConcreteFlyweight {

        private String info;

    }

    // 享元工厂角色
    static class FlyweightFactory {

        private Map<String, IFlyweight> flyweights = new HashMap<>();

        public IFlyweight getFlyweight(String key) {
            IFlyweight flyweight = flyweights.get(key);
            if (flyweight != null) {
                System.out.println("具体享元" + key + "已经存在，被成功获取！");
            } else {
                flyweight = new IFlyweight.ConcreteFlyweight(key);
                flyweights.put(key, flyweight);
            }
            return flyweight;
        }
    }
}
