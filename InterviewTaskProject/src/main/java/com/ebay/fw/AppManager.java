package com.ebay.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class AppManager {

    String browser;
    public WebDriver driver;



    public AppManager(String browser) {
        this.browser = browser;
    }


    public void init() {

        if(browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("remote-allow-origins=*");
            driver = new EdgeDriver(options);

        }


        driver.get("https://www.ebay.de");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    public void stop() {
        driver.quit();
    }
    // www
}


