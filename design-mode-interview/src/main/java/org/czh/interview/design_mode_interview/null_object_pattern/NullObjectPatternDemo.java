package org.czh.interview.design_mode_interview.null_object_pattern;

/**
 * @author : czh
 * description :
 * date : 2021-05-10
 * email 916419307@qq.com
 */
public class NullObjectPatternDemo {

    public static void main(String[] args) {

        AbstractCustomer customer1 = CustomerFactory.getCustomer("Rob");
        AbstractCustomer customer2 = CustomerFactory.getCustomer("Joe");
        AbstractCustomer customer3 = CustomerFactory.getCustomer("Julie");
        AbstractCustomer customer4 = CustomerFactory.getCustomer("Laura");

        System.out.println("Customers");
        System.out.println(customer1.getName());
        System.out.println(customer2.getName());
        System.out.println(customer3.getName());
        System.out.println(customer4.getName());
    }


    public abstract static class AbstractCustomer {

        protected String name;

        public abstract boolean isNil();

        public abstract String getName();

        public static class RealCustomer extends AbstractCustomer {

            public RealCustomer(String name) {
                this.name = name;
            }

            @Override
            public String getName() {
                return name;
            }

            @Override
            public boolean isNil() {
                return false;
            }
        }

        public static class NullCustomer extends AbstractCustomer {

            @Override
            public String getName() {
                return "Not Available in Customer Database";
            }

            @Override
            public boolean isNil() {
                return true;
            }
        }
    }

    public static class CustomerFactory {

        public static final String[] names = {"Rob", "Joe", "Julie"};

        public static AbstractCustomer getCustomer(String name) {
            for (String s : names) {
                if (s.equalsIgnoreCase(name)) {
                    return new AbstractCustomer.RealCustomer(name);
                }
            }
            return new AbstractCustomer.NullCustomer();
        }
    }
}
