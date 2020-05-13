package ooans.OOANS_autoservis.service.encode;

import com.fasterxml.jackson.core.JsonProcessingException;
import ooans.OOANS_autoservis.domain.Car;
import ooans.OOANS_autoservis.domain.mapper.CarBuilderDirector;
import ooans.OOANS_autoservis.service.security.AccountAuthData;


public class EncodeVinFacade {
    public final EncodeVinColorService encodeVinColorService;
    public final EncodeCarServiceHistoryService encodeCarServiceHistoryService;
    public final EncodeCarSpecsService encodeCarSpecsService;


    public EncodeVinFacade() throws JsonProcessingException {
        this.encodeVinColorService = new EncodeVinColorService();
        this.encodeCarServiceHistoryService = new EncodeCarServiceHistoryService();
        this.encodeCarSpecsService = new EncodeCarSpecsService();

    }

    public Car createEncode(String vin) throws JsonProcessingException {
        System.out.println("Ideme vytvorit auto s VIN: "+vin);
        Car c = new CarBuilderDirector(this.encodeVinColorService.callApiColor(), this.encodeCarSpecsService.callApiCarSpecs(), this.encodeCarServiceHistoryService.callApiServiceHistory()).constructCar();
        if(AccountAuthData.getInstance().getToken() != null) System.out.println(c.toString());
        return c;

    }
}
