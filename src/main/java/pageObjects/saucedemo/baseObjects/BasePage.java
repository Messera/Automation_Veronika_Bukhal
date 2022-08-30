package pageObjects.saucedemo.baseObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static driver.SimpleDriver.getWebDriver;

public abstract class BasePage {


    protected void enter(WebElement webElement, String enterData){
        System.out.println("I enter ::" + enterData + " by web element :: " + webElement);
        webElement.clear();
        webElement.sendKeys(enterData);
    }

    protected void enter(By locator, String enterData){
        System.out.println("I enter ::" + enterData + " by locator :: " + locator);
        getWebDriver().findElement(locator).clear();
        getWebDriver().findElement(locator).sendKeys(enterData);
    }


    protected void click (By locator){
        System.out.println("I click by ::" + locator);
        getWebDriver().findElement(locator).click();
    }
    protected void click (WebElement webElement){
        System.out.println("I click by ::" + webElement);
        webElement.click();
    }


    protected String getText(By locator){
        System.out.println("I get text by ::" + locator);
        return  getWebDriver().findElement(locator).getText();
    }


    protected String getText(WebElement webElement) {
        System.out.println("I get text by ::" + webElement);
        return webElement.getText();
    }


}
