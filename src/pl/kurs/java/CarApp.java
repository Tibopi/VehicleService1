package pl.kurs.java;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarApp {
    private Scanner scanner;
    private VehicleService vehicleService;
    private PersonService personService;

    public CarApp() {
        scanner = new Scanner(System.in);
        personService = new PersonService(scanner);
        vehicleService = new VehicleService(scanner, personService);
    }

    public void start() {
        showMenu();
        // pobierz od uzytkowmnika liczbe
        int userChoice = scanner.nextInt();
        if (userChoice != 0) {
            doOperation(userChoice);
            System.out.println();
            start();
        }
    }

    private void doOperation(int userChoice) {
        switch (userChoice) {
            case 1:
                vehicleService.showVehicles();
                break;
            case 2:
                buyAVehicle();
                //  <------ czy tak mozna zwinac
                break;
            case 3:
                vehicleService.sellACar();
                break;
            case 4:
                serchABrand();
                break;
            case 5:
                serchPower();
                break;
            case 6:
                serchMileage();
                break;
            case 7:
                personService.showPeople();
                break;
            case 8:
                vehicleService.modelLetterCounter();
                break;
            case 9:
                vehicleService.novelsInCarBrand();
                break;
            case 10:
                vehicleService.carTruckMotoPrcent();
                break;
            case 11:
                vehicleService.vehiclesPoweredByDiezel();
            case 12:
                vehicleService.mostFrequentLetterinBrand();
        }
    }



    private void buyAVehicle() {
        System.out.println("Co chcesz kupic?");
        System.out.println("1.Samochod");
        System.out.println("2.Motocykl");
        System.out.println("3.Ciezarowka");
        int choice = scanner.nextInt();
        if (choice == 1) {
            vehicleService.showOnlyCars();
        }
        if (choice == 2) {
            vehicleService.showOnlyMotorcycles();
        }
        if (choice == 3) {
            vehicleService.showOnlyTrucks();
        }
        System.out.println("Wybierz pojazd ktory chcesz kupic:");
        int num = scanner.nextInt();
        Vehicle selectedVehicle = vehicleService.getVehicleByIndex(num - 1);
        if (selectedVehicle != null) {
            vehicleService.buyAVehicle(selectedVehicle);
        }
    }

    private List<Vehicle> filterTypesByUserChoice(int userChoice1) {
        switch (userChoice1) {
            case 1:
                //jezeli wybierzed car to:
                return vehicleService.getVehicleList().stream()
                        .filter(Car.class::isInstance)
                        .collect(Collectors.toList());

            case 2:
                return vehicleService.getVehicleList().stream()
                        .filter(Motorcycle.class::isInstance)
                        .collect(Collectors.toList());

            case 3:
                return vehicleService.getVehicleList().stream()
                        .filter(Truck.class::isInstance)
                        .collect(Collectors.toList());

            case 4:
                return vehicleService.getVehicleList();
        }

        return vehicleService.getVehicleList();
    }

    private void showVehiclesByRangeByUserChoiceMilage(int userChoice, List<Vehicle> vehicleList) {
        switch (userChoice) {
            case 1:
                vehicleList.stream()
                        .filter(car -> car.getMileage() < 50000)
                        .forEach(System.out::println);
                break;
            case 2:
                vehicleList.stream()
                        .filter(car -> car.getMileage() > 50000)
                        .filter(car -> car.getMileage() < 100000)
                        .forEach(System.out::println);
                break;
            case 3:
                vehicleList.stream()
                        .filter(car -> car.getMileage() > 100000)
                        .filter(car -> car.getMileage() < 150000)
                        .forEach(System.out::println);
                break;
            case 4:
                vehicleList.stream()
                        .filter(car -> car.getMileage() > 150000)
                        .filter(car -> car.getMileage() < 200000)
                        .forEach(System.out::println);
                break;
            case 5:
                vehicleList.stream()
                        .filter(car -> car.getMileage() > 200000)
                        .filter(car -> car.getMileage() < 250000)
                        .forEach(System.out::println);
                break;
            case 6:
                vehicleList.stream()
                        .filter(car -> car.getMileage() > 250000)
                        .filter(car -> car.getMileage() < 300000)
                        .forEach(System.out::println);
                break;
            case 7:
                vehicleList.stream()
                        .filter(car -> car.getMileage() > 300000)
                        .forEach(System.out::println);
                break;
            case 8:
                int userChoice3 = scanner.nextInt();
                int userChoice4 = scanner.nextInt();
                vehicleList.stream()
                        .filter(car -> car.getMileage() > userChoice3)
                        .filter(car -> car.getMileage() < userChoice4)
                        .forEach(System.out::println);
                break;
            case 9:
                vehicleList.sort(Comparator.comparingInt(Vehicle::getMileage));
                System.out.println(vehicleList);
                break;
            case 10:
                vehicleList.sort(Comparator.comparingInt(Vehicle::getMileage));
                Collections.reverse(vehicleList);
                System.out.println(vehicleList);
                break;
        }
    }

    private void showVehiclesByRangeByUserChoicePowerHp(int userChoice, List<Vehicle> vehicleList) {
        switch (userChoice) {
            case 1:
                vehicleList.stream()
                        .filter(selectedVehicle -> selectedVehicle.getPowerHp() < 100)
                        .forEach(System.out::println);
                break;
            case 2:
                vehicleList.stream()
                        .filter(car -> car.getPowerHp() > 100)
                        .filter(car -> car.getPowerHp() < 200)
                        .forEach(System.out::println);
                break;
            case 3:
                vehicleList.stream()
                        .filter(car -> car.getPowerHp() > 200)
                        .filter(car -> car.getPowerHp() < 300)
                        .forEach(System.out::println);
                break;
            case 4:
                vehicleList.stream()
                        .filter(car -> car.getPowerHp() > 300)
                        .filter(car -> car.getPowerHp() < 400)
                        .forEach(System.out::println);
                break;
            case 5:
                vehicleList.stream()
                        .filter(car -> car.getPowerHp() > 400)
                        .filter(car -> car.getPowerHp() < 500)
                        .forEach(System.out::println);
                break;
            case 6:
                vehicleList.stream()
                        .filter(car -> car.getPowerHp() > 500)
                        .filter(car -> car.getPowerHp() < 600)
                        .forEach(System.out::println);
                break;
            case 7:
                vehicleList.stream()
                        .filter(car -> car.getPowerHp() > 600)
                        .filter(car -> car.getPowerHp() < 700)
                        .forEach(System.out::println);
                break;
            case 8:
                vehicleList.stream()
                        .filter(car -> car.getPowerHp() > 700)
                        .filter(car -> car.getPowerHp() < 800)
                        .forEach(System.out::println);
                break;
            case 9:
                vehicleList.stream()
                        .filter(car -> car.getPowerHp() > 800)
                        .forEach(System.out::println);
                break;
            case 10:
                int userChoice2 = scanner.nextInt();
                vehicleList.stream()
                        .filter(car -> car.getPowerHp() < userChoice2)
                        .forEach(System.out::println);
                break;
            case 11:
                int userChoice3 = scanner.nextInt();
                int userChoice4 = scanner.nextInt();
                vehicleList.stream()
                        .filter(car -> car.getPowerHp() > userChoice3)
                        .filter(car -> car.getPowerHp() < userChoice4)
                        .forEach(System.out::println);
                break;
        }
    }

    private void serchMileage() {
        System.out.println("Wybierz jakiego pojazdu szukasz?");
        System.out.println("1.samochody");
        System.out.println("2.motory");
        System.out.println("3.ciezarowki");
        System.out.println("4.wszytko");
        int userChoice1 = scanner.nextInt();
        showMilageRange();
        List<Vehicle> vehicleList = filterTypesByUserChoice(userChoice1);
        int userChoice = scanner.nextInt();
        showVehiclesByRangeByUserChoiceMilage(userChoice, vehicleList);

    }

    private void serchPower() {
        System.out.println("Wybierz jakiego pojazdu szukasz?");
        System.out.println("1.samochody");
        System.out.println("2.motory");
        System.out.println("3.ciezarowki");
        System.out.println("4.wszytko");
        int userChoice1 = scanner.nextInt();
        showPowerRanges();
        List<Vehicle> vehicleList = filterTypesByUserChoice(userChoice1);

        int userChoice = scanner.nextInt();

        showVehiclesByRangeByUserChoicePowerHp(userChoice, vehicleList);
    }

    private void serchABrand() {
        System.out.println("Jakiego pojazdu szukasz?");
        System.out.println("1.Samochod");
        System.out.println("2.Motocykl");
        System.out.println("3.Ciezarowka");
        int userChoice1 = scanner.nextInt();
        List<Vehicle> vehicleList = filterTypesByUserChoice(userChoice1);
        System.out.println("Jakiej marki szukasz:");
        String userBrand = scanner.next();
        List<Vehicle> carWithSelectedBrand = vehicleService.getCarWithSelectedBrand(userBrand, vehicleList);
        if (carWithSelectedBrand.isEmpty()) {
            System.out.println("nie znaleziono zadnych modeli tego procucenta");
            return;
        }

        System.out.println(carWithSelectedBrand);
    }

    private void showMilageRange() {
        System.out.println("1. Przebieg 0 km - 50,000 km");
        System.out.println("2. Przebieg 50,000 km - 100,000 km ");
        System.out.println("3. Przebieg 100,000 km - 150,000 km ");
        System.out.println("4. Przebieg 150,000 km - 200,000 km");
        System.out.println("5. Przebieg 200,000 km - 250,000 km");
        System.out.println("6. Przebieg 250,000 km - 300,000 km");
        System.out.println("7. Przebieg ponad 300,000 km");
        System.out.println("8. Podaj przebieg od do: ");
        System.out.println("9.Przebieg rosnąco.");
        System.out.println("10.Przebieg malejąco.");
    }

    private void showPowerRanges() {
        System.out.println("Jakiego samochodu szukasz, wybierz z przedzialu albo sam podaj moc: ");
        System.out.println("1. Pojazdy do 100 HP");
        System.out.println("2. Pojazdy od 100HP do 200 HP");
        System.out.println("3. Pojazdy od 200HP do 300 HP");
        System.out.println("4. Pojazdy od 300HP do 400 HP");
        System.out.println("5. Pojazdy od 400HP do 500 HP");
        System.out.println("6. Pojazdy od 500HP do 600 HP");
        System.out.println("7. Pojazdy od 600HP do 700 HP");
        System.out.println("8. Pojazdy od 700HP do 800 HP");
        System.out.println("9. Pojazdy ponad 800HP");
        System.out.println("10. Moc do: ");
        System.out.println("11. Podaj zakres mocy od do:");
    }

    private void showMenu() {
        System.out.println("1. Wyświetl pojazdy");
        System.out.println("2. Kup pojazd");
        System.out.println("3. Sprzedaj pojazd");
        System.out.println("4. Znajdz samochody wybranje marki");
        System.out.println("5. Znajdz pojazd z moca powwyzej X KM");
        System.out.println("6. Znajdz pojazdy z przebiegiem w zakresie X - Y");
        System.out.println("7. Lista osób, ktore kupily.");
        System.out.println("8. Liczba liter w  markach.");
        System.out.println("9. Liczba samoglosek w markach ");
        System.out.println("10. % samochodow motorow ciezarowek na liscie");
        System.out.println("11. % Pojazdy na dizel");
        System.out.println("12. Najczestrza litera.");
        System.out.println("0. EXIT");
    }
}



