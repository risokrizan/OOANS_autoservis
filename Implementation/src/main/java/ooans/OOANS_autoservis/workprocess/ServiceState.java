package ooans.OOANS_autoservis.workprocess;

public interface ServiceState {
    void handleNextServiceState(ServiceProcess sp) throws InterruptedException;
}
