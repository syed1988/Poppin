package com.poppin;

import com.poppin.util.Locators;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

/**
 * Created by Syed on 1/21/16.
 */
public class ColorPageTest {


    private WebDriver driver = null;
    private WebDriverWait wait;
    private WebElement listOfColors;
    private WebElement xButton;

    @Before
    public void setup(){
        //This line of code allows you to run this test with ChromeDriver
        // The second parameter is the location of your chromedriver.exe file on your machine
        // In order to run on chrome driver, please install chromedriver from seleniumhq.org and set the location
        // below and instantiate ChromeDriver.

        //System.setProperty("webdriver.chrome.driver", "/Users/Syed/IdeaProjects/Selenium/ChromeDriver/chromedriver");

        driver = new FirefoxDriver();
        driver.get("http://poppin.com");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,10);
        try {
            xButton = driver.findElement(By.id("x-mark-icon"));
            wait.until(ExpectedConditions.elementToBeClickable(xButton));
            xButton.click();
        }catch (ElementNotVisibleException e){
            System.out.println("Sign-Up prompt did not show up");
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("x-mark-icon")));

    }

    // Closes the browser after each test
    @After
    public void closeBrowser(){
        if (driver != null){
            driver.close();
        }
    }

    // All of the tests below calls the utility method, which has been defined at the end of this class.
    // The method clicks on a color and is navigated to its respective page and asserts the color
    @Test
    public void whitePageTest() {

        navigateToAColorPageAndAssert(Locators.WHITE_PAGE_LOCATOR_CSS, "WHITE");
    }
    @Test
    public void yellowPageTest(){

        navigateToAColorPageAndAssert(Locators.YELLOW_PAGE_LOCATOR_CSS, "YELLOW");
    }
    @Test
    public void orangePageTest() {
        navigateToAColorPageAndAssert(Locators.ORANGE_PAGE_LOCATOR_CSS, "ORANGE");
    }

    @Test
    public void coralPageTest() {
       navigateToAColorPageAndAssert(Locators.CORAL_PAGE_LOCATOR_CSS, "CORAL");
    }

    @Test
    public void redPageTest() {
       navigateToAColorPageAndAssert(Locators.RED_PAGE_LOCATOR_CSS, "RED");
    }

    @Test
    public void pinkPageTest() {
        navigateToAColorPageAndAssert(Locators.PINK_PAGE_LOCATOR_CSS, "PINK");
    }

    @Test
    public void limeGreenPageTest() {
        navigateToAColorPageAndAssert(Locators.LIMEGREEN_PAGE_LOCATOR_CSS, "LIME GREEN");
    }

    @Test
    public void mintPageTest() {
        navigateToAColorPageAndAssert(Locators.MINT_PAGE_LOCATOR_CSS, "MINT");
    }
    @Test
    public void aquaPageTest() {
        navigateToAColorPageAndAssert(Locators.AQUA_PAGE_LOCATOR_CSS, "AQUA");
    }

    @Test
    public void poolBluePageTest() {
        navigateToAColorPageAndAssert(Locators.POOLBLUE_PAGE_LOCATOR_CSS, "POOL BLUE");
    }

    @Test
    public void cobaltPageTest() {
        navigateToAColorPageAndAssert(Locators.COBALT_PAGE_LOCATOR_CSS, "COBALT");
    }

    @Test
    public void navyPageTest() {
        navigateToAColorPageAndAssert(Locators.NAVY_PAGE_LOCATOR_CSS, "NAVY");
    }

    @Test
    public void purplePageTest() {
        navigateToAColorPageAndAssert(Locators.PURPLE_PAGE_LOCATOR_CSS, "PURPLE");
    }

    @Test
    public void blackPageTest() {
        navigateToAColorPageAndAssert(Locators.BLACK_PAGE_LOCATOR_CSS, "BLACK");
    }

    @Test
    public void darkGrayPageTest(){
        navigateToAColorPageAndAssert(Locators.DARKGREY_PAGE_LOCATOR_CSS, "DARK GRAY");
    }

    @Test
    public void lightGreyPageTest() {
        navigateToAColorPageAndAssert(Locators.LIGHTGREY_PAGE_LOCATOR_CSS, "LIGHT GREY");
    }

    @Test
    public void metallicPageTest() {
        navigateToAColorPageAndAssert(Locators.METALLIC_PAGE_LOCATOR_CSS, "METALLICS");
    }


    private void navigateToAColorPageAndAssert(String colorPageLocatorByCSS, String expectedColorPage){
        listOfColors = driver.findElement(By.cssSelector(colorPageLocatorByCSS));
        listOfColors.click();
        WebElement colorPageToVerify = driver.findElement(By.cssSelector(".banner-text>h6"));
        assertEquals(expectedColorPage, colorPageToVerify.getText());
        driver.manage().deleteAllCookies();
    }
}




