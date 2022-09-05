package pageObjects.saucedemo.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.baseObjects.BasePage;

import java.time.Duration;

import static driver.SimpleDriver.getWebDriver;


public class LoginPage extends BasePage {
    By username = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");

    public LoginPage open() {
        getWebDriver().get("https://www.saucedemo.com/");
        return this;
    }

    public LoginPage enterUsername(String username) {
        enter(this.username, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        enter(this.password, password);
        return this;
    }

    public LoginPage verifyThatLoginPageIsClosed(){
        WebDriverWait webDriverWait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(10), Duration.ofSeconds(2));
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(loginBtn));
        return this;
    }

    public LoginPage clickLogin() {
        click(loginBtn);
        return this;
    }



}
