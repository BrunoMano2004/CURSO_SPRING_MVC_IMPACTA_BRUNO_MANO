package apiaut.apiaut.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AutenticacaoTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String authorization;

    private String xcsrfToken;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public String getXcsrfToken() {
        return xcsrfToken;
    }

    public void setXcsrfToken(String xcsrfToken) {
        this.xcsrfToken = xcsrfToken;
    }
}
