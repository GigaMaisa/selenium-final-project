package ge.tbc.testautomation.finalproject.pages;

import ge.tbc.testautomation.finalproject.driver.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class PopupCinemaPage extends Page{
    public void testFunctionality(WebDriver driver){
        String movieTitleXpath = "//div[@class='content-header']//p[@class='movie-title']";
        String movieCinemaXpath = "//div[@class='content-header']//p[@class='movie-cinema'][1]";
        String movieDateXpath = "//div[@class='content-header']//p[@class='movie-cinema'][2]";
        String freeSeatsXpath = "//div[@class='seat free']";
        String registrationXpath = "//section[@class='login-register-outer']//li[@aria-labelledby='ui-id-4']";
        String iuridiuliPiriXpath = "//section[@class='login-register-outer']//a[@id='ui-id-2']";

        WebElement movieTitleElement = findElementByXpath(driver, movieTitleXpath);
        String movieTitle = getTextOfElement(movieTitleElement);

        WebElement movieCinemaElement = findElementByXpath(driver, movieCinemaXpath);
        String movieCinema = getTextOfElement(movieCinemaElement);

        WebElement movieDateElement = findElementByXpath(driver, movieDateXpath);
        String movieDate = getTextOfElement(movieDateElement);

        Assert.assertEquals(movieTitle, CinemaDetailsPage.getMovieName(driver));
        Assert.assertEquals(movieCinema, CinemaDetailsPage.cinemaName);
        Assert.assertEquals(movieDate, UtilityClass.getLastDate(driver));

        List<WebElement> freeSeatsElements = findElementsByXpath(driver, freeSeatsXpath);
        Random random = new Random();
        clickOnElement(freeSeatsElements.get(random.nextInt(0, freeSeatsElements.size()-1)));

        WebElement registrationButton = findElementByXpath(driver, registrationXpath);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until
                (ExpectedConditions.elementToBeClickable(By.xpath(registrationXpath)));
        clickOnElement(registrationButton);

        WebElement iuridiuliPiriButton = findElementByXpath(driver, iuridiuliPiriXpath);
        clickOnElement(iuridiuliPiriButton);
    }
}
