package org.czh.interview.design_mode_interview.mediator_pattern;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : czh
 * description :
 * date : 2021-05-10
 * email 916419307@qq.com
 */
public class SimpleMediatorPatternDemo {

    public static void main(String[] args) {
        ISimpleColleague c1 = new ISimpleColleague.SimpleConcreteColleague1();
        ISimpleColleague c2 = new ISimpleColleague.SimpleConcreteColleague2();
        @SuppressWarnings("unused")
        ISimpleColleague c3 = new ISimpleColleague.SimpleConcreteColleague3();

        c1.send();
        System.out.println("-----------------");

        c2.send();
        System.out.println("-----------------");
    }


    // 抽象同事类
    public interface ISimpleColleague {

        // 接收
        void receive();

        // 发送
        void send();

        // 具体同事类1
        class SimpleConcreteColleague1 implements ISimpleColleague {

            SimpleConcreteColleague1() {
                SimpleMediator smd = SimpleMediator.getMediator();
                smd.register(this);
            }

            public void receive() {
                System.out.println("具体同事类1：收到请求。");
            }

            public void send() {
                SimpleMediator mediator = SimpleMediator.getMediator();
                System.out.println("具体同事类1：发出请求...");
                mediator.relay(this); //请中介者转发
            }
        }

        // 具体同事类2
        class SimpleConcreteColleague2 implements ISimpleColleague {

            SimpleConcreteColleague2() {
                SimpleMediator smd = SimpleMediator.getMediator();
                smd.register(this);
            }

            public void receive() {
                System.out.println("具体同事类2：收到请求。");
            }

            public void send() {
                SimpleMediator mediator = SimpleMediator.getMediator();
                System.out.println("具体同事类2：发出请求...");
                mediator.relay(this); //请中介者转发
            }
        }

        // 具体同事类3
        class SimpleConcreteColleague3 implements ISimpleColleague {

            SimpleConcreteColleague3() {
                SimpleMediator smd = SimpleMediator.getMediator();
                smd.register(this);
            }

            public void receive() {
                System.out.println("具体同事类3：收到请求。");
            }

            public void send() {
                SimpleMediator mediator = SimpleMediator.getMediator();
                System.out.println("具体同事类3：发出请求...");
                mediator.relay(this); //请中介者转发
            }
        }
    }

    // 简单单例中介者
    public static class SimpleMediator {

        @Getter
        private static final SimpleMediator mediator = new SimpleMediator();
        private final List<ISimpleColleague> colleagues = new ArrayList<>();

        private SimpleMediator() {
        }

        // 注册
        public void register(ISimpleColleague colleague) {
            if (!colleagues.contains(colleague)) {
                colleagues.add(colleague);
            }
        }

        // 转发
        public void relay(ISimpleColleague from) {
            for (ISimpleColleague each : colleagues) {
                if (!each.equals(from)) {
                    each.receive();
                }
            }
        }
    }
}
