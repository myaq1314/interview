package org.czh.interview.design_mode_interview.observer_pattern;

import java.util.Observable;
import java.util.Observer;

/**
 * @author : czh
 * description :
 * date : 2021-05-10
 * email 916419307@qq.com
 */
public class JDKObserverPatternDemo {

    public static void main(String[] args) {
//        Observable observable = new Observable() {
//            @Override
//            public void notifyObservers() {
//                System.out.println("具体目标发生改变...");
//                System.out.println("--------------");
//                super.setChanged();
//                super.notifyObservers();
//            }
//        };
        Observable observable = new ConcreteObservable();

        Observer observer1 = new ConcreteObserver1();
        observable.addObserver(observer1);

        Observer observer2 = new ConcreteObserver2();
        observable.addObserver(observer2);

        observable.notifyObservers();
    }

    public static class ConcreteObservable extends Observable {
        @Override
        public void notifyObservers() {
            System.out.println("具体目标发生改变...");
            System.out.println("--------------");
            super.setChanged();
            super.notifyObservers();
        }
    }

    // 具体观察者1
    static class ConcreteObserver1 implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            System.out.println("具体观察者1作出反应！");
        }
    }

    // 具体观察者2
    static class ConcreteObserver2 implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            System.out.println("具体观察者2作出反应！");
        }
    }
}
