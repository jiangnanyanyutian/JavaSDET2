package app.testcase;
import app.page.App;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static app.testcase.TestSearch.searchPage;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;
public class testsearchBYtestNG {

    @DataProvider(name="Exceldataprovider")
    public Object[][]ParamProvider() throws IOException {

        return new Object[][]{ReadExcel.getexceldata("C:\\Users\\win10\\Desktop", "APPparameter.xlsx", "sheet1",2)};

    }

@BeforeTest
public void before(){
    searchPage= App.getInstance().toSearch();
}
    @Test
    public void UserData(String stock,Double price){


        assertThat(searchPage.search(stock).getCurrentPrice(), greaterThanOrEqualTo(price.floatValue()));


}





}
