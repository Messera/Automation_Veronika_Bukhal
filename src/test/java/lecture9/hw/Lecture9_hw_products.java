package lecture9.hw;

import driver.SimpleDriver;
import org.testng.annotations.*;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.saucedemo.BasketPage;
import pageObjects.saucedemo.saucedemo.LoginPage;
import pageObjects.saucedemo.saucedemo.ProductPage;

public class Lecture9_hw_products extends BaseTest {

    @BeforeMethod
    public void preconditions(){
        new SimpleDriver();
        new LoginPage()
                .open("https://www.saucedemo.com/")
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLogin();

        new ProductPage().verifyPageTitle();
    }

    @Test(priority = 2, invocationCount = 3, threadPoolSize = 3)
    public void addToCartTest1(){

        String productName = "Sauce Labs Backpack";
        new ProductPage().addProductToBasket(productName);
        BasketPage basketPage = new BasketPage();
        basketPage.open();
        basketPage.checkIfProductExist(productName);
        basketPage.removeFromCart(productName);
        basketPage.checkIfProductExist(productName);
    }

    @Test(dataProvider = "Product name", priority = 2, dependsOnMethods = "addToCartTest1",  alwaysRun = true)
    public void addToCartTest2(String productName){
        new ProductPage().addProductToBasket(productName);
        BasketPage basketPage = new BasketPage();
        basketPage.open();
        basketPage.checkIfProductExist(productName);
        basketPage.removeFromCart(productName);
        basketPage.checkIfProductExist(productName);
    }

    @AfterMethod
    public void postconditions() {
        SimpleDriver.closeWebDriver();
    }

    @DataProvider(name = "Product name")
    public Object[][] products(){
        return new Object[][]{
                {"Sauce Labs Backpack"},
                {"Sauce Labs Bike Light"},
                {"Sauce Labs Bolt T-Shirt"},
                {"Sauce Labs Fleece Jacket"},
                {"Sauce Labs Onesie"},
                {"Test.allTheThings() T-Shirt (Red)"},
        };
    }

}
