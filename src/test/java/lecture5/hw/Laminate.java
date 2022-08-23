package lecture5.hw;

import driver.SimpleDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static driver.SimpleDriver.getWebDriver;

public class Laminate {

    List<String> actualData = new ArrayList<>();

    @BeforeTest
    public void preconditions(){
        SimpleDriver simpleDriver = new SimpleDriver();
        getWebDriver().get("https://masterskayapola.ru/kalkulyator/laminata.html");

    }

    @BeforeMethod
    public void beforeMethod() {
        getWebDriver().get("https://masterskayapola.ru/kalkulyator/laminata.html");
    }

    @Test
    public void  test1() {

        enter("calc_roomwidth", "10");
        enter("calc_roomheight", "5");
        enter("calc_lamwidth", "1000");
        enter("calc_lamheight", "190");
        enter("calc_inpack", "12");
        enter("calc_price", "500");

        Select selectDirection = new Select(getWebDriver().findElement(By.name("calc_direct")));
        selectDirection.selectByValue("toh");

        enter("calc_bias", "300");
        enter("calc_walldist", "10");


        getWebDriver().findElement(By.cssSelector("[value='Рассчитать']")).click();

// Работает, но не видно, из-за чего зафейлилось

//        String actualData = getWebDriver().findElement(By.cssSelector(".col-xs-12.col-sm-12.whiteback")).getText();
//        String expectedData = "РЕЗУЛЬТАТ РАСЧЕТА:\n" +
//                "Площадь укладки: 0.64 м2.\n" +
//                "Кол-во панелей: 1 шт.\n" +
//                "Кол-во упаковок: 1 шт.\n" +
//                "Стоимость: 5250000 руб.\n" +
//                "Остатки: 98 шт.\n" +
//                "Отрезки: 0 шт.";
//         Assert.assertEquals(actualData, expectedData);
        getActualData();

//        for (String elem : actualData) {
//            System.out.println(elem);
//        }

      List<String> expectedData = Arrays.asList("49.70 м2.",
              "266 шт.",
             "23 шт.",
             "26220 руб.",
              "10 шт.",
              "20 шт.");

        Assert.assertEquals(actualData, expectedData);

    }


    @Test
    public void  test2() {

        enter("calc_roomwidth", "12");
        enter("calc_roomheight", "9");
        enter("calc_lamwidth", "2100");
        enter("calc_lamheight", "400");
        enter("calc_inpack", "10");
        enter("calc_price", "230");

        Select selectDirection = new Select(getWebDriver().findElement(By.name("calc_direct")));
        selectDirection.selectByValue("tow");

        enter("calc_bias", "1050");
        enter("calc_walldist", "20");

        getWebDriver().findElement(By.cssSelector("[value='Рассчитать']")).click();

        getActualData();

        List<String> expectedData = Arrays.asList(
                "107.16 м2.",
                "139 шт.",
                "14 шт.",
                "27048 руб.",
                "1 шт.",
                "14 шт.");

        Assert.assertEquals(actualData, expectedData);

    }


    @Test
    public void  test3() {

        enter("calc_roomwidth", "6");
        enter("calc_roomheight", "2");
        enter("calc_lamwidth", "500");
        enter("calc_lamheight", "50");
        enter("calc_inpack", "20");
        enter("calc_price", "340");

        Select selectDirection = new Select(getWebDriver().findElement(By.name("calc_direct")));
        selectDirection.selectByValue("toh");

        enter("calc_bias", "200");
        enter("calc_walldist", "10");

        getWebDriver().findElement(By.cssSelector("[value='Рассчитать']")).click();

        getActualData();

        List<String> expectedData = Arrays.asList(
                "11.84 м2.",
                "480 шт.",
                "24 шт.",
                "4080 руб.",
                "0 шт.",
                "60 шт.");

        Assert.assertEquals(actualData, expectedData);

    }


    @AfterTest
    public void postconditions(){
        getWebDriver().close();
    }

        private void enter(String name, String value) {
            getWebDriver().findElement(By.name(name)).sendKeys(Keys.chord(Keys.SHIFT,Keys.RIGHT,Keys.RIGHT,Keys.RIGHT, Keys.RIGHT), value);
    }

    private void getActualData(){
        actualData.clear();
        List<WebElement> result = getWebDriver().findElements(By.cssSelector("div [class='form_element'] span[id]"));
        result.forEach(webElement ->  {
            actualData.add(webElement.getText());
        });
    }

}
