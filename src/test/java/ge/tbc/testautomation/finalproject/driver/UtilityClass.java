package ge.tbc.testautomation.finalproject.driver;

import ge.tbc.testautomation.finalproject.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.HashMap;
import java.util.Map;

public class UtilityClass extends Page {
    private static String getDate(WebDriver driver){
        String lastElementXpath = "//div[@id='384933']//div[contains(@id, 'day-choose')][last()]";
        WebElement lastElement = driver.findElement(By.xpath(lastElementXpath));
        String idAttr = lastElement.getAttribute("id");
        String[] splittedString = idAttr.split("-");
        return splittedString[2];
    }

    private static String getCinemaTime(WebDriver driver){
        WebElement timeElement = driver.findElement(By.xpath("//div[@id='384933']//div[contains(@id, 'day-choose')][last()]//p[1]"));
        return timeElement.getText();
    }

    public static String getLastDate(WebDriver driver){
        Map<String, String> map = new HashMap<>();
        map.put("01", "იანვარი");
        map.put("02", "თებერვალი");
        map.put("03", "მარტი");
        map.put("04", "აპრილი");
        map.put("05", "მაისი");
        map.put("06", "ივნისი");
        map.put("07", "ივლისი");
        map.put("08", "აგვისტო");
        map.put("09", "სექტმებერი");
        map.put("10", "ოქტომბერი");
        map.put("11", "ნოემბერი");
        map.put("12", "დეკემბერი");

        String date = getDate(driver);
        String month = date.substring(3, 5);

        String formattedDate = null;
        for (String key: map.keySet()){
            if (month.equalsIgnoreCase(key)){
                formattedDate = date.substring(0, 2) +" "+ map.get(key);
            }
        }
        return formattedDate+" "+getCinemaTime(driver);
    }
}