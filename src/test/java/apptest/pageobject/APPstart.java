package apptest.pageobject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class APPstart {
    public static AndroidDriver<AndroidElement> driver;

    @Before
    public void configparameter() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformNane", "android");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("deviceName", "CUYDU19715002601");
        desiredCapabilities.setCapability("noReset", true);  //重启APP不会重置设置
        desiredCapabilities.setCapability("autoGrantPermissions", true);
        desiredCapabilities.setCapability("udid", System.getenv("UDID"));
        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
         this.driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void sampleTest() {


        MobileElement e0 = (MobileElement) driver.findElementById("android:id/content");
        e0.click();
        System.out.println(driver.getPageSource());
        MobileElement e1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ImageView[2]");
        e1.click();
       // System.out.println(driver.getPageSource());
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        MobileElement e2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ImageView");
        e2.click();


        MobileElement el1 = (MobileElement) driver.findElementById("com.xueqiu.android:id/home_search");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById("com.xueqiu.android:id/search_input_text");
        el2.sendKeys("alibaba");
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementById("com.xueqiu.android:id/current_price");
        el4.click();
    }



//
//    @After
//    public void tearDown() {
//        driver.quit();
//    }
}




