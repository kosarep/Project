import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by Grzegorz on 11.02.2017.
 */
public class NumbersNext {

    int converter () {
        try {
            Scanner reader = new Scanner(System.in);
            System.out.print("Jakie jednostki chcesz konwertować? temp(t)/nic(n): ");
            String choiseWhat = reader.next();
            if (choiseWhat.equals("n")) {
                System.out.print("w takim razie żegnam.");
                return 0;
            }
            System.out.print("C -> K (C) / K -> C (K) : ");
            String choiseHow = reader.next();
            System.out.print("Podaj wartość do zamiany: ");
            BigDecimal value = reader.nextBigDecimal();

            if(choiseWhat.equals("t") && choiseHow.equals("C")) {
                System.out.print("Wartość w K: " + value.add(BigDecimal.valueOf(273.15)));
            } else if (choiseWhat.equals("t") && choiseHow.equals("K")) {
                System.out.print("Wartość w K: " + value.subtract(BigDecimal.valueOf(273.15)));
            } else {
                System.out.print("Nie podjąłeś żadnego wyboru.");
            }
        } catch (Exception e) {
            System.out.println("Wprowadzono zły rodzaj danych!");
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public static void main (String[] args) {
        NumbersNext numbersNext = new NumbersNext();
        numbersNext.converter();
    }
}
