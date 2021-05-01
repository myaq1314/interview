package org.czh.interview.commons.entity;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

/**
 * @author : czh
 * description :
 * date : 2021-05-02
 * email 916419307@qq.com
 */
@SuppressWarnings("unused")
public class ParentTest implements PersonTest {

    @NotBlank
    @Getter
    private String pPri;
    @NotEmpty
    @Getter
    protected String pPro;
    @NotNull
    @Getter
    String pDef;
    @Pattern(regexp = "yyyy-MM-dd")
    @Getter
    public String pPub;

    @NotBlank
    @Getter
    private static String pPriSta;
    @NotEmpty
    @Getter
    protected static String pProSta;
    @NotNull
    @Getter
    static String pDefSta;
    @Pattern(regexp = "yyyy-MM-dd")
    @Getter
    public static String pPubSta;

    static {
        init();
    }

    public ParentTest() {
        this.pPri = "pPriVa";
        this.pPro = "pProVa";
        this.pDef = "pDefVa";
        this.pPub = "pPubVa";
        init();
    }

    private static void init() {
        ParentTest.pPriSta = "pPriStaVa";
        ParentTest.pProSta = "pProStaVa";
        ParentTest.pDefSta = "pDefStaVa";
        ParentTest.pPubSta = "pPubStaVa";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParentTest)) return false;
        ParentTest that = (ParentTest) o;
        return Objects.equals(pPri, that.pPri)
                && Objects.equals(pPro, that.pPro)
                && Objects.equals(pDef, that.pDef)
                && Objects.equals(pPub, that.pPub);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pPri, pPro, pDef, pPub);
    }

    @Override
    public String toString() {
        return "ParentTest{" +
                "pPri='" + pPri + '\'' +
                ", pPro='" + pPro + '\'' +
                ", pDef='" + pDef + '\'' +
                ", pPub='" + pPub + '\'' +
                '}';
    }

    private String getPPriMet() {
        return "pPriMet";
    }

    protected String getPProMet() {
        return "pProMet";
    }

    String getPDefMet() {
        return "pDefMet";
    }

    public String getPPubMet() {
        return "pPubMet";
    }

    private static String getPPriStaMet() {
        return "pPriStaMet";
    }

    protected static String getPProStaMet() {
        return "pProStaMet";
    }

    static String getPDefStaMet() {
        return "pDefStaMet";
    }

    public static String getPPubStaMet() {
        return "pPubStaMet";
    }
}