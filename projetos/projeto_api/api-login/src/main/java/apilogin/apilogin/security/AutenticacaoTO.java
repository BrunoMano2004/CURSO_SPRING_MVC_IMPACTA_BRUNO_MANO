package apilogin.apilogin.security;

public class AutenticacaoTO {
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
