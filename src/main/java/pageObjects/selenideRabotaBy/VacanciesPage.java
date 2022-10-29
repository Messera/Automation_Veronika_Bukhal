package pageObjects.selenideRabotaBy;

import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.className;

public class VacanciesPage {

    public VacanciesPage countVacancies(int count){
        Assert.assertTrue($$(className("serp-item")).size() >= count);
        return this;
    }


    public VacanciesPage verifyPageTitle(String text) {
        Assert.assertEquals($(className("search-catalog-header")).getText(), text);
        return this;
    }
}
