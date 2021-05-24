package org.czh.interview.object_interview.hash_equals_to_string;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : czh
 * description :
 * date : 2021-05-18
 * email 916419307@qq.com
 */
@SuppressWarnings("unused")
public class Bean2 {

    private int anInt;
    private Integer bInt;
    private float aFloat;
    private Float bFloat;
    private double[] doubles1;
    private Double[] doubles2;
    private List<Boolean> aList;
    private BigDecimal bigDecimal;

    public Bean2() {
    }

    public Bean2(int anInt,
                 Integer bInt,
                 float aFloat,
                 Float bFloat,
                 double[] doubles1,
                 Double[] doubles2,
                 List<Boolean> aList,
                 BigDecimal bigDecimal) {
        this.anInt = anInt;
        this.bInt = bInt;
        this.aFloat = aFloat;
        this.bFloat = bFloat;
        this.doubles1 = doubles1;
        this.doubles2 = doubles2;
        this.aList = aList;
        this.bigDecimal = bigDecimal;
    }

    public Bean2(Bean2 source) {
        this.anInt = source.anInt;
        this.bInt = source.bInt;
        this.aFloat = source.aFloat;
        this.bFloat = source.bFloat;
        this.doubles1 = source.doubles1;
        this.doubles2 = source.doubles2;
        this.aList = source.aList;
        this.bigDecimal = source.bigDecimal;
    }

    public static Bean2 getDefaultBean() {
        List<Boolean> aList = new ArrayList<>();
        Collections.addAll(aList, true, false, null, Boolean.TRUE, Boolean.FALSE);
        return new Bean2(1,
                2,
                3.0F,
                4.1F,
                new double[]{5.2D, 6.3d},
                new Double[]{null, 7.4D, 8.5d},
                aList,
                new BigDecimal("9.6")
        );
    }
}
