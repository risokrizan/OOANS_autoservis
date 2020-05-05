package ooans.OOANS_autoservis.workprocess.publisher;

import ooans.OOANS_autoservis.workprocess.subscriber.ServiceStateSubcriber;

import java.util.ArrayList;
import java.util.List;

public abstract class ServiceStatePublisher {

    private List<ServiceStateSubcriber> serviceStateSubcribers;

    public ServiceStatePublisher(){
        this.serviceStateSubcribers = new ArrayList<>();
    }

    public void notifyServiceStateSubscribers() {
        for (ServiceStateSubcriber sss: this.serviceStateSubcribers){
            sss.update();
        }
    }

    public void subscribe(ServiceStateSubcriber sss) {
        this.serviceStateSubcribers.add(sss);
    }
    public void unsubscribe(ServiceStateSubcriber sss){
        this.serviceStateSubcribers.remove(sss);
    }
}
