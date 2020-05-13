package ooans.OOANS_autoservis.service;

import ooans.OOANS_autoservis.dao.UserGarageDao;
import ooans.OOANS_autoservis.domain.Car;
import ooans.OOANS_autoservis.domain.UserGarage;
import ooans.OOANS_autoservis.service.security.AccountAuthData;

public class UserGarageService {

    private final UserGarageDao userGarageDao;

    public UserGarageService(){
        this.userGarageDao = new UserGarageDao();
    }

    public void createUserCar (Car c){
        this.userGarageDao.createCar(c, AccountAuthData.getInstance().getLogin());
    }

    public UserGarage findAllUserGarageCars(){

        return this.userGarageDao.findAllUserCars(AccountAuthData.getInstance().getLogin());
    }
}
