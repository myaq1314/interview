package org.czh.interview.design_mode_interview.interpreter_pattern.antlr.node;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : czh
 * description : 节点
 * date : 2021-04-19
 * email 916419307@qq.com
 */
@Data
public class Node implements java.io.Serializable {

    private String input;
    private List<Node> children = new ArrayList<>();

    public Node() {
    }

    public Node(String input) {
        this.input = input;
    }

    public void addChild(Node node) {
        this.children.add(node);
    }

    public Node getChild(int index) {
        return this.children.get(index);
    }
}
