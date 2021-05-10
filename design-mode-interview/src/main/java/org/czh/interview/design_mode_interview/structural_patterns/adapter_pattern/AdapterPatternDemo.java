package org.czh.interview.design_mode_interview.structural_patterns.adapter_pattern;

import lombok.AllArgsConstructor;

/**
 * @author : czh
 * description :
 * date : 2021-05-07
 * email 916419307@qq.com
 */
public class AdapterPatternDemo {

    public static void main(String[] args) {
        ITarget classAdapter = new ITarget.ClassAdapter();
        classAdapter.request();

        ITarget objectAdapter = new ITarget.ObjectAdapter(new Adaptee());
        objectAdapter.request();
    }


    // 目标接口
    public interface ITarget {
        void request();

        // 类 适配器
        class ClassAdapter extends Adaptee implements ITarget {
            public void request() {
                super.specificRequest();
            }
        }

        // 对象 适配器
        @AllArgsConstructor
        class ObjectAdapter implements ITarget {

            private final Adaptee adaptee;

            public void request() {
                this.adaptee.specificRequest();
            }
        }
    }

    // 适配者接口
    public static class Adaptee {
        public void specificRequest() {
            System.out.println("适配者中的业务代码被调用！");
        }
    }
}
