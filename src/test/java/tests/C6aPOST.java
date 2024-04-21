package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C6aPOST {

//    POST: Yeni kaynak oluşturmak veya veri göndermek için kullanılır.
//    PUT: Varolan bir kaynağı güncellemek için kullanılır.

    /*
        https://jsonplaceholder.typicode.com/posts url’ine asagidaki body ile bir POST request
        gonderdigimizde
                {
                "title":"API",
                "body":"API ogrenmek ne guzel",
                 "userId":97,
                }
        donen Response’un,
            status code’unun 201,
            ve content type’inin application/json

        ve Response Body'sindeki,
           "title"'in "API" oldugunu
           "userId" degerinin 100'den kucuk oldugunu
           "body" nin "API" kelimesi icerdigini
        test edin.
     */

    @Test
    public void post01() {
        //1-Endpoint ve Request body hazirlama
        String url = "https://jsonplaceholder.typicode.com/posts";

        JSONObject reqBody = new JSONObject();
        reqBody.put("title", "API");
        reqBody.put("body", "API ogrenmek ne guzel");
        reqBody.put("userId", 97);

        //2-Soruda expected data verilmediği için oluşturulmadı

        //3-Dönen Response kaydedilir
        Response response = given()
                .contentType("application/json")
                .when()
                .body(reqBody.toString())
                .post(url);
//body() Metodu: Bu metot, isteğin gövdesini belirtir. reqBody.toString() ifadesi ile
//önceden hazırlanan reqBody adlı JSONObject'nin string halini alarak isteğin gövdesi olarak belirlenir.
//Bu adım, isteğin gövdesinin hangi verileri içereceğini belirler.

//post() Metodu: Bu metot, REST Assured zincirleme yapısında bir adımdır ve bir POST isteğinin
//gönderilmesini sağlar. Bu adımda, daha önce belirlenen ayarlar ve gövde ile birlikte POST isteği gönderilir.

        //4-Assertion
        response.then().assertThat()
                .statusCode(201)
                .contentType("application/json")
                .body("title", equalTo("API"))
                .body("userId",Matchers.lessThan(100))
                .body("body",Matchers.containsString("API"));
    }
}
