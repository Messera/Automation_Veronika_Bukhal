package pageObjects.selenideRabotaBy;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private SelenideElement text = $(By.id("a11y-search-input"));
    private SelenideElement submitBtn = $(By.cssSelector("[type='submit']"));


    public HomePage enterSearch(String text) {
        this.text.sendKeys(text);
        return this;
    }


    public HomePage clickSubmit() {
        submitBtn.click();
        return this;
    }

}