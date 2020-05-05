package ooans.OOANS_autoservis.workprocess;

public class ServiceStateOrdered implements ServiceState {
    @Override
    public void handleNextServiceState(ServiceProcess sp) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Som v stave: Objednany na servis");
        sp.setServiceState(new ServiceStateCarDelivered() );
    }
}
