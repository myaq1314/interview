package org.czh.interview.design_mode_interview.behavioral_patterns.memento_pattern;

import lombok.Data;

/**
 * @author : czh
 * description :
 * date : 2021-05-10
 * email 916419307@qq.com
 */
public class SimpleMementoPatternDemo {

    public static void main(String[] args) {
        // 发起人
        PrototypeOriginator originator = new PrototypeOriginator();
        originator.setState("S0");
        System.out.println("初始状态:" + originator.getState());

        // 管理者
        PrototypeCaretaker caretaker = new PrototypeCaretaker();
        // 保存状态
        caretaker.setMemento(originator.createMemento());

        originator.setState("S1");
        System.out.println("新的状态:" + originator.getState());

        // 恢复状态
        originator.restoreMemento(caretaker.getMemento());
        System.out.println("恢复状态:" + originator.getState());
    }


    // 发起人原型
    @Data
    public static class PrototypeOriginator implements Cloneable {

        private String state;

        // 创建备忘录
        public PrototypeOriginator createMemento() {
            return this.clone();
        }

        // 回滚备忘录
        public void restoreMemento(PrototypeOriginator memento) {
            this.setState(memento.getState());
        }

        @Override
        public PrototypeOriginator clone() {
            try {
                return (PrototypeOriginator) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException("类OriginatorPrototype拷贝失败");
            }
        }
    }

    // 原型管理者
    @Data
    static class PrototypeCaretaker {
        private PrototypeOriginator memento;
    }

}
