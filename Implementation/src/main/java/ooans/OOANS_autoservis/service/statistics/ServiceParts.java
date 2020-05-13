package ooans.OOANS_autoservis.service.statistics;

import java.util.ArrayList;
import java.util.List;

public class ServiceParts implements SparePartPrice {
    private List<SparePartPrice> partsList = new ArrayList<SparePartPrice>();

    @Override
    public void printPrice() {
        for(SparePartPrice sp:partsList)
        {
            sp.printPrice();
        }
    }
    public void add2Service(SparePartPrice sp)
    {
        partsList.add(sp);
    }

    public void removeFromService(SparePartPrice sp)
    {
        partsList.remove(sp);
    }
}
