package webtest.pageboject;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage extends CommonPage {


    public HomePage login() {
        String URL = "https://work.weixin.qq.com";
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("pageLoadStrategy", "normal");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver(chromeOptions);
       //很重要的一个隐式等待，全局的，创建一个driver对象就为改队形创建一个等待时间
        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        driver.get(URL);
        driver.manage().window().maximize();
        driver.findElement(By.linkText("企业登录")).click();
        System.out.println(driver.manage().getCookies());
        driver.manage().addCookie(new Cookie("wwrtx.refid", "2590788570442807"));
        driver.manage().addCookie(new Cookie("wwrtx.sid", "vz8lc5ZbIh9dARjpPCqf0aorho4rgKgAjrVovYo4tby_NZg6L4GRux_OCnIBBm3P"));
        //填坑1，添加cookies之后刷新页面才能登陆，没有该语句登陆不成功
        driver.navigate().refresh();
        return this;
    }

    //添加成员快捷按钮
    public addressBookPage menberadd() throws InterruptedException {

        //填坑2，缺少等待，页面未加载完成去定位元素失败，必须加等待时间
        // new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("添加成员"))).click();
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        waituntillocatedandclicked(By.linkText("添加成员"), 5);
        findElement(By.linkText("添加成员")).click();


        return new addressBookPage();

    }

    //首页点击通讯录
    public addressBookPage mennu_contact() {
        //waituntil(By.linkText("通讯录"), 10);
        findElement(By.linkText("通讯录")).click();
        return new addressBookPage();
    }

    //导入通讯录按钮
    public BachLoadPage loadcontactbook() {
        findElement(By.linkText("导入通讯录")).click();
        //findElement(By.cssSelector(".index_service_cnt_item_title")).click();
        return new BachLoadPage();
    }


    //消息群发按钮
    public SendMassagePage groupmessagesend() {
       // waituntilclicked(By.linkText("消息群发"), 5);
        findElement(By.linkText("消息群发")).click();
        //findElement(By.cssSelector(".index_service_cnt_item_title")).click();
        return new SendMassagePage();

    }


}

