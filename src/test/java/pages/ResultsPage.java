package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constants.CustomData.*;

public class ResultsPage extends BasePage{

    public static By TITLE_RESULT = By.className("archive-title");
    public static By TITLE_NEWS = By.xpath("//h2[@class = 'entry-title']");
    public static By ON_ONE_TITLE_NEWS = By.xpath("//h1[@class = 'entry-title']");
    public static By SUMMARY_NEWS = By.xpath("//div[@class = 'entry-summary']");
    public static By SUMMARY_EMPTY_NEWS = By.xpath("//div[@class = 'entry-content']//p");

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    public void waitTitleAppear(){
        wait_element_visible(TITLE_RESULT);
    }

    public void validateTitleAndDescriptionExist() {
        Assert.assertEquals(getTextByAttribute(TITLE_NEWS, "innerText"), TITLE_NEWS_RESULT);
        Assert.assertEquals(getTextByAttribute(SUMMARY_NEWS, "innerText"), SUMMARY_RESULT);
    }

    public void validateTitleAndDescriptionNonExistent() {
        Assert.assertEquals(getTextByAttribute(ON_ONE_TITLE_NEWS, "innerText"), NO_ONE_RESULT);
        Assert.assertEquals(getTextByAttribute(SUMMARY_EMPTY_NEWS, "innerText"), NO_ONE_DESCRIPTION);
    }
}
