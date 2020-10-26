package apitest.department.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.eclipse.jetty.util.HostMap;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class deparmentmanage {

    public Response deparmentlist(String TOKEN) {
        return given()
                .param("access_token", TOKEN)
                //.param("id", id)
                .when()
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/list")
                .then()
                .log().all()
                .body("errcode", equalTo(0))
                .extract()
                .response();

    }

    public Response creatdepartment(String TOKEN, String departmentname, int parentid) {
        HashMap<String, Object> data = new HostMap<>();
        data.put("name", departmentname);
        data.put("parentid", parentid);
        return given()
                .queryParam("access_token", TOKEN)
                .contentType(ContentType.JSON)
                .body(data)
                .when().log().all()
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
                .then().log().all()
                .body("errcode", equalTo(0))
                .extract()
                .response();
    }


    public Response updatedepartment(String TOKEN, String RENAME,int departmentid) {
      return creatdepartment(TOKEN,RENAME,departmentid);
    }

    public Response deletdepartment(String TOKEN,int deleteid) {
        return given()
                .param("access_token", TOKEN)
                .param("id", deleteid)
                .when()
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/delete")
                .then()
                .log().all()
                .body("errcode", equalTo(0))
                .extract()
                .response();
    }


}
