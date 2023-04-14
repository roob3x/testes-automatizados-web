package steps;

import io.cucumber.java.es.Dado;
import io.cucumber.java.pt.Entao;
import pages.CategoryPage;


import static support.Driver.driver;

public class CategoryStep {
    CategoryPage categoryPage = new CategoryPage(driver);

    @Entao("valido que sou direcionado para a pagina de categoria {string}")
    public void validoCategoria(String category) throws InterruptedException {
        categoryPage.categoryValidate(category);
    }
}
