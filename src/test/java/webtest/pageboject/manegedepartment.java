package webtest.pageboject;

import org.openqa.selenium.By;

public class manegedepartment extends CommonPage{

public  manegedepartment menbermanege(){
    findElement(By.id("1688852652134520_anchor")).click();
    findElement(By.id("1688854015409070_anchor")).click();
    findElement(By.cssSelector("jstree-contextmenu-hover")).click();
    findElement(By.linkText("下移")).click();
    return this;
}

}
