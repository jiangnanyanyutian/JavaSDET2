package framework;

import app.page.BasePage;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import service.Work;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import  service.user.api.BaseApi;

public class ApiObjectMethodModel {
    private HashMap<Object, Object> params;
    public HashMap<String, Object> query;
    public HashMap<String, Object> header;
    public HashMap<String, Object> postBody;
    public String postBodyRaw;
    public String method = "";
    public String url = "";

    public    String dataK;
    public String dataV;
    public HashMap<String,Object> data = new HashMap<>();

    public Response run() {
        RequestSpecification request = given();
        request.queryParam("access_token", Work.getInstance().getToken());

        if (query != null) {
            query.entrySet().forEach(entry -> {
                request.queryParam(entry.getKey(), repalce(entry.getValue().toString()));
            });
        }

        if (header != null) {
            header.entrySet().forEach(entry -> {
                request.header(entry.getKey(), repalce(entry.getValue().toString()));
            });
        }

        if (postBody != null) {
            //todo: replace hashmap读出来的是个字符串，需要转换成hashmap
            //request.body(postBody);


            //尝试转成hashmap
            postBody.entrySet().forEach(entry ->{

               dataK= entry.getKey();
               dataV=repalce(entry.getValue().toString());
               data.put(dataK,dataV);


            });
            request.body(data);


        }




        if (postBodyRaw != null) {
            request.body(repalce(postBodyRaw));
        }

        //读模板尝试,,好像行不通，还是直接写来的方便，
//        if (postBodyRaw.equals("temple")){
//            BaseApi baseApi=new BaseApi();
//
//          String body=baseApi.template("/service/user/api/user.json", data);
//
//            request.body(body);
//        }




        return request
                .when().log().all().request(method, url)
                .then().log().all().extract().response();
    }

    public String repalce(String raw){
        for (Map.Entry<Object, Object> kv : params.entrySet()) {
            String matcher = "${" + kv.getKey() + "}";
            if (raw.contains(matcher)) {
                System.out.println(kv);
                raw = raw.replace(matcher, kv.getValue().toString());
            }
        }
        return raw;
    }

    public Response run(HashMap<Object, Object> params) {
        this.params=params;
        return run();
    }
}
