package org.czh.interview.jdk_interview.design_mode_interview.structural_patterns.proxy_pattern;

import lombok.AllArgsConstructor;

import java.lang.reflect.Proxy;

/**
 * @author : czh
 * description :
 * date : 2021-05-07
 * email 916419307@qq.com
 */
public class DynamicProxyPatternDemo {

    public static void main(String[] args) {
        ISubject proxy1 = (ISubject) new DynamicProxy(new ISubject.RealSubject1()).getProxyInstance();
        proxy1.insert();

        ISubject proxy2 = (ISubject) new DynamicProxy(new ISubject.RealSubject2()).getProxyInstance();
        proxy2.insert();
    }

    // 抽象主题
    public interface ISubject {
        void insert();

        // 真实主题1
        class RealSubject1 implements ISubject {
            public void insert() {
                System.out.println("数据1插入数据库...");
            }
        }

        // 真实主题2
        class RealSubject2 implements ISubject {
            public void insert() {
                System.out.println("数据2插入数据库...");
            }
        }
    }

    // 代理类
    @AllArgsConstructor
    public static class DynamicProxy {

        private final Object target;

        public Object getProxyInstance() {
            return Proxy.newProxyInstance(
                    this.target.getClass().getClassLoader(),
                    this.target.getClass().getInterfaces(),
                    (proxy, method, args) -> {
                        preRequest();
                        Object returnValue = method.invoke(target, args);
                        postRequest();
                        return returnValue;
                    }
            );
        }

        public void preRequest() {
            System.out.println("开启事务。");
        }

        public void postRequest() {
            System.out.println("提交事务。");
        }
    }
}
