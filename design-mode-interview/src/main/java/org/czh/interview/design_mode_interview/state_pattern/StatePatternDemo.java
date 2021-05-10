package org.czh.interview.design_mode_interview.state_pattern;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : czh
 * description :
 * date : 2021-05-10
 * email 916419307@qq.com
 */
public class StatePatternDemo {

    public static void main(String[] args) {
        // 创建环境
        Context context = new Context();

        // 处理请求
        context.handle();
        System.out.println();

        context.handle();
        System.out.println();

        context.handle();
        System.out.println();
    }


    // 环境类
    @Data
    @AllArgsConstructor
    public static class Context {

        private State state;

        // 定义环境类的初始状态
        public Context() {
            this.state = new State.ConcreteStateA();
        }

        // 对请求做处理
        public void handle() {
            state.handle(this);
        }
    }

    // 抽象状态类
    public abstract static class State {

        public abstract void handle(Context context);

        // 具体状态A类
        static class ConcreteStateA extends State {
            public void handle(Context context) {
                System.out.println("当前状态是 A.");
                context.setState(new ConcreteStateB());
            }
        }

        // 具体状态B类
        static class ConcreteStateB extends State {
            public void handle(Context context) {
                System.out.println("当前状态是 B.");
                context.setState(new ConcreteStateA());
            }
        }
    }
}
