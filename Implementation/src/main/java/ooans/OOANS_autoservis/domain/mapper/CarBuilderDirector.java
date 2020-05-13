package ooans.OOANS_autoservis.domain.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import ooans.OOANS_autoservis.domain.Car;

public class CarBuilderDirector {
    public final Builder builder;
    private final String colorJson;
    private final String specJson;
    private final String serviceHistoryJson;

    public CarBuilderDirector(String colorJson,String specJson, String serviceHistoryJson) throws JsonProcessingException {
       this.colorJson=colorJson;
       this.specJson=specJson;
       this.serviceHistoryJson=serviceHistoryJson;
       builder = new CarBuilder(this.specJson);
    }


    public Car constructCar() throws JsonProcessingException {

        this.builder.buildColor(colorJson);
        this.builder.buildServiceHistory(serviceHistoryJson);
        return this.builder.getCar();

    }
}
