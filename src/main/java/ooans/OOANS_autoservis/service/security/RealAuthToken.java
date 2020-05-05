package ooans.OOANS_autoservis.service.security;

public class RealAuthToken implements AuthToken{



    @Override
    public String dispatchRequest(String httpRequest) {
        System.out.println("Odosielam request: body:{" + httpRequest+"}");
        return "response";
    }

    public String refreshToken(){
        System.out.println("Obnovuje sa token");
        return AuthManager.rndChar();
    }

}
