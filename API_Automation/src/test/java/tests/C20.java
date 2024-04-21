package tests;

import baseUrl.DummyBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataDummy;

import static io.restassured.RestAssured.given;

public class C20 extends DummyBaseURL {

    @Test
    public void get01() {


        // 1 - URL hazirla
        specDummy.pathParams("pp1", "api", "pp2", "v1", "pp3", "employee", "pp4", 3);

        // 2 - Expected Data hazirla
        TestDataDummy testDataDummy = new TestDataDummy();
        JSONObject expData = testDataDummy.expectedBodyOlusturJson();

        // 3 - Response'i Kaydet
        Response response=given().spec(specDummy).when().get("/{pp1}/{pp2}/{pp3}/{pp4}");

        // 4 - Assertion
        JsonPath resJP=response.jsonPath();

        Assert.assertEquals(expData.get("status"),resJP.get("status"));
        Assert.assertEquals(expData.get("message"),resJP.get("message"));
        Assert.assertEquals(expData.getJSONObject("data").get("id"),resJP.get("data.id"));
        Assert.assertEquals(expData.getJSONObject("data").get("employee_name"),resJP.get("data.employee_name"));
        Assert.assertEquals(expData.getJSONObject("data").get("employee_salary"),resJP.get("data.employee_salary"));
        Assert.assertEquals(expData.getJSONObject("data").get("employee_age"),resJP.get("data.employee_age"));
        Assert.assertEquals(expData.getJSONObject("data").get("profile_image"),resJP.get("data.profile_image"));


    }
}
