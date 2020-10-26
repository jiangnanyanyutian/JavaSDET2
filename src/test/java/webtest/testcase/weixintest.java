package webtest.testcase;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import webtest.pageboject.*;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class weixintest {

    public static HomePage homepage = new HomePage();

    public static String name;
    public static String accountID;
    public static String phone;
    public static String menber;
    public static String title;
    public static String content;
    public static String addtionURL;
    public static String picture;
    public static String summary;
    public static String author;
    private String js;

    //测试之前设置环境
    @BeforeClass
    public static void setup() {

        homepage.login();
        //设置添加成员信息
        name = "小燕子";
        accountID = "8833";
        phone = "13949135563";
        //设置消息群发参数
        menber = "王启";
        title = "消息群发测试title";
        content = "你有新的快递，请注意查收，取件请凭取件码。";
        addtionURL = "C:\\Users\\Administrator\\Desktop\\54310245.jpg";
        picture = "C:\\Users\\Administrator\\Desktop\\54310245.jpg";
        summary = "消息概要summary";
        author = "tester";


    }

    //测试完成之后清理
    @AfterClass
    public static void teardown() throws InterruptedException {
        homepage.close();
    }

    //删除上次test添加的成员
    @Test
    public void delete() {
        homepage.mennu_contact();
        addressBookPage addressBookPage = new addressBookPage();
        addressBookPage.deletemenber(phone);
    }

    @Test
    //添加成员测试用例开始
    public void addmember() throws InterruptedException {

        homepage.menberadd();
        addressBookPage addressBookPage = new addressBookPage();
        addressBookPage.addmenberd(name, accountID, phone);


    }

    @Test
    //通过勾选删除
    public void checkboxdelete() {

        homepage.mennu_contact();
        addressBookPage addressBookPage = new addressBookPage();
        addressBookPage.checkboxdelet();
    }

    @Test
    //上传图片
    public void uploadfile() throws InterruptedException {
        homepage.loadcontactbook();
        BachLoadPage BachLoadPage = new BachLoadPage();
        BachLoadPage.uploadfile("C:\\Users\\Administrator\\Desktop\\通讯录批量导入模板.xlsx");


    }

    @Test
    //消息群发
    public void sendmessage() throws InterruptedException {
        homepage.groupmessagesend();
        SendMassagePage sendMassagePage = new SendMassagePage();
        sendMassagePage.sendmessage(menber);
        sendMassagePage.sendcontent(title, content, addtionURL, picture, summary, author);
        sendMassagePage.confirmsend();

    }
    //素材管理
@Test

    public void sourcemanege() throws InterruptedException {
        homepage.sourcemanege();
        sourcelibrary sourcelibrary=new sourcelibrary();
        //SendMassagePage sendMassagePage = new SendMassagePage();
        sourcelibrary.sourcelocate();
        sourcelibrary.sourcecontent(title, content, addtionURL, picture, summary, author);
        sourcelibrary.userselect();

    }
    //素材管理
    @Test
    public void deparmentmanege() throws InterruptedException {
        homepage.contactbook();
        manegedepartment manegedepartment=new manegedepartment();
        manegedepartment.menbermanege();

    }
    //js运行测试
//    @Test
//    public void testjs() throws InterruptedException {
//        WebDriver driver;
//        String URL = "https://testerhome.com/";
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zhicall\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.get(URL);
//        WebElement element = driver.findElement(By.cssSelector(".navbar-brand"));
//        //element.click();
//        String style = "background:yellow";
//        String js = "arguments[0].setAttribute('style',arguments[1])";
//        ((JavascriptExecutor) driver).executeScript(js, element, style);
////聚焦元素
//        WebElement element1 = driver.findElement(By.linkText("关于"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
//
//        Thread.sleep(5000);
////滚动到指定位置
//        String js1 = "window.scrollTo(0,500)";
//        ((JavascriptExecutor) driver).executeScript(js1);
//        Thread.sleep(5000);
//        String js2 = "window.scrollTop=1000";
//        ((JavascriptExecutor) driver).executeScript(js2);
//    }


}
