package support;

import constants.Path;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static constants.Config.ACCESS_KEY;
import static constants.Config.USERNAME;
import static constants.Path.*;
import static constants.Url.URL_BROWSERSTACK;

public class Driver {
    public static WebDriver driver;
    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            if (Path.nomePc.contains("Mac")) {
                System.out.println("==== LOADING macIOS DRIVER ====");
                System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_IOS);
            }
            else {
                System.out.println("==== LOADING LINUX DRIVER ====");
                System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_LINUX);
                options.addArguments("--headless");
            }

            options.addArguments("--disable-notifications");
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static WebDriver createBrowserStack() throws MalformedURLException {
        if (driver == null) {
            System.out.println("==== BROWSERSTACK LOADING ====");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browser", "Chrome");
            caps.setCapability("browser_version", "110.0");
            caps.setCapability("os", "Windows");
            caps.setCapability("os_version", "10");
            caps.setCapability("name", "JUnit Test");

            driver = new RemoteWebDriver(new URL("https://" + USERNAME + ":" + ACCESS_KEY +
                    URL_BROWSERSTACK), caps);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }


    public static void endSession() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
