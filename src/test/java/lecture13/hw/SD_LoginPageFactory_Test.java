package lecture13.hw;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.sausedemo.LoginPage;
import pageObjects.baseObjects.BaseTest;

public class SD_LoginPageFactory_Test extends BaseTest {

    @Test (enabled = false)
    public void login_Test(){
        new LoginPage()
                .open()
                .enterUserName(properties.getProperty("username"))
                .enterPassword(properties.getProperty("password"))
                .clickLogin()
                .verifyPageUrl();
    }

    //Chain Of Invocation, если я правильно поняла, заключается в нашей цепочке из методов, как и написано выше.
    //Еще можно было бы создать переменную loginPage = new LoginPage и в последующем образаться к ней.

}
