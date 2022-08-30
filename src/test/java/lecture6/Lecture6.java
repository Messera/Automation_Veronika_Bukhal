package lecture6;

import driver.SimpleDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static driver.SimpleDriver.getWebDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Lecture6 {

    @BeforeTest
    public void preconditions(){
        SimpleDriver simpleDriver = new SimpleDriver();
        getWebDriver().get("https://www.saucedemo.com/");

    }


    @Test (enabled = false)
    public void  authTest() {

        getWebDriver().findElement(By.id("user-name")).sendKeys("standard_user");
        getWebDriver().findElement(By.name("password")).sendKeys("secret_sauce");
        getWebDriver().findElement(By.id("login-button")).click();
        elementExist(By.linkText("Facebook"));
        elementExist(By.partialLinkText("Twi"));
        elementExist(By.className("app_logo"));
        elementExist(By.cssSelector(""));
        elementExist(By.xpath("//*[@id=\"rec465090684\"]"));



    }

    @Test
    public void aboveTest(){
        System.out.println(getWebDriver().findElements(with(By.tagName("input")).near(By.className("password"))).size());
        getWebDriver().findElement(with(By.tagName("input")).above(By.name("password"))).sendKeys("above");
        getWebDriver().findElement(with(By.tagName("input")).below(By.name("password"))).click();
        System.out.println(getWebDriver().findElement(with(By.tagName("h4")).toLeftOf(By.className("password"))).getText());
        System.out.println(getWebDriver().findElement(with(By.tagName("h4")).toRightOf(By.className("login_credentials"))).getText());

    }




    private void elementExist(By by) {
        Assert.assertEquals(getWebDriver().findElements(by).size(), 1);

    }

//    @AfterTest
//    public void postconditions(){
//        getWebDriver().close();
//    }

}
