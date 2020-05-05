package ooans.OOANS_autoservis.domain;

public class Color {
    String colorCode;
    String name;

    @Override
    public String toString() {
        return "Color{" +
                "colorCode=" + colorCode +
                ", name='" + name + '\'' +
                '}';
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
