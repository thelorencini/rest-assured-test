package gherkin.stepdefs;

import br.com.core.americanas.*;
import br.com.core.report.ExtentReports;
import br.com.core.setup.DriverManager;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class CompraSteps extends DriverManager {

    private TelaBusca tela_busca;
    private TelaProduto tela_produto;
    private TelaGarantia tela_garantia;
    private TelaCesta tela_cesta;
    private TelaInicial tela_inicial;

    public CompraSteps() {
        tela_busca = new TelaBusca(driver);
        tela_produto = new TelaProduto(driver);
        tela_garantia = new TelaGarantia(driver);
        tela_cesta = new TelaCesta(driver);
        tela_inicial = new TelaInicial(driver);
    }

    @Dado("^que eu busco pelo produto \"([^\"]*)\"$")
    public void queEuBuscoPeloProduto(String produto) throws Throwable {
        tela_inicial.buscarProduto(produto);

    }

    @E("^seleciono o primeiro retorno$")
    public void selecionoOPrimeiroRetorno() {
        tela_busca.selecionaProduto();
    }

    @Quando("^eu clicar em comprar$")
    public void euClicarEmComprar() {
        tela_produto.clicarComprar();
        tela_garantia.clicarContinuar();
    }

    @E("^incluir mais um produto na cesta$")
    public void incluirMaisUmProdutoNaCesta() {
        tela_cesta.incluirItemCesta();
    }

    @Entao("^devo visualizar a opção de parcelamento em \"([^\"]*)\"$")
    public void devoVisualizarAOpçãoDeParcelamentoEm(String parcelas) throws Throwable {
        tela_cesta.validarParcelamento(parcelas);
    }

    @E("^que o valor total de produtos é inferior a \"([^\"]*)\"$")
    public void queOValorTotalDeProdutosÉInferiorA(String valorTotal) throws Throwable {
        tela_cesta.validarValorTotal(valorTotal);
    }

}
