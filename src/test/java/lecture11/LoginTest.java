package lecture11;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.saucedemo.LoginPage;
import pageObjects.saucedemo.saucedemo.ProductPage;

public class LoginTest extends BaseTest {

    @Parameters({"username", "password"})
    @Test
    public void login(String username, String password) {
        get(LoginPage.class)
                .open()
                .enterUsername(username)
                .enterPassword(password)
                .clickLogin()
                .verifyThatLoginPageIsClosed();


    }


}
