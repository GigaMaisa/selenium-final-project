package ge.tbc.testautomation.finalproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.*;

public class CinemaDetailsPage extends Page{
    public static String getMovieName(WebDriver driver){
        String movieNameXpath = "//div[@class='info']//p[@class='name']";
        WebElement movieNameElement = driver.findElement(By.xpath(movieNameXpath));
        return movieNameElement.getText();
    }

    public static final String cinemaName = "კავეა ისთ ფოინთი";


    public void testFunctionality(WebDriver driver, JavascriptExecutor js){
        String caveaEastPointButtonXpath = "//li[contains(@class, 'ui-corner-top') and contains(@class, 'ui-state-default')]//a[text()='კავეა ისთ ფოინთი']";
        String listCssSelector = "ul.cinema-tabs";
        String elementsCssSelector = "ul.cinema-tabs li";

        WebElement caveaEastPointButton = findElementByXpath(driver, caveaEastPointButtonXpath);
        clickOnElement(caveaEastPointButton);

        WebElement scrollList = findElementByCSS(driver, listCssSelector);
        List<WebElement> scrollBarElements = findElementsByCSS(driver, elementsCssSelector);
        scrollIntoElement(driver, scrollList, js, scrollBarElements.get(scrollBarElements.size()-1));

        Map<String, Integer> map = new HashMap<>();
        map.put("კავეა ისთ ფოინთი", 384933);
        map.put("კავეა თბილისი მოლი", 314390);
        map.put("კავეა გალერია თბილისი", 549580);
        map.put("კავეა სითი მოლი საბურთალო", 607158);

        String lastDateSessionXpath = "//div[@id='"+map.get("კავეა ისთ ფოინთი")+"']//ul//li[last()]";
        WebElement lastDateSessionElement = findElementByXpath(driver, lastDateSessionXpath);
        clickOnElement(lastDateSessionElement);

        String[] splittedString = getTextOfElement(lastDateSessionElement).split(" ");
        String dayOfSession = splittedString[0];

        String caveaEastPointNamesXpath = "//div[@id='"+map.get("კავეა ისთ ფოინთი")+"']//div[@id='day-choose-" +dayOfSession+"']//p[@class='cinema-title']";
        List<WebElement> cinemaNames = findElementsByXpath(driver, caveaEastPointNamesXpath);
        for (WebElement cinema: cinemaNames){
            Assert.assertEquals(getTextOfElement(cinema), "კავეა ისთ ფოინთი");
        }

        String lastSessionXpath = "//div[@id='"+map.get("კავეა ისთ ფოინთი")+"']//div[contains(@id, 'day-choose-"+dayOfSession+"')][last()]";
        WebElement lastSessionElement = findElementByXpath(driver, lastSessionXpath);
        js.executeScript("arguments[0].scrollIntoView()", lastSessionElement);
        clickOnElement(lastSessionElement);

        String ticketsMapXpath = "//div[@class='tickets-corns']";
        new WebDriverWait(driver, Duration.ofSeconds(15)).until
                (ExpectedConditions.visibilityOfElementLocated(By.xpath(ticketsMapXpath)));
    }
}
