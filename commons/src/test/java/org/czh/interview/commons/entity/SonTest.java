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
public class SonTest extends ParentTest {

    @NotBlank
    private String sPri;
    @NotEmpty
    protected String sPro;
    @NotNull
    String sDef;
    @Pattern(regexp = "yyyy-MM-dd")
    public String sPub;

    @NotBlank
    private static String sPriSta;
    @NotEmpty
    protected static String sProSta;
    @NotNull
    static String sDefSta;
    @Pattern(regexp = "yyyy-MM-dd")
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