package pl.kurs.java;

public class Motorcycle extends Vehicle {
    private String engineType;
    private boolean moded;

    public Motorcycle(String brand, String model, int yearOfProduction, int powerHp, int torque, int mileage, String typeOfPetrol, int price, String engineType, boolean moded) {
        super(brand, model, yearOfProduction, powerHp, torque, mileage, typeOfPetrol, price);
        this.engineType = engineType;
        this.moded = moded;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "engineType='" + engineType + '\'' +
                ", moded=" + moded +
                '}' + " " + super.toString();
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public boolean isModed() {
        return moded;
    }

    public void setModed(boolean moded) {
        this.moded = moded;
    }
    @Override
    public String getType() {
        return "Motorcycle";
    }
    }
