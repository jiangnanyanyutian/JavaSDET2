package service.user.api;

import io.restassured.response.Response;
import service.Work;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserApi extends BaseApi {
    public Response get(String userid) {
        HashMap<Object, Object> params=new HashMap<>();
        params.put("userid", userid);
        setParams(params);

        return parseSteps();

//没有封装之前的写法
//        return given()
//                .queryParam("access_token", Work.getInstance().getToken())
//                .queryParam("userid", userid)
//                .when().log().all().get("https://qyapi.weixin.qq.com/cgi-bin/user/get")
//        .then().log().all().extract().response();

    }
//没有封装之前的写法
//    public Response update(String userid,String email, HashMap<String, Object> data) {
//        data.put("userid", userid);
//        data.put("email",email);
//
//        return given()
//                .queryParam("access_token", Work.getInstance().getToken())
//                .body(data).log().all()
//                .when().log().all().post("https://qyapi.weixin.qq.com/cgi-bin/user/update")
//                .then().extract().response();
//    }

    public Response update(Map<Object, Object> data) {
        setParams((HashMap<Object, Object>) data);
        return parseSteps();
    }



    public Response create(String userid, HashMap<String, Object> data) {
        data.put("userid", userid);

        return given()
                .queryParam("access_token", Work.getInstance().getToken())
                .body(data)
                .when().log().all().post("https://qyapi.weixin.qq.com/cgi-bin/user/create")
                .then().log().all().extract().response();
    }

   //创建用户，需要填写大量的入参

//    public Response clone(String userid, HashMap<String, Object> data) {
//        data.put("userid", userid);
//
//        //todo: 使用模板技术
//
//        String body=template("/service/user/api/user.json", data);
//
//        return given()
//                .queryParam("access_token", Work.getInstance().getToken())
//                .contentType(ContentType.JSON)
//                .body(body)
//                .when().log().all().post("https://qyapi.weixin.qq.com/cgi-bin/user/create")
//                .then().log().all().extract().response();
//    }

    public Response clone(String userid, HashMap<String, Object> data){

        data.put("userid", userid);

        //todo: 使用模板技术

        String body=template("/service/user/api/user.json", data);


        return parseSteps();
    }





    public Response delete(String userid) {
        return given()
                .queryParam("access_token", Work.getInstance().getToken())
                .queryParam("userid", userid)
                .when().log().all().get("https://qyapi.weixin.qq.com/cgi-bin/user/delete")
                .then().log().all().extract().response();
    }





}
