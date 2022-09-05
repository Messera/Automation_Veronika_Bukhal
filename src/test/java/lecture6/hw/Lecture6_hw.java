package lecture6.hw;

import driver.SimpleDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;

import static driver.SimpleDriver.getWebDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Lecture6_hw extends BaseTest {

    @BeforeTest
    public void preconditions(){
        SimpleDriver simpleDriver = new SimpleDriver();
        getWebDriver().get("https://www.saucedemo.com/");

    }


    @Test
    public void  cartTest() {
        getWebDriver().findElement(By.id("user-name")).sendKeys("standard_user");
        getWebDriver().findElement(By.name("password")).sendKeys("secret_sauce");
        getWebDriver().findElement(By.id("login-button")).click();
        String productName = getWebDriver().findElement(By.id("item_0_title_link")).getText();
        System.out.println(productName);
        String price = getElementProduct(productName).findElement(By.className("inventory_item_price")).getText();
        System.out.println(price);
        getWebDriver().findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();
        getWebDriver().findElement(By.cssSelector(".shopping_cart_link")).click();
        Assert.assertEquals(getWebDriver().findElement(By.id("item_0_title_link")).getText(), productName);
        Assert.assertEquals(getWebDriver().findElement(By.className("inventory_item_price")).getText(), price);

    }

    @Test
    public void  searchTest() {
        getWebDriver().findElement(By.id("user-name")).sendKeys("standard_user");
        getWebDriver().findElement(By.name("password")).sendKeys("secret_sauce");
        getWebDriver().findElement(By.id("login-button")).click();
        System.out.println(getWebDriver().findElement(with(By.className("inventory_item_desc")).below(By.id("item_1_title_link"))).getText());

    }


    private WebElement getElementProduct(String productName) {
        return getWebDriver().findElement(By.xpath("//*[@class = 'inventory_item_name' and text() = '" + productName + "']//ancestor::div[@class='inventory_item']"));
    }


}
