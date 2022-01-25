package WebDrivers;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import java.util.ArrayList;
import java.util.List;

public class WebDriverManager {

    protected static WebDriver webDriver;
    protected static List<WebDriverDefinition> driversList;

    public static void setWebDriver(WebDriver driver) {
        webDriver = driver;
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static void addToDriversList(WebDriverDefinition driverDefinition) {
        if (null == driversList) {
            driversList = new ArrayList<WebDriverDefinition>();
        }
        driversList.add(driverDefinition);
    }

    public static WebDriverDefinition createWebDriver(String appUrl, String browser){
        WebDriverDefinition driverDefinition = new WebDriverDefinition(appUrl, browser);
        addToDriversList(driverDefinition);
        return driverDefinition;
    }

    @AfterTest
    public void afterTest(){
        if (null != driversList) {
            for (WebDriverDefinition driverDefinition : driversList) {
                if (null != driverDefinition.getDriver()) {
                    try {
                        System.out.println("Iterated through web drivers list: Found " + driverDefinition.getDriver().getTitle());
                        driverDefinition.getDriver().quit();
                    } catch (NoSuchSessionException exception) {
                        System.out.println("[NoSuchSessionException] No webdriver found. Moving on. ");
                    }
                }
            }
        }
    }
}
