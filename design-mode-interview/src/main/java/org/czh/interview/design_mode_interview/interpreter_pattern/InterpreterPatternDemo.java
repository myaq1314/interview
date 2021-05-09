package org.czh.interview.design_mode_interview.interpreter_pattern;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : czh
 * description :
 * date : 2021-05-08
 * email 916419307@qq.com
 */
public class InterpreterPatternDemo {

    public static void main(String[] args) {
        Context bus = new Context(new String[]{"韶关", "广州"}, new String[]{"老人", "妇女", "儿童"});
        bus.freeRide("韶关的老人"); // 您是韶关的老人，您本次乘车免费！
        bus.freeRide("韶关的年轻人"); // 韶关的年轻人，您不是免费人员，本次乘车扣费2元！
        bus.freeRide("广州的妇女"); // 您是广州的妇女，您本次乘车免费！
        bus.freeRide("广州的儿童"); // 您是广州的儿童，您本次乘车免费！
        bus.freeRide("山东的儿童"); // 山东的儿童，您不是免费人员，本次乘车扣费2元！

    }

    // 抽象表达式类
    public interface IExpression {
        boolean interpret(String info); // 解释方法

        // 终结符表达式类
        class TerminalExpression implements IExpression {
            private final Set<String> set = new HashSet<>();

            public TerminalExpression(String[] data) {
                set.addAll(Arrays.asList(data));
            }

            public boolean interpret(String info) {
                return set.contains(info);
            }
        }

        // 非终结符表达式类
        @AllArgsConstructor
        class AndExpression implements IExpression {
            private final IExpression city;
            private final IExpression person;

            public boolean interpret(String info) {
                String[] array = info.split("的");
                return city.interpret(array[0]) && person.interpret(array[1]);
            }
        }
    }

    // 环境类
    public static class Context {

        private final IExpression cityPerson;

        public Context(String[] cities, String[] persons) {
            cityPerson = new IExpression.AndExpression(
                    new IExpression.TerminalExpression(cities),
                    new IExpression.TerminalExpression(persons)
            );
        }

        public void freeRide(String info) {
            boolean ok = cityPerson.interpret(info);
            if (ok) {
                System.out.println("您是" + info + "，您本次乘车免费！");
            } else {
                System.out.println(info + "，您不是免费人员，本次乘车扣费2元！");
            }
        }
    }
}
