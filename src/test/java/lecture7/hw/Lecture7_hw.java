package lecture7.hw;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.saucedemo.BasketPage;
import pageObjects.saucedemo.saucedemo.CheckoutPage;
import pageObjects.saucedemo.saucedemo.LoginPage;
import pageObjects.saucedemo.saucedemo.ProductPage;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static driver.SimpleDriver.getWebDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Lecture7_hw extends BaseTest {


    @Test
    public void loginTest_locked_out_user() {
        login("locked_out_user");
        Assert.assertEquals(getWebDriver().findElement(By.cssSelector("h3")).getText(),
                "Epic sadface: Sorry, this user has been locked out." );

    }

    @Test
    public void loginTest_problem_user() {
        login("problem_user");
        ProductPage productPage = new ProductPage();
        productPage.verifyPageTitle();
        List<WebElement> results = getWebDriver().findElements(By.tagName("img"));
        for (WebElement element : results) {
            if (element.getAttribute("class").equals("inventory_item_img")) {
                System.out.println(element.getAttribute("src"));
                Assert.assertTrue(element.getAttribute("src").contains("/static/media/sl-404.168b1cce.jpg"));
            }
        }
    }

    @Test
    public void loginTest() {

        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.enterUsername("performance_glitch_user");
        loginPage.enterPassword("secret_sauce");
        long start = System.currentTimeMillis();
        loginPage.clickLogin();
        long finish = System.currentTimeMillis();
        long totalTime = finish - start;
        System.out.println("Total Time for page load - "+totalTime);
        ProductPage productPage = new ProductPage();
        productPage.verifyPageTitle();
        Assert.assertTrue(totalTime > 4000);
    }

    //Тест на добавление товара в корзину в Lecture6_hw

    @Test
    public void  cart_remove_Test() {
        login("standard_user");
        ProductPage productPage = new ProductPage();
        String productName = "Sauce Labs Bike Light";
        productPage.addProductToBasket(productName);
        BasketPage basketPage = new BasketPage();
        basketPage.open();
        Assert.assertEquals(getWebDriver().findElement(By.id("item_0_title_link")).getText(), productName);
        getWebDriver().findElement(By.id("remove-sauce-labs-bike-light")).click();
        WebDriverWait webDriverWait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(10), Duration.ofSeconds(2));
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("item_0_title_link")));
        //????

    }


    @Test
    public void  checkoutTest() {
        login("standard_user");
        ProductPage productPage = new ProductPage();
        String productName = "Sauce Labs Bike Light";
        String cost1 = productPage.getProductCost(productName);
        productPage.addProductToBasket(productName);
        BasketPage basketPage = new BasketPage();
        basketPage.open();
        String cost2 = basketPage.getProductCost(productName);
        String quantity1 = basketPage.getCartQuantity(productName);
        basketPage.checkout();
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.enterInformation();
        checkoutPage.verifyPageTitle("CHECKOUT: OVERVIEW");
        String cost3 = checkoutPage.getProductCost(productName);
        Assert.assertEquals(cost1,cost2, cost3);
        String quantity2 = checkoutPage.getCartQuantity(productName);
        Assert.assertEquals(checkoutPage.getTotalResult(),checkoutPage.getTotalValue());
        Assert.assertEquals(quantity1, quantity2);
        checkoutPage.clickFinish();
        checkoutPage.verifyPageTitle("CHECKOUT: COMPLETE!");

    }


    private void login(String userName) {
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.enterUsername(userName);
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
    }

    @Test
    public void  testTest() {
        getWebDriver().get("https://www.google.com/");
        getWebDriver().findElement(By.xpath("//a[contains(text(),'Gmail')]")).click();
    }


}
