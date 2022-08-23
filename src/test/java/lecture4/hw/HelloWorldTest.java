package lecture4.hw;

import driver.SimpleDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static driver.SimpleDriver.getWebDriver;

public class HelloWorldTest {

    @BeforeTest
    public void preconditions() {
        SimpleDriver simpleDriver = new SimpleDriver();
        getWebDriver().get("https://www.google.com/");
    }

    @BeforeMethod
    public void beforeMethod() {
        getWebDriver().get("https://www.google.com/");
    }

    @Test
    public void test1() {

        getWebDriver().findElement(By.name("q")).sendKeys("Hello world", Keys.ENTER);
        List<WebElement> results = getWebDriver().findElements(By.id("search"));
        for (WebElement element : results) {
            Assert.assertTrue(element.getText().contains("world"));
        }
        Assert.assertEquals(getWebDriver().findElement(By.name("q")).getAttribute("value"), "Hello world");
    }

    @Test
    public void test2() {

        getWebDriver().findElement(By.name("q")).sendKeys("//**", Keys.ENTER);
        Assert.assertTrue(getWebDriver().findElement(By.id("topstuff")).getText().contains("Your search - //** - did not match any documents."));
    }

    @AfterTest
    public void postconditions() {
        getWebDriver().close();
    }

}
