package ooans.OOANS_autoservis.workprocess;

public class ServiceStateDone implements ServiceState{
    @Override
    public void handleNextServiceState(ServiceProcess sp) throws InterruptedException {
        Thread.sleep(500);
        System.out.println("Som v stave: Oprava ukoncena");
        sp.setServiceState(new ServiceStateCarTaken());

    }
}
