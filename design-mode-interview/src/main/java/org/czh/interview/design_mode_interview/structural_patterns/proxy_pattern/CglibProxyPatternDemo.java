package org.czh.interview.design_mode_interview.structural_patterns.proxy_pattern;

import lombok.AllArgsConstructor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author : czh
 * description :
 * date : 2021-05-07
 * email 916419307@qq.com
 */
public class CglibProxyPatternDemo {

    public static void main(String[] args) {
        ISubject realSubject1 = (ISubject.RealSubject1) new CglibProxy(new ISubject.RealSubject1()).getProxyInstance();
        realSubject1.insert();

        ISubject realSubject2 = (ISubject.RealSubject2) new CglibProxy(new ISubject.RealSubject2()).getProxyInstance();
        realSubject2.insert();
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

    @AllArgsConstructor
    public static class CglibProxy implements MethodInterceptor {

        private final Object target;

        // 为目标对象创建一个代理对象
        public Object getProxyInstance() {
            // 工具类
            Enhancer enhancer = new Enhancer();
            // 设置父类
            enhancer.setSuperclass(target.getClass());
            // 设置回调函数
            enhancer.setCallback(this);
            // 创建子类
            return enhancer.create();
        }

        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            preRequest();
            Object returnValue = method.invoke(target, args);
            postRequest();
            return returnValue;
        }

        public void preRequest() {
            System.out.println("开启事务。");
        }

        public void postRequest() {
            System.out.println("提交事务。");
        }
    }
}
