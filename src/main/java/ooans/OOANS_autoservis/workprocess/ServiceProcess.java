package ooans.OOANS_autoservis.workprocess;

import ooans.OOANS_autoservis.domain.Car;
import ooans.OOANS_autoservis.workprocess.publisher.ServiceStatePublisher;

public class ServiceProcess extends ServiceStatePublisher {

    public ServiceState serviceState;

    public Car serviceCar;

    public Car getServiceCar() {
        return serviceCar;
    }

    public void setServiceCar(Car serviceCar) {
        this.serviceCar = serviceCar;
    }

    public void setServiceState(ServiceState serviceState) {
        this.serviceState = serviceState;
        this.notifyServiceStateSubscribers();
    }

    public ServiceState getServiceState() {
        return serviceState;
    }



}
