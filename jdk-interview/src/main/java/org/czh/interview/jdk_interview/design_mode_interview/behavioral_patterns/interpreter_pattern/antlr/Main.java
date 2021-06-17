package org.czh.interview.jdk_interview.design_mode_interview.behavioral_patterns.interpreter_pattern.antlr;


import org.czh.interview.jdk_interview.design_mode_interview.behavioral_patterns.interpreter_pattern.antlr.parser.OwnEvaluation;

/**
 * @author : czh
 * description :
 * date : 2021-04-20
 * email 916419307@qq.com
 */
public class Main {

    public static void main(String[] args) {
        OwnEvaluation evaluation = new OwnEvaluation();
        System.out.println(evaluation.evaluation("1"));
        System.out.println(evaluation.evaluation("1.2>3&&2.4>1"));
        System.out.println(evaluation.evaluation("1*2"));
        System.out.println(evaluation.evaluation("4/2"));
        System.out.println(evaluation.evaluation("1+2-4/2"));
    }
}
