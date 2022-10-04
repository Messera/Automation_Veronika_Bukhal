package lecture5;

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

public class GoogleTest {


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

        getWebDriver().findElement(By.name("q")).sendKeys("Привет Мир", Keys.ENTER);
        List<WebElement> results = getWebDriver().findElements(By.cssSelector("[lang ='ru'] h3"));
        for (WebElement element : results) {
            Assert.assertTrue(element.getText().contains("Мир"));
        }

    }

    @AfterTest
    public void postconditions() {
        getWebDriver().close();
    }

    private void pause(Integer timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
