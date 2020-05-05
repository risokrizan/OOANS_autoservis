package ooans.OOANS_autoservis;

import ooans.OOANS_autoservis.domain.Car;
import ooans.OOANS_autoservis.domain.Report;
import ooans.OOANS_autoservis.domain.ReportTypeEnum;
import ooans.OOANS_autoservis.domain.UserGarage;
import ooans.OOANS_autoservis.service.encode.EncodeVinFacade;
import ooans.OOANS_autoservis.service.UserGarageService;
import ooans.OOANS_autoservis.service.factory.ReportFactory;
import ooans.OOANS_autoservis.service.security.AuthManager;
import ooans.OOANS_autoservis.workprocess.ServiceProcess;
import ooans.OOANS_autoservis.workprocess.ServiceStateOrdered;
import ooans.OOANS_autoservis.workprocess.subscriber.NotificationSubscriber;
import ooans.OOANS_autoservis.workprocess.subscriber.WorkflowSubscriber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class OoansAutoservisApplication {

	public static void main(String[] args) throws Exception {

		SpringApplication.run(OoansAutoservisApplication.class, args);
		System.out.println("1. Prihlasenie"+"\n"+"2. Pridanie vozidla do garaze" + "\n"+"3. Vyber vozidla z garaze"+"\n"+"4. Proces servisu"+"\n"+"5. Statistika pouzitych dielov" + "\n" + "6. Generovanie reportov ");
		AuthManager authManager = new AuthManager();
		EncodeVinFacade encodeVinFacade = new EncodeVinFacade();
		UserGarageService userGarageService = new UserGarageService();
		ReportFactory reportFactory = new ReportFactory();
		Car createdCar = null;
		reportFactory.initReportServices();
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
				createdCar = encodeVinFacade.createEncode(vin);
				userGarageService.createUserCar(createdCar);
				break;
			case 3:
				System.out.println("Auta v garazi zakaznika");
				UserGarage ug = userGarageService.findAllUserGarageCars();
				if(ug.isNull()){
					System.out.println("Garaz je prazdva, NullObject");
				}else{
					for (Car userCars : ug.getCars()) {
						System.out.println(userCars.toString());
					}
				}
				break;
			case 4:
				if(createdCar != null) {
					System.out.println("vytvaram objednavku na servis");
					ServiceProcess sp = new ServiceProcess();
					sp.setServiceCar(createdCar);
					sp.subscribe(new NotificationSubscriber());
					sp.subscribe(new WorkflowSubscriber());

					sp.setServiceState(new ServiceStateOrdered());
					sp.notifyServiceStateSubscribers();
				}else{
					System.out.print("Nieje vybrate auto");
				}



				break;
			case 5:
				System.out.println("Statistika pouzitych dielov");

				break;
			case 6:

				System.out.println(java.util.Arrays.asList(ReportTypeEnum.values()));
				System.out.println("Zadajte typ reportu z zoznamu");
				String reportyType = sc.next();
				reportFactory.getReportService(ReportTypeEnum.valueOf(reportyType)).generateReport(new Report(), "/report.pdf", "test");
				break;
		}

	}

}
