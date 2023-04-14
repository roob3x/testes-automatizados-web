package steps;

import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import pages.ResultsPage;

import static support.Driver.driver;

public class ResultsStep {
    ResultsPage resultsPage = new ResultsPage(driver);

    @Quando("sou direcionado para tela de resultado")
    public void paginaResultadoCarregada() throws InterruptedException {
        resultsPage.waitTitleAppear();
    }

    @Entao("valido o titulo da pesquisa bem como sua descricao")
    public void validoDadosDePesuisaValida() throws InterruptedException {
        resultsPage.validateTitleAndDescriptionExist();
    }

    @Entao("valido que é retornado nenhum resultado")
    public void validoDadosDePesuisaInvalida() throws InterruptedException {
        resultsPage.validateTitleAndDescriptionNonExistent();
    }
}
