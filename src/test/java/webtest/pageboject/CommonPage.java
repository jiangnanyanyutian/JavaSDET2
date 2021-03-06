package webtest.pageboject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.print.DocFlavor;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

//封装元素查找方法
public class CommonPage {
    public static RemoteWebDriver driver;

    public WebElement findElement(By by) {

        return driver.findElement(by);
    }
//封装隐式等待时间方法

    public void waituntillocatedandclicked(By by, int timeout) {

        new WebDriverWait(driver, timeout).until(visibilityOfElementLocated(by));
        new WebDriverWait(driver, timeout).until(elementToBeClickable(by));
    }

    public void waituntilvisiable(By by, int timeout) {

        new WebDriverWait(driver, timeout).until(visibilityOfElementLocated(by));
    }


    public void waituntilclicked(By by, int timeout) {

        new WebDriverWait(driver, timeout).until(elementToBeClickable(by));
    }

    //关闭浏览器
    public void close() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
