package org.czh.interview.commons.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author : czh
 * description :
 * date : 2021-05-02
 * email 916419307@qq.com
 */
@SuppressWarnings("unused")
public class ParentTest implements PersonTest {

    @NotBlank
    private String pPri;
    @NotEmpty
    protected String pPro;
    @NotNull
    String pDef;
    @Pattern(regexp = "yyyy-MM-dd")
    public String pPub;

    @NotBlank
    private static String pPriSta;
    @NotEmpty
    protected static String pProSta;
    @NotNull
    static String pDefSta;
    @Pattern(regexp = "yyyy-MM-dd")
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