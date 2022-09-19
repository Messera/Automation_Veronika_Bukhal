package lecture9.hw;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.saucedemo.LoginPage;
import testNgUtils.Retry;

import static driver.SimpleDriver.getWebDriver;

public class Lecture9_hw_login extends BaseTest {

    int count = 0;
    @Parameters("url")
    @BeforeMethod
    public void preconditions(@Optional("https://www.google.com/") String url){
        new LoginPage()
                .open(url);
    }

    @Test (dataProvider = "Login data", description = "1 positive and 3 negative tests for login",  retryAnalyzer = Retry.class)
    public void loginTest(String username, String password) {

        count++;
        System.out.println(count);
        new LoginPage()
                .enterUsername(username)
                .enterPassword(password)
                .clickLogin();
        switch (count){
            case 1: new LoginPage().verifyThatLoginPageIsClosed();
            break;
            case 2:
                Assert.assertEquals(getWebDriver().findElement(By.className("error-message-container")).getText(), "Epic sadface: Username is required");
            break;
            case 3:
                Assert.assertEquals(getWebDriver().findElement(By.className("error-message-container")).getText(), "Epic sadface: Password is required");
            break;
            case 4:
                Assert.assertEquals(getWebDriver().findElement(By.className("error-message-container")).getText(), "Epic sadface: Username and password do not match any user in this service");
            break;

        }
    }

    @DataProvider(name = "Login data")
    public Object[][] getData(){
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"", "secret_sauce"},
                {"problem_user", ""},
                {"performance_gliatch_user", "secret_sauce"},
        };
    }




}
