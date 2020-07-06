package br.com.core.pojos;
import com.github.javafaker.Faker;
import lombok.Data;

import java.util.List;

@Data
public class Enderecos {

    public Enderecos(){
        Faker faker = new Faker();
        this.logradouro = faker.animal().name();
        this.numero = Long.parseLong(faker.address().buildingNumber());
        this.complemento = "N/A";
        this.bairro = "TESTE API RESTFULL";
        this.cidade = faker.address().city();
        this.estado = "SP";
    }

    private String logradouro;
    private long numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
}
