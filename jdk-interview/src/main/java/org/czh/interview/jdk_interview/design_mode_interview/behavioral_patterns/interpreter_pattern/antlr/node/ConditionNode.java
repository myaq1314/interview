package org.czh.interview.jdk_interview.design_mode_interview.behavioral_patterns.interpreter_pattern.antlr.node;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author : czh
 * description : 条件节点
 * date : 2021-04-19
 * email 916419307@qq.com
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ConditionNode extends Node {

    private Node condition;
    private Node trueCondition;

}
