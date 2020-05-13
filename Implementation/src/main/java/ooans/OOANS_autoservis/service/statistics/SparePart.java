package ooans.OOANS_autoservis.service.statistics;

public class SparePart implements SparePartPrice{
    public Number price;
    public String name;
    public String date;


    public SparePart(String name, Number p, String d){
        this.name=name;
        this.price=p;
        this.date=d;
    }

    @Override
    public void printPrice() {
        System.out.println("Nahradny diel: "+this.name+ " Cena: " + this.price+ " Datum: "+ this.date );
    }
}
