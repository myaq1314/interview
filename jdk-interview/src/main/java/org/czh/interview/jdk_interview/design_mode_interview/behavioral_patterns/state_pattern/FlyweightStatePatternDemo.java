package org.czh.interview.jdk_interview.design_mode_interview.behavioral_patterns.state_pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : czh
 * description :
 * date : 2021-05-10
 * email 916419307@qq.com
 */
public class FlyweightStatePatternDemo {

    public static void main(String[] args) {
        // 创建环境
        ShareContext context = new ShareContext();
        // 处理请求
        context.handle();
        context.handle();
        context.handle();
        context.handle();
    }

    // 环境类
    public static class ShareContext {

        private final Map<String, ShareState> stateSet = new HashMap<>();
        private ShareState state;

        public ShareContext() {
            state = new ShareState.ConcreteState1();
            stateSet.put("1", state);

            state = new ShareState.ConcreteState2();
            stateSet.put("2", state);

            state = getState("1");
        }

        // 设置新状态
        public void setState(ShareState state) {
            this.state = state;
        }

        // 读取状态
        public ShareState getState(String key) {
            return stateSet.get(key);
        }

        // 对请求做处理
        public void handle() {
            state.handle(this);
        }
    }

    // 抽象状态类
    public abstract static class ShareState {

        public abstract void handle(ShareContext context);

        // 具体状态1类
        static class ConcreteState1 extends ShareState {
            public void handle(ShareContext context) {
                System.out.println("当前状态是： 状态1");
                context.setState(context.getState("2"));
            }
        }

        // 具体状态2类
        static class ConcreteState2 extends ShareState {
            public void handle(ShareContext context) {
                System.out.println("当前状态是： 状态2");
                context.setState(context.getState("1"));
            }
        }
    }
}
