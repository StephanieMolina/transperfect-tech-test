package WebDrivers;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.HashMap;

public class WebDriverDefinition {

    WebDriver driver;

    public WebDriverDefinition(String _appUrl, String _browser) {
        driver = createDriver(_appUrl, _browser);
    }

    public WebDriver createDriver(String _appUrl, String _browser){
        setBrowser(_browser);
        driver.get(_appUrl);
        return driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    private void setBrowser(String _browser) {
        if (_browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();

            options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

            options.addArguments("--no-sandbox");
            options.addArguments("start-maximized");
            options.addArguments("--disable-notifications");
            options.addArguments("use-fake-ui-for-media-stream");
            options.addArguments("--use-fake-device-for-media-stream");
            options.addArguments("--use-fake-ui-for-media-stream");
            options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            options.addArguments("enable-automation");
//            options.addArguments("-headless");
            options.addArguments("--disable-extensions");
            options.addArguments("--dns-prefetch-disable");
            options.addArguments("--disable-gpu");
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            options.setExperimentalOption("prefs", chromePrefs);

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);

            System.out.println("[WebDriverDefinition][Driver][Chrome] Creating new chrome instance");
            driver = new ChromeDriver(options);

        } else {
            System.out.println("Browser cannot be launched");
        }
        driver.manage().window().setSize(new Dimension(1440, 1400));
    }
}
