package lecture19.hw;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.driver;

public class MySite {

    @Test
    public void MySiteTest(){

//        driver.get("file:///Users/veronikab/IdeaProjects/Automation_QA16/src/test/java/lecture19/hw/My_Site/Index.html");
        //open("http://localhost:63342/Automation_QA16/lecture19/hw/My_Site/Index.html?_ijt=3kpkhvbtah7g6i27ost2d1ai8o&_ij_reload=RELOAD_ON_SAVE");
        System.out.println($(By.className("about__text")).getText());
        $(By.xpath("/html/body/header/div/div/nav/a[2]")).click();
//        System.out.println($(By.xpath("/html/body/div[2]/div/div/table/tbody/tr[1]/th[6]")).getText());
//        for (int i = 1; i < 12; i++) {
//            System.out.println($(By.xpath("/html/body/div[2]/div/div/table/tbody/tr[" + i + "]/th[6]")).getText());
//        }
    }

}
