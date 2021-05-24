package org.czh.interview.object_interview.hash_equals_to_string;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author : czh
 * description :
 * date : 2021-05-18
 * email 916419307@qq.com
 */
@Setter
@Getter
@SuppressWarnings("unused")
public class Bean1 implements java.lang.Cloneable {

    private int anInt;
    private Integer bInt;
    private float aFloat;
    private Float bFloat;
    private double[] doubles1;
    private Double[] doubles2;
    private List<Boolean> aList;
    private BigDecimal bigDecimal;

    public Bean1() {
    }

    public Bean1(int anInt,
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

    public Bean1(Bean1 source) {
        this.anInt = source.anInt;
        this.bInt = source.bInt;
        this.aFloat = source.aFloat;
        this.bFloat = source.bFloat;
        this.doubles1 = source.doubles1;
        this.doubles2 = source.doubles2;
        this.aList = source.aList;
        this.bigDecimal = source.bigDecimal;
    }

    public static Bean1 getDefaultBean() {
        List<Boolean> aList = new ArrayList<>();
        Collections.addAll(aList, true, false, null, Boolean.TRUE, Boolean.FALSE);
        return new Bean1(1,
                2,
                3.0F,
                4.1F,
                new double[]{5.2D, 6.3d},
                new Double[]{null, 7.4D, 8.5d},
                aList,
                new BigDecimal("9.6")
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Bean1)) {
            return false;
        }
        Bean1 that = (Bean1) o;
        return anInt == that.anInt
                && Float.compare(that.aFloat, aFloat) == 0
                && Objects.equals(bInt, that.bInt)
                && Objects.equals(bFloat, that.bFloat)
                && Arrays.equals(doubles1, that.doubles1)
                && Arrays.equals(doubles2, that.doubles2)
                && Objects.equals(aList, that.aList)
                && Objects.equals(bigDecimal, that.bigDecimal);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(anInt
                , bInt
                , aFloat
                , bFloat
                , aList
                , bigDecimal);
        result = 31 * result + Arrays.hashCode(doubles1);
        result = 31 * result + Arrays.hashCode(doubles2);
        return result;
    }

    @Override
    public String toString() {
        return "Bean1{"
                + "anInt=" + anInt
                + ", bInt=" + bInt
                + ", aFloat=" + aFloat
                + ", bFloat=" + bFloat
                + ", doubles1=" + Arrays.toString(doubles1)
                + ", doubles2=" + Arrays.toString(doubles2)
                + ", aList=" + aList
                + ", bigDecimal=" + bigDecimal
                + '}';
    }

    @Override
    protected Bean1 clone() throws CloneNotSupportedException {
        Bean1 clone = (Bean1) super.clone();
        if (doubles1 != null) {
            if (doubles1.length == 0) {
                clone.setDoubles1(new double[]{});
            } else {
                clone.setDoubles1(Arrays.copyOf(doubles1, doubles1.length));
            }
        }
        if (doubles2 != null) {
            if (doubles2.length == 0) {
                clone.setDoubles2(new Double[]{});
            } else {
                clone.setDoubles2(Arrays.copyOf(doubles2, doubles2.length));
            }
        }
        if (aList != null) {
            if (aList.size() == 0) {
                clone.setAList(new ArrayList<>());
            } else {
                List<Boolean> bList = new ArrayList<>(aList.size());
                bList.addAll(aList);
                clone.setAList(bList);
            }
        }
        return clone;
    }
}
