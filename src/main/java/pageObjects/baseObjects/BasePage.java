package pageObjects.baseObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;
import java.time.Duration;

import static driver.SimpleDriver.getWebDriver;

public abstract class BasePage {

    protected WebDriverWait wait;
    protected WebDriver driver;
    protected Actions actions;

    protected BasePage(){
        driver = getWebDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        actions = new Actions(driver);
    }


    //???????
//    protected FluentWait<WebDriver> fluentWait(long timeout, long pollingEvery){
//        return new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout)).pollingEvery(5, SECONDS).ignoring(NoSuchElementException.class);
//    }
////?????

    protected void enter(WebElement webElement, String enterData){
        System.out.println("I enter ::" + enterData + " by web element :: " + webElement);
        webElement.clear();
        webElement.sendKeys(enterData);
    }

    protected void enter(By locator, CharSequence... enterData){
        System.out.println("I enter ::" + enterData + ", by locator :: " + locator);
        driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(locator).sendKeys(enterData);
    }


    protected void click (By locator){
        System.out.println("I click by ::" + locator);
        driver.findElement(locator).click();
    }
    protected void click (WebElement webElement){
        System.out.println("I click by ::" + webElement);
        webElement.click();
    }


    protected String getText(By locator){
        System.out.println("I get text by ::" + locator);
        return  driver.findElement(locator).getText();
    }


    protected String getText(WebElement webElement) {
        System.out.println("I get text by ::" + webElement);
        return webElement.getText();
    }


}
