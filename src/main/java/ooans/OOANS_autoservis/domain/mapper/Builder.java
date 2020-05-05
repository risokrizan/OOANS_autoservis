package ooans.OOANS_autoservis.domain.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import ooans.OOANS_autoservis.domain.Car;
import ooans.OOANS_autoservis.domain.Specification;

public interface Builder {
    void buildColor(String JSON) throws JsonProcessingException;
    void buildServiceHistory(String JSON) throws JsonProcessingException;
    Car getCar();
}
