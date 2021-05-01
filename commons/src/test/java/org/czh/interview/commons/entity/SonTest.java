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
public class SonTest extends ParentTest {

    @NotBlank
    @Getter
    private String sPri;
    @NotEmpty
    @Getter
    protected String sPro;
    @NotNull
    @Getter
    String sDef;
    @Pattern(regexp = "yyyy-MM-dd")
    @Getter
    public String sPub;

    @NotBlank
    @Getter
    private static String sPriSta;
    @NotEmpty
    @Getter
    protected static String sProSta;
    @NotNull
    @Getter
    static String sDefSta;
    @Pattern(regexp = "yyyy-MM-dd")
    @Getter
    public static String sPubSta;

    static {
        init();
    }

    public SonTest() {
        super();
        this.sPri = "sPriVa";
        this.sPro = "sProVa";
        this.sDef = "sDefVa";
        this.sPub = "sPubVa";
        init();
    }

    private static void init() {
        SonTest.sPriSta = "sPriStaVa";
        SonTest.sProSta = "sProStaVa";
        SonTest.sDefSta = "sDefStaVa";
        SonTest.sPubSta = "sPubStaVa";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SonTest)) return false;
        SonTest sonTest = (SonTest) o;
        return Objects.equals(sPri, sonTest.sPri)
                && Objects.equals(sPro, sonTest.sPro)
                && Objects.equals(sDef, sonTest.sDef)
                && Objects.equals(sPub, sonTest.sPub);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sPri, sPro, sDef, sPub);
    }

    @Override
    public String toString() {
        return "SonTest{" +
                "pPro='" + pPro + '\'' +
                ", pDef='" + pDef + '\'' +
                ", pPub='" + pPub + '\'' +
                ", sPri='" + sPri + '\'' +
                ", sPro='" + sPro + '\'' +
                ", sDef='" + sDef + '\'' +
                ", sPub='" + sPub + '\'' +
                '}';
    }

    private String getSPriMet() {
        return "sPriMet";
    }

    protected String getSProMet() {
        return "sProMet";
    }

    String getSDefMet() {
        return "sDefMet";
    }

    public String getSPubMet() {
        return "sPubMet";
    }

    private static String getSPriStaMet() {
        return "sPriStaMet";
    }

    protected static String getSProStaMet() {
        return "sProStaMet";
    }

    static String getSDefStaMet() {
        return "sDefStaMet";
    }

    public static String getSPubStaMet() {
        return "sPubStaMet";
    }
}