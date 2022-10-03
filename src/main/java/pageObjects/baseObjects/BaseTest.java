package pageObjects.baseObjects;

import driver.SimpleDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import testNgUtils.ExtentReportListener;
import testNgUtils.InvokedMethodListener;

import java.lang.reflect.InvocationTargetException;

import static driver.SimpleDriver.closeWebDriver;

@Listeners({InvokedMethodListener.class, ExtentReportListener.class})

public abstract class BaseTest {

    @BeforeTest
    public void setUp() {
        System.out.println("I started new web driver!");
        new SimpleDriver();

    }

    protected <T> T get(Class<T> page){
        T instance = null;
        try {
            instance = page.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return instance;
    }

    @AfterTest
    public void stop() {
        System.out.println("I closed web driver!");
        closeWebDriver();
    }

}
