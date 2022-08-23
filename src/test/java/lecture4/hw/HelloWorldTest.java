package lecture4.hw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class HelloWorldTest {

    WebDriver driver;

    @BeforeTest
    public void preconditions(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com/");

    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://www.google.com/");
    }

    @Test
    public void  test1() {

        WebElement searchLine = driver.findElement(By.name("q"));
        WebElement continueButton = driver.findElement(By.xpath("//input[@name='btnK']"));
        searchLine.sendKeys("Hello World");
        continueButton.click();
        pause(2);
        WebElement wiki = driver.findElement(By.xpath("//h3[contains(.,'Hello, world! - Википедия')]"));
        Assert.assertEquals("Hello, world! - Википедия", "Hello, world! - Википедия");


    }

    @AfterTest
    public void postconditions(){
        driver.close();
    }

    private void pause(Integer timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
}}
