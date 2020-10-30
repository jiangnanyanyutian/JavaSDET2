package apitest.department.testcase;

import apitest.department.api.deparmentmanage;
import apitest.gettoken.gettoken;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;

public class departmenttestcase {
    public static gettoken gettoken=new gettoken();
    public  static  deparmentmanage deparmentmanage=new deparmentmanage();
    public static String TOKEN;
    public static  String departmentname;
    public  static  int parentid;
    @BeforeClass
    public static void setup(){
        TOKEN=gettoken.GETTOKEN();
         departmentname="智康财务";

        parentid=1;
    }


    @Test
    public void departmentlist(){

        deparmentmanage.deparmentlist(TOKEN);


    }
    @Test
    public void creatdepartment(){
        deparmentmanage.creatdepartment(TOKEN,departmentname,parentid).body().path("errmsg", String.valueOf(equalTo("created")));
    }
}

