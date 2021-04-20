package pl.kurs.java;
import java.util.Comparator;
public class CarComparatorMilage implements Comparator<Car> {
        @Override
        public int compare (Car o1, Car o2) {

            return Integer.compare( o1.getMileage(), o2.getMileage());

    }







}
