package gherkin.hooks;
import br.com.core.report.ExtentReports;
import br.com.core.rest.ServiceFactory;
import br.com.core.setup.SetupManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends SetupManager {
    private ExtentReports reports = new ExtentReports();

    @Before
    public void before(Scenario scenario) {
        testScenario = scenario;
        serviceFactory = new ServiceFactory("", "", "");
        reports.setCucumberLanguage();
    }

    @After
    public void after() {
    }
}
