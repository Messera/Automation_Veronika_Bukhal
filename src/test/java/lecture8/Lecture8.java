package lecture8;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.saucedemo.LoginPage;
import pageObjects.saucedemo.saucedemo.ProductPage;

public class Lecture8 extends BaseTest {

    @Test
    public void login() {
//        getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
//        getWebDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1));
        new LoginPage()
                .open()
                .enterUsername("performance_glitch_user")
                .enterPassword("secret_sauce")
                .clickLogin()
                .verifyThatLoginPageIsClosed();
        new ProductPage().verifyPageTitle();

    }

}
