package service.user.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import framework.ApiObjectModel;
import io.restassured.response.Response;

import java.io.*;
import java.util.HashMap;

public class BaseApi {
    ApiObjectModel model = new ApiObjectModel();

   // HashMap<String, java.lang.Object> params;
    HashMap<Object, Object> params;

    public Response parseSteps() {
        String method = Thread.currentThread().getStackTrace()[2].getMethodName();
        System.out.println(method);

        if(model.methods.entrySet().isEmpty()) {
            System.out.println("pom first load");
            String path = "/" + this.getClass().getCanonicalName().replace('.', '/') + ".yaml";
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            try {
                model = mapper.readValue(
                        BaseApi.class.getResourceAsStream(path), ApiObjectModel.class
                );
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return (Response) model.run(method,params);




    }

    public void setParams(HashMap<Object, java.lang.Object> data){
        params=data;
    }


    //模板技术实现参数读取

    public String template(String templatePath, HashMap<String, java.lang.Object> data){
        Writer writer = new StringWriter();
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile(this.getClass().getResource(templatePath).getPath());
        mustache.execute(writer, data);
        try {
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return writer.toString();
    }







}
