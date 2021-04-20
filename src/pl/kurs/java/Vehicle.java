package pl.kurs.java;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Vehicle {
    private String brand;
    private String model;
    private int yearOfProduction;
    private int powerHp;
    private int torque;
    private int mileage;
    private String typeOfPetrol;
    private int price;

    public Vehicle(String brand, String model, int yearOfProduction, int powerHp, int torque, int mileage, String typeOfPetrol, int price) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.powerHp = powerHp;
        this.torque = torque;
        this.mileage = mileage;
        this.typeOfPetrol = typeOfPetrol;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", powerHp=" + powerHp +
                ", torque=" + torque +
                ", mileage=" + mileage +
                ", typeOfPetrol='" + typeOfPetrol + '\'' +
                ", price=" + price +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public int getPowerHp() {
        return powerHp;
    }

    public void setPowerHp(int powerHp) {
        this.powerHp = powerHp;
    }

    public int getTorque() {
        return torque;
    }

    public void setTorque(int torque) {
        this.torque = torque;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getTypeOfPetrol() {
        return typeOfPetrol;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType(){
        return "dupa";
    }
}