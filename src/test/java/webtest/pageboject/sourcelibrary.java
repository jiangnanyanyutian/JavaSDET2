package webtest.pageboject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class sourcelibrary extends CommonPage {
    //定位到添加图文信息
    public void sourcelocate() {
        //findElement(By.linkText("素材库")).click();
        findElement(By.cssSelector(".ww_icon_AppMaterialBig")).click();
        findElement(By.linkText("图文")).click();
        findElement(By.linkText("添加图文")).click();


    }

    public sourcelibrary sourcecontent(String title, String content, String addtionURL, String picture, String summary, String author) throws InterruptedException {

        //填坑3：此处有frame需要进行切换，执行完成之后需要切换回来
        findElement(By.cssSelector(".ww_editorTitle")).sendKeys(title);
        driver.switchTo().frame(0);
        findElement(By.cssSelector(".msg_mpNewsEditor_frameBody")).sendKeys(content);
        driver.switchTo().defaultContent();

        findElement(By.cssSelector(".js_amrd_uploadFile ")).sendKeys(addtionURL);
        //上传封面图片
        findElement(By.cssSelector(".msg_infoItem_coverPlaceHolder")).click();
        findElement(By.cssSelector(".js_file")).sendKeys(picture);
        // findElement(By.linkText("选择图片")).sendKeys(picture);

        findElement(By.cssSelector(".js_save")).click();
        Thread.sleep(5000);

        //填坑4：需要将滚动屏幕，才可以将需要定位的元素在屏幕总可视化


        findElement(By.cssSelector(".msg_edit_infoItem_textWord")).click();

        //填坑5：此处的元素需要依赖前一步的操作才可进行交互
        findElement(By.cssSelector(".js_amrd_abstract_input")).sendKeys(summary);
        findElement(By.cssSelector(".js_amrd_author_input")).sendKeys(author);

        return this;
    }

    //可使用人选择并提交信息
    public void userselect() {
        ((JavascriptExecutor) (driver)).executeScript("window.scroll(0,1200)");
        findElement(By.linkText("选择")).click();
        findElement(By.cssSelector(".ww_checkbox")).click();
        findElement(By.linkText("确定")).click();
        //findElement(By.linkText("完成")).click();
        waituntilclicked(By.cssSelector(".js_amrd_save"), 5);
        findElement(By.cssSelector(".js_amrd_save")).click();

    }
}
