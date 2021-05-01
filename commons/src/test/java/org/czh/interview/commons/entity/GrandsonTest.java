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
public class GrandsonTest extends SonTest {

    @NotBlank
    private String gPri;
    @NotEmpty
    protected String gPro;
    @NotNull
    String gDef;
    @Pattern(regexp = "yyyy-MM-dd")
    public String gPub;

    @NotBlank
    private static String gPriSta;
    @NotEmpty
    protected static String gProSta;
    @NotNull
    static String gDefSta;
    @Pattern(regexp = "yyyy-MM-dd")
    public static String gPubSta;

    static {
        init();
    }

    public GrandsonTest() {
        super();
        this.gPri = "gPriVa";
        this.gPro = "gProVa";
        this.gDef = "gDefVa";
        this.gPub = "gPubVa";
        init();
    }

    private static void init() {
        GrandsonTest.gPriSta = "gPriStaVa";
        GrandsonTest.gProSta = "gProStaVa";
        GrandsonTest.gDefSta = "gDefStaVa";
        GrandsonTest.gPubSta = "gPubStaVa";
    }

    private String getGPriMet() {
        return "gPriMet";
    }

    protected String getGProMet() {
        return "gProMet";
    }

    String getGDefMet() {
        return "gDefMet";
    }

    public String getGPubMet() {
        return "gPubMet";
    }

    private static String getGPriStaMet() {
        return "gPriStaMet";
    }

    protected static String getGProStaMet() {
        return "gProStaMet";
    }

    static String getGDefStaMet() {
        return "gDefStaMet";
    }

    public static String getGPubStaMet() {
        return "gPubStaMet";
    }
}
