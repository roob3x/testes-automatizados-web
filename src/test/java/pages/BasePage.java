package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class BasePage {
    private static final Logger logger = Logger.getLogger(BasePage.class.getName());
    protected WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public WebDriverWait wait_for() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        return wait;
    }

    public WebElement find(By locator) {
        WebElement element = wait_for().until(ExpectedConditions.elementToBeClickable(locator));
        return element;
    }

    public String getTextByAttribute(By locator, String attribute) {
        logger.info("-- obtendo o texto do elemento " + locator + " atraves do atributo " + attribute);
        return find(locator).getAttribute(attribute);
    }

    public void click(By locator) {
        wait_for().until(ExpectedConditions.elementToBeClickable(locator)).click();
        logger.info("-- clicando no elemento " + locator);
    }


    public void send_keys(By locator, String text) {
        wait_for().until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(text);
        logger.info("-- escrevendo no elemento " + locator);
    }

    public void handleWindow() {
        Set<String> janelas = driver.getWindowHandles();
        for (String janela : janelas) {
            if (!janela.equals(driver.getWindowHandle())) {
                driver.switchTo().window(janela);
                break;
            }
        }
    }
}
