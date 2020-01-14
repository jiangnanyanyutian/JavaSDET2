package webtest.pageboject;

import org.openqa.selenium.By;

public class SendMassagePage extends CommonPage {
    public void sendmessage(String menber, String title, String content, String addtionURL, String summary, String author) throws InterruptedException {
        Thread.sleep(2000);
        // waituntilclicked(By.linkText("选择需要发送消息的应用"), 2);
        findElement(By.linkText("选择需要发消息的应用")).click();
        findElement(By.cssSelector(".ww_icon_AppNotice")).click();
        findElement(By.linkText("确定")).click();

        findElement(By.linkText("选择发送范围")).click();
        //下面的步骤执行时间很长，会影响整个脚本的运行时间。需要采用pageload策略进行改进？？？。
        findElement(By.id("memberSearchInput")).sendKeys(menber);
        findElement(By.cssSelector(".ww_searchResult_title_peopleName")).click();
        findElement(By.linkText("确定")).click();



        findElement(By.linkText("在此输入标题")).sendKeys(title);

        findElement(By.cssSelector(".view mpnews msg_noticeEditor_frameBody")).sendKeys(content);
        findElement(By.linkText("添加附件")).sendKeys(addtionURL);
        findElement(By.linkText("添加原文链接")).sendKeys("我是测试我是测试");
        findElement(By.cssSelector(".qui_textarea")).sendKeys(summary);
        findElement(By.cssSelector(".js_amrd_sendName")).sendKeys(author);
        findElement(By.linkText("发送")).click();

    }

}
