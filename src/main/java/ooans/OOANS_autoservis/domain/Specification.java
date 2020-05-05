package ooans.OOANS_autoservis.domain;

public class Specification {
    String engineCode;
    String power;
    String chassisType;
    String manufactureYear;
    String brand;
    String name;

    @Override
    public  String toString() {
        return "Specification{" +
                "engineCode='" + engineCode + '\'' +
                ", power='" + power + '\'' +
                ", chassisType='" + chassisType + '\'' +
                ", manufactureYear='" + manufactureYear + '\'' +
                ", brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getEngineCode() {
        return engineCode;
    }

    public void setEngineCode(String engineCode) {
        this.engineCode = engineCode;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getChassisType() {
        return chassisType;
    }

    public void setChassisType(String chassisType) {
        this.chassisType = chassisType;
    }

    public String getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(String manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
