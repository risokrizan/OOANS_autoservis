package ooans.OOANS_autoservis.dao;

import ooans.OOANS_autoservis.domain.*;

import java.util.*;

public class UserGarageDao {

    private Map<String, List<Car>> userGarageCars;

    public UserGarageDao(){
        userGarageCars = new HashMap<>();
        mockGarageData();

    }

    public UserGarage findAllUserCars(String user){
        UserGarage ug;
        if(userGarageCars.containsKey(user)){
            ug = createQueryUserGarageCars(userGarageCars.get(user));
        }else{
            ug = createQueryUserGarageEmpty();
        }
        return ug;
    }

    public UserGarageCars createQueryUserGarageCars(List<Car> cars){
        UserGarageCars ucg = new UserGarageCars();
        ucg.setCars(cars);
        return ucg;
    }

    public UserGarageEmpty createQueryUserGarageEmpty(){
        return new UserGarageEmpty();
    }

    public void createCar(Car c, String user){

        try {
            List<Car> userCars = userGarageCars.get(user);
            userCars.add(c);
        }
        catch (Exception e){ System.out.println("Najskor sa prihlas");}

    }

    public void mockGarageData(){
        Color c1 = new Color();
        c1.setColorCode("213213F");
        c1.setName("Antic");
        Specification s1 = new Specification();
        s1.setBrand("Audi");
        s1.setName("A5");
        Specification s2 = new Specification();
        s2.setBrand("VW");
        s2.setName("GOLF");
        userGarageCars.put("admin", Arrays.asList(new Car(c1, new ServiceHistory(), s1), new Car(c1, new ServiceHistory(), s2)));
        userGarageCars.put("test", Arrays.asList(new Car(c1, new ServiceHistory(), s1)));
    }
}
