package pl.kurs.java;


public class Truck extends Vehicle {
    private int pull;
    private boolean withBed;

    public Truck(String brand, String model, int yearOfProduction, int powerHp, int torque, int mileage, String typeOfPetrol, int price, int pull, boolean withBed) {
        super(brand, model, yearOfProduction, powerHp, torque, mileage, typeOfPetrol, price);
        this.pull = pull;
        this.withBed = withBed;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "pull=" + pull +
                ", withBed=" + withBed +
                '}' + " " + super.toString();
    }

    public int getPull() {
        return pull;
    }

    public void setPull(int pull) {
        this.pull = pull;
    }

    public boolean isWithBed() {
        return withBed;
    }

    public void setWithBed(boolean withBed) {
        this.withBed = withBed;
    }
    @Override
    public String getType() {
        return "Truck";
    }
}
