package org.example.StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Utilities.BrowserUtils;
import org.example.WebsitePages.P01_HomePage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class HomePage {

    //create home Page Object
    public P01_HomePage hPElements = new P01_HomePage(Hooks.driver);

    int cartItems_Before;
    int cartListItems_After;
    public SoftAssert soft = new SoftAssert();

    // <editor-fold defaultstate="collapsed" desc="Background Steps">
    //Navigate to the WebSite
    @Given("guest user navigate Amazon Website")
    public void user_open_url(){
        System.out.println("Navigate");
        Hooks.driver.navigate().to("https://www.amazon.com/");
    }
    @Then("guest user should be in amazon home page")
    public void check_url() throws InterruptedException {
        Thread.sleep(1000);   //to give opportunity to the driver to open the second tab after click on facebook icon
        String expected_url = "https://www.amazon.com/";
        String actual_url = Hooks.driver.getCurrentUrl();
        System.out.println(expected_url);
        System.out.println(actual_url);
        //Url Assertion
        Assert.assertEquals(actual_url,expected_url);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Click on  (All) hamburger-menu button">
    @When("guest user click on hamburger-menu icon")
    public void user_click_on_ALL_button() throws InterruptedException {
        hPElements.hamburger_btn().click();
        Thread.sleep(1000);  //to give opportunity to the driver to open the side tab after click on button
    }
    @Then("Side menu of products opens")
    public void check_if_side_menu_opened() throws InterruptedException {
        Thread.sleep(500);
        boolean actual_result = hPElements.sideMenu().isDisplayed();
        System.out.println(actual_result);
        //Url Assertion
        Assert.assertTrue(actual_result);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="navigate to computers and Tablets page">
    @When("guest user click on Computers tab")
    public void user_click_on_Computers_button() throws InterruptedException {
        hPElements.computers_tab().click();
        Thread.sleep(1000);
    }
    @And("guest user click on Computers & Tablets tab")
    public void user_click_on_Computers_Tablets_button() throws InterruptedException {
        Thread.sleep(1000);
        hPElements.computers_tablets_tab().click();

    }
    @Then("computers And Tablets Page opens")
    public void check_computers_And_Tablets_Page_opens() throws InterruptedException {
        Thread.sleep(1000);
        String expected_url = "https://www.amazon.com/s?i=specialty-aps&bbn=16225007011&rh=n%3A16225007011%2Cn%3A13896617011&ref=nav_em__nav_desktop_sa_intl_computers_tablets_0_2_6_4";
        String actual_url = Hooks.driver.getCurrentUrl();
        System.out.println(expected_url);
        System.out.println(actual_url);
        //Url Assertion
        Assert.assertEquals(actual_url,expected_url);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Samsung filter is checked">
    @Given("guest user navigate to computers And Tablets Page")
    public void user_navigate_to_computer_tablet_products() throws InterruptedException {
        Thread.sleep(3000);
        hPElements.click_tabs();
    }

    @When("guest user click on samsung filter")
    public void user_click_on_samsungFilter_button() throws InterruptedException {
        Thread.sleep(1000);
        hPElements.samsungFilter().click();
    }
    @Then("samsung checkbox is checked")
    public void check_samsung_checkbox() throws InterruptedException {
        Thread.sleep(1000);
        Boolean actual_result = hPElements.samsungcheckbox().isSelected();
        Boolean exbected_result =true;
        System.out.println(actual_result);
        //Url Assertion
        soft.assertEquals(actual_result,exbected_result);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Add product to cart">
    @When("^guest user click on product \"(.*)\" block$")
    public void choose_product(int item_num)  throws InterruptedException {
        Thread.sleep(1000);
        cartItems_Before = BrowserUtils.convertStringToInt(hPElements.cart_items().getText());
        System.out.println(cartItems_Before);
        hPElements.choose_product().get(item_num).click();
        Thread.sleep(1000);

    }

    @And("guest user click on Add to cart button")
    public void add_to_cart() throws InterruptedException {
        Thread.sleep(1000);
        hPElements.add_to_cart_button().click();
        cartListItems_After = BrowserUtils.convertStringToInt(hPElements.cart_items().getText());
        System.out.println(cartListItems_After);
    }
    @Then("carts items increases by one")
    public void check_cart_items() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Item added " + cartListItems_After + " > " + cartItems_Before + " "+ (cartListItems_After > cartItems_Before));
        Assert.assertTrue(cartListItems_After > cartItems_Before,"Numbers of items in Shopping cart Increased!");
    }

// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Add product to cart">
    @When("guest user navigate to cart")
    public void navigate_to_Cart()  throws InterruptedException {
        hPElements.cart_items().click();
        Thread.sleep(1000);

    }

    @And("guest user Delete added product")
    public void delete_product() throws InterruptedException {
        Thread.sleep(1000);
        hPElements.delete_button().click();
        cartListItems_After = BrowserUtils.convertStringToInt(hPElements.cart_items().getText());
        System.out.println(cartListItems_After);
    }
    @Then("check cart items decreased by one")
    public void check_cart_item_decreased() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Item added " + cartListItems_After + " = " + cartItems_Before + " "+ (cartListItems_After <= cartItems_Before));
        soft.assertTrue(cartListItems_After <= cartItems_Before,"Numbers of items in Shopping cart Increased!");

        //Check the delete msg (second assertion)
        String expected_msg = "Your Amazon Cart is empty.";
        String actual_msg = hPElements.cart_msg_div().getText();
        System.out.println(expected_msg);
        System.out.println(actual_msg);
        soft.assertEquals(actual_msg.contains(expected_msg), true);
    }
    // </editor-fold>
}


