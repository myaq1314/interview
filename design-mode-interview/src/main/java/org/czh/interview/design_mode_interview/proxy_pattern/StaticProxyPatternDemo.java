package org.czh.interview.design_mode_interview.proxy_pattern;

import lombok.AllArgsConstructor;

/**
 * @author : czh
 * description :
 * date : 2021-05-07
 * email 916419307@qq.com
 */
public class StaticProxyPatternDemo {

    public static void main(String[] args) {
        ISubject proxy = new ISubject.StaticProxy(new ISubject.RealSubject());
        proxy.insert();
    }

    // 抽象主题
    public interface ISubject {
        void insert();

        // 真实主题
        class RealSubject implements ISubject {
            public void insert() {
                System.out.println("插入数据库...");
            }
        }

        // 代理类
        @AllArgsConstructor
        class StaticProxy implements ISubject {

            private final RealSubject realSubject;

            public void insert() {
                preRequest();
                realSubject.insert();
                postRequest();
            }

            public void preRequest() {
                System.out.println("开启事务。");
            }

            public void postRequest() {
                System.out.println("提交事务。");
            }
        }
    }
}
