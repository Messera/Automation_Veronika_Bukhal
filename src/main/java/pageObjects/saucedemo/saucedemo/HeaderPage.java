package pageObjects.saucedemo.saucedemo;

import org.openqa.selenium.By;

public class HeaderPage extends BasketPage{

    By basketBtn = By.className("shopping_cart_link");
    By navigationBtn = By.id("react-burger-menu-btn");
    By allItemsBtn = By.id("inventory_sidebar_link");
    By aboutBtn = By.id("about_sidebar_link");
    By logoutBtn = By.id("logout_sidebar_link");
    By resetBtn = By.id("reset_sidebar_link");


    public void clickBasketBtn(){
        click(basketBtn);
    }

    public void clickNavigationBtn(){
        click(navigationBtn);
    }

    public void clickAllItemsBtn(){
        click(allItemsBtn);
    }
    public void clickAboutBtn(){
        click(aboutBtn);
    }
    public void clickLogoutBtn(){
        click(logoutBtn);
    }
    public void clickResetBtn(){
        click(resetBtn);
    }





}
