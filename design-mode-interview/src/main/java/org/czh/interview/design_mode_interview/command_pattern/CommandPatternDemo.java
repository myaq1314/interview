package org.czh.interview.design_mode_interview.command_pattern;

import lombok.AllArgsConstructor;
import lombok.Setter;

/**
 * @author : czh
 * description :
 * date : 2021-05-08
 * email 916419307@qq.com
 */
public class CommandPatternDemo {

    public static void main(String[] args) {
        Invoker invoker = new Invoker(new ICommand.ConcreteCommand());
        invoker.call();
    }

    // 接收者
    interface IReceiver {
        void action();

        class ConcreteReceiver implements IReceiver {
            public void action() {
                System.out.println("接收者的action()方法被调用...");
            }
        }
    }

    // 抽象命令
    interface ICommand {
        void execute();

        // 具体命令
        @AllArgsConstructor
        class ConcreteCommand implements ICommand {

            private final IReceiver receiver;

            public ConcreteCommand() {
                receiver = new IReceiver.ConcreteReceiver();
            }

            public void execute() {
                receiver.action();
            }
        }
    }

    // 调用者
    @Setter
    @AllArgsConstructor
    public static class Invoker {

        private ICommand command;

        public void call() {
            System.out.println("调用者执行命令command...");
            command.execute();
        }
    }
}
