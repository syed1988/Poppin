package com.poppin;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Unit test for simple App.
 */
public class AppTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/Syed/IdeaProjects/Selenium/ChromeDriver/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");



    }

}
