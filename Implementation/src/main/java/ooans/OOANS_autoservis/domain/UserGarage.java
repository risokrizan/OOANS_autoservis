package ooans.OOANS_autoservis.domain;

import java.util.List;

public abstract class UserGarage {
    public List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    public abstract boolean isNull();
}
