package ooans.OOANS_autoservis.workprocess;

public class ServiceStateInWorking implements ServiceState{
    @Override
    public void handleNextServiceState(ServiceProcess sp) throws InterruptedException {
        Thread.sleep(8000);
        System.out.println("Som v stave: Oprava sa vykonava");
        sp.setServiceState(new ServiceStateDone());
    }
}
