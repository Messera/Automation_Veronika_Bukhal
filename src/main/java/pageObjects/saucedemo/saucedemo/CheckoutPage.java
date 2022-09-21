package pageObjects.saucedemo.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import static driver.SimpleDriver.getWebDriver;

public class CheckoutPage extends BasePage {

    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");
    By next = By.id("continue");
    private By title = By.xpath("//span[@class='title']");



    public CheckoutPage enterInformation() {
        enter(firstName, "Name");
        enter(lastName, "Surname");
        enter(postalCode, "1234");
        click(next);
        return this;
    }


    private WebElement  getElementCartItem(String productName){
        return getWebDriver().findElement(By.xpath("//*[@class = 'inventory_item_name' and text() = '" + productName + "']//ancestor::div[@class='cart_item']"));
    }


    private WebElement getElementProductCost (String productName){
        return getElementCartItem(productName).findElement(By.className("inventory_item_price"));
    }

    private WebElement getElementCartQuantity(String productName) {
        return getElementCartItem(productName).findElement(By.className("cart_quantity"));

    }

    public String getProductCost(String productName){
        return getText(getElementProductCost(productName));
    }

    public String getCartQuantity(String productName){
        return getText(getElementCartQuantity(productName));
    }



    public double getTotalResult() {
        double subtotal = Double.parseDouble(getWebDriver().findElement(By.className("summary_subtotal_label")).getText().replaceAll("[^0-9, .]", ""));
        double tax = Double.parseDouble(getWebDriver().findElement(By.className("summary_tax_label")).getText().replaceAll("[^0-9, .]", ""));
        double totalResult = roundAvoid(subtotal + tax,2);
        return totalResult;
    }
    public double getTotalValue() {
        double totalValue = Double.parseDouble(getWebDriver().findElement(By.className("summary_total_label")).getText().replaceAll("[^0-9, .]", ""));
        return totalValue;
    }

    public CheckoutPage clickFinish(){
        click(By.id("finish"));
        return this;
    }

    public void verifyPageTitle(String pageTitle) {
        Assert.assertEquals(getText(title), pageTitle);
    }


    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }


}
