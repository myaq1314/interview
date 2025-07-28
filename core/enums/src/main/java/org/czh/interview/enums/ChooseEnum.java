package org.czh.interview.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : CZH
 * description : 选择 枚举
 * datetime : 2025/7/25
 * email : 916419307@qq.com
 */
@Getter
@AllArgsConstructor
public enum ChooseEnum implements IDictEnum<Integer, String> {

    NO(0, "否"),
    YES(1, "是"),

    // 占位符
    ;

    public final Integer key;
    public final String value;
}
