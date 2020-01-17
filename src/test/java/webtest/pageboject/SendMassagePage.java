package webtest.pageboject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class SendMassagePage extends CommonPage {
    public void sendmessage(String menber, String title, String content, String addtionURL, String summary, String author) throws InterruptedException {
        Thread.sleep(2000);
        // waituntilclicked(By.linkText("选择需要发送消息的应用"), 2);
        findElement(By.linkText("选择需要发消息的应用")).click();
        findElement(By.cssSelector(".ww_icon_AppNotice")).click();
        findElement(By.linkText("确定")).click();

        //填坑1：发送范围的按钮，刚开始不可见，需要依赖上一步骤操作完成才可见，此地方需要用显示等待判断后再操作，不然脚本会不稳定
        waituntilclicked(By.linkText("选择发送范围"), 5);
        findElement(By.linkText("选择发送范围")).click();


        //填坑2：下面的步骤执行时间很长，会影响整个脚本的运行时间。需要采用pageload策略进行改进(浏览器的加载方式设置键homepage类)。
        findElement(By.id("memberSearchInput")).sendKeys(menber);
        Thread.sleep(2000);
        findElement(By.cssSelector(".js_search_item")).click();
        findElement(By.linkText("确认")).click();

        //填坑3：此处有frame需要进行切换，执行完成之后需要切换回来
        findElement(By.cssSelector(".ww_editorTitle")).sendKeys(title);
        driver.switchTo().frame(0);
        findElement(By.cssSelector(".msg_noticeEditor_frameBody")).sendKeys(content);
        driver.switchTo().defaultContent();

        findElement(By.cssSelector(".msg_edit_infoItem_attachment")).sendKeys(addtionURL);

        //填坑4：需要将滚动屏幕，才可以将需要定位的元素在屏幕总可视化

        ((JavascriptExecutor) (driver)).executeScript("window.scroll(0,1200)");

        findElement(By.cssSelector(".msg_edit_infoItem_textWord")).click();
        //填坑5：此处的元素需要依赖前一步的操作才可进行交互
        findElement(By.cssSelector(".js_announce_abstract_input")).sendKeys(summary);
        findElement(By.cssSelector(".js_amrd_sendName")).sendKeys(author);
        findElement(By.linkText("发送")).click();
        findElement(By.linkText("确定")).click();

    }

}
