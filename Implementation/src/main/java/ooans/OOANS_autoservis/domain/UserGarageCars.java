package ooans.OOANS_autoservis.domain;

import java.util.ArrayList;
import java.util.List;

public class UserGarageCars extends  UserGarage {

    public UserGarageCars(){
    }

    @Override
    public boolean isNull() {
        return false;
    }

    public void setCars(List<Car> cars){
        super.cars = cars;
    }
}
