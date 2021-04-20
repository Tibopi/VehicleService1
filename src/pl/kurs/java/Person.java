package pl.kurs.java;


import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;                 // pola
    private List<Vehicle> vehicleList;

    public Person(String name) {
        this.vehicleList = new ArrayList<>();
        this.name = name;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vehicle> getCarList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }
}

