package apitest.gettoken;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class gettoken {
    String TOKEN;

//@Test
    public  String GETTOKEN(){

        TOKEN=given()
                .param("corpsecret","e72EEX6tv6BwyN3mwaJGR0NeeMHsFb7qPnMFZ3Io36c")
                .param("corpid","ww52704e1c31965178")
                .when()
                .log().all()
                .get(" https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then()
                .log().all()
                .body("errcode",equalTo(0))
                .extract()
                .body().path("access_token");
        System.out.println(TOKEN);


       return TOKEN;

    }




}
