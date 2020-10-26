package webtest.pageboject;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HomePage extends CommonPage {


    public HomePage login() {
        String URL = "https://work.weixin.qq.com";
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.findElement(By.linkText("企业登录")).click();
        System.out.println(driver.manage().getCookies());
        driver.manage().addCookie(new Cookie("wwrtx.refid", "13911327832556506"));
        driver.manage().addCookie(new Cookie("wwrtx.sid", "vz8lc5ZbIh9dARjpPCqf0dl6jqyQbU1Uekt6wkUUa1N7EQxFLIOce7_7tgtR5FeV"));
        //填坑1，添加cookies之后刷新页面才能登陆，没有该语句登陆不成功
        driver.navigate().refresh();
        return this;
    }

    //添加成员快捷按钮
    public addressBookPage menberadd() throws InterruptedException {

        //填坑2，缺少等待，页面未加载完成去定位元素失败，必须加等待时间
        // new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("添加成员"))).click();
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        waituntilclick(By.linkText("添加成员"),5);
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
    public addressBookPage addressmanage() {

        return new addressBookPage();
    }


    //消息群发按钮
    public SendMassagePage groupmessagesend() {


        return new SendMassagePage();

    }


}

