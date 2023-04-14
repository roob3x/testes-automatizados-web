package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constants.CustomData.CATEGORY_NAME;

public class PlataformaPage extends BasePage{

    public PlataformaPage(WebDriver driver) {
        super(driver);
    }

    public static By AGIBANK_FACEBOOK_H1 = By.xpath("//h1[contains ( text(), 'Agibank')]");
    public static By AGIBANK_INSTAGRAM_SPAN = By.xpath("//span[contains ( text(), 'Agibank')]");
    public static By AGIBANK_LINKEDIN_H2 = By.xpath("//h2[contains ( text(), 'Agibank')]");

    public void plataformValidate(String plataform) {
        switch (plataform) {
            case "facebook":
                Assert.assertEquals(getTextByAttribute(AGIBANK_FACEBOOK_H1, "innerText"),
                        "Agibank");
                break;
            case "instagram":
                Assert.assertEquals(getTextByAttribute(AGIBANK_INSTAGRAM_SPAN, "innerText"),
                        "Agibank");
                break;
            case "linkedin":
                Assert.assertEquals(getTextByAttribute(AGIBANK_LINKEDIN_H2, "innerText"),
                        "Employees at Agibank");
                break;
        }
    }
}
