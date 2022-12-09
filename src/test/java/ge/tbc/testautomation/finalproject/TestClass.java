package ge.tbc.testautomation.finalproject;

import ge.tbc.testautomation.finalproject.driver.Driver;
import ge.tbc.testautomation.finalproject.pages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestClass {
    WebDriver driver;
    JavascriptExecutor js;

    @BeforeTest
    @Parameters("browser")
    public void setupTest(String browser){
        if (browser.equalsIgnoreCase("edge")){
            driver = Driver.getEdgeDriver();
            js = Driver.getJsExecutor(driver);
        }
        else if (browser.equalsIgnoreCase("chrome")){
            driver = Driver.getChromeDriver();
            js = Driver.getJsExecutor(driver);
        }
    }

    @Test
    public void runTest() {
        Driver.getURL(driver, "https://www.swoop.ge/");

        HomePage homePage = new HomePage();
        homePage.testFunctionality(driver);

        CinemasPage cinemasPage = new CinemasPage();
        cinemasPage.testFunctionality(driver);

        CinemaDetailsPage detailsPage = new CinemaDetailsPage();
        detailsPage.testFunctionality(driver, js);

        PopupCinemaPage popupCinemaPage = new PopupCinemaPage();
        popupCinemaPage.testFunctionality(driver);

        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.testFunctionality(driver);
    }

    @AfterTest
    public void endTest(){
        driver.quit();
    }
}