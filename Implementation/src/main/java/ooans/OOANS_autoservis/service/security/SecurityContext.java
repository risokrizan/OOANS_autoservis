package ooans.OOANS_autoservis.service.security;

import java.util.List;

public class SecurityContext {



    public static void authData(Number id, String login, List<String> roles, String token){
       AccountAuthData userData = AccountAuthData.getInstance();
       userData.setId(id);
       userData.setLogin(login);
       userData.setRoles(roles);
       userData.setToken(token);
    }
    public static void clear(){
        AccountAuthData.clearInstance();
    }
}
