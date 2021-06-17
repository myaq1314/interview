package org.czh.interview.jdk_interview.design_mode_interview.behavioral_patterns.mediator_pattern;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : czh
 * description :
 * date : 2021-05-09
 * email 916419307@qq.com
 */
public class MediatorPatternDemo {

    public static void main(String[] args) {
        // 中介者
        Mediator mediator = new Mediator.ConcreteMediator();

        // 同事类1
        Colleague colleague1 = new Colleague.ConcreteColleague1();
        mediator.register(colleague1);
        // 同事类2
        Colleague colleague2 = new Colleague.ConcreteColleague2();
        mediator.register(colleague2);
        // 同事类3
        Colleague colleague3 = new Colleague.ConcreteColleague3();
        mediator.register(colleague3);

        // 同事1 发送请求，请求中介者转发
        colleague1.send();
        System.out.println();

        // 同事2 发送请求，请求中介者转发
        colleague2.send();
    }


    // 抽象中介者
    public abstract static class Mediator {
        // 注册
        public abstract void register(Colleague colleague);

        // 转发
        public abstract void relay(Colleague from);

        // 具体中介者
        static class ConcreteMediator extends Mediator {

            private final List<Colleague> colleagues = new ArrayList<>();

            // 注册
            public void register(Colleague colleague) {
                if (!colleagues.contains(colleague)) {
                    colleagues.add(colleague);
                    colleague.setMediator(this);
                }
            }

            // 转发
            public void relay(Colleague from) {
                for (Colleague each : colleagues) {
                    if (!each.equals(from)) {
                        each.receive();
                    }
                }
            }
        }
    }

    // 抽象同事类
    public abstract static class Colleague {

        @Setter
        protected Mediator mediator;

        // 接收
        public abstract void receive();

        // 发送
        public abstract void send();

        // 具体同事类1
        static class ConcreteColleague1 extends Colleague {
            // 接收
            public void receive() {
                System.out.println("具体同事类1收到请求。");
            }

            // 发送
            public void send() {
                System.out.println("具体同事类1发出请求。");
                // 请中介者转发
                mediator.relay(this);
            }
        }

        // 具体同事类2
        static class ConcreteColleague2 extends Colleague {
            // 接收
            public void receive() {
                System.out.println("具体同事类2收到请求。");
            }

            // 发送
            public void send() {
                System.out.println("具体同事类2发出请求。");
                // 请中介者转发
                mediator.relay(this);
            }
        }

        // 具体同事类3
        static class ConcreteColleague3 extends Colleague {
            // 接收
            public void receive() {
                System.out.println("具体同事类3收到请求。");
            }

            // 发送
            public void send() {
                System.out.println("具体同事类3发出请求。");
                // 请中介者转发
                mediator.relay(this);
            }
        }
    }
}
