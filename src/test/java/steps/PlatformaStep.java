package steps;

import io.cucumber.java.pt.Entao;
import pages.PlataformaPage;

import static support.Driver.driver;

public class PlatformaStep {
    PlataformaPage plataformaPage = new PlataformaPage(driver);

    @Entao("valido que sou direcionado para a pagina da plataforma {string}")
    public void validoPlataforma(String plataform) throws InterruptedException {
        plataformaPage.plataformValidate(plataform);
    }
}
