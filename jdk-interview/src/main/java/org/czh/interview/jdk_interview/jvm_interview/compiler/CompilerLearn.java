package org.czh.interview.jdk_interview.jvm_interview.compiler;

/**
 * @author : czh
 * description :
 * date : 2021-05-20
 * email 916419307@qq.com
 */
public class CompilerLearn {

    private String name;

    public CompilerLearn(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        CompilerLearn compiler = new CompilerLearn("TOM");
        System.out.println(compiler.toString());
    }

    @Override
    public String toString() {
        return "Animal{"
                + "name='" + name + '\''
                + '}';
    }
}
