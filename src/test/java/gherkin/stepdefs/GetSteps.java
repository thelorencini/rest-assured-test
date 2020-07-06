package gherkin.stepdefs;

import br.com.core.rest.ServiceFactory;
import br.com.core.setup.SetupManager;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.junit.Assert;

import java.util.HashMap;

import static br.com.core.report.ExtentReports.appendToReport;
import static org.hamcrest.core.IsEqual.equalTo;

public class GetSteps extends SetupManager {

    public static ResponseOptions<Response> response;
    public static HashMap<String, String> parameters;

    @Então("^o status code deverá ser \"([^\"]*)\"$")
    public void oStatusCodeDeveráSer(int statusCode) throws Throwable {
        Assert.assertThat(response.statusCode(), equalTo(statusCode));
        appendToReport(response.getBody().prettyPrint());
    }

    @Quando("^eu fizer o GET com os dados$")
    public void euFizerARequestComOsDados() {
        response = serviceFactory.ExecuteAPIWithPathParams(parameters);
    }



    @E("^e eu tenha o ddd \"([^\"]*)\" e o numero \"([^\"]*)\"$")
    public void eEuTenhaODddEONumero(String ddd, String numero) throws Throwable {
        parameters = new HashMap<>();
        parameters.put("ddd", ddd);
        parameters.put("numero", numero);
    }


}
