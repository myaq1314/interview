package org.czh.interview.jdk_interview.design_mode_interview.behavioral_patterns.chain_of_responsibility_pattern;

import lombok.Data;
import org.czh.interview.commons.validate.EmptyValidate;

/**
 * @author : czh
 * description :
 * date : 2021-05-08
 * email 916419307@qq.com
 */
public class ChainOfResponsibilityPatternDemo {

    public static void main(String[] args) {

        Handler handler3 = new Handler.ConcreteHandler3();

        Handler handler2 = new Handler.ConcreteHandler2();
        handler2.setNext(handler3);

        Handler handler1 = new Handler.ConcreteHandler1();
        handler1.setNext(handler2);

        handler1.handleRequest(8);

        handler1.handleRequest(31);
    }


    // 抽象处理者角色：领导类
    @Data
    public abstract static class Handler {

        // 下一个处理者
        private Handler next;

        // 处理请求的方法
        public void handleRequest(int leaveDays) {
            if (eligibility(leaveDays)) {
                concreteHandle(leaveDays);
            } else if (EmptyValidate.isNotNull(getNext())) {
                getNext().handleRequest(leaveDays);
            } else {
                System.out.println("请假天数太多，没有人批准该假条！请去找校长，办理休学");
            }
        }

        // 是否满足条件
        abstract boolean eligibility(int leaveDays);

        // 具体处理条件
        abstract void concreteHandle(int leaveDays);

        // 具体处理者角色1：班主任 有权限 批复 3天之内的请假
        public static class ConcreteHandler1 extends Handler {
            @Override
            boolean eligibility(int leaveDays) {
                return leaveDays <= 3;
            }

            @Override
            void concreteHandle(int leaveDays) {
                System.out.println("班主任批准您请假" + leaveDays + "天。");
            }
        }

        // 具体处理者角色2：系主任 有权限 批复 大于3天，小于等于7天的请假
        public static class ConcreteHandler2 extends Handler {
            @Override
            boolean eligibility(int leaveDays) {
                return leaveDays > 3 && leaveDays <= 7;
            }

            @Override
            void concreteHandle(int leaveDays) {
                System.out.println("系主任批准您请假" + leaveDays + "天。");
            }
        }

        // 具体处理者角色3：教导主任 有权限 批复 大于7天，小于等于30天的请假
        public static class ConcreteHandler3 extends Handler {
            @Override
            boolean eligibility(int leaveDays) {
                return leaveDays > 7 && leaveDays <= 30;
            }

            @Override
            void concreteHandle(int leaveDays) {
                System.out.println("教导主任批准您请假" + leaveDays + "天。");
            }
        }
    }
}
