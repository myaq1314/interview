package org.czh.interview.design_mode_interview.behavioral_patterns.observer_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : czh
 * description :
 * date : 2021-05-10
 * email 916419307@qq.com
 */
public class ObserverPatternDemo {

    public static void main(String[] args) {
        Subject subject = new Subject.ConcreteSubject();

        IObserver observer1 = new IObserver.ConcreteObserver1();
        subject.add(observer1);

        IObserver observer2 = new IObserver.ConcreteObserver2();
        subject.add(observer2);

        subject.notifyObserver();
    }


    // 抽象观察者
    public interface IObserver {
        // 响应
        void response();

        // 具体观察者1
        class ConcreteObserver1 implements IObserver {
            public void response() {
                System.out.println("具体观察者1作出反应！");
            }
        }

        // 具体观察者2
        class ConcreteObserver2 implements IObserver {
            public void response() {
                System.out.println("具体观察者2作出反应！");
            }
        }
    }

    // 抽象目标
    public abstract static class Subject {

        protected List<IObserver> observers = new ArrayList<>();

        // 增加观察者方法
        public void add(IObserver observer) {
            observers.add(observer);
        }

        // 删除观察者方法
        @SuppressWarnings("unused")
        public void remove(IObserver observer) {
            observers.remove(observer);
        }

        //通知观察者方法
        public abstract void notifyObserver();

        // 具体目标
        static class ConcreteSubject extends Subject {
            public void notifyObserver() {
                System.out.println("具体目标发生改变...");
                System.out.println("--------------");
                for (IObserver each : observers) {
                    each.response();
                }
            }
        }
    }
}
