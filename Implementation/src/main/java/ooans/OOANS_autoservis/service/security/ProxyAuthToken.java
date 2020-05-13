package ooans.OOANS_autoservis.service.security;
import java.util.Random;


public class ProxyAuthToken implements AuthToken {
    private RealAuthToken realAuthToken;
    boolean first_time= true;

    @Override
    public String dispatchRequest(String httpRequest) {
        if(realAuthToken == null){
            realAuthToken = new RealAuthToken();
        }
        if(checkIfTokenIsOutDated()){
            AccountAuthData.getInstance().setToken( realAuthToken.refreshToken());
        }
        System.out.println("Request zavolany s tokenom: " + AccountAuthData.getInstance().getToken());
        return realAuthToken.dispatchRequest(httpRequest);
    }
    public boolean checkIfTokenIsOutDated(){
        if (first_time){
            first_time=false;
            return false;
        }

        Random random = new Random();
        return random.nextBoolean();
    }


}
