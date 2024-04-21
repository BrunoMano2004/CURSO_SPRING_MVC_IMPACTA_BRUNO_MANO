package apilogin.apilogin.response;

import java.util.Objects;

public class UsuarioResponse {

    private long id;

    private String nome;

    private String senha;

    private long cpf;

    private String cep;

    private String logradouro;

    private int numero;

    private String bairro;

    public UsuarioResponse() {
        super();
    }

    public UsuarioResponse(long id, String nome, String senha, long cpf, String cep, String logradouro, int numero, String bairro) {
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioResponse that = (UsuarioResponse) o;
        return id == that.id && cpf == that.cpf && cep == that.cep && numero == that.numero && Objects.equals(nome, that.nome) && Objects.equals(senha, that.senha) && Objects.equals(logradouro, that.logradouro) && Objects.equals(bairro, that.bairro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, senha, cpf, cep, logradouro, numero, bairro);
    }

    @Override
    public String toString() {
        return "LoginTO{" +
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
