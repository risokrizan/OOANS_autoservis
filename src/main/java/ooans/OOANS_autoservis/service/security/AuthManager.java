package ooans.OOANS_autoservis.service.security;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AuthManager {
    public AuthToken authToken;

    public AuthManager(){
        authToken = new ProxyAuthToken();
    }

    public boolean login(String login, String password){
        Map<String,String> allowed_logins = new HashMap<>();
        allowed_logins.put("admin","admin");
        allowed_logins.put("test","test");
        allowed_logins.put("ahoj","ahoj");
        String user_pass = allowed_logins.get(login);
        try{
            if (user_pass.isEmpty()){
                throw new Exception();
            }
            if(user_pass.equals(password)){
                System.out.println("Uspesne prihlaseny");
                SecurityContext.authData(1,login, Arrays.asList("rolaA","rolaB"),rndChar());
                AccountAuthData.getInstance().log();
                return true;
            }
            else{
                System.out.println("Zle heslo");
                return false;
            }
        }
        catch(Exception e){
            System.out.println("Pouzivatel nieje zregistrovany");
            return false;
        }
    }
    public void reqestGenerator(){
        Runnable helloRunnable = new Runnable() {
            public void run() {
               authToken.dispatchRequest(rndChar());
            }
        };

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(helloRunnable, 0, 15, TimeUnit.SECONDS);
    }
    public static String rndChar () {
        Random r = new Random();
        StringBuilder token = new StringBuilder();
        String alphabet = "123xyz";
        for (int i = 0; i < 20; i++) {
            token.append(alphabet.charAt(r.nextInt(alphabet.length())));
        }
        return token.toString();
    }

    public void logout(){
        SecurityContext.clear();
    }


}
