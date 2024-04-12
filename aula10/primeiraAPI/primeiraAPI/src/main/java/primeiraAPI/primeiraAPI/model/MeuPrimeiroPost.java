package primeiraAPI.primeiraAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MeuPrimeiroPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String meuTexto;

    public String getMeuTexto() {
        return meuTexto;
    }

    public void setMeuTexto(String meuTexto) {
        this.meuTexto = meuTexto;
    }
}
