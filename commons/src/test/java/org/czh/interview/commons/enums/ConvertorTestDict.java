package org.czh.interview.commons.enums;

import lombok.Getter;
import org.czh.interview.commons.convertor.ArrayConvertor;
import org.czh.interview.commons.convertor.CollectionConvertor;
import org.czh.interview.commons.enums.parent.IDictEnum;

/**
 * @author : czh
 * description :
 * date : 2021-05-02
 * email 916419307@qq.com
 */
public enum ConvertorTestDict implements IDictEnum<String, Class<?>> {

    ARRAY("array", ArrayConvertor.class),
    LIST("list", CollectionConvertor.class),
    SET("set", CollectionConvertor.class),

    // 预留扩展位
    ;

    @Getter
    public final String key;
    @Getter
    public final Class<?> value;

    ConvertorTestDict(String key, Class<?> value) {
        this.key = key;
        this.value = value;
    }
}