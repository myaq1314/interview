package org.czh.interview.commons.enums.parent;

import lombok.Getter;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author : czh
 * description :
 * date : 2021-04-28
 * email 916419307@qq.com
 */
public class IColumnEnumTest {

    @Test
    public void test() {
        System.out.println(InteriorColumnEnum.FIRST_NAME.getColumn());
        System.out.println(InteriorColumnEnum.FIRST_NAME.getField());
        System.out.println(InteriorColumnEnum.FIRST_NAME.getType().getSimpleName());

        Assert.assertEquals(
                "getColumn() show equals column field",
                InteriorColumnEnum.ID.getColumn(),
                InteriorColumnEnum.ID.column
        );

        Assert.assertEquals(
                "getField() show equals field field",
                InteriorColumnEnum.ID.getField(),
                InteriorColumnEnum.ID.field
        );

        Assert.assertEquals(
                "getType() show equals type field",
                InteriorColumnEnum.ID.getType(),
                InteriorColumnEnum.ID.type
        );
    }

    enum InteriorColumnEnum implements IColumnEnum {

        ID("id", "id", Integer.class),
        FIRST_NAME("first_name", "firstName", String.class),

        // 预留扩展位
        ;

        @Getter
        public final String column;
        @Getter
        public final String field;
        @Getter
        public final Class<?> type;

        InteriorColumnEnum(String column, String field, Class<?> type) {
            this.column = column;
            this.field = field;
            this.type = type;
        }
    }
}
