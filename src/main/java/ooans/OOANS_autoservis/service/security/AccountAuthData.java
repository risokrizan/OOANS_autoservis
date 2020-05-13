package ooans.OOANS_autoservis.service.security;

import java.util.List;

public class AccountAuthData {
    Number id;
    String login;
    List<String> roles;
    String token;



    public static AccountAuthData getInstance() {
        if (user_instance == null)
            user_instance = new AccountAuthData();

        return user_instance;
    }

    public static void  clearInstance(){
        user_instance=null;
    }
    @Override
    public String toString() {
        return "AccountAuthData{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", roles=" + roles +
                ", token='" + token + '\'' +
                '}';
    }

    public void log() {
        System.out.println(this.toString());
    }
    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private static AccountAuthData user_instance = null;

    private AccountAuthData() {

    }
}
