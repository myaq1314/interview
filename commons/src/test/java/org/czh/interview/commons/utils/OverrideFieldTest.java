package org.czh.interview.commons.utils;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.List;

@SuppressWarnings("unused")
interface Earth extends java.io.Serializable {
    default String getType() {
        return "Earth";
    }
}

/**
 * @author : czh
 * description :
 * date : 2021-05-01
 * email 916419307@qq.com
 */
public class OverrideFieldTest {

    @Test
    public void test() {
        List<Field> fields = FieldUtil.queryAllFieldList(City.class);
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }

}

@SuppressWarnings("unused")
class Country implements Earth {
    public String publicField;
    protected String protectedField;
    String defaultField;
    private String privateField;

    public Country(String privateField,
                   String protectedField,
                   String defaultField,
                   String publicField) {
        this.privateField = privateField;
        this.protectedField = protectedField;
        this.defaultField = defaultField;
        this.publicField = publicField;
    }
}

@SuppressWarnings("unused")
class Province extends Country {
    public Double publicField;
    protected Double protectedField;
    Double defaultField;
    private Double privateField;

    public Province(Double privateField,
                    Double protectedField,
                    Double defaultField,
                    Double publicField) {
        super(privateField.toString(), protectedField.toString(), defaultField.toString(), publicField.toString());
        this.privateField = privateField;
        this.protectedField = protectedField;
        this.defaultField = defaultField;
        this.publicField = publicField;
    }
}

@SuppressWarnings("unused")
class City extends Province {
    public Integer publicField;
    protected Integer protectedField;
    Integer defaultField;
    private Integer privateField;

    public City(Integer privateField,
                Integer protectedField,
                Integer defaultField,
                Integer publicField) {
        super(privateField.doubleValue(), protectedField.doubleValue(), defaultField.doubleValue(), publicField.doubleValue());
        this.privateField = privateField;
        this.protectedField = protectedField;
        this.defaultField = defaultField;
        this.publicField = publicField;
    }
}