package pl.kurs.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonService {
    private Scanner scanner;
    private List<Person> persons;



    public PersonService(Scanner scanner) {
        this.scanner = scanner;
        persons = new ArrayList<>();
    }

    public void addPersonToList(BankAccount bankAccount, Vehicle vehicle) {
        for (Person person : persons) {
            if (person.getName().equals(bankAccount.getOwner())) {
                person.addVehicle(vehicle);
                return;
            }
        }

        Person person1 = new Person(bankAccount.getOwner());
        person1.addVehicle(vehicle);

        persons.add(person1);
    }

    public void showPeople() {
        for (Person person : persons) {
            System.out.println("Kto kupił: " + person.getName() + " Kupione auta: " + person.getCarList());
        }
    }
}
