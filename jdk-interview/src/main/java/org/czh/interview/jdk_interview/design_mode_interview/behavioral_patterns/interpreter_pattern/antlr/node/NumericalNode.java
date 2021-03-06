package org.czh.interview.jdk_interview.design_mode_interview.behavioral_patterns.interpreter_pattern.antlr.node;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author : czh
 * description : 数值节点
 * date : 2021-04-19
 * email 916419307@qq.com
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class NumericalNode extends Node {

    private BigDecimal numerical;

    public NumericalNode(String input) {
        super(input);
        this.numerical = new BigDecimal(input);
    }
}
