package lecture17.hw;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Configuration.*;

public class Login_Test {

    @BeforeTest
    public void pre() {
        baseUrl = "https://moodpanda.com/";
    }

    @Test
    public void login_Test(){
        open(baseUrl);
        $(By.partialLinkText("Get started")).click();
        $(By.cssSelector("[type='text']")).sendKeys("Email@test.com");
        $(By.cssSelector("[type='password']")).sendKeys("Password");
        $(By.xpath("//button[@class]")).click();
        $(By.cssSelector("[class^=notification]")).shouldBe(exactText("Your email or password is wrong"));
    }

    @Test
    public void password_missing_Test(){
        open(baseUrl);
        $(By.partialLinkText("Get started")).click();
        $(By.cssSelector("[type='text']")).sendKeys("Email@test.com");
        $(By.xpath("//button[@class]")).click();
        $(By.cssSelector("[class^=notification]")).shouldBe(exactText("Password is required"));
    }

    @Test
    public void wrong_email_Test(){
        open(baseUrl);
        $(By.partialLinkText("Get started")).click();
        $(By.cssSelector("[type='text']")).sendKeys("Logintest.com");
        $(By.cssSelector("[type='password']")).sendKeys("Password");
        $(By.xpath("//button[@class]")).click();
        $(By.cssSelector("[class^=notification]")).shouldBe(exactText("Invalid email address"));
    }

}
