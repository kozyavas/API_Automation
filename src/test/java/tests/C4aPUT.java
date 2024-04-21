package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C4aPUT {
    /*
        C4_Put_ResponseBilgileriAssertion
                https://jsonplaceholder.typicode.com/posts/70 url’ine asagidaki Json
                formatindaki body ile bir PUT request gonderdigimizde
                {
                    "title": "Ahmet",
                    "body": "Merhaba",
                    "userId": 10,
                    "id": 70
                }
                donen Response’un,
                 status code’unun 200,
                 ve content type’inin application/json; charset=utf-8,
                 ve Server isimli Header’in degerinin cloudflare,
                 ve status Line’in HTTP/1.1 200 OK
                     */

    /*
1. PUT isteği, bir kaynağın güncellenmesi için kullanılır ve geri dönen yanıt,
güncellenmiş kaynağın durumunu yansıtır.

2. PUT isteğinin yanıtını kontrol ederek, yapılan güncellemenin başarıyla
gerçekleşip gerçekleşmediğini doğrulayabiliriz.

3. Bu şekilde, API'nin beklendiği gibi çalıştığını ve istenen değişikliklerin
yapıldığını doğrulamış oluruz.
     */
    @Test
    public void put01() {
        // 1-Endpoint ve Request Body hazirla
        String url = "https://jsonplaceholder.typicode.com/posts/70";

        /*
        Veri oluştururken veya veri üzerinde işlem yaparken, JSONObject kullanarak
        JSON formatındaki verileri kolayca oluşturabilir, düzenleyebilir ve yönetebiliriz.
        Bu, API isteklerinin oluşturulması ve işlenmesi sürecini daha kolay ve daha esnek hale getirir.
        Bu nedenle, genellikle API isteklerinde request body oluşturmak için JSONObject kullanılır.
         */
        JSONObject reqBody = new JSONObject();
        reqBody.put("title", "Ahmet");
        reqBody.put("body", "Merhaba");
        reqBody.put("userId", 10);
        reqBody.put("id", 70);

        // 2- Expected data hazirla

        // 3- Responseí kaydet
        // NOT : Eger sorgumuzda bir request body gonderiyorsak gonderdigimiz datanin formatini
        // belirtmek zorundayiz. Bunu da hemen given() methodundan sonra pre-condition olarak belirtebiliriz.

        Response response = given()
                //given(), REST Assured kütüphanesindeki bir başlangıç noktasıdır
                // ve bir HTTP isteğini tanımlamak için kullanılır.
                // Bu metod genellikle bir HTTP isteği başlatmadan önce yapılandırma ve
                // ön ayarları belirtmek için kullanılır.
                .contentType(ContentType.JSON)
                //Sunucu, gelen isteği analiz ederken, isteğin içeriğinin hangi türde olduğunu bilmesi gerekir.
                // Bu nedenle, gönderilen verinin türünü belirtmek önemlidir.
                // Bu durumda, JSON içeriğinin olduğunu belirtmek için ContentType.JSON kullanılmıştır.
                .when()
                //when() metodundan sonra genellikle HTTP isteğinin türü (GET, POST, PUT, DELETE vb.) ve
                // hedef URL belirtilir. Bu şekilde, HTTP isteği başlatılır ve belirtilen URL'ye yönlendirilir.
                // İsteğin yapılması için gerekli olan bilgileri ve yapılandırmaları zaten given() metodunda
                // belirlemiş olursunuz.
                .body(reqBody.toString())
                // toString() metodunun kullanılmasının nedeni, reqBody değişkeninin ne tür
                // bir veri yapısına sahip olduğuna bağlıdır. Normalde, reqBody bir JSON nesnesi olmalıdır.
                // Ancak, bazen reqBody başka bir veri türüne sahip olabilir, örneğin bir dize veya
                // bir başka nesne türü olabilir.
                .put(url);
        // Bu kod parçasında, put() metodu HTTP PUT isteğinin oluşturulması için kullanılmıştır.
        // Yani, given() ve when() metodlarıyla yapılandırılan isteğin, belirtilen URL'ye
        // bir güncelleme işlemi yapması amaçlanmıştır.

        //4- Assertion
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server", "cloudflare")
                .statusLine("HTTP/1.1 200 OK");

        // when() metodu, HTTP isteğinin yapılmasını sağlar ve bir Response nesnesi döndürür.
        // Ardından, then() metodu kullanılarak bu yanıt doğrulanabilir.
        // then() metodu, yanıtı doğrulama için çeşitli yöntemler sağlar,
        // bu yöntemler arasında durum kodu kontrolü, başlık doğrulama, içerik doğrulama
        // ve daha fazlası bulunur.
        // Yani, HTTP isteği yapmak için when() metodu kullanılırken,
        // gelen yanıtı doğrulamak için then() metodu kullanılır.
        // Bu doğrulama aşamasında, yanıtın beklenen özelliklerini kontrol edebiliriz.


    }
}
