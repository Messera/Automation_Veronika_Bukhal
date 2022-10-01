package pageObjects.baseObjects;

import driver.SimpleDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import testNgUtils.ExtentReportListener;
import testNgUtils.InvokedMethodListener;

import static driver.SimpleDriver.closeWebDriver;

@Listeners({InvokedMethodListener.class, ExtentReportListener.class})

public abstract class BaseTest {

    @BeforeTest
    public void setUp() {
        System.out.println("I started new web driver!");
        new SimpleDriver();

    }

    @AfterTest
    public void stop() {
        System.out.println("I closed web driver!");
        closeWebDriver();
    }

}
