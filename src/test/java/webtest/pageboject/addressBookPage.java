package webtest.pageboject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class addressBookPage extends CommonPage {
    //填写成员信息，添加成员
    public addressBookPage addmenberd(String name, String accountID, String phone) {
        findElement(By.name("username")).sendKeys(name);
        findElement(By.name("acctid")).sendKeys(accountID);
        findElement(By.name("mobile")).sendKeys(phone);
        findElement(By.linkText("保存")).click();
        return this;

    }

    //通过搜索手机号，删除患者
    public addressBookPage deletemenber(String userphone) {
        //遇到输入框需要提前清空
        waituntilvisiable(By.id("memberSearchInput"), 5);
        findElement(By.id("memberSearchInput")).clear();
        findElement(By.id("memberSearchInput")).sendKeys(userphone);


        //填坑3，此处需要判断搜索的内容是否存在，需要找出有标志性的标识来表示存在搜索内容，此处用“编辑”按钮作为检查标志
        //并加上异常处理，如果搜索内容不为空才进行删除操作

        try {
            waituntillocatedandclicked(By.linkText("编辑"), 2);
        } catch (Exception e) {
            System.out.println("not found");
            return this;
        }

        findElement(By.linkText("删除")).click();
        findElement(By.linkText("确认")).click();

        return this;
    }

    //通过勾选框，整页删除成员,通过采用几个轮询方式操作选择的元素数量。
    public addressBookPage checkboxdelet() {
        try {

            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       waituntilvisiable(By.cssSelector(".ww_checkbox"), 5);
        List<WebElement> elements = driver.findElements((By.cssSelector(".ww_checkbox")));
        for (int i = 1; i < 2; i++) {
            elements.get(i).click();
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
//        findElement(By.linkText("删除")).click();
//        findElement(By.linkText("确认")).click();
        return this;

    }
}
