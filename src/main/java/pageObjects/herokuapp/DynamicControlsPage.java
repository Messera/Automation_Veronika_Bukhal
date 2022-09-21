package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.baseObjects.BasePage;

public class DynamicControlsPage extends BasePage {

    private By checkbox = By.id("checkbox");
    private By checkboxBtn = By.xpath("//*[@id=\"checkbox-example\"]/button");
    private By message = By.id("message");
    private By input = By.xpath("//*[@id=\"input-example\"]/input");
    private By inputBtn = By.xpath("//*[@id=\"input-example\"]/button");


    public DynamicControlsPage clickCheckboxBtn(){
        click(checkboxBtn);
        return this;
    }

    public DynamicControlsPage clickInputBtn(){
        click(inputBtn);
        return this;
    }

    public String checkboxIsGone(){
        wait.until(ExpectedConditions.textToBe(message, "It's gone!"));
        if (driver.findElements(By.id("checkbox")).isEmpty())
            System.out.println("Checkbox is gone!");
        return getText(message);
}

    public String  inputEnabled(){
        wait.until(ExpectedConditions.textToBe(message, "It's enabled!"));
        return getText(message);

    }

    public DynamicControlsPage inputAvailability(){

        if (driver.findElement(input).isEnabled()){
            System.out.println("Input enabled!");
        } else {
            System.out.println("Input disabled!");
        }
        return this;

    }



}
