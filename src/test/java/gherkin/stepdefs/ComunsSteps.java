package gherkin.stepdefs;

import br.com.core.rest.ServiceFactory;
import br.com.core.setup.SetupManager;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Quando;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

import java.util.HashMap;

public class ComunsSteps extends SetupManager {

    public static ResponseOptions<Response> response;
    public static HashMap<String, String> parameters;

    @Dado("^que eu deseje fazer um \"([^\"]*)\" em \"([^\"]*)\"$")
    public void queEuDesejeFazerUmEm(String metodo, String uri) throws Throwable {
        serviceFactory = new ServiceFactory(uri, metodo, null);
    }

}
