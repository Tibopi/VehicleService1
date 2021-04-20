package pl.kurs.java;


public class Car extends Vehicle {
    private String body;

    //konstruktor obiektu car
    public Car(String brand, String model, int yearOfProduction, int powerHp, int torque, int mileage, String typeOfPetrol, int price, String body) {
        super(brand, model, yearOfProduction, powerHp, torque, mileage, typeOfPetrol, price);
        this.body = body;

    }

    @Override
    public String toString() {
        return "Car{" +
                "body='" + body + '\'' +
                '}' + " " + super.toString();
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String getType() {
        return "Car";
    }
}










