package lecture7;

import org.testng.annotations.Test;
import pageObjects.saucedemo.baseObjects.BaseTest;
import pageObjects.saucedemo.saucedemo.LoginPage;
import pageObjects.saucedemo.saucedemo.ProductPage;

public class Lecture7_1 extends BaseTest {


    @Test
    public void loginTest() {

        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        ProductPage productPage = new ProductPage();
        productPage.verifyPageTitle();
    }
}
