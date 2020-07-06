package br.com.core.pojos;
import br.com.core.util.GeraDocumento;
import com.github.javafaker.Faker;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class Pessoas {

    public Pessoas() {
        Faker faker = new Faker();
        Random gerador = new Random();

        this.codigo = gerador.nextInt(100);
        this.nome = faker.name().fullName();
        this.enderecos = new ArrayList<Enderecos>();
        this.enderecos.add(new Enderecos());
        this.telefones = new ArrayList<Telefones>();
        this.telefones.add(new Telefones());
    }

    private long codigo;
    private String nome;
    private String cpf;
    private List<Enderecos> enderecos;
    private List<Telefones> telefones;


}
