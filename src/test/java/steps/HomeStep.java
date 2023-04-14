package steps;

import io.cucumber.java.es.Dado;
import pages.HomePage;


import static support.Driver.driver;

public class HomeStep{
    HomePage homePage = new HomePage(driver);

    @Dado("realizo a busca do assunto {string}")
    public void consultaAssunto(String title) throws InterruptedException {
        homePage.searchSubject(title);
    }

    @Dado("que acesso a categoria {string}")
    public void queAcessoACategoria(String category) throws InterruptedException {
        homePage.chooseCategory(category);
    }
}
