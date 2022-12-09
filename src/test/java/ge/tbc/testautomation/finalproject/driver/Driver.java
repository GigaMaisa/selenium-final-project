package ge.tbc.testautomation.finalproject.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Driver {
    public static WebDriver getChromeDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getEdgeDriver(){
        WebDriverManager.edgedriver().setup();
        EdgeOptions opts = new EdgeOptions();
        opts.addArguments("start-maximized");
        WebDriver driver = new EdgeDriver(opts);
        driver.manage().window().maximize();
        return driver;
    }

    public static JavascriptExecutor getJsExecutor(WebDriver driver){
        return (JavascriptExecutor) driver;
    }

    public static void getURL(WebDriver driver, String URL){
        driver.get(URL);
    }
}