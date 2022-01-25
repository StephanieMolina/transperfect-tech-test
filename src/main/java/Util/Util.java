package Util;

import WebDrivers.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Util extends WebDriverManager {

    public static WebElement waitForPresence(By _by){
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.presenceOfElementLocated(_by));
    }

    public static List<WebElement> waitForAllPresences(By _by){
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(_by));
    }
}
