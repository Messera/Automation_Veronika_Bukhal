package pageFactory.sausedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import static driver.SimpleDriver.getWebDriver;

public class LoginPage extends BasePage {

    @FindBy(how = How.ID, using = "user-name" )
    WebElement username;

    @FindBy(how = How.ID, using = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginBtn;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public LoginPage open() {
        load();
        return this;
    }

    public LoginPage enterUserName(String username){
        enter(this.username, username);
        return this;
    }

    public LoginPage enterPassword(String password){
        enter(this.password, password);
        return this;
    }

    public LoginPage clickLogin(){
        click(loginBtn);
        return this;
    }

    public LoginPage verifyPageUrl() {
        Assert.assertNotEquals(getWebDriver().getCurrentUrl(), "https://www.saucedemo.com/");
        return this;
    }

}
