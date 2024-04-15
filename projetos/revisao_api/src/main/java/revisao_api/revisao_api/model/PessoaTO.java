package revisao_api.revisao_api.model;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Objects;

@Entity
@Table(name="tb_pessoa")
@EntityListeners(AuditingEntityListener.class)
public class PessoaTO {

    @Id
    @Column(name="pessoa_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="pessoa_nome")
    private String nome;

    @Column(name="pessoa_email")
    private String email;

    @Column(name="pessoa_cpf")
    private String cpf;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaTO pessoaTO = (PessoaTO) o;
        return id == pessoaTO.id && Objects.equals(nome, pessoaTO.nome) && Objects.equals(email, pessoaTO.email) && Objects.equals(cpf, pessoaTO.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, cpf);
    }

    @Override
    public String toString() {
        return "PessoaTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
