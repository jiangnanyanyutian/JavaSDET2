package webtest.testcase;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import webtest.pageboject.HomePage;
import webtest.pageboject.addressBookPage;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class weixintest {

    public static HomePage homepage = new HomePage();

    public static String name;
    public static String accountID;
    public static String phone;

    private String js;

    //测试之前设置环境
    @BeforeClass
    public static void setup() {

        homepage.login();
        name = "小燕子";
        accountID = "8833";
        phone = "13949135563";
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
    public void checkboxdelete() {

        homepage.mennu_contact();
        addressBookPage addressBookPage = new addressBookPage();
        addressBookPage.checkboxdelet();
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
