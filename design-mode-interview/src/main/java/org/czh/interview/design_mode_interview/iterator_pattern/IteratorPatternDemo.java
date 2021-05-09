package org.czh.interview.design_mode_interview.iterator_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : czh
 * description :
 * date : 2021-05-09
 * email 916419307@qq.com
 */
public class IteratorPatternDemo {

    public static void main(String[] args) {
        IAggregate aggregate = new IAggregate.ConcreteAggregate();
        aggregate.add("中山大学");
        aggregate.add("华南理工");
        aggregate.add("韶关学院");
        aggregate.add("济南职业");
        aggregate.add("济宁学院");
        aggregate.add("山东师范");

        System.out.print("聚合的内容有：");

        IIterator iterator = aggregate.getIterator();
        while (iterator.hasNext()) {
            Object ob = iterator.next();
            System.out.print(ob.toString() + "\t");
        }

        Object ob = iterator.first();
        System.out.println("\nFirst：" + ob.toString());

        // 移除 济南职业 学校
        IIterator iterator2 = aggregate.getIterator();
        while (iterator2.hasNext()) {
            Object next = iterator2.next();
            if ("济南职业".equals(next)) {
                iterator2.remove();
                continue;
            }
            System.out.print(next.toString() + "\t");
        }
    }

    // 抽象聚合
    public interface IAggregate {

        void add(Object obj);

        void remove(Object obj);

        IIterator getIterator();

        // 具体聚合
        class ConcreteAggregate implements IAggregate {
            private final List<Object> list = new ArrayList<>();

            public void add(Object obj) {
                list.add(obj);
            }

            public void remove(Object obj) {
                list.remove(obj);
            }

            public IIterator getIterator() {
                return (new IIterator.ConcreteIterator(list));
            }
        }
    }


    // 抽象迭代器
    public interface IIterator {

        Object first();

        Object next();

        boolean hasNext();

        void remove();

        // 具体迭代器
        class ConcreteIterator implements IIterator {

            private final List<Object> list;
            private int index = -1;

            public ConcreteIterator(List<Object> list) {
                this.list = list;
            }

            public boolean hasNext() {
                return index < list.size() - 1;
            }

            public Object first() {
                index = 0;
                return list.get(index);
            }

            public Object next() {
                Object obj = null;
                if (this.hasNext()) {
                    obj = list.get(++index);
                }
                return obj;
            }

            public void remove() {
                this.list.remove(index);
                index--;
            }
        }
    }
}

