package br.com.core.rest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class ServiceFactory {


    private RequestSpecBuilder builder = new RequestSpecBuilder();
    private String method;
    private String url;


    /**
     *ServiceFactoryV2 construtor para passar as configurações iniciais
     * @param uri
     * @param method
     * @param token
     */
    public ServiceFactory(String uri, String method, String token){
        this.url = "http://localhost:8080" + uri;
        this.method = method;
        if (token != null)
            builder.addHeader("Authorization", "Bearer " + token);
    }


    /**
     * ExecuteAPI para executar API com as operações POST/DELETE/GET
     * @return  ResponseOptions<Response>
     */

    private ResponseOptions<Response> ExecuteAPI(){
        RequestSpecification requestSpecification = builder.build();
        RequestSpecification request = RestAssured.given();
        request.contentType(ContentType.JSON);
        request.spec(requestSpecification);

        if(this.method.equalsIgnoreCase(APIConstant.ApiMethods.POST))
            return request.post(this.url);
        else if(this.method.equalsIgnoreCase(APIConstant.ApiMethods.DELETE))
            return request.delete(this.url);
        else if(this.method.equalsIgnoreCase(APIConstant.ApiMethods.GET))
            return request.get(this.url);

        return null;
    }

    /**
     * Authenticate para pegar a valor do token caso necessário
     * @param body
     * @return string token
     */
    public String Authenticate(Object body){
        builder.setBody(body);
        return ExecuteAPI().getBody().jsonPath().get("access_token");
    }


    /**
     * Executar a API com query params sendo passados
     * @param queryPath
     * @return Response
     */
    public ResponseOptions<Response> ExecuteAPIWithQueryParams(Map<String, String> queryPath) {
        builder.addQueryParams(queryPath);
        return ExecuteAPI();
    }

    /**
     * Executar a API com path params sendo passados
     * @param pathParam
     * @return Response
     */
    public ResponseOptions<Response> ExecuteAPIWithPathParams(HashMap<String, String> pathParam) {
        builder.addPathParams(pathParam);
        return ExecuteAPI();
    }

    /**
     * Executar a API com path params & body sendo passados
     * @param body
     * @param pathPar
     * @return Response
     */
    public ResponseOptions<Response> ExecuteAPIWithPathParamsAndBody(Map<String, String> body, Map<String, String> pathPar) {
        builder.setBody(body);
        builder.addPathParams(pathPar);
        return ExecuteAPI();
    }

    /**
     * Executar a API com body sendo passado
     * @param body
     * @return Response
     */
    public ResponseOptions<Response> ExecuteAPIWithBody(Object body) {
        builder.setBody(body);
        return ExecuteAPI();
    }

}

