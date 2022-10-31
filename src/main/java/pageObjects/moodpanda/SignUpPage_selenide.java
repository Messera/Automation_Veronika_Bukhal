package pageObjects.moodpanda;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;


public class SignUpPage_selenide {

    private final SelenideElement signUp = $(By.partialLinkText("Sign up"));
    private final SelenideElement firstName = $("[placeholder='Your first name']");
    private final SelenideElement lastName = $("[placeholder=\"e.g. 'S'\"]");
    private final SelenideElement email = $("[placeholder='Your email address']");
    private final SelenideElement password = $("[type='password']");
    private final SelenideElement checkbox = $("[type='checkbox']");
    private final SelenideElement signUpBtn = $(By.xpath("//*[@class='box']//button"));
    private final SelenideElement verifyEmail = $(By.xpath("//*[@class='notification']"));
    private final SelenideElement enterCode = $(By.xpath("//*[@class='input']"));
    private final SelenideElement alert = $(By.xpath("//*[@role='alert']"));

    public SignUpPage_selenide openSingUpPage() {
        signUp.click();
        return this;
    }

    public SignUpPage_selenide enterFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
        return this;
    }
    public SignUpPage_selenide enterEmail() {
        String email = RandomStringUtils.randomAlphanumeric(6);
        this.email.sendKeys(email + "@test.com");
        return this;
    }
    public SignUpPage_selenide enterEmail(String email) {
        this.email.sendKeys(email + "@test.com");
        return this;
    }
    public SignUpPage_selenide enterLastName(String lastName) {
        this.lastName.sendKeys(lastName);
        return this;
    }

    public SignUpPage_selenide enterPassword(String password) {
        this.password.sendKeys(password);
        return this;
    }
    public SignUpPage_selenide clickCheckbox() {
        this.checkbox.click();
        return this;
    }

    public SignUpPage_selenide clickSignUp() {
        this.signUpBtn.click();
        return this;
    }
    public SignUpPage_selenide verifyEmail() {
        this.verifyEmail.shouldBe(exactText("We've emailed you a verification code"));
        this.enterCode.shouldBe(enabled);
        return this;
    }

    public SignUpPage_selenide verifyExistEmail() {
        this.alert.shouldBe(exactText("You already have an account, or this account cannot be created"));
        return this;
    }

    public SignUpPage_selenide verifyNoCheckbox() {
        this.alert.shouldBe(exactText("You must be over 16 and agree to our terms to use MoodPanda."));
        return this;
    }




}
