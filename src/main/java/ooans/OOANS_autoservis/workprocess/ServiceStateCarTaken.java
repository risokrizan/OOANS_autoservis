package ooans.OOANS_autoservis.workprocess;

public class ServiceStateCarTaken implements ServiceState{


    @Override
    public void handleNextServiceState(ServiceProcess sp) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Som v stave: Vozidlo odovzdane");
    }
}
