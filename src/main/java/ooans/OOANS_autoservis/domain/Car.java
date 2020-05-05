package ooans.OOANS_autoservis.domain;

import java.util.List;

public class Car {
    Color color;
    Specification specification;
    ServiceHistory serviceHistory;

    public Car(Color c, ServiceHistory sh, Specification spec) {
        this.color=c;
        this.specification=spec;
        this.serviceHistory=sh;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color=" + color.toString() +
                ", specification=" + specification.toString() +
                ", serviceHistory=" + serviceHistory.toString() +
                '}';
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    public ServiceHistory getServiceHistory() {
        return serviceHistory;
    }

    public void setServiceHistory(ServiceHistory serviceHistory) {
        this.serviceHistory = serviceHistory;
    }


}
