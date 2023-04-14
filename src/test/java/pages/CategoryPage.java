package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constants.CustomData.CATEGORY_NAME;
import static constants.CustomData.NOSSO_CANAL_CATEGORY;

public class CategoryPage extends BasePage{
    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public static By CATEGORY_TITLE = By.xpath("//h1[@class = 'archive-title']");
    public static By ENTRY_TITLE = By.xpath("//h1[@class = 'entry-title']");

    public void categoryValidate(String category){
        if (!category.contains("Inscreva-se no nosso canal!")){
            Assert.assertEquals(getTextByAttribute(CATEGORY_TITLE, "innerText"),
                    CATEGORY_NAME.replace("CATEGORIA", category));
        }
        else {
            Assert.assertEquals(getTextByAttribute(ENTRY_TITLE, "innerText"), NOSSO_CANAL_CATEGORY);
        }
    }
}
