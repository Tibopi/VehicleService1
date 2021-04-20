package pl.kurs.java;


import java.util.Comparator;

public class CarComparatorPower implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        int wynik = Integer.compare( o1.getPowerHp(), o2.getPowerHp());
        return -1 * wynik;
    }


}

