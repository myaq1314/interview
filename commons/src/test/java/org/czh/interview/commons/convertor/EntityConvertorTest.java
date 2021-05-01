package org.czh.interview.commons.convertor;

import com.alibaba.fastjson.JSONObject;
import org.czh.interview.commons.entity.EntityTest;
import org.czh.interview.commons.entity.SonTest;
import org.czh.interview.commons.validate.EqualsAssert;
import org.junit.Test;

import java.util.Map;

/**
 * @author : czh
 * description :
 * date : 2021-05-02
 * email 916419307@qq.com
 */
public class EntityConvertorTest {

    @Test
    public void convertToMapTest() {
        SonTest son = new SonTest();
        Map<String, Object> map = EntityConvertor.convertToMap(son);
        System.out.println(map);

        EqualsAssert.equals(son.getPPri(), map.get("pPri"));
        EqualsAssert.equals(son.getPPro(), map.get("pPro"));
        EqualsAssert.equals(son.getPDef(), map.get("pDef"));
        EqualsAssert.equals(son.getPPub(), map.get("pPub"));
        EqualsAssert.equals(SonTest.getPPriSta(), map.get("pPriSta"));
        EqualsAssert.equals(SonTest.getPProSta(), map.get("pProSta"));
        EqualsAssert.equals(SonTest.getPDefSta(), map.get("pDefSta"));
        EqualsAssert.equals(SonTest.getPPubSta(), map.get("pPubSta"));
        EqualsAssert.equals(son.getSPri(), map.get("sPri"));
        EqualsAssert.equals(son.getSPro(), map.get("sPro"));
        EqualsAssert.equals(son.getSDef(), map.get("sDef"));
        EqualsAssert.equals(son.getSPub(), map.get("sPub"));
        EqualsAssert.equals(SonTest.getSPriSta(), map.get("sPriSta"));
        EqualsAssert.equals(SonTest.getSProSta(), map.get("sProSta"));
        EqualsAssert.equals(SonTest.getSDefSta(), map.get("sDefSta"));
        EqualsAssert.equals(SonTest.getSPubSta(), map.get("sPubSta"));
    }

    @Test
    public void convertToJsonObjectTest() {
        EntityTest entityTest = new EntityTest();
        entityTest.setId(2L);
        entityTest.setName("TOM");
        entityTest.setAge(18);
        entityTest.setPrice(6.42D);

        JSONObject jsonObject = EntityConvertor.convertToJsonObject(entityTest);
        System.out.println(jsonObject);

        String jsonString = EntityConvertor.convertToJsonString(entityTest);
        System.out.println(jsonString);
    }
}
