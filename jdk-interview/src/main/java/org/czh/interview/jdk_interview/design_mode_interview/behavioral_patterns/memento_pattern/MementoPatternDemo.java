package org.czh.interview.jdk_interview.design_mode_interview.behavioral_patterns.memento_pattern;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : czh
 * description :
 * date : 2021-05-10
 * email 916419307@qq.com
 */
public class MementoPatternDemo {

    public static void main(String[] args) {
        // 发起人
        Originator originator = new Originator();
        originator.setState("S0");
        System.out.println("初始状态:" + originator.getState());

        // 管理者
        Caretaker caretaker = new Caretaker();
        // 管理者管理发起人创建的备忘录，并记录state值
        caretaker.setMemento(originator.createMemento());

        // 发起人，更改state值为S1
        originator.setState("S1");
        System.out.println("新的状态:" + originator.getState());

        // 发起人，通过管理人操作备忘录，回滚state的值
        originator.restoreMemento(caretaker.getMemento());
        System.out.println("恢复状态:" + originator.getState());
    }


    // 备忘录
    @Data
    @AllArgsConstructor
    public static class Memento {

        private String state;

    }

    // 发起人
    @Data
    public static class Originator {

        private String state;

        // 创建备忘录
        public Memento createMemento() {
            return new Memento(state);
        }

        // 回滚备忘录
        public void restoreMemento(Memento memento) {
            this.setState(memento.getState());
        }
    }

    // 管理者
    @Data
    public static class Caretaker {

        private Memento memento;

    }
}
