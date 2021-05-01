package org.czh.interview.reflect_interview;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

@SuppressWarnings("unused")
interface Person extends java.io.Serializable {
    default String getType() {
        return "Person";
    }
}

/**
 * @author : czh
 * description :
 * date : 2021-04-30
 * email 916419307@qq.com
 */
public class FieldUtilTest {

    Parent parent;
    Son son;
    Grandson grandson;

    @Before
    public void create() {
        parent = new Parent(
                "p_parentPrivateField",
                "p_parentProtectedField",
                "p_parentDefaultField",
                "p_parentPublicField"
        );

        son = new Son(
                "s_parentPrivateField",
                "s_parentProtectedField",
                "s_parentDefaultField",
                "s_parentPublicField",
                "s_sonPrivateField",
                "s_sonProtectedField",
                "s_sonDefaultField",
                "s_sonPublicField"
        );

        grandson = new Grandson(
                "g_parentPrivateField",
                "g_parentProtectedField",
                "g_parentDefaultField",
                "g_parentPublicField",
                "g_sonPrivateField",
                "g_sonProtectedField",
                "g_sonDefaultField",
                "g_sonPublicField",
                "g_grandsonPrivateField",
                "g_grandsonProtectedField",
                "g_grandsonDefaultField",
                "g_grandsonPublicField"
        );
    }

    @Test
    public void fieldTest() {
        Class<? extends Parent> parentClazz = parent.getClass();
        System.out.println("\n----------------- parentClazz getDeclaredFields -----------------");
        Field[] parentDeclaredFields = parentClazz.getDeclaredFields();
        // parentPrivateField	parentProtectedField	parentDefaultField	parentPublicField
        Arrays.stream(parentDeclaredFields).map(Field::getName).forEach(s -> System.out.print(s + "\t"));
        System.out.println("\n----------------- parentClazz getFields -----------------");
        Field[] parentFields = parentClazz.getFields();
        // parentPublicField
        Arrays.stream(parentFields).map(Field::getName).forEach(s -> System.out.print(s + "\t"));
        System.out.println("\n----------------- parentClazz getAllFields -----------------");
        Field[] parentAllFields = FieldUtils.getAllFields(parentClazz);
        // parentPrivateField	parentProtectedField	parentDefaultField	parentPublicField
        Arrays.stream(parentAllFields).map(Field::getName).forEach(s -> System.out.print(s + "\t"));

        Class<? extends Son> sonClazz = son.getClass();
        System.out.println("\n----------------- sonClazz getDeclaredFields -----------------");
        Field[] sonDeclaredFields = sonClazz.getDeclaredFields();
        // sonPrivateField	sonProtectedField	sonDefaultField	sonPublicField
        Arrays.stream(sonDeclaredFields).map(Field::getName).forEach(s -> System.out.print(s + "\t"));
        System.out.println("\n----------------- sonClazz getFields -----------------");
        Field[] sonFields = sonClazz.getFields();
        // sonPublicField	parentPublicField
        Arrays.stream(sonFields).map(Field::getName).forEach(s -> System.out.print(s + "\t"));
        System.out.println("\n----------------- sonClazz getAllFields -----------------");
        Field[] sonAllFields = FieldUtils.getAllFields(sonClazz);
        // sonPrivateField	sonProtectedField	sonDefaultField	sonPublicField
        // parentPrivateField	parentProtectedField	parentDefaultField	parentPublicField
        Arrays.stream(sonAllFields).map(Field::getName).forEach(s -> System.out.print(s + "\t"));

        Class<? extends Grandson> grandsonClazz = grandson.getClass();
        System.out.println("\n----------------- grandsonClazz getDeclaredFields -----------------");
        Field[] grandsonDeclaredFields = grandsonClazz.getDeclaredFields();
        // grandsonPrivateField	grandsonProtectedField	grandsonDefaultField	grandsonPublicField
        Arrays.stream(grandsonDeclaredFields).map(Field::getName).forEach(s -> System.out.print(s + "\t"));
        System.out.println("\n----------------- grandsonClazz getFields -----------------");
        Field[] grandsonFields = grandsonClazz.getFields();
        // grandsonPublicField	sonPublicField	parentPublicField
        Arrays.stream(grandsonFields).map(Field::getName).forEach(s -> System.out.print(s + "\t"));
        System.out.println("\n----------------- grandsonClazz getAllFields -----------------");
        Field[] grandsonAllFields = FieldUtils.getAllFields(grandsonClazz);
        // grandsonPrivateField	grandsonProtectedField	grandsonDefaultField	grandsonPublicField
        // sonPrivateField	sonProtectedField	sonDefaultField	sonPublicField
        // parentPrivateField	parentProtectedField	parentDefaultField	parentPublicField
        Arrays.stream(grandsonAllFields).map(Field::getName).forEach(s -> System.out.print(s + "\t"));
    }

    @Test
    public void methodTest() {
        Class<? extends Parent> parentClazz = parent.getClass();
        System.out.println("\n----------------- parentClazz getDeclaredMethods -----------------");
        Method[] parentDeclaredMethods = parentClazz.getDeclaredMethods();
        // getParentPrivateMethod	getParentProtectedMethod	getParentDefaultMethod	getParentPublicMethod
        Arrays.stream(parentDeclaredMethods).map(Method::getName).forEach(s -> System.out.print(s + "\t"));
        System.out.println("\n----------------- parentClazz getMethods -----------------");
        Method[] parentMethods = parentClazz.getMethods();
        // getParentPublicMethod	wait	wait	wait	equals	toString	hashCode	getClass	notify	notifyAll	getType
        Arrays.stream(parentMethods).map(Method::getName).forEach(s -> System.out.print(s + "\t"));

        Class<? extends Son> sonClazz = son.getClass();
        System.out.println("\n----------------- sonClazz getDeclaredMethods -----------------");
        Method[] sonDeclaredMethods = sonClazz.getDeclaredMethods();
        // getSonPrivateMethod	getSonProtectedMethod	getSonDefaultMethod	getSonPublicMethod
        Arrays.stream(sonDeclaredMethods).map(Method::getName).forEach(s -> System.out.print(s + "\t"));
        System.out.println("\n----------------- sonClazz getMethods -----------------");
        Method[] sonMethods = sonClazz.getMethods();
        // getSonPublicMethod	getParentPublicMethod	wait	wait	wait	equals	toString	hashCode	getClass	notify	notifyAll	getType
        Arrays.stream(sonMethods).map(Method::getName).forEach(s -> System.out.print(s + "\t"));

        Class<? extends Grandson> grandsonClazz = grandson.getClass();
        System.out.println("\n----------------- grandsonClazz getDeclaredMethods -----------------");
        Method[] grandsonDeclaredMethods = grandsonClazz.getDeclaredMethods();
        // getGrandsonPrivateMethod	getGrandsonProtectedMethod	getGrandsonDefaultMethod	getGrandsonPublicMethod
        Arrays.stream(grandsonDeclaredMethods).map(Method::getName).forEach(s -> System.out.print(s + "\t"));
        System.out.println("\n----------------- grandsonClazz getMethods -----------------");
        Method[] grandsonMethods = grandsonClazz.getMethods();
        // getGrandsonPublicMethod	getSonPublicMethod	getParentPublicMethod	wait	wait	wait	equals	toString	hashCode	getClass	notify	notifyAll	getType
        Arrays.stream(grandsonMethods).map(Method::getName).forEach(s -> System.out.print(s + "\t"));
    }
}

@SuppressWarnings("unused")
class Parent implements Person {
    public String parentPublicField;
    protected String parentProtectedField;
    String parentDefaultField;
    private String parentPrivateField;

    public Parent(String parentPrivateField,
                  String parentProtectedField,
                  String parentDefaultField,
                  String parentPublicField) {
        this.parentPrivateField = parentPrivateField;
        this.parentProtectedField = parentProtectedField;
        this.parentDefaultField = parentDefaultField;
        this.parentPublicField = parentPublicField;
    }

    private String getParentPrivateMethod() {
        return "parentPrivateMethod";
    }

    protected String getParentProtectedMethod() {
        return "parentProtectedMethod";
    }

    String getParentDefaultMethod() {
        return "parentDefaultMethod";
    }

    public String getParentPublicMethod() {
        return "parentPublicMethod";
    }

}

@SuppressWarnings("unused")
class Son extends Parent {
    public String sonPublicField;
    protected String sonProtectedField;
    String sonDefaultField;
    private String sonPrivateField;

    public Son(String parentPrivateField,
               String parentProtectedField,
               String parentDefaultField,
               String parentPublicField,
               String sonPrivateField,
               String sonProtectedField,
               String sonDefaultField,
               String sonPublicField) {
        super(parentPrivateField, parentProtectedField, parentDefaultField, parentPublicField);
        this.sonPrivateField = sonPrivateField;
        this.sonProtectedField = sonProtectedField;
        this.sonDefaultField = sonDefaultField;
        this.sonPublicField = sonPublicField;
    }

    private String getSonPrivateMethod() {
        return "sonPrivateMethod";
    }

    protected String getSonProtectedMethod() {
        return "sonProtectedMethod";
    }

    String getSonDefaultMethod() {
        return "sonDefaultMethod";
    }

    public String getSonPublicMethod() {
        return "sonPublicMethod";
    }
}

@SuppressWarnings("unused")
class Grandson extends Son {
    public String grandsonPublicField;
    protected String grandsonProtectedField;
    String grandsonDefaultField;
    private String grandsonPrivateField;

    public Grandson(String parentPrivateField,
                    String parentProtectedField,
                    String parentDefaultField,
                    String parentPublicField,
                    String sonPrivateField,
                    String sonProtectedField,
                    String sonDefaultField,
                    String sonPublicField,
                    String grandsonPrivateField,
                    String grandsonProtectedField,
                    String grandsonDefaultField,
                    String grandsonPublicField) {
        super(
                parentPrivateField,
                parentProtectedField,
                parentDefaultField,
                parentPublicField,
                sonPrivateField,
                sonProtectedField,
                sonDefaultField,
                sonPublicField
        );
        this.grandsonPrivateField = grandsonPrivateField;
        this.grandsonProtectedField = grandsonProtectedField;
        this.grandsonDefaultField = grandsonDefaultField;
        this.grandsonPublicField = grandsonPublicField;
    }

    private String getGrandsonPrivateMethod() {
        return "grandsonPrivateMethod";
    }

    protected String getGrandsonProtectedMethod() {
        return "grandsonProtectedMethod";
    }

    String getGrandsonDefaultMethod() {
        return "grandsonDefaultMethod";
    }

    public String getGrandsonPublicMethod() {
        return "grandsonPublicMethod";
    }
}
