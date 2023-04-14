package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public static By MAGNIFYING_GLASS_BTN = By.id("search-open");
    public static By SEARCH_INPUT = By.className("search-field");
    public static By SEARCH_BTN = By.xpath("//input[@type = 'submit']");
    public static By INSTITUCIONAL_CATEGORY = By.xpath("//a[contains( text(), 'Institucional')]");
    public static By PRODUTOS_CATEGORY = By.xpath("//a[contains( text(), 'Produtos')]");
    public static By SERVICOS_CATEGORY = By.xpath("//a[contains( text(), 'Serviços')]");
    public static By FINANCAS_CATEGORY = By.xpath("//a[contains( text(), 'Suas finanças')]");
    public static By SEGURANCA_CATEGORY = By.xpath("//a[contains( text(), 'Sua segurança')]");
    public static By CARREIRA_CATEGORY = By.xpath("//a[contains( text(), 'Sua carreira')]");
    public static By NOSSO_CANAL__CATEGORY = By.xpath("//a[contains( text(), 'Inscreva-se no nosso canal!')]");
    public static By INVESTIMENTO_CATEGORY = By.xpath("//a[contains( text(), 'Seus investimentos')]");
    public static By FACEBOOK_PLATFORM = By.xpath("//li[@id = 'menu-item-24']//a");
    public static By INSTAGRAM_PLATFORM = By.xpath("//li[@id = 'menu-item-26']//a");
    public static By LINKEDIN_PLATFORM = By.xpath("//li[@id = 'menu-item-2696']//a");

    public void searchSubject(String text) throws InterruptedException {
        click(MAGNIFYING_GLASS_BTN);
        send_keys(SEARCH_INPUT, text);
        click(SEARCH_BTN);
    }

    public void chooseCategory(String category) {
        switch (category) {
            case "Institucional":
                click(INSTITUCIONAL_CATEGORY);
                break;
            case "Produtos":
                click(PRODUTOS_CATEGORY);
                break;
            case "Serviços":
                click(SERVICOS_CATEGORY);
                break;
            case "Suas finança":
                click(FINANCAS_CATEGORY);
                break;
            case "Sua segurança":
                click(SEGURANCA_CATEGORY);
                break;
            case "Sua carreira":
                click(CARREIRA_CATEGORY);
                break;
            case "Inscreva-se no nosso canal!":
                click(NOSSO_CANAL__CATEGORY);
                break;
            case "Seus investimentos":
                click(INVESTIMENTO_CATEGORY);
                break;
        }
    }

    public void choosePlataform(String plataform) {
        switch (plataform) {
            case "facebook":
                click(FACEBOOK_PLATFORM);
                break;
            case "instagram":
                click(INSTAGRAM_PLATFORM);
                break;
            case "linkedin":
                click(LINKEDIN_PLATFORM);
                break;
        }
    }
}
