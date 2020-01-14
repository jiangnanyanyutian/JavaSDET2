package webtest.pageboject;

import org.openqa.selenium.By;

public class BachLoadPage extends CommonPage {
    //上传文件
    public void uploadfile(String filename) throws InterruptedException {
        //waituntilclicked(By.id("js_upload_file_input"), 5);
        //坑：隐式等待在此处不可用，如果不加等待，元素查找失败
        Thread.sleep(2000);
        findElement(By.id("js_upload_file_input")).sendKeys(filename);
        findElement(By.id("submit_csv")).click();

    }


}
