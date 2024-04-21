package apibancodados.apibancodados.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table(name = "tb_usuario")
public class UsuarioTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private long id;

    @Column(name = "nome_usuario")
    private String nome;

    @Column(name = "senha_usuario")
    private String senha;

    @Column(name = "cpf_usuario")
    private long cpf;

    @Column(name = "cep_usuario")
    private String cep;

    @Column(name = "logradouro_usuario")
    private String logradouro;

    @Column(name = "numero_usuario")
    private int numero;

    @Column(name = "bairro_usuario")
    private String bairro;

    public UsuarioTO() {
        super();
    }

    public UsuarioTO(long id, String nome, String senha, long cpf, String cep, String logradouro, int numero, String bairro) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioTO usuario = (UsuarioTO) o;
        return id == usuario.id && cpf == usuario.cpf && cep == usuario.cep && numero == usuario.numero && Objects.equals(nome, usuario.nome) && Objects.equals(senha, usuario.senha) && Objects.equals(logradouro, usuario.logradouro) && Objects.equals(bairro, usuario.bairro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, senha, cpf, cep, logradouro, numero, bairro);
    }

    @Override
    public String toString() {
        return "UsuarioTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", cpf=" + cpf +
                ", cep=" + cep +
                ", logradouro='" + logradouro + '\'' +
                ", numero=" + numero +
                ", bairro='" + bairro + '\'' +
                '}';
    }
}
