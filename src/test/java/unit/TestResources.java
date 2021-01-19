package unit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.github.mustachejava.MustacheFactory;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class TestResources {
    public String name;
    public int age;

    @Test
    public void readFile() throws IOException {
        System.out.println(this.getClass().getName());
        System.out.println(this.getClass().getCanonicalName());
        System.out.println(this.getClass().getResource("/"));
        System.out.println(this.getClass().getResource("/app/testcase/TestSearch.yaml"));
        System.out.println(
                FileUtils.readFileToString(
                        new File(
                                this.getClass().getResource("/app/testcase/TestSearch.yaml").getPath()), "UTF-8"));

    }
//将方法中的参数写成json格式

    @Test
    public void writeJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("demo.json"), this);

    }
//json文件中读取name的值，并打印
    @Test
    public void readJson() throws IOException {
        ObjectMapper mapper=new ObjectMapper();
        TestResources demo=mapper.readValue(new File("demo.json"), this.getClass()); //生成了一个类
        System.out.println(demo);
        System.out.println(demo.name);
    }
//从yaml文件中读取参数
    @Test
    public void readYaml() throws IOException {
        ObjectMapper mapper=new ObjectMapper(new YAMLFactory());
        Object[][] demo=mapper.readValue(this.getClass().getResourceAsStream("/app/testcase/TestSearch.yaml"),
                Object[][].class);
        System.out.println(demo);

        System.out.println(demo.length);
        System.out.println(demo[0].length);
        System.out.println(demo[0]);
        System.out.println(demo[0][0]);



    }
//







}
