package code9.project.authservice.security;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
