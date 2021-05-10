package org.czh.interview.design_mode_interview.behavioral_patterns.interpreter_pattern.antlr.node;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author : czh
 * description :
 * date : 2021-04-19
 * email 916419307@qq.com
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SymbolNode extends BinaryNode {

    private SymbolDict symbolDict;

}
