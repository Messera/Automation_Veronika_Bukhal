package lecture11;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void login() {
        get(LoginPage.class)
                .open()
                .enterUsername()
                .enterPassword()
                .clickLogin()
                .verifyThatLoginPageIsClosed();


    }


}
