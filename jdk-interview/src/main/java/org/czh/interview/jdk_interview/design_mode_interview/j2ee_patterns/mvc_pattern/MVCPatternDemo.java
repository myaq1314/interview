package org.czh.interview.jdk_interview.design_mode_interview.j2ee_patterns.mvc_pattern;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : czh
 * description :
 * date : 2021-05-10
 * email 916419307@qq.com
 */
public class MVCPatternDemo {

    public static void main(String[] args) {
        // 从数据库获取学生记录
        Student model = retrieveStudentFromDatabase();

        //创建一个视图：把学生详细信息输出到控制台
        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

        //更新模型数据
        controller.setStudentName("John");

        controller.updateView();
    }

    private static Student retrieveStudentFromDatabase() {
        Student student = new Student();
        student.setName("Robert");
        student.setRollNo("10");
        return student;
    }

    @Data
    public static class Student {

        private String rollNo;
        private String name;

    }

    public static class StudentView {

        public void printStudentDetails(String studentName, String studentRollNo) {
            System.out.println("Student: ");
            System.out.println("Name: " + studentName);
            System.out.println("Roll No: " + studentRollNo);
            System.out.println();
        }
    }

    @SuppressWarnings("unused")
    @AllArgsConstructor
    public static class StudentController {

        private final Student model;
        private final StudentView view;

        public String getStudentName() {
            return model.getName();
        }

        public void setStudentName(String name) {
            model.setName(name);
        }

        public String getStudentRollNo() {
            return model.getRollNo();
        }

        public void setStudentRollNo(String rollNo) {
            model.setRollNo(rollNo);
        }

        public void updateView() {
            view.printStudentDetails(model.getName(), model.getRollNo());
        }
    }
}
