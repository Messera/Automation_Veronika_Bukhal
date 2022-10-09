package lecture13.hw;

import org.testng.annotations.Test;
import pageFactory.moodpanda.HomePage;
import pageObjects.baseObjects.BaseTest;
import pageObjects.moodpanda.NavigationPage;
import pageObjects.moodpanda.SignUpPage;
import pageObjects.moodpanda.entity.SignUpBuilder;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.entity.Login;
import pageObjects.saucedemo.entity.LoginBuilder;

public class SD_LoginValueObject_Test extends BaseTest {

    @Test (enabled = false)
    public void login_Test() {
        new LoginPage().open();
        Login login = new Login() {{
            setUsername("standard_user");
            setPassword("secret_sauce");
        }};

        new LoginPage().enterData(login);

    }

    //какой смысл делать Value Object  и Builder для сайта, где из вводимых данных только логин и пароль?

    @Test
    public void loginBuilder_Test() {
        new LoginPage().open();

        LoginBuilder login = new LoginBuilder.Builder()
                .withUsername("standard_user")
                .withPassword("secret_sauce")
                .build();

        new LoginPage().enterData(login).verifyThatLoginPageIsClosed();


    }}
