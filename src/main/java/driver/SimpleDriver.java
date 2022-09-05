package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SimpleDriver {

    private static WebDriver webDriver;

    {
        if (webDriver == null){
            WebDriverManager.chromedriver().setup();
            // можно было так написать  -  WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
            webDriver = new ChromeDriver(getChromeOptions());
            //without web driver manager
            //setWebDriver();
//
//            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//            webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
//            webDriver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
        }
    }

    public static void closeWebDriver(){
        webDriver.close();
        webDriver.quit();
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }


    //мы по-другому сделали, но можно через сетер
    private static void setWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver = driver;
    }


    private static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        return chromeOptions;
    }
}
