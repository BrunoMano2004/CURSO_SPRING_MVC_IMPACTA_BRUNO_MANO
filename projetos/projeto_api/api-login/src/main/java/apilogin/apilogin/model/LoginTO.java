package apilogin.apilogin.model;

import java.util.Objects;

public class LoginTO {

    private long cpf;

    private String senha;

    public LoginTO() {
        super();
    }

    public LoginTO(long cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
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
        LoginTO that = (LoginTO) o;
        return cpf == that.cpf && Objects.equals(senha, that.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, senha);
    }

    @Override
    public String toString() {
        return "LoginTO{" +
                "cpf=" + cpf +
                ", senha='" + senha + '\'' +
                '}';
    }
}
