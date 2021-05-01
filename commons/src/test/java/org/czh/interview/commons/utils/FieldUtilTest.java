package org.czh.interview.commons.utils;

import org.czh.interview.commons.convertor.CollectionConvertor;
import org.czh.interview.commons.exceptions.CommonException;
import org.czh.interview.commons.validate.FlagAssert;
import org.junit.Test;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.lang.reflect.Field;
import java.util.ArrayList;
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

    public Son initSon() {
        Son son = new Son(
                "parentPrivateFieldValue",
                "parentProtectedFieldValue",
                "parentDefaultFieldValue",
                "parentPublicFieldValue",
                "sonPrivateFieldValue",
                "sonProtectedFieldValue",
                "sonDefaultFieldValue",
                "sonPublicFieldValue"
        );
        son.init("parentPrivateStaticFieldValue",
                "parentProtectedStaticFieldValue",
                "parentDefaultStaticFieldValue",
                "parentPublicStaticFieldValue",
                "sonPrivateStaticFieldValue",
                "sonProtectedStaticFieldValue",
                "sonDefaultStaticFieldValue",
                "sonPublicStaticFieldValue"
        );
        return son;
    }

    @Test
    public void sonWriteFieldTest() {
        Son son = initSon();
        Class<? extends Son> sonClazz = son.getClass();

        List<String> fieldNameList = new ArrayList<>();
        Collections.addAll(fieldNameList,
                "sonPrivateField", "sonProtectedField", "sonDefaultField", "sonPublicField",
                "sonPrivateStaticField", "sonProtectedStaticField", "sonDefaultStaticField", "sonPublicStaticField",
                "parentPrivateField", "parentProtectedField", "parentDefaultField", "parentPublicField",
                "parentPrivateStaticField", "parentProtectedStaticField", "parentDefaultStaticField", "parentPublicStaticField"
        );

        List<String> targetFieldValueListFromAll = new ArrayList<>();
        for (String fieldName : fieldNameList) {
            try {
                FieldUtil.writeFieldFromAll(son, fieldName, fieldName + "ValueWriteFromAll");
                String fieldValue = (String) FieldUtil.readFieldFromAll(son, fieldName);
                targetFieldValueListFromAll.add(fieldValue);
            } catch (CommonException ignored) {

            }
        }
        List<String> compareFieldValueListFromAll = new ArrayList<>();
        Collections.addAll(compareFieldValueListFromAll,
                "sonPrivateFieldValueWriteFromAll", "sonProtectedFieldValueWriteFromAll", "sonDefaultFieldValueWriteFromAll", "sonPublicFieldValueWriteFromAll",
                "sonPrivateStaticFieldValueWriteFromAll", "sonProtectedStaticFieldValueWriteFromAll", "sonDefaultStaticFieldValueWriteFromAll", "sonPublicStaticFieldValueWriteFromAll",
                "parentPrivateFieldValueWriteFromAll", "parentProtectedFieldValueWriteFromAll", "parentDefaultFieldValueWriteFromAll", "parentPublicFieldValueWriteFromAll",
                "parentPrivateStaticFieldValueWriteFromAll", "parentProtectedStaticFieldValueWriteFromAll", "parentDefaultStaticFieldValueWriteFromAll", "parentPublicStaticFieldValueWriteFromAll"
        );
        FlagAssert.isTrue(Objects.equals(targetFieldValueListFromAll, compareFieldValueListFromAll));

        List<String> targetStaticFieldValueListFromAll = new ArrayList<>();
        for (String fieldName : fieldNameList) {
            try {
                FieldUtil.writeStaticFieldFromAll(sonClazz, fieldName, fieldName + "StaticValueWriteFromAll");
                String fieldValue = (String) FieldUtil.readStaticFieldFromAll(sonClazz, fieldName);
                targetStaticFieldValueListFromAll.add(fieldValue);
            } catch (CommonException ignored) {

            }
        }
        List<String> compareStaticFieldValueListFromAll = new ArrayList<>();
        Collections.addAll(compareStaticFieldValueListFromAll,
                "sonPrivateStaticFieldStaticValueWriteFromAll", "sonProtectedStaticFieldStaticValueWriteFromAll", "sonDefaultStaticFieldStaticValueWriteFromAll", "sonPublicStaticFieldStaticValueWriteFromAll",
                "parentPrivateStaticFieldStaticValueWriteFromAll", "parentProtectedStaticFieldStaticValueWriteFromAll", "parentDefaultStaticFieldStaticValueWriteFromAll", "parentPublicStaticFieldStaticValueWriteFromAll"
        );
        FlagAssert.isTrue(Objects.equals(targetStaticFieldValueListFromAll, compareStaticFieldValueListFromAll));

        son = initSon();
        List<String> targetFieldValueListFromPubic = new ArrayList<>();
        for (String fieldName : fieldNameList) {
            try {
                FieldUtil.writeFieldFromPublic(son, fieldName, fieldName + "ValueWriteFromPublic");
                String fieldValue = (String) FieldUtil.readFieldFromPublic(son, fieldName);
                targetFieldValueListFromPubic.add(fieldValue);
            } catch (CommonException ignored) {

            }
        }
        List<String> compareFieldValueListFromPublic = new ArrayList<>();
        Collections.addAll(compareFieldValueListFromPublic,
                "sonPublicFieldValueWriteFromPublic",
                "sonPublicStaticFieldValueWriteFromPublic",
                "parentPublicFieldValueWriteFromPublic",
                "parentPublicStaticFieldValueWriteFromPublic"
        );
        FlagAssert.isTrue(Objects.equals(targetFieldValueListFromPubic, compareFieldValueListFromPublic));

        List<String> targetStaticFieldValueListFromPubic = new ArrayList<>();
        for (String fieldName : fieldNameList) {
            try {
                FieldUtil.writeStaticFieldFromPublic(sonClazz, fieldName, fieldName + "StaticValueWriteFromPublic");
                String fieldValue = (String) FieldUtil.readStaticFieldFromPublic(sonClazz, fieldName);
                targetStaticFieldValueListFromPubic.add(fieldValue);
            } catch (CommonException ignored) {

            }
        }
        List<String> compareStaticFieldValueListFromPublic = new ArrayList<>();
        Collections.addAll(compareStaticFieldValueListFromPublic,
                "sonPublicStaticFieldStaticValueWriteFromPublic",
                "parentPublicStaticFieldStaticValueWriteFromPublic"
        );
        FlagAssert.isTrue(Objects.equals(targetStaticFieldValueListFromPubic, compareStaticFieldValueListFromPublic));

        son = initSon();
        List<String> targetFieldValueListFromOwn = new ArrayList<>();
        for (String fieldName : fieldNameList) {
            try {
                FieldUtil.writeFieldFromOwn(son, fieldName, fieldName + "ValueWriteFromOwn");
                String fieldValue = (String) FieldUtil.readFieldFromOwn(son, fieldName);
                targetFieldValueListFromOwn.add(fieldValue);
            } catch (CommonException ignored) {

            }
        }
        List<String> compareFieldValueListFromOwn = new ArrayList<>();
        Collections.addAll(compareFieldValueListFromOwn,
                "sonPrivateFieldValueWriteFromOwn", "sonProtectedFieldValueWriteFromOwn", "sonDefaultFieldValueWriteFromOwn", "sonPublicFieldValueWriteFromOwn",
                "sonPrivateStaticFieldValueWriteFromOwn", "sonProtectedStaticFieldValueWriteFromOwn", "sonDefaultStaticFieldValueWriteFromOwn", "sonPublicStaticFieldValueWriteFromOwn"
        );
        FlagAssert.isTrue(Objects.equals(targetFieldValueListFromOwn, compareFieldValueListFromOwn));

        List<String> targetStaticFieldValueListFromOwn = new ArrayList<>();
        for (String fieldName : fieldNameList) {
            try {
                FieldUtil.writeStaticFieldFromOwn(sonClazz, fieldName, fieldName + "StaticValueWriteFromOwn");
                String fieldValue = (String) FieldUtil.readStaticFieldFromOwn(sonClazz, fieldName);
                targetStaticFieldValueListFromOwn.add(fieldValue);
            } catch (CommonException ignored) {

            }
        }
        List<String> compareStaticFieldValueListFromOwn = new ArrayList<>();
        Collections.addAll(compareStaticFieldValueListFromOwn,
                "sonPrivateStaticFieldStaticValueWriteFromOwn", "sonProtectedStaticFieldStaticValueWriteFromOwn", "sonDefaultStaticFieldStaticValueWriteFromOwn", "sonPublicStaticFieldStaticValueWriteFromOwn"
        );
        FlagAssert.isTrue(Objects.equals(targetStaticFieldValueListFromOwn, compareStaticFieldValueListFromOwn));
    }

    @Test
    public void sonReadFieldTest() {
        Son son = initSon();
        Class<? extends Son> sonClazz = son.getClass();

        List<String> fieldNameList = new ArrayList<>();
        Collections.addAll(fieldNameList,
                "sonPrivateField", "sonProtectedField", "sonDefaultField", "sonPublicField",
                "sonPrivateStaticField", "sonProtectedStaticField", "sonDefaultStaticField", "sonPublicStaticField",
                "parentPrivateField", "parentProtectedField", "parentDefaultField", "parentPublicField",
                "parentPrivateStaticField", "parentProtectedStaticField", "parentDefaultStaticField", "parentPublicStaticField"
        );

        List<String> targetFieldValueListFromAll = new ArrayList<>();
        for (String fieldName : fieldNameList) {
            try {
                String fieldValue = (String) FieldUtil.readFieldFromAll(son, fieldName);
                targetFieldValueListFromAll.add(fieldValue);
            } catch (CommonException ignored) {

            }
        }
        List<String> compareFieldValueListFromAll = new ArrayList<>();
        Collections.addAll(compareFieldValueListFromAll,
                "sonPrivateFieldValue", "sonProtectedFieldValue", "sonDefaultFieldValue", "sonPublicFieldValue",
                "sonPrivateStaticFieldValue", "sonProtectedStaticFieldValue", "sonDefaultStaticFieldValue", "sonPublicStaticFieldValue",
                "parentPrivateFieldValue", "parentProtectedFieldValue", "parentDefaultFieldValue", "parentPublicFieldValue",
                "parentPrivateStaticFieldValue", "parentProtectedStaticFieldValue", "parentDefaultStaticFieldValue", "parentPublicStaticFieldValue"
        );
        FlagAssert.isTrue(Objects.equals(targetFieldValueListFromAll, compareFieldValueListFromAll));

        List<String> targetStaticFieldValueListFromAll = new ArrayList<>();
        for (String fieldName : fieldNameList) {
            try {
                String fieldValue = (String) FieldUtil.readStaticFieldFromAll(sonClazz, fieldName);
                targetStaticFieldValueListFromAll.add(fieldValue);
            } catch (CommonException ignored) {

            }
        }
        List<String> compareStaticFieldValueListFromAll = new ArrayList<>();
        Collections.addAll(compareStaticFieldValueListFromAll,
                "sonPrivateStaticFieldValue", "sonProtectedStaticFieldValue", "sonDefaultStaticFieldValue", "sonPublicStaticFieldValue",
                "parentPrivateStaticFieldValue", "parentProtectedStaticFieldValue", "parentDefaultStaticFieldValue", "parentPublicStaticFieldValue"
        );
        FlagAssert.isTrue(Objects.equals(targetStaticFieldValueListFromAll, compareStaticFieldValueListFromAll));

        List<String> targetFieldValueListFromPubic = new ArrayList<>();
        for (String fieldName : fieldNameList) {
            try {
                String fieldValue = (String) FieldUtil.readFieldFromPublic(son, fieldName);
                targetFieldValueListFromPubic.add(fieldValue);
            } catch (CommonException ignored) {

            }
        }
        List<String> compareFieldValueListFromPublic = new ArrayList<>();
        Collections.addAll(compareFieldValueListFromPublic,
                "sonPublicFieldValue",
                "sonPublicStaticFieldValue",
                "parentPublicFieldValue",
                "parentPublicStaticFieldValue"
        );
        FlagAssert.isTrue(Objects.equals(targetFieldValueListFromPubic, compareFieldValueListFromPublic));

        List<String> targetStaticFieldValueListFromPubic = new ArrayList<>();
        for (String fieldName : fieldNameList) {
            try {
                String fieldValue = (String) FieldUtil.readStaticFieldFromPublic(sonClazz, fieldName);
                targetStaticFieldValueListFromPubic.add(fieldValue);
            } catch (CommonException ignored) {

            }
        }
        List<String> compareStaticFieldValueListFromPublic = new ArrayList<>();
        Collections.addAll(compareStaticFieldValueListFromPublic,
                "sonPublicStaticFieldValue",
                "parentPublicStaticFieldValue"
        );
        FlagAssert.isTrue(Objects.equals(targetStaticFieldValueListFromPubic, compareStaticFieldValueListFromPublic));

        List<String> targetFieldValueListFromOwn = new ArrayList<>();
        for (String fieldName : fieldNameList) {
            try {
                String fieldValue = (String) FieldUtil.readFieldFromOwn(son, fieldName);
                targetFieldValueListFromOwn.add(fieldValue);
            } catch (CommonException ignored) {

            }
        }
        List<String> compareFieldValueListFromOwn = new ArrayList<>();
        Collections.addAll(compareFieldValueListFromOwn,
                "sonPrivateFieldValue", "sonProtectedFieldValue", "sonDefaultFieldValue", "sonPublicFieldValue",
                "sonPrivateStaticFieldValue", "sonProtectedStaticFieldValue", "sonDefaultStaticFieldValue", "sonPublicStaticFieldValue"
        );
        FlagAssert.isTrue(Objects.equals(targetFieldValueListFromOwn, compareFieldValueListFromOwn));

        List<String> targetStaticFieldValueListFromOwn = new ArrayList<>();
        for (String fieldName : fieldNameList) {
            try {
                String fieldValue = (String) FieldUtil.readStaticFieldFromOwn(sonClazz, fieldName);
                targetStaticFieldValueListFromOwn.add(fieldValue);
            } catch (CommonException ignored) {

            }
        }
        List<String> compareStaticFieldValueListFromOwn = new ArrayList<>();
        Collections.addAll(compareStaticFieldValueListFromOwn,
                "sonPrivateStaticFieldValue", "sonProtectedStaticFieldValue", "sonDefaultStaticFieldValue", "sonPublicStaticFieldValue"
        );
        FlagAssert.isTrue(Objects.equals(targetStaticFieldValueListFromOwn, compareStaticFieldValueListFromOwn));
    }

    @Test
    public void sonGetFieldTest() {
        Son son = initSon();
        Class<? extends Son> sonClazz = son.getClass();

        List<String> fieldNameList = new ArrayList<>();
        Collections.addAll(fieldNameList,
                "sonPrivateField", "sonProtectedField", "sonDefaultField", "sonPublicField",
                "sonPrivateStaticField", "sonProtectedStaticField", "sonDefaultStaticField", "sonPublicStaticField",
                "parentPrivateField", "parentProtectedField", "parentDefaultField", "parentPublicField",
                "parentPrivateStaticField", "parentProtectedStaticField", "parentDefaultStaticField", "parentPublicStaticField"
        );

        List<String> targetFieldNameListFromAll = new ArrayList<>();
        for (String fieldName : fieldNameList) {
            try {
                Field field = FieldUtil.getFieldFromAll(sonClazz, fieldName);
                targetFieldNameListFromAll.add(field.getName());
            } catch (CommonException ignored) {

            }
        }
        List<String> compareFieldNameListFromAll = new ArrayList<>();
        Collections.addAll(compareFieldNameListFromAll,
                "sonPrivateField", "sonProtectedField", "sonDefaultField", "sonPublicField",
                "sonPrivateStaticField", "sonProtectedStaticField", "sonDefaultStaticField", "sonPublicStaticField",
                "parentPrivateField", "parentProtectedField", "parentDefaultField", "parentPublicField",
                "parentPrivateStaticField", "parentProtectedStaticField", "parentDefaultStaticField", "parentPublicStaticField"
        );
        FlagAssert.isTrue(Objects.equals(targetFieldNameListFromAll, compareFieldNameListFromAll));

        List<String> targetFieldNameListFromPubic = new ArrayList<>();
        for (String fieldName : fieldNameList) {
            try {
                Field field = FieldUtil.getFieldFromPublic(sonClazz, fieldName);
                targetFieldNameListFromPubic.add(field.getName());
            } catch (CommonException ignored) {

            }
        }
        List<String> compareFieldValueListFromPublic = new ArrayList<>();
        Collections.addAll(compareFieldValueListFromPublic,
                "sonPublicField",
                "sonPublicStaticField",
                "parentPublicField",
                "parentPublicStaticField"
        );
        FlagAssert.isTrue(Objects.equals(targetFieldNameListFromPubic, compareFieldValueListFromPublic));

        List<String> targetFieldNameListFromOwn = new ArrayList<>();
        for (String fieldName : fieldNameList) {
            try {
                Field field = FieldUtil.getFieldFromOwn(sonClazz, fieldName);
                targetFieldNameListFromOwn.add(field.getName());
            } catch (CommonException ignored) {

            }
        }
        List<String> compareFieldNameListFromOwn = new ArrayList<>();
        Collections.addAll(compareFieldNameListFromOwn,
                "sonPrivateField", "sonProtectedField", "sonDefaultField", "sonPublicField",
                "sonPrivateStaticField", "sonProtectedStaticField", "sonDefaultStaticField", "sonPublicStaticField"
        );
        FlagAssert.isTrue(Objects.equals(targetFieldNameListFromOwn, compareFieldNameListFromOwn));
    }

    @Test
    public void sonQueryFieldTest() {
        Son son = initSon();
        Class<? extends Parent> sonClazz = son.getClass();

        List<Field> sonAllFieldList = FieldUtil.queryAllFieldList(sonClazz);
        List<String> sonAllFieldNameList = CollectionConvertor.convertToList(sonAllFieldList, Field::getName);
        List<String> sonCompareAllFieldNameList = new ArrayList<>();
        Collections.addAll(sonCompareAllFieldNameList,
                "sonPrivateField",
                "sonProtectedField",
                "sonDefaultField",
                "sonPublicField",
                "sonPrivateStaticField",
                "sonProtectedStaticField",
                "sonDefaultStaticField",
                "sonPublicStaticField",
                "parentPrivateField",
                "parentProtectedField",
                "parentDefaultField",
                "parentPublicField",
                "parentPrivateStaticField",
                "parentProtectedStaticField",
                "parentDefaultStaticField",
                "parentPublicStaticField"
        );
        FlagAssert.isTrue(Objects.equals(sonAllFieldNameList, sonCompareAllFieldNameList));

        List<Field> sonPublicFieldList = FieldUtil.queryPublicFieldList(sonClazz);
        List<String> sonPublicFieldNameList = CollectionConvertor.convertToList(sonPublicFieldList, Field::getName);
        List<String> sonComparePublicFieldNameList = new ArrayList<>();
        Collections.addAll(sonComparePublicFieldNameList,
                "sonPublicField",
                "sonPublicStaticField",
                "parentPublicField",
                "parentPublicStaticField"
        );
        FlagAssert.isTrue(Objects.equals(sonPublicFieldNameList, sonComparePublicFieldNameList));

        List<Field> sonOwnFieldList = FieldUtil.queryOwnFieldList(sonClazz);
        List<String> sonOwnFieldNameList = CollectionConvertor.convertToList(sonOwnFieldList, Field::getName);
        List<String> sonCompareOwnFieldNameList = new ArrayList<>();
        Collections.addAll(sonCompareOwnFieldNameList,
                "sonPrivateField",
                "sonProtectedField",
                "sonDefaultField",
                "sonPublicField",
                "sonPrivateStaticField",
                "sonProtectedStaticField",
                "sonDefaultStaticField",
                "sonPublicStaticField"
        );
        FlagAssert.isTrue(Objects.equals(sonOwnFieldNameList, sonCompareOwnFieldNameList));
    }

    @Test
    public void sonQueryFieldWithAnnoTest() {
        Son son = initSon();
        Class<? extends Parent> sonClazz = son.getClass();

        List<Field> sonAllFieldList = FieldUtil.queryAllFieldListWithAnno(sonClazz, NotNull.class);
        List<String> sonAllFieldNameList = CollectionConvertor.convertToList(sonAllFieldList, Field::getName);
        List<String> sonCompareAllFieldNameList = new ArrayList<>();
        Collections.addAll(sonCompareAllFieldNameList,
                "sonDefaultField",
                "sonDefaultStaticField",
                "parentDefaultField",
                "parentDefaultStaticField"
        );
        FlagAssert.isTrue(Objects.equals(sonAllFieldNameList, sonCompareAllFieldNameList));

        List<Field> sonPublicFieldList = FieldUtil.queryPublicFieldListWithAnno(sonClazz, Pattern.class);
        List<String> sonPublicFieldNameList = CollectionConvertor.convertToList(sonPublicFieldList, Field::getName);
        List<String> sonComparePublicFieldNameList = new ArrayList<>();
        Collections.addAll(sonComparePublicFieldNameList,
                "sonPublicField",
                "sonPublicStaticField",
                "parentPublicField",
                "parentPublicStaticField"
        );
        FlagAssert.isTrue(Objects.equals(sonPublicFieldNameList, sonComparePublicFieldNameList));

        List<Field> sonOwnFieldList = FieldUtil.queryOwnFieldListWithAnno(sonClazz, NotBlank.class);
        List<String> sonOwnFieldNameList = CollectionConvertor.convertToList(sonOwnFieldList, Field::getName);
        List<String> sonCompareOwnFieldNameList = new ArrayList<>();
        Collections.addAll(sonCompareOwnFieldNameList,
                "sonPrivateField",
                "sonPrivateStaticField"
        );
        FlagAssert.isTrue(Objects.equals(sonOwnFieldNameList, sonCompareOwnFieldNameList));
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
    @NotBlank
    private String parentPrivateField;
    @NotEmpty
    protected String parentProtectedField;
    @NotNull
    String parentDefaultField;
    @Pattern(regexp = "yyyy-MM-dd")
    public String parentPublicField;

    @NotBlank
    private static String parentPrivateStaticField = "parentPrivateStaticFieldValue";
    @NotEmpty
    protected static String parentProtectedStaticField = "parentProtectedStaticFieldValue";
    @NotNull
    static String parentDefaultStaticField = "parentDefaultStaticFieldValue";
    @Pattern(regexp = "yyyy-MM-dd")
    public static String parentPublicStaticField = "parentPublicStaticFieldValue";

    public Parent(String parentPrivateField,
                  String parentProtectedField,
                  String parentDefaultField,
                  String parentPublicField) {
        this.parentPrivateField = parentPrivateField;
        this.parentProtectedField = parentProtectedField;
        this.parentDefaultField = parentDefaultField;
        this.parentPublicField = parentPublicField;
    }

    public void init(String parentPrivateStaticField,
                     String parentProtectedStaticField,
                     String parentDefaultStaticField,
                     String parentPublicStaticField) {
        Parent.parentPrivateStaticField = parentPrivateStaticField;
        Parent.parentProtectedStaticField = parentProtectedStaticField;
        Parent.parentDefaultStaticField = parentDefaultStaticField;
        Parent.parentPublicStaticField = parentPublicStaticField;
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
    @NotBlank
    private String sonPrivateField;
    @NotEmpty
    protected String sonProtectedField;
    @NotNull
    String sonDefaultField;
    @Pattern(regexp = "yyyy-MM-dd")
    public String sonPublicField;

    @NotBlank
    private static String sonPrivateStaticField = "sonPrivateStaticFieldValue";
    @NotEmpty
    protected static String sonProtectedStaticField = "sonProtectedStaticFieldValue";
    @NotNull
    static String sonDefaultStaticField = "sonDefaultStaticFieldValue";
    @Pattern(regexp = "yyyy-MM-dd")
    public static String sonPublicStaticField = "sonPublicStaticFieldValue";

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

    public void init(String parentPrivateStaticField,
                     String parentProtectedStaticField,
                     String parentDefaultStaticField,
                     String parentPublicStaticField,
                     String sonPrivateStaticField,
                     String sonProtectedStaticField,
                     String sonDefaultStaticField,
                     String sonPublicStaticField
    ) {
        super.init(parentPrivateStaticField,
                parentProtectedStaticField,
                parentDefaultStaticField,
                parentPublicStaticField);
        Son.sonPrivateStaticField = sonPrivateStaticField;
        Son.sonProtectedStaticField = sonProtectedStaticField;
        Son.sonDefaultStaticField = sonDefaultStaticField;
        Son.sonPublicStaticField = sonPublicStaticField;
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
    @NotBlank
    private String grandsonPrivateField;
    @NotEmpty
    protected String grandsonProtectedField;
    @NotNull
    String grandsonDefaultField;
    @Pattern(regexp = "yyyy-MM-dd")
    public String grandsonPublicField;

    @NotBlank
    private static String grandsonPrivateStaticField = "grandsonPrivateStaticFieldValue";
    @NotEmpty
    protected static String grandsonProtectedStaticField = "grandsonProtectedStaticFieldValue";
    @NotNull
    static String grandsonDefaultStaticField = "grandsonDefaultStaticFieldValue";
    @Pattern(regexp = "yyyy-MM-dd")
    public static String grandsonPublicStaticField = "grandsonPublicStaticFieldValue";

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
        super(parentPrivateField,
                parentProtectedField,
                parentDefaultField,
                parentPublicField,
                sonPrivateField,
                sonProtectedField,
                sonDefaultField,
                sonPublicField);
        this.grandsonPrivateField = grandsonPrivateField;
        this.grandsonProtectedField = grandsonProtectedField;
        this.grandsonDefaultField = grandsonDefaultField;
        this.grandsonPublicField = grandsonPublicField;
    }

    public void init(String parentPrivateStaticField,
                     String parentProtectedStaticField,
                     String parentDefaultStaticField,
                     String parentPublicStaticField,
                     String sonPrivateStaticField,
                     String sonProtectedStaticField,
                     String sonDefaultStaticField,
                     String sonPublicStaticField,
                     String grandsonPrivateStaticField,
                     String grandsonProtectedStaticField,
                     String grandsonDefaultStaticField,
                     String grandsonPublicStaticField) {
        super.init(parentPrivateStaticField,
                parentProtectedStaticField,
                parentDefaultStaticField,
                parentPublicStaticField,
                sonPrivateStaticField,
                sonProtectedStaticField,
                sonDefaultStaticField,
                sonPublicStaticField);
        Grandson.grandsonPrivateStaticField = grandsonPrivateStaticField;
        Grandson.grandsonProtectedStaticField = grandsonProtectedStaticField;
        Grandson.grandsonDefaultStaticField = grandsonDefaultStaticField;
        Grandson.grandsonPublicStaticField = grandsonPublicStaticField;
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


