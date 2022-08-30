package lecture7;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.saucedemo.baseObjects.BasePage;
import pageObjects.saucedemo.baseObjects.BaseTest;
import pageObjects.saucedemo.saucedemo.BasketPage;
import pageObjects.saucedemo.saucedemo.HeaderPage;
import pageObjects.saucedemo.saucedemo.LoginPage;
import pageObjects.saucedemo.saucedemo.ProductPage;

public class Lecture7_2 extends BaseTest {

    @BeforeClass
    public void login() {
        new LoginPage()
                .open()
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLogin();

    }

    @Test
    public void productTest() {
        String productName = "Sauce Labs Backpack";
        ProductPage productPage = new ProductPage();
        productPage.verifyPageTitle();
        String productCost = productPage.getProductCost(productName);
        productPage.addProductToBasket(productName);
        HeaderPage headerPage = new HeaderPage();
        headerPage.clickBasketBtn();
        BasketPage basketPage = new BasketPage();
        String cartProductCost = basketPage.getProductCost(productName);
        Assert.assertEquals(productCost, cartProductCost);
        Assert.assertEquals(basketPage.enterCartQuantity(productName), "1");

        }

    }



