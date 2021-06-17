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
public class LucentCompositePatternDemo {

    public static void main(String[] args) {
        IComponent root = new IComponent.Composite("根树枝节点");

        IComponent leaf1 = new IComponent.Leaf("叶子节点1");
        root.add(leaf1);

        IComponent c1 = new IComponent.Composite("树枝节点1");
        root.add(c1);

        IComponent leaf2 = new IComponent.Leaf("树枝节点11");
        c1.add(leaf2);

        IComponent leaf3 = new IComponent.Leaf("树枝节点12");
        c1.add(leaf3);

        root.operation();

    }

    // 抽象构件
    public interface IComponent {
        void add(IComponent c);

        void remove(IComponent c);

        IComponent getChild(int i);

        void operation();

        // 树叶构件
        @AllArgsConstructor
        class Leaf implements IComponent {

            private final String name;

            public void add(IComponent c) {

            }

            public void remove(IComponent c) {

            }

            public IComponent getChild(int i) {
                return null;
            }

            public void operation() {
                System.out.printf("%s 被访问\n", name);
            }
        }

        // 树枝构件
        @AllArgsConstructor
        class Composite implements IComponent {

            private final List<IComponent> children = new ArrayList<>();
            private String name;

            public void add(IComponent c) {
                children.add(c);
            }

            public void remove(IComponent c) {
                children.remove(c);
            }

            public IComponent getChild(int i) {
                return children.get(i);
            }

            public void operation() {
                for (Object obj : children) {
                    ((IComponent) obj).operation();
                }
            }
        }
    }
}
