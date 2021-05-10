package org.czh.interview.design_mode_interview.creational_patterns.prototype_pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.czh.interview.commons.validate.EmptyAssert;

/**
 * @author : czh
 * description :
 * date : 2021-05-07
 * email 916419307@qq.com
 */
public class PrototypePatternDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        Citation citation = new Citation("张三", "同学：在2016学年第一学期中表现优秀，被评为三好学生。", new School("山东省枣庄市薛城区", "枣庄八中"));
        citation.display();

        Citation citation1 = new Citation("李四",
                citation.getInfo(),
                new School(citation.getSchool().getAddress(), citation.getSchool().getName())
        );
        citation1.display();

        Citation citation2 = citation.clone();
        citation2.setName("王二");
        citation2.display();

        Citation citation3 = new Citation(citation);
        citation3.setName("麻子");
        citation3.display();
    }

    /**
     * 奖状类
     */
    @Data
    @ToString
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Citation implements Cloneable {

        private String name;
        private String info;
        private School school;

        public Citation(Citation citation) {
            EmptyAssert.isNotNull(citation);

            this.name = citation.name;
            this.info = citation.info;
            this.school = new School(citation.school);
        }

        public void display() {
            System.out.println(name + info + school.getName() + "[" + school.getAddress() + "]");
        }

        public Citation clone() throws CloneNotSupportedException {
            Citation citation = (Citation) super.clone();
            citation.setSchool(this.school.clone());
            return citation;
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class School implements Cloneable {

        private String address;
        private String name;

        public School(School school) {
            EmptyAssert.isNotNull(school);

            this.address = school.address;
            this.name = school.name;
        }

        @Override
        protected School clone() throws CloneNotSupportedException {
            return (School) super.clone();
        }
    }
}
