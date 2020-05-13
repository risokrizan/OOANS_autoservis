package ooans.OOANS_autoservis.workprocess;

public class ServiceStateCarDelivered implements ServiceState {
    @Override
    public void handleNextServiceState(ServiceProcess sp) throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Som v stave: Vozidlo pristavene na servis");
        sp.setServiceState(new ServiceStateInWorking());
    }
}
