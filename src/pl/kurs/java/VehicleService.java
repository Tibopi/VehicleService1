package pl.kurs.java;


import java.util.*;


public class VehicleService {
    private Scanner scanner;
    private BankAccountService bankAccountService;
    public PersonService personService;
    private List<Vehicle> vehicles;


    //metody

    public VehicleService(Scanner scanner, PersonService personService) {
        this.scanner = scanner;
        bankAccountService = new BankAccountService(scanner);
        this.personService = personService;
        initializeVehicles();
    }


    public List<Vehicle> getVehicleList() {
        return vehicles;
    }

    public void showVehicles() {
        System.out.println("jakie pojazdy chesz zobacyc:");
        System.out.println("1.samochody");
        System.out.println("2.motory");
        System.out.println("3.ciezarowki");
        int userCh = scanner.nextInt();
        if (userCh == 1) {
            for (Vehicle cars : vehicles) {
                if (cars instanceof Car) {
                    Car vehicle = (Car) cars;
                    System.out.println(cars);
                }
            }
        }
        if (userCh == 2) {
            for (Vehicle motorcycles : vehicles) {
                if (motorcycles instanceof Motorcycle) {
                    Motorcycle vehicle = (Motorcycle) motorcycles;
                    System.out.println(motorcycles);
                }
            }
        }
        if (userCh == 3) {
            for (Vehicle trucks : vehicles) {
                if (trucks instanceof Truck) {
                    Truck vehicle = (Truck) trucks;
                    System.out.println(trucks);
                }
            }
        }
    }

    public Vehicle getVehicleByIndex(int index) {
        if (index >= 0 && index < vehicles.size()) {                //zeby szukalo na liscie carsow
            return vehicles.get(index);
        }

        System.out.println("Podano nieprawidlowy numer pojazdu.");
        return null;
    }

    private void initializeVehicles() {
        vehicles = new ArrayList<>();
        vehicles.add(new Car("BMW", "X3", 2012, 178, 315, 195000, "Dizel", 65000, "SUV"));
        vehicles.add(new Car("Audi", "A6", 2016, 250, 440, 117000, "Dizel", 112000, "Sedan"));
        vehicles.add(new Car("Mercedes", "S 63 AMG", 2018, 612, 850, 64000, "Benzyna", 470000, "Sedan"));
        vehicles.add(new Car("Fiat", "Panda", 2010, 72, 105, 256000, "Benzyna+LPG", 5500, "Hatchback"));
        vehicles.add(new Motorcycle("Suzuki", "Hayabuza", 2018, 200, 300, 14000, "Benzyna", 110000, "V4", true));
        vehicles.add(new Car("Audi", "S7", 2016, 430, 600, 47000, "Benzyna", 310000, "Sedan"));
        vehicles.add(new Car("Mercedes", "C 43 AMG", 2019, 420, 550, 35000, "Benzyna", 260000, "Sedan"));
        vehicles.add(new Truck("Scania", "R20", 2019, 520, 1500, 140000, "Dizel", 250000, 18000, true));
        vehicles.add(new Car("Jeep", "Grand Cherokee", 2015, 312, 500, 150000, "Dizel", 190000, "SUV"));
        vehicles.add(new Car("Seat", "Toledo", 2012, 2012, 200, 197000, "Benzyna", 30000, "Sedan"));
        vehicles.add(new Car("Audi", "A3", 2011, 130, 220, 211000, "Benzyna", 35000, "Hatchback"));
        vehicles.add(new Car("Skoda", "Ocatvia", 2016, 190, 350, 97000, "Dizel", 95000, "Sedan"));
        vehicles.add(new Motorcycle("Yamaha", "R1", 2017, 160, 200, 24000, "Benzyna", 60000, "R3", false));
        vehicles.add(new Car("Toyota", "Supra", 2018, 350, 500, 30000, "Benzyna", 150000, "Coupe"));
        vehicles.add(new Car("Seat", "Leon", 2020, 155, 300, 197000, "Benzyna", 150000, "Sedan"));
        vehicles.add(new Car("BMW", "640d", 2017, 390, 700, 50000, "Dizel", 290000, "Sedan"));
    }

    public void showOnlyCars() {
        for (int i = 0; i < vehicles.size(); i++) {
            Vehicle vehicle = vehicles.get(i);
            if (vehicle instanceof Car) {
                System.out.println(i + 1 + ". " + vehicle);
            }
        }
    }

    public void showOnlyMotorcycles() {
        for (int i = 0; i < vehicles.size(); i++) {
            Vehicle vehicle = vehicles.get(i);
            if (vehicle instanceof Motorcycle) {
                System.out.println(i + 1 + ". " + vehicle);
            }
        }
    }

    public void showOnlyTrucks() {
        for (int i = 0; i < vehicles.size(); i++) {
            Vehicle vehicle = vehicles.get(i);
            if (vehicle instanceof Truck) {
                System.out.println(i + 1 + ". " + vehicle);
            }
        }
    }

    public void buyAVehicle(Vehicle vehicle) {
        System.out.println("Podaj numer konta : ");
        int nrkonta = scanner.nextInt();
        BankAccount bankAccount = bankAccountService.getUserBankAccount(nrkonta);


        if (bankAccount == null) {
            System.out.println("Nie znaleziono konta o takim numerze");
            return;
        }

        if (vehicle.getPrice() <= bankAccount.getBalance()) {
            System.out.println("Masz tyle kasy ");
            bankAccount.removeBalance(vehicle.getPrice());
            personService.addPersonToList(bankAccount, vehicle);

            vehicles.remove(vehicle);

        } else {
            System.out.println("nie stac cie");
        }
    }

    public void sellACar() {
        //wprowac dane samochodu
        System.out.println("Wprowadz marke:");
        String brand = scanner.next();
        System.out.println("model");
        String model = scanner.next();
        System.out.println("rok prod.");
        int yearOfProd = scanner.nextInt();
        System.out.println("power:");
        int power = scanner.nextInt();
        System.out.println("torque:");
        int torque = scanner.nextInt();
        System.out.println("milage:");
        int milage = scanner.nextInt();
        System.out.println("petrol");
        String petrol = scanner.next();
        System.out.println("price");
        int price = scanner.nextInt();
        System.out.println("jakiego typu pojazd sprzedajesz?");
        System.out.println("1.samochod");
        System.out.println("2.motocykl");
        System.out.println("3.ciezarowka");
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println("Body type:");
            String body = scanner.next();
            vehicles.add(new Car(brand, model, yearOfProd, power, torque, milage, petrol, price, body));
        }
        if (choice == 2) {
            System.out.println("Engine type: ");
            String engineType = scanner.next();
            System.out.println("Czy jest tuningowany: ");
            boolean moded = scanner.nextBoolean();
            vehicles.add(new Motorcycle(brand, model, yearOfProd, power, torque, milage, petrol, price, engineType, moded));
        }
        if (choice == 3) {
            System.out.println("Uciag: ");
            int pull = scanner.nextInt();
            System.out.println("Posiada lozko? T/F");
            boolean withBed = scanner.nextBoolean();
            vehicles.add(new Truck(brand, model, yearOfProd, power, torque, milage, petrol, price, pull, withBed));
        }

        System.out.println("Podaj numer konta : ");
        int nrkonta = scanner.nextInt();

        BankAccount bankAccount = bankAccountService.getUserBankAccount(nrkonta);

        if (bankAccount == null) {
            System.out.println("Nie znaleziiono konta o takim numerze");
            return;
        }

        bankAccount.addBalance(price);
    }

    public List<Vehicle> getCarWithSelectedBrand(String brand, List<Vehicle> vehicleList) {
        List<Vehicle> carList = new ArrayList<>();
        for (Vehicle vehicle : vehicleList) {
            //for (Vehicle vehicle : vehicles)
            if (brand.equalsIgnoreCase(vehicle.getBrand())) { // Audi AUDI
                carList.add(vehicle);
            }
        }
        return carList;
    }

    public void modelLetterCounter() {

        int sum = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Car) {// alfra romeo -> alfaromeo
                int p = vehicle.getModel().replaceAll("\\s", "").length();
                sum += p;
            }
        }
        System.out.println("Suma znakow to: " + sum);
    }

    public void novelsInCarBrand() {
        char[] vowels = {'a', 'e', 'y', 'i', 'u', 'o'};
        int counter = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Car) {
                String ch = vehicle.getBrand().toLowerCase();
                for (int i = 0; i < vehicle.getBrand().length(); i++) {
                    if (ch.charAt(i) == 'a' || ch.charAt(i) == 'e' || ch.charAt(i) == 'i' ||
                            ch.charAt(i) == 'o' || ch.charAt(i) == 'u' || ch.charAt(i) == 'y')
                        counter++;
                }
            }
        }
        System.out.println("Liczba samoglosek w markach to: " + counter);
    }

    public void mostFrequentLetterinBrand() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Car) {
                Map<Character, Integer> count = new HashMap<>();
                char[] chars = vehicle.getBrand().toLowerCase().toCharArray();
                for (char c : chars) {
                    if (count.get(c) == null) {
                        count.put(c, 1);
                    } else {
                        count.put(c, count.get(c) + 1);
                    }
                }
                Integer sum = count.values().stream().mapToInt(d -> d).sum();
                System.out.println(count + " Ilość liter w marce: " + sum);
            }
        }
    }

    public void carTruckMotoPrcent() {
        double carCounter = 0;
        double truckCounter = 0;
        double motorcycleCounter = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Car) {
                carCounter++;
            }
            if (vehicle instanceof Truck) {
                truckCounter++;
            }
            if (vehicle instanceof Motorcycle) {
                motorcycleCounter++;
            }
        }
        double carProcentage = (carCounter / vehicles.size()) * 100;
        System.out.println("Samochody to " + carProcentage + " %");

        double truckProcentage = (truckCounter / vehicles.size()) * 100;
        System.out.println("Ciezarowki to " + truckProcentage + " %");

        double motorcycleProcentage = (motorcycleCounter / vehicles.size()) * 100;
        System.out.println("Motory to " + motorcycleProcentage + " %");
    }

    public void vehiclesPoweredByDiezel() {
        double sum = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getTypeOfPetrol().equals("Dizel"))
                sum++;
        }
        double dizelProcentage = (sum / vehicles.size()) * 100;
        System.out.println("Pojazdy na diesel to  " + dizelProcentage + "%");
    }

    public Map<String, Integer> countVehicleTypes() {
        Map<String, Integer> countVeh = new HashMap<>();
        for (Vehicle vehicle : vehicles) {
            countVeh.merge(vehicle.getType(), 1, Integer::sum);

            /*
            MERGE
            sprawdza czy klucz znajduje sie na mapie
                - jeżli tak, to wywoluje Integer::sum - czylu sumuje obecną wartość dla tego klucza z "1"
                - jeżeli nie, to dodaje ten klucz z podaną wartością "1"
             */

//            if (countVeh.containsKey(vehicle.getType())) {
//                countVeh.put(vehicle.getType(), countVeh.get(vehicle.getType() + 1));
//            } else {
//                countVeh.put(vehicle.getType(), 1);
//            }
        }

        return countVeh;
    }
}

/*

string, int, double, float, boolean, long, short, char,for, foreach, switch, while
scanner, metody
list, sety, klasy
gettery, settery
dziedziczenie

 */

