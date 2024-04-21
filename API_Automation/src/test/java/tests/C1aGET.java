package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C1aGET {
    /*
https://restful-booker.herokuapp.com/booking/10 url'ine bir GET request
gonderdigimizde donen Response'un,
    status code'unun 200,
    ve content type'inin application/json; charset=utf-8, ve
    Server isimli Header'in degerinin Cowboy,
    ve status Line'in HTTP/1.1 200 OK
    ve response suresinin 5 sn'den kisa oldugunu manuel olarak test ediniz.
 */
    // API Testlerinde 4 işlem ile test yapılır
    /*
1-EndPoint belirlenir
2-Gerekli ise Expected Data Hazırlanır
3-Actual Data kaydedilir
4-Assertion işlemi gerçekleştirilir

1-EndPoint Belirlenir: EndPoint, bir web hizmetine veya API'ye erişmek için kullanılan URL'yi
ifade eder. İlk olarak, test edilecek API'nin endpoint'i belirlenir.
Bu, testin hangi API endpoint'ini hedeflediğini ve hangi kaynağa veya hizmete
istek gönderileceğini belirlemeyi içerir.

2-Gerekli İse Beklenen Veri Hazırlanır(Expected Data): Test senaryosunun gereksinimlerine
bağlı olarak, beklenen veri hazırlanabilir. Bu, testin başarılı olması için API'den dönen
verinin ne olması gerektiğini tanımlamayı içerir. Örneğin, bir kaynak oluşturulduğunda
veya güncellendiğinde beklenen yanıtın ne olması gerektiği gibi.

3-Gerçek Veri Alınır (Actual Data): API'ye istek gönderilir ve gerçek veri alınır.
Bu adım, belirlenen API endpoint'ine isteğin yapılmasını ve geri dönen yanıtın alınmasını içerir.

4-Doğrulama (Assertion): Son olarak, alınan yanıtın beklenen sonuçlarla uyumlu olup olmadığını
kontrol etmek için bir doğrulama işlemi yapılır. Bu, HTTP yanıt kodunun, yanıtın içeriğinin
ve belirli başlıkların doğruluğunun kontrol edilmesini içerir. Bu adım, testin başarılı olup
olmadığını belirlemek için kullanılır.
*/

    @Test
    public void get01(){
        //1-EndPoint belirlenir
        String url="https://restful-booker.herokuapp.com/booking/10";

        //2-Gerekli ise Expected Data Hazırlanır

        //3-Actual Data kaydedilir
        Response response=given().when().get(url);

        //4-Assertion
        System.out.println("Status code: "+response.getStatusCode());
        System.out.println("Content type: "+response.getContentType());
        System.out.println("Server: "+response.getHeader("Server"));
        System.out.println("Status line: "+response.getStatusLine());
        System.out.println("Test time: "+response.getTime()+ " ms");
    }
}
