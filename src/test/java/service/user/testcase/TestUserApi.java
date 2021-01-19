package service.user.testcase;



import cn.hutool.core.map.MapUtil;
import org.junit.jupiter.api.Test;
import service.user.api.UserApi;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class TestUserApi {
    @Test
    public void get(){
        UserApi user=new UserApi();
        user.get("seveniruby").then().body("errcode", equalTo(0));
    }


    @Test
    public void update(){
        UserApi user=new UserApi();
//        String userid="WangQi";
//        String email="931916854@qq.com";

   // 引用，开源工具类
        Map<Object,Object> map= MapUtil.builder()
                .put("userid","WangQi")
                .put("email","931916854@qq.com").build();


        user.update(map).then().body("errcode",equalTo(0));


    }
}
