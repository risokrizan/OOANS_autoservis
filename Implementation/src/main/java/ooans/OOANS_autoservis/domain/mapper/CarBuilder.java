package ooans.OOANS_autoservis.domain.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ooans.OOANS_autoservis.domain.Car;
import ooans.OOANS_autoservis.domain.Color;
import ooans.OOANS_autoservis.domain.ServiceHistory;
import ooans.OOANS_autoservis.domain.Specification;

public class CarBuilder implements Builder {
    ObjectMapper om = new ObjectMapper();
    private Color c;  //optional
    private ServiceHistory sh; //optional
    private final Specification spec; //required

    public CarBuilder(String specJSON) throws JsonProcessingException {
        this.spec=this.buildSpecification(specJSON);
    }


    @Override
    public void buildColor(String JSON) throws JsonProcessingException {
        this.c = om.readValue(JSON, Color.class);
    }

    @Override
    public void buildServiceHistory(String JSON) throws JsonProcessingException {
        this.sh = om.readValue(JSON,ServiceHistory.class);
    }


    private Specification buildSpecification(String JSON) throws JsonProcessingException {
        return om.readValue(JSON,Specification.class);
    }

    public Car getCar(){
        return new Car(c,sh,spec);
    }
}
