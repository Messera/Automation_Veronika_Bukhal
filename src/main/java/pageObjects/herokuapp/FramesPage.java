package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import java.util.concurrent.TimeUnit;

public class FramesPage extends BasePage {

    private By clickLink(String linkText) {
        return By.linkText(linkText);
    }
    private By iframe = By.id("mce_0_ifr");
    private By textArea = By.id("tinymce");
    private By boldText = By.cssSelector("[aria-label='Bold']");

    public FramesPage clickFrameLink(String linkText){
        click(clickLink(linkText));
        return this;
    }

    public FramesPage switchToFrame(){
        driver.switchTo().frame(driver.findElement(iframe));
        return this;
    }

    public FramesPage enterText(String text){
        enter(textArea, text, Keys.chord(Keys.CONTROL, "a"));
        return this;
    }

    public FramesPage unSwitchFrame(){
        driver.switchTo().defaultContent();
        return this;
    }

    public FramesPage clickBoldText(){
        click(boldText);
        return this;
    }

    public void checkText(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p")).getText());
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p")).getText(), "Your content goes here.");
        //не работает

    }

}
