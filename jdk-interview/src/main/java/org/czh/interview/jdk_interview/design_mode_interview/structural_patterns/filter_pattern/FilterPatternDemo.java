package org.czh.interview.jdk_interview.design_mode_interview.structural_patterns.filter_pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.czh.interview.commons.entity.parent.IBaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : czh
 * description :
 * date : 2021-05-08
 * email 916419307@qq.com
 */
public class FilterPatternDemo {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        persons.add(new Person("Robert", "Male", "Single"));
        persons.add(new Person("John", "Male", "Married"));
        persons.add(new Person("Laura", "Female", "Married"));
        persons.add(new Person("Diana", "Female", "Single"));
        persons.add(new Person("Mike", "Male", "Single"));
        persons.add(new Person("Bobby", "Male", "Single"));

        IFilter<Person> male = new IFilter.MaleFilter();
        IFilter<Person> female = new IFilter.FemaleFilter();
        IFilter<Person> single = new IFilter.SingleFilter();
        IFilter<Person> singleAndMale = new IFilter.AndFilter(single, male);
        IFilter<Person> singleOrFemale = new IFilter.OrFilter(single, female);

        System.out.println("Males: ");
        printPersons(male.filter(persons));

        System.out.println("\nFemales: ");
        printPersons(female.filter(persons));

        System.out.println("\nSingle Males: ");
        printPersons(singleAndMale.filter(persons));

        System.out.println("\nSingle Or Females: ");
        printPersons(singleOrFemale.filter(persons));
    }

    public static void printPersons(List<Person> persons) {
        for (Person person : persons) {
            System.out.println("Person : [ Name : " + person.getName()
                    + ", Gender : " + person.getGender()
                    + ", Marital Status : " + person.getMaritalStatus()
                    + " ]");
        }
    }

    // 抽象过滤器角色
    public interface IFilter<T extends IBaseEntity> {
        List<T> filter(List<T> sourceList);

        // 具体过滤器角色：男性过滤器
        class MaleFilter implements IFilter<Person> {
            @Override
            public List<Person> filter(List<Person> sourceList) {
                List<Person> targetList = new ArrayList<>();
                for (Person source : sourceList) {
                    if ("MALE".equals(source.getGender())) {
                        targetList.add(source);
                    }
                }
                return targetList;
            }
        }

        // 具体过滤器角色：女性过滤器
        class FemaleFilter implements IFilter<Person> {
            @Override
            public List<Person> filter(List<Person> sourceList) {
                List<Person> targetList = new ArrayList<>();
                for (Person source : sourceList) {
                    if ("Female".equals(source.getGender())) {
                        targetList.add(source);
                    }
                }
                return targetList;
            }
        }

        // 具体过滤器角色：单身过滤器
        class SingleFilter implements IFilter<Person> {
            @Override
            public List<Person> filter(List<Person> sourceList) {
                List<Person> targetList = new ArrayList<>();
                for (Person source : sourceList) {
                    if ("SINGLE".equals(source.getMaritalStatus())) {
                        targetList.add(source);
                    }
                }
                return targetList;
            }
        }

        // 具体过滤器角色：And组合过滤器
        @AllArgsConstructor
        class AndFilter implements IFilter<Person> {

            private final IFilter<Person> criteria;
            private final IFilter<Person> otherCriteria;

            @Override
            public List<Person> filter(List<Person> sourceList) {
                List<Person> resultList = criteria.filter(sourceList);
                return otherCriteria.filter(resultList);
            }
        }

        // 具体过滤器角色：Or组合过滤器
        @AllArgsConstructor
        class OrFilter implements IFilter<Person> {

            private final IFilter<Person> criteria;
            private final IFilter<Person> otherCriteria;

            @Override
            public List<Person> filter(List<Person> sourceList) {
                List<Person> result1List = criteria.filter(sourceList);
                List<Person> result2List = otherCriteria.filter(sourceList);

                for (Person person : result2List) {
                    if (!result1List.contains(person)) {
                        result1List.add(person);
                    }
                }
                return result1List;
            }
        }
    }

    // 被过滤的角色
    @Getter
    @AllArgsConstructor
    public static class Person implements IBaseEntity {

        private final String name;
        private final String gender;
        private final String maritalStatus;

    }
}
