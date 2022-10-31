package lecture19.hw;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverConditions;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;

import static com.codeborne.selenide.Selenide.*;



public class MySite {

    @Test
    public void MySiteTest(){

        open("file:///Users/veronikab/IdeaProjects/Automation_QA16/src/test/java/lecture19/hw/My_Site/Index.html");

        $(By.className("title__img")).shouldBe(Condition.exist);

        Assert.assertEquals($(By.className("about__text")).getText(), "A promising tester with little experience, but a strong desire to grow and develop in this area. I think that the goal of the first higher education is to understand what you do not want to do for the rest of your life. By the age of 23, I realized that YOLO and followed my dream.");
        $(By.xpath("/html/body/header/div/div/nav/a[2]")).click();

        LinkedList<String> description = new LinkedList<>();
        for (int i = 2; i < 6; i++) {
            description.add($(By.xpath("/html/body/div[2]/div/div/table/tbody/tr[" + i + "]/td[6]")).getText());
        }
        System.out.println(description);

        $(By.xpath("//*[@id=\"topS\"]/div/div/nav/a[4]")).click();
        webdriver().shouldHave(WebDriverConditions.url("file:///Users/veronikab/IdeaProjects/Automation_QA16/src/test/java/lecture19/hw/My_Site/Contact.html"));

    }

}
