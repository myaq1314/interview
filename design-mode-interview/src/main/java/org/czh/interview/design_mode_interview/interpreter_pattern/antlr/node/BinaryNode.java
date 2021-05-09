package org.czh.interview.design_mode_interview.interpreter_pattern.antlr.node;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author : czh
 * description : 二元表达式节点
 * date : 2021-04-19
 * email 916419307@qq.com
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BinaryNode extends Node {

    private Node leftNode;
    private Node rightNode;

}
