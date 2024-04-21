package apilogin.apilogin.request;

import java.util.Objects;

public class SenhaRequestDecrypt {

    private String senhaRequestDecrypt;

    public SenhaRequestDecrypt() {
        super();
    }

    public SenhaRequestDecrypt(String senhaRequestDecrypt) {
        this.senhaRequestDecrypt = senhaRequestDecrypt;
    }

    public String getSenhaRequestDecrypt() {
        return senhaRequestDecrypt;
    }

    public void setSenhaRequestDecrypt(String senhaRequestDecrypt) {
        this.senhaRequestDecrypt = senhaRequestDecrypt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SenhaRequestDecrypt that = (SenhaRequestDecrypt) o;
        return Objects.equals(senhaRequestDecrypt, that.senhaRequestDecrypt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senhaRequestDecrypt);
    }

    @Override
    public String toString() {
        return "SenhaRequestDecrypt{" +
                "senhaRequestDecrypt='" + senhaRequestDecrypt + '\'' +
                '}';
    }
}
