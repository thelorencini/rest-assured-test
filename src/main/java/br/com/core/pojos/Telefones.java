package br.com.core.pojos;
import com.github.javafaker.Faker;
import lombok.Data;

@Data
public class Telefones {

    public Telefones(){
        long numberFake = 100000000 + (int)(Math.random() * (999999999 - 100000000));
        this.numero = Long.toString(numberFake);
        this.ddd = "16";

    }

    private String ddd;
    private String numero;
}
