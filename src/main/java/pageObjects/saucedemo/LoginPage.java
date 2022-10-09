package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;
import pageObjects.saucedemo.entity.Login;
import pageObjects.saucedemo.entity.LoginBuilder;


public class LoginPage extends BasePage {
    By username = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");

    public LoginPage open() {
        load("https://www.saucedemo.com/");
        return this;
    }

    public LoginPage open(String url) {
        load(url);
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

    public LoginPage verifyThatLoginPageIsClosed() {
        Assert.assertTrue(elementNotExist(loginBtn));
        return this;
    }

    public LoginPage clickLogin() {
        click(loginBtn);
        return this;
    }

    public LoginPage enterData(Login login) {
        enterUsername(login.getUsername());
        enterPassword(login.getPassword());
        clickLogin();
        return this;
    }

    public LoginPage enterData(LoginBuilder login) {
        enterUsername(login.getUsername());
        enterPassword(login.getPassword());
        clickLogin();
        return this;
    }


}
