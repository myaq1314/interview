package org.czh.interview.design_mode_interview.structural_patterns.adapter_pattern;

/**
 * @author : czh
 * description :
 * date : 2021-05-07
 * email 916419307@qq.com
 */
public class TwoWayAdapterPatternDemo {

    public static void main(String[] args) {
        System.out.println("目标通过双向适配器访问适配者：");
        TwoWayAdapter targetAdapter = new TwoWayAdapter(new ITwoWayAdaptee.AdapteeRealize());
        targetAdapter.request();
        System.out.println("-------------------");

        System.out.println("适配者通过双向适配器访问目标：");
        TwoWayAdapter adapteeAdapter = new TwoWayAdapter(new ITwoWayTarget.TargetRealize());
        adapteeAdapter.specificRequest();
        System.out.println("-------------------");

    }

    /**
     * 目标接口
     */
    interface ITwoWayTarget {
        void request();

        /**
         * 目标实现
         */
        class TargetRealize implements ITwoWayTarget {
            public void request() {
                System.out.println("目标代码被调用！");
            }
        }
    }

    /**
     * 适配者接口
     */
    interface ITwoWayAdaptee {
        void specificRequest();

        /**
         * 适配者实现
         */
        class AdapteeRealize implements ITwoWayAdaptee {
            public void specificRequest() {
                System.out.println("适配者代码被调用！");
            }
        }
    }

    /**
     * 双向适配器
     */
    static class TwoWayAdapter implements ITwoWayTarget, ITwoWayAdaptee {

        private ITwoWayTarget target;
        private ITwoWayAdaptee adaptee;

        public TwoWayAdapter(ITwoWayTarget target) {
            this.target = target;
        }

        public TwoWayAdapter(ITwoWayAdaptee adaptee) {
            this.adaptee = adaptee;
        }

        public void request() {
            adaptee.specificRequest();
        }

        public void specificRequest() {
            target.request();
        }
    }
}
