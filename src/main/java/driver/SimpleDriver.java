package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SimpleDriver {

    private static ThreadLocal <WebDriver> webDriver = new ThreadLocal<>();

    {
        if (webDriver.get() == null){
            WebDriverManager.chromedriver().setup();
            // можно было так написать  -  WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
            webDriver.set(new ChromeDriver(getChromeOptions()));
            //without web driver manager
            //setWebDriver();
            webDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            webDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
            webDriver.get().manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
        }
    }

    public static void closeWebDriver() {
        if (webDriver.get() != null) {
            webDriver.get().close();
            webDriver.get().quit();
            webDriver = null;
        }
    }

    public static WebDriver getWebDriver() {
        return webDriver.get();
    }


    //мы по-другому сделали, но можно через сетер
    private static void setWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.set(driver);
    }


    private static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        return chromeOptions;
    }
}
