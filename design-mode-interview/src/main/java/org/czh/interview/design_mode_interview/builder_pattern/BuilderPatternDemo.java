package org.czh.interview.design_mode_interview.builder_pattern;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author : czh
 * description :
 * date : 2021-05-06
 * email 916419307@qq.com
 */
public class BuilderPatternDemo {

    public static void main(String[] args) {
        Director director = new Director(new Builder.ConcreteBuilder1());
        Product product1 = director.construct();
        product1.show();

        director.setBuilder(new Builder.ConcreteBuilder2());
        Product product2 = director.construct();
        product2.show();
    }

    /**
     * 产品：客厅
     */
    @Setter
    @ToString
    static class Product {

        private String partA; // 墙
        private String partB; // 电视
        private String partC; // 沙发

        // 显示产品的特性
        public void show() {
            System.out.println(this.toString());
        }
    }

    /**
     * 抽象建造者：装修工人
     */
    public static abstract class Builder {
        // 创建产品对象
        protected Product product = new Product();

        public abstract void buildPartA();

        public abstract void buildPartB();

        public abstract void buildPartC();

        // 返回产品对象
        public Product getResult() {
            return product;
        }

        /**
         * 具体建造者：具体装修工人1
         */
        public static class ConcreteBuilder1 extends Builder {
            public void buildPartA() {
                product.setPartA("建造 PartA1");
            }

            public void buildPartB() {
                product.setPartB("建造 PartB1");
            }

            public void buildPartC() {
                product.setPartC("建造 PartC1");
            }
        }

        /**
         * 具体建造者：具体装修工人2
         */
        public static class ConcreteBuilder2 extends Builder {
            public void buildPartA() {
                product.setPartA("建造 PartA2");
            }

            public void buildPartB() {
                product.setPartB("建造 PartB2");
            }

            public void buildPartC() {
                product.setPartC("建造 PartC2");
            }
        }
    }

    /**
     * 导演：指挥者：项目经理
     */
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Director {

        @Setter
        private Builder builder;

        // 产品构建与组装方法
        public Product construct() {
            builder.buildPartA();
            builder.buildPartB();
            builder.buildPartC();
            return builder.getResult();
        }
    }
}
