package org.czh.interview.design_mode_interview.j2ee_patterns.composite_entity_pattern;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : czh
 * description :
 * date : 2021-05-10
 * email 916419307@qq.com
 */
public class CompositeEntityPatternDemo {

    public static void main(String[] args) {
        Client client = new Client();
        client.setData("Test", "Data");
        client.printData();
        System.out.println();

        client.setData("Second Test", "Data1");
        client.printData();
        System.out.println();
    }


    @Data
    public static class DependentObject1 {

        private String data;

    }

    public static class DependentObject2 {

        @Getter
        @Setter
        private String data;

    }

    // 粗粒度对象
    public static class CoarseGrainedObject {
        DependentObject1 object1 = new DependentObject1();
        DependentObject2 object2 = new DependentObject2();

        public void setData(String data1, String data2) {
            object1.setData(data1);
            object2.setData(data2);
        }

        public String[] getData() {
            return new String[]{object1.getData(), object2.getData()};
        }
    }

    // 组合实体
    public static class CompositeEntity {

        private final CoarseGrainedObject grainedObject = new CoarseGrainedObject();

        public void setData(String data1, String data2) {
            grainedObject.setData(data1, data2);
        }

        public String[] getData() {
            return grainedObject.getData();
        }
    }

    public static class Client {

        private final CompositeEntity compositeEntity = new CompositeEntity();

        public void printData() {
            for (int i = 0; i < compositeEntity.getData().length; i++) {
                System.out.println("Data: " + compositeEntity.getData()[i]);
            }
        }

        public void setData(String data1, String data2) {
            compositeEntity.setData(data1, data2);
        }
    }
}
