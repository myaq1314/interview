package org.czh.interview.commons.convertor;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.czh.interview.commons.annotations.tag.NotNullTag;
import org.czh.interview.commons.entity.parent.IBaseEntity;
import org.czh.interview.commons.utils.FieldUtil;
import org.czh.interview.commons.validate.EmptyAssert;
import org.czh.interview.commons.validate.EmptyValidate;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : czh
 * description : 对象转换器
 * date : 2021-04-28
 * email 916419307@qq.com
 */
@SuppressWarnings("unused")
public final class EntityConvertor {

    /*
      -----------------------------bean convert to new map-------------------------------
     */

    public static <S extends IBaseEntity> Map<String, Object> convertToMap(@NotNullTag final S source) {
        Map<String, Object> target = new HashMap<>();
        convertToMap(source, target);
        return target;
    }

    /*
      -----------------------------bean convert to map-------------------------------
     */
    public static <S extends IBaseEntity> void convertToMap(@NotNullTag final S source,
                                                            @NotNullTag final Map<String, Object> target) {
        EmptyAssert.allNotNull(source, target);

        Class<?> clazz = source.getClass();
        List<Field> fieldList = FieldUtil.queryAllFieldList(clazz);
        if (EmptyValidate.isEmpty(fieldList)) {
            return;
        }

        fieldList.forEach(field -> target.put(field.getName(), FieldUtil.readField(source, field)));
    }

    /*
      -----------------------------bean convert to new json-------------------------------
     */
    public static <S extends IBaseEntity> JSONObject convertToJsonObject(@NotNullTag final S source) {
        EmptyAssert.isNotNull(source);

        return (JSONObject) JSONObject.toJSON(source);
    }

    public static <S extends IBaseEntity> String convertToJsonString(@NotNullTag final S source) {
        EmptyAssert.isNotNull(source);

        return JSONObject.toJSONString(source, SerializerFeature.DisableCircularReferenceDetect);
    }
}
