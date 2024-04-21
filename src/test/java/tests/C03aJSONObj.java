package tests;

import org.json.JSONObject;
import org.junit.Test;

public class C03aJSONObj {

    /*
           Asagidaki JSON Objesini olusturup konsolda yazdirin.
                     {
                     "title":"Ahmet",
                     "body":"Merhaba",
                     "userId":1
                     }
      */

    @Test
    public void JSONDataOlusturma01() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title", "Ahmet");
        jsonObject.put("body", "Merhaba");
        jsonObject.put("userId", 1);

        System.out.println("JSon bilgiler: " + jsonObject);

    }

    @Test
    public void JSONDataOlusturma02() {

        JSONObject innerData = new JSONObject();// once inner data object olusturulur
        innerData.put("checkin", "2018-01-01");
        innerData.put("checkout", "2019-01-01");

        JSONObject outerData = new JSONObject();// sonra outer data object olusturulur
        outerData.put("firstname", "Jim");
        outerData.put("lastname", "Brown");
        outerData.put("bookingdates", innerData);// burasi inner data oldugu icin
        // value degeri yukarida hazirladigimiz innerData oldu

        outerData.put("totalprice", 111);
        outerData.put("depositpaid", true);
        outerData.put("additionalneeds", "Breakfast");

        System.out.println("JSON data: " + outerData);

    }
}
