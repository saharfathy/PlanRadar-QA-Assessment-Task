package org.example.StepDefinition;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {


    // define before and after annotation for your driver
    public static WebDriver driver = null;

    @Before
    public static void open_browser() {
        System.out.println("Hooks Before");
        //bridge between test scripts and browser
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("webdriver.chrome.driver", chromePath);

        //create Web driver Object
        driver = new ChromeDriver();
        // make the window full screen
        driver.manage().window().maximize();
        // make the driver wait for 8 sev
        driver.manage().timeouts().implicitlyWait( 8, TimeUnit.SECONDS);
        //Thread.sleep(3000);

    }

    @After
    public static void close_browser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
        System.out.println("Hooks After");
    }
}
