package ooans.OOANS_autoservis;

import ooans.OOANS_autoservis.service.EncodeVinFacade;
import ooans.OOANS_autoservis.service.security.AuthManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class OoansAutoservisApplication {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(OoansAutoservisApplication.class, args);
		System.out.println("1. Prihlasenie"+"\n"+"2. Pridanie vozidla do garaze" + "\n"+"3. Proces servisu"+"\n"+"4. Vyber vozidla z garaze"+"\n"+"5. Statistika pouzitych dielov" + "\n" + "6. Generovanie reportov ");
		AuthManager authManager = new AuthManager();
		EncodeVinFacade encodeVinFacade = new EncodeVinFacade();
		Scanner sc = new Scanner(System.in);

		switch(sc.nextInt()) {
			case 1:
				System.out.println("Zadaj meno");
				String log = sc.next();
				System.out.println("Zadaj heslo");
				String pass = sc.next();
				Boolean runReqGen = authManager.login(log,pass);
				if(runReqGen) authManager.reqestGenerator();
				break;
			case 2:
				System.out.println("Nacitaj VIN cislo: ");
				String vin = sc.next();
				encodeVinFacade.createEncode(vin);

				break;
		}

	}

}
