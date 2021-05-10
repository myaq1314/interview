package org.czh.interview.design_mode_interview.behavioral_patterns.visitor_pattern;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 * @author : czh
 * description :
 * date : 2021-05-10
 * email 916419307@qq.com
 */
public class VisitorPatternDemo {

    public static void main(String[] args) {
        // 元素集合类
        ObjectStructure gather = new ObjectStructure();

        System.out.println("CEO通知人事，让每一个员工去找他汇报这一年的工作");

        // 元素集合类 依次通知每一个元素，要求元素接受访问者访问
        gather.accept(new IVisitor.ConcreteVisitor());

        System.out.println("人事回复CEO，所有员工都已经找他汇报完工作");
    }


    // 抽象访问者
    public interface IVisitor {

        // 访问 元素
        void visit(IElement element);

        // 具体访问者A类:
        class ConcreteVisitor implements IVisitor {
            @Override
            public void visit(IElement element) {
                if (element instanceof IElement.ConcreteElement) {
                    System.out.printf("CEO接收员工 %s 的汇报，并记录：姓名 %s, KPI %s \n",
                            ((IElement.ConcreteElement) element).getName(),
                            ((IElement.ConcreteElement) element).getName(),
                            ((IElement.ConcreteElement) element).getKpi()
                    );
                }
            }
        }
    }

    // 抽象元素类
    public interface IElement {

        // 接受 访问者 访问
        void accept(IVisitor visitor);

        // 具体元素A类
        class ConcreteElement implements IElement {

            @Getter
            private final String name;
            @Getter
            private int kpi;

            public ConcreteElement(String name) {
                this.name = name;
                this.kpi = new Random().nextInt(10); // 随机分配KPI
            }

            @Override
            public void accept(IVisitor visitor) {
                System.out.printf("%s 的KPI是 %s \n", this.name, this.kpi);
                int tmpKpi = this.kpi;
                // 元素本身进行预处理
                while (this.kpi < 6) {
                    this.kpi = new Random().nextInt(10); // 随机分配KPI
                }
                if (this.kpi != tmpKpi) {
                    System.out.printf("%s 将KPI修改成 %s，然后去找CEO \n", this.name, this.kpi);
                }
                // 元素接收访问者访问
                visitor.visit(this);

                if (this.kpi != tmpKpi) {
                    this.kpi = tmpKpi;
                    System.out.printf("%s 从CEO处回来，将KPI恢复成原值 %s\n", this.name, tmpKpi);
                }

                System.out.printf("%s 将结果回复给人事\n", this.name);
            }
        }
    }

    // 对象结构角色：人事，记录公司所有的员工
    public static class ObjectStructure {

        @Getter
        private final Collection<IElement> elements = new ArrayList<>();

        public ObjectStructure() {
            this.elements.add(new IElement.ConcreteElement("工程师A"));
            this.elements.add(new IElement.ConcreteElement("工程师B"));
            this.elements.add(new IElement.ConcreteElement("工程师C"));
            this.elements.add(new IElement.ConcreteElement("工程师D"));
            this.elements.add(new IElement.ConcreteElement("工程师E"));
            this.elements.add(new IElement.ConcreteElement("工程师F"));
            this.elements.add(new IElement.ConcreteElement("工程师G"));
        }

        public void accept(IVisitor visitor) {
            elements.forEach(element -> {
                System.out.printf("人事通知 %s 去找CEO汇报近一年工作情况\n", ((IElement.ConcreteElement) element).getName());
                element.accept(visitor);
                System.out.printf("人事记录 %s 已经汇报完工作，并查看是否还有员工没有去找CEO汇报工作\n", ((IElement.ConcreteElement) element).getName());
                System.out.println("------------------------");
            });
            System.out.println("人事发现所有员工都已经汇报完工作\n");
        }
    }
}
