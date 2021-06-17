package org.czh.interview.jdk_interview.design_mode_interview.j2ee_patterns.transfer_object_pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : czh
 * description :
 * date : 2021-05-10
 * email 916419307@qq.com
 */
public class TransferObjectPatternDemo {

    public static void main(String[] args) {
        StuBO stuBO = new StuBO();

        // 输出所有的学生
        for (StuEO stuEO : stuBO.queryAllStus()) {
            System.out.println("Stu: [RollNo : " + stuEO.getRollNo() + ", Name : " + stuEO.getName() + " ]");
        }

        // 更新学生
        StuEO stuEO = stuBO.queryAllStus().get(0);
        stuEO.setName("Michael");
        stuBO.updateStu(stuEO);

        // 获取学生
        stuBO.getStu(0);
        System.out.println("Stu: [RollNo : " + stuEO.getRollNo() + ", Name : " + stuEO.getName() + " ]");
    }

    // 传输对象
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StuEO {

        private String name;
        private int rollNo;

    }

    // 业务对象
    public static class StuBO {

        // 列表是当作一个数据库
        List<StuEO> stuEOList;

        public StuBO() {
            stuEOList = new ArrayList<>();

            StuEO stu1 = new StuEO("Robert", 0);
            stuEOList.add(stu1);

            StuEO stu2 = new StuEO("John", 1);
            stuEOList.add(stu2);
        }

        @SuppressWarnings("unused")
        public void deleteStu(StuEO stu) {
            stuEOList.remove(stu.getRollNo());
            System.out.println("Stu: Roll No " + stu.getRollNo() + ", deleted from database");
        }

        // 从数据库中检索学生名单
        public List<StuEO> queryAllStus() {
            return stuEOList;
        }

        @SuppressWarnings("unused")
        public StuEO getStu(int rollNo) {
            return stuEOList.get(rollNo);
        }

        public void updateStu(StuEO stu) {
            stuEOList.get(stu.getRollNo()).setName(stu.getName());
            System.out.println("Stu: Roll No " + stu.getRollNo() + ", updated in the database");
        }
    }
}
