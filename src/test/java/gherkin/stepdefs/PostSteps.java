package gherkin.stepdefs;

import br.com.core.pojos.Pessoas;
import br.com.core.pojos.Telefones;
import br.com.core.rest.ServiceFactory;
import br.com.core.setup.SetupManager;
import br.com.core.util.GeraDocumento;
import com.google.gson.Gson;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Quando;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PostSteps extends SetupManager {

    public static ResponseOptions<Response> response;
    public static HashMap<String, String> parameters;
    public static Pessoas pessoa = new Pessoas();
    public static Telefones telefones = new Telefones();
    public static List<Telefones> listaTelefones = new ArrayList<Telefones>();



    @E("^eu tenha o código \"([^\"]*)\" e o cpf \"([^\"]*)\"$")
    public void euTenhaOCódigoEOCpf(int codigo, String cpf) throws Throwable {
        Gson gson = new Gson();
        pessoa.setCodigo(codigo);
        pessoa.setCpf(cpf);
        String json = gson.toJson(pessoa);
    }

    @E("^eu tenha o ddd \"([^\"]*)\" o numero \"([^\"]*)\"$")
    public void euTenhaODddONumero(String ddd, String numero) throws Throwable {
        Gson gson = new Gson();
        GeraDocumento documento = new GeraDocumento();
        pessoa.setCpf(documento.geraCPF());
        telefones.setDdd(ddd);
        telefones.setNumero(numero);
        listaTelefones.add(telefones);
        pessoa.setTelefones(listaTelefones);
        String json = gson.toJson(pessoa);
    }

    @Quando("^eu realizar o POST$")
    public void euRealizarOPOST() {
        response = serviceFactory.ExecuteAPIWithBody(pessoa);
    }
}

