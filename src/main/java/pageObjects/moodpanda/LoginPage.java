package pageObjects.moodpanda;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

public class LoginPage extends MoodPandaBasePage {

    private By email = By.cssSelector("[type='text']");
    private By password = By.cssSelector("[type='password']");
    private By loginBtn = By.xpath("//button[@class]");
    private By notification = By.cssSelector("[class^=notification]");


    public LoginPage(){
        isPageOpened();
    }

    public LoginPage enterPassword(String password){
        enter(this.password, password);
        return this;
    }

    public LoginPage enterEmail(String email){
        enter(this.email, email);
        return this;
    }

    public LoginPage clickLogin(){
        click(loginBtn);
        return this;
    }

    public LoginPage verifyErrorMessage(String message){
        Assert.assertEquals(getText(notification), message);
        return this;
    }

    @Override
    public void isPageOpened() {
        waitVisibilityOfElement(email);
    }
}
