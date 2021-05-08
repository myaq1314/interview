package org.czh.interview.design_mode_interview.filter_pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;

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

        ICriteria male = new ICriteria.CriteriaMale();
        ICriteria female = new ICriteria.CriteriaFemale();
        ICriteria single = new ICriteria.CriteriaSingle();
        ICriteria singleMale = new ICriteria.AndCriteria(single, male);
        ICriteria singleOrFemale = new ICriteria.OrCriteria(single, female);

        System.out.println("Males: ");
        printPersons(male.meetCriteria(persons));

        System.out.println("\nFemales: ");
        printPersons(female.meetCriteria(persons));

        System.out.println("\nSingle Males: ");
        printPersons(singleMale.meetCriteria(persons));

        System.out.println("\nSingle Or Females: ");
        printPersons(singleOrFemale.meetCriteria(persons));
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
    public interface ICriteria {
        List<Person> meetCriteria(List<Person> personList);

        // 具体过滤器角色：男性过滤器
        class CriteriaMale implements ICriteria {
            @Override
            public List<Person> meetCriteria(List<Person> persons) {
                List<Person> malePersons = new ArrayList<>();
                for (Person person : persons) {
                    if (person.getGender().equalsIgnoreCase("MALE")) {
                        malePersons.add(person);
                    }
                }
                return malePersons;
            }
        }

        // 具体过滤器角色：女性过滤器
        class CriteriaFemale implements ICriteria {
            @Override
            public List<Person> meetCriteria(List<Person> persons) {
                List<Person> femalePersons = new ArrayList<>();
                for (Person person : persons) {
                    if (person.getGender().equalsIgnoreCase("FEMALE")) {
                        femalePersons.add(person);
                    }
                }
                return femalePersons;
            }
        }

        // 具体过滤器角色：单身过滤器
        class CriteriaSingle implements ICriteria {
            @Override
            public List<Person> meetCriteria(List<Person> persons) {
                List<Person> singlePersons = new ArrayList<>();
                for (Person person : persons) {
                    if (person.getMaritalStatus().equalsIgnoreCase("SINGLE")) {
                        singlePersons.add(person);
                    }
                }
                return singlePersons;
            }
        }

        // 具体过滤器角色：And组合过滤器
        @AllArgsConstructor
        class AndCriteria implements ICriteria {

            private final ICriteria criteria;
            private final ICriteria otherCriteria;

            @Override
            public List<Person> meetCriteria(List<Person> persons) {
                List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);
                return otherCriteria.meetCriteria(firstCriteriaPersons);
            }
        }

        // 具体过滤器角色：Or组合过滤器
        @AllArgsConstructor
        class OrCriteria implements ICriteria {

            private final ICriteria criteria;
            private final ICriteria otherCriteria;

            @Override
            public List<Person> meetCriteria(List<Person> persons) {
                List<Person> firstCriteriaItems = criteria.meetCriteria(persons);
                List<Person> otherCriteriaItems = otherCriteria.meetCriteria(persons);

                for (Person person : otherCriteriaItems) {
                    if (!firstCriteriaItems.contains(person)) {
                        firstCriteriaItems.add(person);
                    }
                }
                return firstCriteriaItems;
            }
        }
    }

    // 被过滤的角色
    @Getter
    @AllArgsConstructor
    public static class Person {

        private final String name;
        private final String gender;
        private final String maritalStatus;

    }
}
