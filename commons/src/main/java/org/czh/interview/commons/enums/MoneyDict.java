package org.czh.interview.commons.enums;

import org.czh.interview.commons.enums.parent.IDictEnum;

/**
 * @author : czh
 * description :
 * date : 2021-04-28
 * email 916419307@qq.com
 */
public enum MoneyDict implements IDictEnum<Double, String> {

    BAIY(10000000000d, "百亿元", "百亿"),
    YI(100000000d, "亿元", "亿"),

    BAIW(1000000d, "百万元", "百万"),
    WAN(10000d, "万元", "万"),

    QIAN(1000d, "千元", "千"),
    BAI(100d, "百元", "百"),
    YUAN(1d, "元", null),

    JIAO(0.1d, "角", "毛"),
    FEN(0.01d, "分", null),
    HAO(0.001d, "毫", null),
    SI(0.0001d, "丝", null),

    // 预留扩展位
    ;

    public final Double key;
    public final String value;
    public final String alias;

    MoneyDict(Double key, String value, String alias) {
        this.key = key;
        this.value = value;
        this.alias = alias;
    }

    @Override
    public Double getKey() {
        return key;
    }

    @Override
    public String getValue() {
        return value;
    }

    public String getAlias() {
        return alias;
    }
}
