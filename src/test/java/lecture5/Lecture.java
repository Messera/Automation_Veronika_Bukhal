package lecture5;

import driver.SimpleDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static driver.SimpleDriver.getWebDriver;

public class Lecture {

    @BeforeTest
    public void preconditions() {
        SimpleDriver simpleDriver = new SimpleDriver();
        getWebDriver().get("http://13gp.by/informatsiya/meditsinskie-kalkulyatory/995-raschet-skorosti-klubochkovoj-filtratsii-skf");

    }


    @Test
    public void test1() {

        Select selectGender = new Select(getWebDriver().findElement(By.id("oSex")));
        selectGender.selectByValue("1");
        getWebDriver().findElement(By.id("oCr")).sendKeys("75");
        getWebDriver().findElement(By.id("oAge")).sendKeys("23");
        getWebDriver().findElement(By.id("oWeight")).sendKeys("55");
        getWebDriver().findElement(By.id("oCr")).sendKeys("75");
        getWebDriver().findElement(By.id("oHeight")).sendKeys("170");
        getWebDriver().findElement(By.cssSelector("[value='Рассчитать']")).click();
        List<String> actualData = new ArrayList<>();
        List<WebElement> result = getWebDriver().findElements(By.cssSelector("li div[id]"));
        result.forEach(webElement -> {
            actualData.add(webElement.getText());
        });
        List<String> expectedData = new ArrayList<>() {{
            add("MDRD: 0 (мл/мин/1,73кв.м)");
            add("ХБП: 5 стадия");
            add("Cockroft-Gault: 1 (мл/мин)");
            add("Поверхность тела:1.63 (кв.м)");

        }};
        Assert.assertEquals(actualData, expectedData);

    }

    @AfterTest
    public void postconditions() {
        getWebDriver().close();
    }

//    private void enter(String id, String value) {
//        getWebDriver().findElement(By.id(id)).clear();
//    }


}
