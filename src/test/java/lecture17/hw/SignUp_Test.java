package lecture17.hw;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.SelenideBaseTest;
import pageObjects.moodpanda.SignUpPage_selenide;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Configuration.*;
public class SignUp_Test extends SelenideBaseTest {

    @BeforeTest
    public void pre() {
        baseUrl = "https://moodpanda.com/";
    }

    @Test
    public void signUp_Test() {
        open(baseUrl);
        get(SignUpPage_selenide.class)
                .openSingUpPage()
                .enterFirstName("NameA")
                .enterLastName("L")
                .enterEmail()
                .enterPassword("12345678")
                .clickCheckbox()
                .clickSignUp()
                .clickSignUp()
                .verifyEmail();
        closeWebDriver();
   //     Configuration.holdBrowserOpen = true;

    }



    @Test
    public void signUp_NoCheckbox_Test() {
        open(baseUrl);
        get(SignUpPage_selenide.class)
                .openSingUpPage()
                .enterFirstName("NameB")
                .enterLastName("L")
                .enterEmail()
                .enterPassword("12345678")
                .clickSignUp()
                .clickSignUp()
                .verifyNoCheckbox();
        closeWebDriver();
       //Configuration.holdBrowserOpen = true;

    }
    @Test
    public void signUp_exist_Test() {
        open(baseUrl);
        get(SignUpPage_selenide.class)
                .openSingUpPage()
                .enterFirstName("NameC")
                .enterLastName("L")
                .enterEmail("Email")
                .enterPassword("12345678")
                .clickCheckbox()
                .clickSignUp()
                .clickSignUp()
                .verifyExistEmail();
        closeWebDriver();
        //   Configuration.holdBrowserOpen = true;

    }
}
