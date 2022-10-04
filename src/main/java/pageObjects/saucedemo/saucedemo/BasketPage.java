package pageObjects.saucedemo.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.baseObjects.BasePage;

import static driver.SimpleDriver.getWebDriver;

public class BasketPage extends BasePage {


    private WebElement getElementCartItem(String productName) {
        return getWebDriver().findElement(By.xpath("//*[@class = 'inventory_item_name' and text() = '" + productName + "']//ancestor::div[@class='cart_item']"));
    }


    private WebElement getElementProductCost(String productName) {
        return getElementCartItem(productName).findElement(By.className("inventory_item_price"));
    }

    private WebElement getElementCartQuantity(String productName) {
        return getElementCartItem(productName).findElement(By.className("cart_quantity"));

    }

    public BasketPage open() {
        getWebDriver().findElement(By.id("shopping_cart_container")).click();
        return this;
    }

    public String getProductCost(String productName) {
        return getText(getElementProductCost(productName));
    }


    public String getCartQuantity(String productName) {
        return getText(getElementCartQuantity(productName));
    }

    public BasketPage checkout() {
        getWebDriver().findElement(By.id("checkout")).click();
        return this;
    }

    private WebElement getRemoveFromCartBtn(String productName) {
        return getElementCartItem(productName).findElement(By.tagName("button"));
    }

    public void removeFromCart(String productName) {
        click(getRemoveFromCartBtn(productName));
    }

    public BasketPage checkIfProductExist(String productName) {
        getElementCart(productName);
        return this;
    }

    private void getElementCart(String productName) {

        try {
            getWebDriver().findElement(By.xpath("//*[@class = 'inventory_item_name' and text() = '" + productName + "']//ancestor::div[@class='cart_item']"));
            System.out.println("Product was added successfully");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Product was removed successfully");
        }

    }


}
