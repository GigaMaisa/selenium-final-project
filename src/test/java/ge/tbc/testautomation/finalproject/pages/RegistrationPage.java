package ge.tbc.testautomation.finalproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class RegistrationPage extends Page{
    public void testFunctionality(WebDriver driver){
        String companyName = "gfd";
        String companyCode = "vxc";
        String city = "854114";
        String zipCode = "65445132";
        String email = "ადადასდსად";
        String password = "gr";
        String repeatPassword = "dfsds";
        String nameLastName = "fdgf fds";
        String personalID = "01";
        String phoneNumber = "59";

        String companyTypeXpath = "//div[@id='register-content-2']//select[@class='mail-input']";
        String companyNameXpath = "//div[@id='register-content-2']//input[@id='lName']";
        String companyCodeXpath = "//div[@id='register-content-2']//input[@id='lTaxCode']";
        String cityXpath = "//div[@id='register-content-2']//input[@id='lCity']";
        String zipCodeXpath = "//div[@id='register-content-2']//input[@id='lPostalCode']";
        String emailXpath = "//div[@id='register-content-2']//input[@id='lContactPersonEmail']";
        String passwordXpath = "//div[@id='register-content-2']//input[@id='lContactPersonPassword']";
        String repeatPasswordXpath = "//div[@id='register-content-2']//input[@id='lContactPersonConfirmPassword']";
        String nameLastNameXpath = "//div[@id='register-content-2']//input[@id='lContactPersonName']";
        String personalIDXpath = "//div[@id='register-content-2']//input[@id='lContactPersonPersonalID']";
        String phoneNumberXpath = "//div[@id='register-content-2']//input[@id='lContactPersonPhone']";
        String checkBoxXpath = "//div[@id='register-content-2']//input[@id='IsLegalAgreedTerms']";
        String registerButtonXpath = "//div[@id='register-content-2']//div[@class='dashbord-registration']//input";
        String alertTextXpath = "//div[@id='register-content-2']//div[@class='physicalInfoMassage']//p";


        Select select = new Select(findElementByXpath(driver, companyTypeXpath));
        List<WebElement> selectableElements = select.getOptions();
        Random random = new Random();
        clickOnElement(selectableElements.get(random.nextInt(1, selectableElements.size())));

        typeTextInElement(findElementByXpath(driver, companyNameXpath), companyName);
        typeTextInElement(findElementByXpath(driver, companyCodeXpath), companyCode);
        typeTextInElement(findElementByXpath(driver, cityXpath), city);
        typeTextInElement(findElementByXpath(driver, zipCodeXpath), zipCode);
        typeTextInElement(findElementByXpath(driver, emailXpath), email);
        typeTextInElement(findElementByXpath(driver, passwordXpath), password);
        typeTextInElement(findElementByXpath(driver, repeatPasswordXpath), repeatPassword);
        typeTextInElement(findElementByXpath(driver, nameLastNameXpath), nameLastName);
        typeTextInElement(findElementByXpath(driver, personalIDXpath), personalID);
        typeTextInElement(findElementByXpath(driver, phoneNumberXpath), phoneNumber);
        clickOnElement(findElementByXpath(driver, checkBoxXpath));
        clickOnElement(findElementByXpath(driver, registerButtonXpath));

        new WebDriverWait(driver, Duration.ofSeconds(15)).until
                (ExpectedConditions.visibilityOfElementLocated(By.xpath(alertTextXpath)));

        String expectedAlertText = "რეგისტრაციის დროს დაფიქსირდა შეცდომა!";
        String actualAlertText = getTextOfElement(findElementByXpath(driver, alertTextXpath));
        Assert.assertEquals(actualAlertText, expectedAlertText);
    }
}
