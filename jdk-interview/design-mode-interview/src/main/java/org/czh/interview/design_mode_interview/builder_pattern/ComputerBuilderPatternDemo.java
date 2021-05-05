package org.czh.interview.design_mode_interview.builder_pattern;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author : czh
 * description :
 * date : 2021-05-05
 * email 916419307@qq.com
 */
public class ComputerBuilderPatternDemo {

    public static void main(String[] args) {
        Builder builder = new Builder.MacBookBuilder();

        Director director = new Director(builder);
        director.construct("英特尔主板", "Retina显示器");

        System.out.println(builder.build());
    }
}

@ToString
@NoArgsConstructor
abstract class Computer {

    @Setter
    protected String board;
    @Setter
    protected String display;
    protected String os;

    public abstract void setOs();

    @NoArgsConstructor
    static class MacBook extends Computer {
        @Override
        public void setOs() {
            this.os = "Mac OS X 12";
        }
    }

}

abstract class Builder {

    abstract void buildBoard(String board);

    abstract void buildDisplay(String display);

    abstract void buildOs();

    abstract Computer build();

    static class MacBookBuilder extends Builder {
        private final Computer computer = new Computer.MacBook();

        @Override
        void buildBoard(String board) {
            computer.setBoard(board);
        }

        @Override
        void buildDisplay(String display) {
            computer.setDisplay(display);
        }

        @Override
        void buildOs() {
            computer.setOs();
        }

        @Override
        Computer build() {
            return computer;
        }
    }

}

@AllArgsConstructor
class Director {

    Builder builder;

    public void construct(String board, String display) {
        builder.buildDisplay(display);
        builder.buildBoard(board);
        builder.buildOs();
    }
}





