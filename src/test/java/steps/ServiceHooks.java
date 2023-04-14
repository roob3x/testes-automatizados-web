package steps;

import io.cucumber.java.*;
import support.Driver;
import utils.Screenshot;

import java.net.MalformedURLException;

import static constants.Url.MAIN_URL;

public class ServiceHooks {
    @Before
    public void beforeScenario(Scenario scenario) throws InterruptedException {
        Driver.getDriver().get(MAIN_URL);
    }

    @BeforeStep
    public void beforeStep() {
        Screenshot.takeScreenShot();
    }

    @After
    public void tearDown() throws InterruptedException {
        Driver.endSession();
    }

    @AfterStep
    public void afterStep() {
        Screenshot.takeScreenShot();
    }

}
