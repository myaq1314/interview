package org.czh.interview.jdk_interview.design_mode_interview.structural_patterns.composite_pattern;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : czh
 * description :
 * date : 2021-05-07
 * email 916419307@qq.com
 */
public class SafetyCompositePatternDemo {

    public static void main(String[] args) {
        IComponent.AbstractComposite root = new IComponent.AbstractComposite.Composite("根树枝节点");

        IComponent leaf1 = new IComponent.Leaf("叶子节点1");
        root.add(leaf1);

        IComponent.AbstractComposite c1 = new IComponent.AbstractComposite.Composite("树枝节点1");
        root.add(c1);

        IComponent leaf2 = new IComponent.Leaf("树枝节点11");
        c1.add(leaf2);

        IComponent leaf3 = new IComponent.Leaf("树枝节点12");
        c1.add(leaf3);

        root.operation();
    }

    // 抽象构件
    public interface IComponent {

        void operation();

        abstract class AbstractComposite implements IComponent {

            private final List<IComponent> children = new ArrayList<>();

            public void add(IComponent component) {
                children.add(component);
            }

            public void remove(IComponent component) {
                children.remove(component);
            }

            public IComponent getChild(int index) {
                return children.get(index);
            }

            public void operation() {
                children.forEach(IComponent::operation);
            }

            // 树枝构件
            @AllArgsConstructor
            static
            class Composite extends AbstractComposite implements IComponent {

                private String name;

            }
        }

        // 树叶构件
        @AllArgsConstructor
        class Leaf implements IComponent {

            private final String name;

            public void operation() {
                System.out.printf("%s 被访问\n", name);
            }
        }
    }
}
