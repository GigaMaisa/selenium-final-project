package ge.tbc.testautomation.finalproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class CinemasPage extends Page{
    public void testFunctionality(WebDriver driver){
        String allCinemaEventsXpath = "//div[contains(@class, 'cinema_container')]//div[@class='movies-deal']";
        String buyTicketButtonXpath = "//div[contains(@class, 'cinema_container')]//div[@class='movies-deal']//div[@class='info-cinema-ticket']";

        List<WebElement> cinemaElements = findElementsByXpath(driver, allCinemaEventsXpath);
        List<WebElement> cinemaBuyButtons = findElementsByXpath(driver, buyTicketButtonXpath);
        hoverOverElement(cinemaElements.get(0), driver);
        clickOnElement(cinemaBuyButtons.get(0));

        String movieDetailsXpath = "//div[@class='movie-detailed-info']";
        new WebDriverWait(driver, Duration.ofSeconds(10)).until
                (ExpectedConditions.visibilityOfElementLocated(By.xpath(movieDetailsXpath)));
    }
}
