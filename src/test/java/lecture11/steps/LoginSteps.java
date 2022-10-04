package lecture11.steps;

import pageObjects.baseObjects.BasePage;
import pageObjects.saucedemo.saucedemo.LoginPage;

public class LoginSteps extends BasePage {

    LoginPage loginPage = new LoginPage();

    public LoginSteps login(String username, String password) {
        loginPage.open().enterUsername(username).enterPassword(password).clickLogin();
        return this;
    }


}
