package pageObjects.baseObjects;

import driver.SimpleDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import static driver.SimpleDriver.closeWebDriver;

public abstract class BaseTest {

    @BeforeTest
    public void setUp() {
        System.out.println("I started new web driver!");
        new SimpleDriver();

    }

    @AfterTest
    public void stop(){
        System.out.println("I closed web driver!");
        closeWebDriver();
    }

}
