package ooans.OOANS_autoservis;

import ooans.OOANS_autoservis.domain.Car;
import ooans.OOANS_autoservis.domain.Report;
import ooans.OOANS_autoservis.domain.ReportTypeEnum;
import ooans.OOANS_autoservis.domain.UserGarage;
import ooans.OOANS_autoservis.service.encode.EncodeVinFacade;
import ooans.OOANS_autoservis.service.UserGarageService;
import ooans.OOANS_autoservis.service.factory.ReportFactory;
import ooans.OOANS_autoservis.service.security.AuthManager;
import ooans.OOANS_autoservis.service.statistics.ServiceParts;
import ooans.OOANS_autoservis.service.statistics.SparePart;
import ooans.OOANS_autoservis.workprocess.*;
import ooans.OOANS_autoservis.workprocess.subscriber.NotificationSubscriber;
import ooans.OOANS_autoservis.workprocess.subscriber.WorkflowSubscriber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class OoansAutoservisApplication {

	public static void main(String[] args) throws Exception {

		SpringApplication.run(OoansAutoservisApplication.class, args);
		AuthManager authManager = new AuthManager();
		EncodeVinFacade encodeVinFacade = new EncodeVinFacade();
		UserGarageService userGarageService = new UserGarageService();
		ReportFactory reportFactory = new ReportFactory();
		Car createdCar = null;
		reportFactory.initReportServices();
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.println("1. Prihlasenie"+"\n"+"2. Pridanie vozidla do garaze" + "\n"+"3. Vyber vozidla z garaze"+"\n"+"4. Proces servisu"+"\n"+"5. Statistika pouzitych dielov" + "\n" + "6. Generovanie reportov ");
			switch (sc.nextInt()) {
				case 1:
					System.out.println("Zadaj meno");
					String log = sc.next();
					System.out.println("Zadaj heslo");
					String pass = sc.next();
					Boolean runReqGen = authManager.login(log, pass);
					if (runReqGen) authManager.reqestGenerator();
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
					if (ug.isNull()) {
						System.out.println("Garaz je prazdva, NullObject");
					} else {
						for (Car userCars : ug.getCars()) {
							System.out.println(userCars.toString());
						}
					}
					break;
				case 4:
					if (createdCar != null) {
						System.out.println("Som v stave: Vytvorena objednavka na servis");
						ServiceProcess sp = new ServiceProcess();
						sp.setServiceCar(createdCar);
						sp.subscribe(new NotificationSubscriber());
						sp.subscribe(new WorkflowSubscriber());

						sp.setServiceState(new ServiceStateOrdered());
						while(!(sp.getServiceState() instanceof ServiceStateCarTaken)) {
							sp.getServiceState().handleNextServiceState(sp);
						}
					} else {
						System.out.println("Nieje vybrate auto");
					}


					break;
				case 5:
					if (createdCar != null) {
					ServiceParts chassis = new ServiceParts();
					ServiceParts brakes = new ServiceParts();
					ServiceParts engine = new ServiceParts();
					ServiceParts suspension = new ServiceParts();
					ServiceParts oils = new ServiceParts();
					ServiceParts spark_plugs = new ServiceParts();
					ServiceParts brake_discs = new ServiceParts();

					chassis.add2Service(engine);
					chassis.add2Service(suspension);
					chassis.add2Service(engine);
					chassis.add2Service(brakes);
					engine.add2Service(oils);
					engine.add2Service(spark_plugs);
					brakes.add2Service(brake_discs);

					SparePart kotucpredny = new SparePart("kotucpredny", 50,"1.1.2020");
					SparePart kotucpzadny = new SparePart("kotuczadny",25,"1.1.2020");
					SparePart sviecky = new SparePart("sviecky",100,"25.2.2020");
					SparePart motulOlej = new SparePart("olej",24,"1.5.2020");
					SparePart filter = new SparePart("filter",14,"1.5.2020");
					SparePart tlmice = new SparePart("tlmice",200,"3.4.2020");

					brakes.add2Service(kotucpredny);
					brakes.add2Service(kotucpzadny);
					spark_plugs.add2Service(sviecky);
					oils.add2Service(motulOlej);
					oils.add2Service(filter);
					suspension.add2Service(tlmice);


					System.out.println("[ENGINE,SUSPENSION,CHASIS,BRAKES,OILS,SPARK_PLUGS]");

						switch(sc.next()) {
							case "ENGINE":
								engine.printPrice();
								break;
							case "SUSPENSION":
								suspension.printPrice();
								break;
							case "CHASIS":
								chassis.printPrice();
								break;
							case "BRAKES":
								brakes.printPrice();
								break;
							case "OILS":
								oils.printPrice();
								break;
							case "SPARK_PLUGS":
								spark_plugs.printPrice();
								break;
						}
					System.out.println("Statistika pouzitych dielov");
					} else {
						System.out.println("Nieje vybrate auto");
					}


					break;
				case 6:
					try {
						System.out.println(java.util.Arrays.asList(ReportTypeEnum.values()));
						System.out.println("Zadajte typ reportu z zoznamu");
						String reportyType = sc.next();
						reportFactory.getReportService(ReportTypeEnum.valueOf(reportyType)).generateReport(new Report(), "/report.pdf", "test");
					}
					catch(Exception e){System.out.println("Vybrany neznamy report");}
					break;
			}
		}

	}



}
