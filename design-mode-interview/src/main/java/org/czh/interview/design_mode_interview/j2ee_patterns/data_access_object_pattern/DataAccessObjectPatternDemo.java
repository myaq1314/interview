package org.czh.interview.design_mode_interview.j2ee_patterns.data_access_object_pattern;

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
public class DataAccessObjectPatternDemo {

    public static void main(String[] args) {
        StuDao stuDao = new StuDao.StuDaoImpl();

        // 输出所有的学生
        for (Stu stu : stuDao.queryStuList()) {
            System.out.println("Stu: [RollNo : " + stu.getRollNo() + ", Name : " + stu.getName() + " ]");
        }
        System.out.println();

        // 删除 学号为3 的学生
        stuDao.deleteStu(stuDao.getStu(2));

        for (Stu stu : stuDao.queryStuList()) {
            System.out.println("Stu: [RollNo : " + stu.getRollNo() + ", Name : " + stu.getName() + " ]");
        }
        System.out.println();

        // 更新学生
        Stu stu = stuDao.queryStuList().get(0);
        stu.setName("Michael");
        stuDao.updateStu(stu);

        // 获取学生
        stuDao.getStu(0);
        System.out.println("Stu: [RollNo : " + stu.getRollNo() + ", Name : " + stu.getName() + " ]");
    }


    public interface StuDao {

        List<Stu> queryStuList();

        Stu getStu(int rollNo);

        void updateStu(Stu stu);

        void deleteStu(Stu stu);

        class StuDaoImpl implements StuDao {

            // 列表是当作一个数据库
            List<Stu> stuList;

            public StuDaoImpl() {
                stuList = new ArrayList<>();
                Stu stu1 = new Stu("Robert", 0);
                Stu stu2 = new Stu("John", 1);
                Stu stu3 = new Stu("Tom", 2);
                stuList.add(stu1);
                stuList.add(stu2);
                stuList.add(stu3);
            }

            @Override
            public void deleteStu(Stu stu) {
                stuList.remove(stu.getRollNo());
                System.out.println("Stu: Roll No " + stu.getRollNo() + ", deleted from database");
            }

            //从数据库中检索学生名单
            @Override
            public List<Stu> queryStuList() {
                return stuList;
            }

            @Override
            public Stu getStu(int rollNo) {
                return this.stuList.get(rollNo);
            }

            @Override
            public void updateStu(Stu stu) {
                stuList.get(stu.getRollNo()).setName(stu.getName());
                System.out.println("Stu: Roll No " + stu.getRollNo() + ", updated in the database");
            }
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Stu {

        private String name;
        private int rollNo;

    }
}
