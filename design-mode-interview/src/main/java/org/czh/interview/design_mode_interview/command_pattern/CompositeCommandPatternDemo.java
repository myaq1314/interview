package org.czh.interview.design_mode_interview.command_pattern;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : czh
 * description :
 * date : 2021-05-08
 * email 916419307@qq.com
 */
public class CompositeCommandPatternDemo {

    public static void main(String[] args) {
        ICommand.CompositeInvoker invoker = new ICommand.CompositeInvoker();
        invoker.add(new ICommand.ConcreteCommand1());
        invoker.add(new ICommand.ConcreteCommand2());

        invoker.execute();
    }


    // 抽象命令
    public interface ICommand {
        void execute();

        // 树枝构件: 调用者
        class CompositeInvoker implements ICommand {
            private final List<ICommand> children = new ArrayList<>();

            public void add(ICommand c) {
                children.add(c);
            }

            @SuppressWarnings("unused")
            public void remove(ICommand c) {
                children.remove(c);
            }

            @SuppressWarnings("unused")
            public ICommand getChild(int i) {
                return children.get(i);
            }

            public void execute() {
                for (ICommand child : children) {
                    child.execute();
                }
            }
        }

        // 树叶构件: 具体命令1
        @AllArgsConstructor
        class ConcreteCommand1 implements ICommand {

            private final CompositeReceiver receiver;

            ConcreteCommand1() {
                receiver = new CompositeReceiver();
            }

            public void execute() {
                receiver.action1();
            }
        }

        // 树叶构件: 具体命令2
        @AllArgsConstructor
        class ConcreteCommand2 implements ICommand {

            private final CompositeReceiver receiver;

            ConcreteCommand2() {
                receiver = new CompositeReceiver();
            }

            public void execute() {
                receiver.action2();
            }
        }
    }

    // 接收者
    public static class CompositeReceiver {
        public void action1() {
            System.out.println("接收者的action1()方法被调用...");
        }

        public void action2() {
            System.out.println("接收者的action2()方法被调用...");
        }
    }
}
