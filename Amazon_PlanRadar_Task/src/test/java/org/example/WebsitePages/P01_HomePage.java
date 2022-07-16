package org.example.WebsitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P01_HomePage {

    WebDriver driver;
    public P01_HomePage(WebDriver driver) {
        this.driver = driver ;
    }

    public WebElement hamburger_btn(){
        WebElement hamburger_btn = driver.findElement(By.id("nav-hamburger-menu"));
        return hamburger_btn;
    }

    public WebElement sideMenu(){
        WebElement sideMenu = driver.findElement(By.className("hmenu"));
        return sideMenu;
    }

    public WebElement computers_tab(){
        WebElement computers_tab = driver.findElement(By.xpath("//div[@id=\"hmenu-content\"]//div[contains(text(),'Computers')]"));

        return computers_tab;
    }

    public WebElement computers_tablets_tab(){
        WebElement computers_tablets_tab = driver.findElement(By.xpath ("//div[@id=\"hmenu-content\"]//a[contains(text(),'Computers & Tablets')]"));

        return computers_tablets_tab;
    }

    public WebElement samsungFilter(){
        WebElement samsungFilter = driver.findElement(By.xpath("//li[@id=\"p_89/SAMSUNG\"]//i[@class=\"a-icon a-icon-checkbox\"]"));
        return samsungFilter;
    }
    public WebElement samsungcheckbox(){
        WebElement samsungcheckbox = driver.findElement(By.xpath("//li[@id=\"p_89/SAMSUNG\"]//input[@type=\"checkbox\"]"));
        return samsungcheckbox;
    }

   public void click_tabs() throws InterruptedException {
       hamburger_btn().click();
       Thread.sleep(500);
       computers_tab().click();
       Thread.sleep(500);
       computers_tablets_tab().click();
       Thread.sleep(500);
   }


    public WebElement cart_items()
    {
        WebElement cart_items = driver.findElement(By.id("nav-cart-count"));
        return cart_items;
    }

    public List<WebElement> choose_product()
    {
        List<WebElement> products = driver.findElements(By.xpath("//div[@class=\"s-main-slot s-result-list s-search-results sg-row\"]//div[@class=\"sg-col-4-of-12 s-result-item s-asin sg-col-4-of-16 sg-col s-widget-spacing-small sg-col-4-of-20\"]"));
        return products;
    }

    public WebElement add_to_cart_button()
    {
        WebElement add_to_cart_button = driver.findElement(By.xpath("//div[@id=\"usedOnlyBuybox\"]//div [@id=\"usedbuyBox\"] //input[@id=\"add-to-cart-button-ubb\"]"));
        return add_to_cart_button;
    }
    public WebElement delete_button()
    {
        WebElement delete_button = driver.findElement(By.xpath("//div[@class=\"a-column a-span10\"]//div[@class =\"a-row sc-action-links\"]//span[@class=\"a-declarative\"]//input[@value=\"Delete\"]"));
        return delete_button;
    }

    public WebElement cart_msg_div(){
        WebElement cart_msg_div = driver.findElement(By.xpath("//div[@id=\"sc-active-cart\" ]//h1[@class=\"a-spacing-mini a-spacing-top-base\"]"));
        return cart_msg_div;
    }
}
