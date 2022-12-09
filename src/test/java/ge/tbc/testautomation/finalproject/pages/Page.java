package ge.tbc.testautomation.finalproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class Page {
    public WebElement findElementByXpath(WebDriver driver, String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public List<WebElement> findElementsByXpath(WebDriver driver, String xpath) {
        return driver.findElements(By.xpath(xpath));
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    public String getTextOfElement(WebElement element) {
        return element.getText();
    }

    public void hoverOverElement(WebElement element, WebDriver driver){
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
    }

    public WebElement findElementByCSS(WebDriver driver, String cssSelector){
        return driver.findElement(By.cssSelector(cssSelector));
    }

    public List<WebElement> findElementsByCSS(WebDriver driver, String cssSelector){
        return driver.findElements(By.cssSelector(cssSelector));
    }

    public void scrollIntoElement(WebDriver driver, WebElement scrollingContainer, JavascriptExecutor js, WebElement targetElement){
        Actions builder = new Actions(driver);
        builder.moveToElement(scrollingContainer).perform();
        js.executeScript("arguments[0].scrollIntoView()", targetElement);
    }

    public void typeTextInElement(WebElement element, String text){
        element.click();
        element.sendKeys(text);
    }
}
