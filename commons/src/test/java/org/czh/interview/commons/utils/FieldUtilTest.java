package org.czh.interview.commons.utils;

import org.czh.interview.commons.convertor.ArrayConvertor;
import org.czh.interview.commons.convertor.CollectionConvertor;
import org.czh.interview.commons.validate.FlagAssert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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
                "parentPrivateField",
                "parentProtectedField",
                "parentDefaultField",
                "parentPublicField"
        );

        son = new Son(
                "parentPrivateField",
                "parentProtectedField",
                "parentDefaultField",
                "parentPublicField",
                "sonPrivateField",
                "sonProtectedField",
                "sonDefaultField",
                "sonPublicField"
        );

        grandson = new Grandson(
                "parentPrivateField",
                "parentProtectedField",
                "parentDefaultField",
                "parentPublicField",
                "sonPrivateField",
                "sonProtectedField",
                "sonDefaultField",
                "sonPublicField",
                "grandsonPrivateField",
                "grandsonProtectedField",
                "grandsonDefaultField",
                "grandsonPublicField"
        );
    }

    @Test
    public void parentFieldTest() {
        Class<? extends Parent> parentClazz = parent.getClass();

        List<Field> parentAllFieldList = FieldUtil.getAllFieldList(parentClazz);
        List<String> parentAllFieldNameList = CollectionConvertor.convertToList(parentAllFieldList, Field::getName);
        List<String> parentCompareAllFieldNameList = new ArrayList<>();
        Collections.addAll(parentCompareAllFieldNameList,
                "parentPrivateField",
                "parentProtectedField",
                "parentDefaultField",
                "parentPublicField"
        );
        FlagAssert.isTrue(Objects.equals(parentAllFieldNameList, parentCompareAllFieldNameList));

        Field[] parentAllFields = FieldUtil.getAllFields(parentClazz);
        String[] parentAllFieldNames = ArrayConvertor.convertToArray(parentAllFields, String.class, Field::getName);
        String[] parentCompareAllFieldNames = new String[]{
                "parentPrivateField",
                "parentProtectedField",
                "parentDefaultField",
                "parentPublicField"
        };
        FlagAssert.isTrue(Arrays.equals(parentAllFieldNames, parentCompareAllFieldNames));

        List<Field> parentPublicFieldList = FieldUtil.getPublicFieldList(parentClazz);
        List<String> parentPublicFieldNameList = CollectionConvertor.convertToList(parentPublicFieldList, Field::getName);
        List<String> parentComparePublicFieldNameList = new ArrayList<>();
        Collections.addAll(parentComparePublicFieldNameList,
                "parentPublicField"
        );
        FlagAssert.isTrue(Objects.equals(parentPublicFieldNameList, parentComparePublicFieldNameList));

        Field[] parentPublicFields = FieldUtil.getPublicFields(parentClazz);
        String[] parentPublicFieldNames = ArrayConvertor.convertToArray(parentPublicFields, String.class, Field::getName);
        String[] parentComparePublicFieldNames = new String[]{
                "parentPublicField"
        };
        FlagAssert.isTrue(Arrays.equals(parentPublicFieldNames, parentComparePublicFieldNames));

        List<Field> parentOwnFieldList = FieldUtil.getOwnFieldList(parentClazz);
        List<String> parentOwnFieldNameList = CollectionConvertor.convertToList(parentOwnFieldList, Field::getName);
        List<String> parentCompareOwnFieldNameList = new ArrayList<>();
        Collections.addAll(parentCompareOwnFieldNameList,
                "parentPrivateField",
                "parentProtectedField",
                "parentDefaultField",
                "parentPublicField"
        );
        FlagAssert.isTrue(Objects.equals(parentOwnFieldNameList, parentCompareOwnFieldNameList));

        Field[] parentOwnFields = FieldUtil.getOwnFields(parentClazz);
        String[] parentOwnFieldNames = ArrayConvertor.convertToArray(parentOwnFields, String.class, Field::getName);
        String[] parentCompareOwnFieldNames = new String[]{
                "parentPrivateField",
                "parentProtectedField",
                "parentDefaultField",
                "parentPublicField"
        };
        FlagAssert.isTrue(Arrays.equals(parentOwnFieldNames, parentCompareOwnFieldNames));
    }

    @Test
    public void sonFieldTest() {
        Class<? extends Parent> sonClazz = son.getClass();

        List<Field> sonAllFieldList = FieldUtil.getAllFieldList(sonClazz);
        List<String> sonAllFieldNameList = CollectionConvertor.convertToList(sonAllFieldList, Field::getName);
        List<String> sonCompareAllFieldNameList = new ArrayList<>();
        Collections.addAll(sonCompareAllFieldNameList,
                "sonPrivateField",
                "sonProtectedField",
                "sonDefaultField",
                "sonPublicField",
                "parentPrivateField",
                "parentProtectedField",
                "parentDefaultField",
                "parentPublicField"
        );
        FlagAssert.isTrue(Objects.equals(sonAllFieldNameList, sonCompareAllFieldNameList));

        Field[] sonAllFields = FieldUtil.getAllFields(sonClazz);
        String[] sonAllFieldNames = ArrayConvertor.convertToArray(sonAllFields, String.class, Field::getName);
        String[] sonCompareAllFieldNames = new String[]{
                "sonPrivateField",
                "sonProtectedField",
                "sonDefaultField",
                "sonPublicField",
                "parentPrivateField",
                "parentProtectedField",
                "parentDefaultField",
                "parentPublicField"
        };
        FlagAssert.isTrue(Arrays.equals(sonAllFieldNames, sonCompareAllFieldNames));

        List<Field> sonPublicFieldList = FieldUtil.getPublicFieldList(sonClazz);
        List<String> sonPublicFieldNameList = CollectionConvertor.convertToList(sonPublicFieldList, Field::getName);
        List<String> sonComparePublicFieldNameList = new ArrayList<>();
        Collections.addAll(sonComparePublicFieldNameList,
                "sonPublicField",
                "parentPublicField"
        );
        FlagAssert.isTrue(Objects.equals(sonPublicFieldNameList, sonComparePublicFieldNameList));

        Field[] sonPublicFields = FieldUtil.getPublicFields(sonClazz);
        String[] sonPublicFieldNames = ArrayConvertor.convertToArray(sonPublicFields, String.class, Field::getName);
        String[] sonComparePublicFieldNames = new String[]{
                "sonPublicField",
                "parentPublicField"
        };
        FlagAssert.isTrue(Arrays.equals(sonPublicFieldNames, sonComparePublicFieldNames));

        List<Field> sonOwnFieldList = FieldUtil.getOwnFieldList(sonClazz);
        List<String> sonOwnFieldNameList = CollectionConvertor.convertToList(sonOwnFieldList, Field::getName);
        List<String> sonCompareOwnFieldNameList = new ArrayList<>();
        Collections.addAll(sonCompareOwnFieldNameList,
                "sonPrivateField",
                "sonProtectedField",
                "sonDefaultField",
                "sonPublicField"
        );
        FlagAssert.isTrue(Objects.equals(sonOwnFieldNameList, sonCompareOwnFieldNameList));

        Field[] sonOwnFields = FieldUtil.getOwnFields(sonClazz);
        String[] sonOwnFieldNames = ArrayConvertor.convertToArray(sonOwnFields, String.class, Field::getName);
        String[] sonCompareOwnFieldNames = new String[]{
                "sonPrivateField",
                "sonProtectedField",
                "sonDefaultField",
                "sonPublicField"
        };
        FlagAssert.isTrue(Arrays.equals(sonOwnFieldNames, sonCompareOwnFieldNames));
    }

    @Test
    public void grandsonFieldTest() {
        Class<? extends Parent> grandsonClazz = grandson.getClass();

        List<Field> grandsonAllFieldList = FieldUtil.getAllFieldList(grandsonClazz);
        List<String> grandsonAllFieldNameList = CollectionConvertor.convertToList(grandsonAllFieldList, Field::getName);
        List<String> grandsonCompareAllFieldNameList = new ArrayList<>();
        Collections.addAll(grandsonCompareAllFieldNameList,
                "grandsonPrivateField",
                "grandsonProtectedField",
                "grandsonDefaultField",
                "grandsonPublicField",
                "sonPrivateField",
                "sonProtectedField",
                "sonDefaultField",
                "sonPublicField",
                "parentPrivateField",
                "parentProtectedField",
                "parentDefaultField",
                "parentPublicField"
        );
        FlagAssert.isTrue(Objects.equals(grandsonAllFieldNameList, grandsonCompareAllFieldNameList));

        Field[] grandsonAllFields = FieldUtil.getAllFields(grandsonClazz);
        String[] grandsonAllFieldNames = ArrayConvertor.convertToArray(grandsonAllFields, String.class, Field::getName);
        String[] grandsonCompareAllFieldNames = new String[]{
                "grandsonPrivateField",
                "grandsonProtectedField",
                "grandsonDefaultField",
                "grandsonPublicField",
                "sonPrivateField",
                "sonProtectedField",
                "sonDefaultField",
                "sonPublicField",
                "parentPrivateField",
                "parentProtectedField",
                "parentDefaultField",
                "parentPublicField"
        };
        FlagAssert.isTrue(Arrays.equals(grandsonAllFieldNames, grandsonCompareAllFieldNames));

        List<Field> grandsonPublicFieldList = FieldUtil.getPublicFieldList(grandsonClazz);
        List<String> grandsonPublicFieldNameList = CollectionConvertor.convertToList(grandsonPublicFieldList, Field::getName);
        List<String> grandsonComparePublicFieldNameList = new ArrayList<>();
        Collections.addAll(grandsonComparePublicFieldNameList,
                "grandsonPublicField",
                "sonPublicField",
                "parentPublicField"
        );
        FlagAssert.isTrue(Objects.equals(grandsonPublicFieldNameList, grandsonComparePublicFieldNameList));

        Field[] grandsonPublicFields = FieldUtil.getPublicFields(grandsonClazz);
        String[] grandsonPublicFieldNames = ArrayConvertor.convertToArray(grandsonPublicFields, String.class, Field::getName);
        String[] grandsonComparePublicFieldNames = new String[]{
                "grandsonPublicField",
                "sonPublicField",
                "parentPublicField"
        };
        FlagAssert.isTrue(Arrays.equals(grandsonPublicFieldNames, grandsonComparePublicFieldNames));

        List<Field> grandsonOwnFieldList = FieldUtil.getOwnFieldList(grandsonClazz);
        List<String> grandsonOwnFieldNameList = CollectionConvertor.convertToList(grandsonOwnFieldList, Field::getName);
        List<String> grandsonCompareOwnFieldNameList = new ArrayList<>();
        Collections.addAll(grandsonCompareOwnFieldNameList,
                "grandsonPrivateField",
                "grandsonProtectedField",
                "grandsonDefaultField",
                "grandsonPublicField"
        );
        FlagAssert.isTrue(Objects.equals(grandsonOwnFieldNameList, grandsonCompareOwnFieldNameList));

        Field[] grandsonOwnFields = FieldUtil.getOwnFields(grandsonClazz);
        String[] grandsonOwnFieldNames = ArrayConvertor.convertToArray(grandsonOwnFields, String.class, Field::getName);
        String[] grandsonCompareOwnFieldNames = new String[]{
                "grandsonPrivateField",
                "grandsonProtectedField",
                "grandsonDefaultField",
                "grandsonPublicField"
        };
        FlagAssert.isTrue(Arrays.equals(grandsonOwnFieldNames, grandsonCompareOwnFieldNames));
    }
}

@SuppressWarnings("unused")
interface Person extends java.io.Serializable {
    default String getType() {
        return "Person";
    }
}

@SuppressWarnings("unused")
class Parent implements Person {
    private String parentPrivateField;
    protected String parentProtectedField;
    String parentDefaultField;
    public String parentPublicField;

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
    private String sonPrivateField;
    protected String sonProtectedField;
    String sonDefaultField;
    public String sonPublicField;

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
    private String grandsonPrivateField;
    protected String grandsonProtectedField;
    String grandsonDefaultField;
    public String grandsonPublicField;

    public Grandson(String parentPrivateField,
                    String parentProtectedField,
                    String parentDefaultField,
                    String parentPublicField,
                    String sonPrivateField,
                    String sonProtectedField,
                    String sonDefaultField,
                    String sonPublicField,
                    String grandsonPrivateField,
                    String grandsonProtectedField, String grandsonDefaultField, String grandsonPublicField) {
        super(parentPrivateField, parentProtectedField, parentDefaultField, parentPublicField, sonPrivateField, sonProtectedField, sonDefaultField, sonPublicField);
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
