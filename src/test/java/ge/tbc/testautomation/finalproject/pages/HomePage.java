package ge.tbc.testautomation.finalproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Page{
    public void testFunctionality(WebDriver driver){
        String cinemaButtonXpath = "//ul[@class='category-navigation-ul']//li[contains(@class, 'cat-0')]//a";
        WebElement cinemaButton = findElementByXpath(driver, cinemaButtonXpath);
        clickOnElement(cinemaButton);
    }
}
