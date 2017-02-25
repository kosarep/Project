import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Grzegorz on 06.02.2017.
 */
public class Numbers6 {

    void tilesCost () {
        Scanner reader = new Scanner(System.in);
        try {
            System.out.println("Podaj szerokość: ");
            int w = reader.nextInt();
            System.out.println("Podaj długość: ");
            int h = reader.nextInt();
            System.out.println("Podaj cenę za m2: ");
            int p = reader.nextInt();
            System.out.println("Cena za całą podłogę wynosi: " + w * h * p + " zł");
        } catch (Exception e) {
            System.out.print("Zły typ danych wejściowych!");
            System.out.print(e.getMessage());
        }

    }

    void mortgageCalc () {
        Scanner reader = new Scanner(System.in);
        try {
            System.out.print("Podaj kwotę pożyczki: ");
            int sum = reader.nextInt();
            System.out.print("Podaj oprocentowanie: ");
            int percent = reader.nextInt();
            System.out.print("Podaj okres spłacania: ");
            int period = reader.nextInt();
            System.out.print("Miesięcznie(m)/tygodniowo(t)/dziennie(d): ");
            String interval = reader.next();
            double payment;
            switch (interval) {
                case "m":
                    payment = sum * (1 + percent / 100) / period;
                    System.out.format("Miesięcznie będziesz płacić: " + String.format("%.2f", payment) + " zł");
                    break;
                case "t":
                    payment = sum * (1 + percent / 100) / (period * 30.5 / 7);
                    System.out.print("Tygodniowo będziesz płacić: " + String.format("%.2f", payment) + " zł");
                    break;
                case "d":
                    payment = sum * (1 + percent / 100) / (period * 30.5);
                    System.out.printf("Dziennie będziesz płacić: " + String.format("%.2f", payment) + " zł");
                    break;
                default:
                    payment = sum * (1 + percent / 100) / period;
                    System.out.printf("Miesięcznie będziesz płacić: " + String.format("%.2f", payment) + " zł");
                    break;
            }

        } catch (Exception e) {
            System.out.println("Wprowadzono zły rodzaj danych!");
            System.out.println(e.getMessage());
        }
        reader.close();
    }

    void changeReturn () {
        Scanner reader = new Scanner(System.in);
        try {
            System.out.print("Podaj cenę: ");
            BigDecimal cost = reader.nextBigDecimal();
            System.out.print("Podaj gotówkę: ");
            BigDecimal money = reader.nextBigDecimal();
            BigDecimal rest = money.subtract(cost);
            BigDecimal restEnd = rest;
            BigDecimal[] changeValue = {BigDecimal.valueOf(200),BigDecimal.valueOf(100),BigDecimal.valueOf(50),BigDecimal.valueOf(20),BigDecimal.valueOf(10),BigDecimal.valueOf(5),BigDecimal.valueOf(2),BigDecimal.valueOf(1),BigDecimal.valueOf(0.5),BigDecimal.valueOf(0.2),BigDecimal.valueOf(0.1),BigDecimal.valueOf(0.05),BigDecimal.valueOf(0.02),BigDecimal.valueOf(0.01)};
            BigInteger[] changeNumber = {BigInteger.ZERO,BigInteger.ZERO,BigInteger.ZERO,BigInteger.ZERO,BigInteger.ZERO,BigInteger.ZERO,BigInteger.ZERO,BigInteger.ZERO,BigInteger.ZERO,BigInteger.ZERO,BigInteger.ZERO,BigInteger.ZERO,BigInteger.ZERO,BigInteger.ZERO};
            String[] changeName = {"200zł","100zł","50zł","20zł","10zł","5zł","2zł","1zł","50gr","20gr","10gr","5gr","2gr","1gr"};

            for(int i = 0; i < 14; i++) {
                changeNumber[i] = (rest.divide(changeValue[i]).toBigInteger());
                rest = rest.remainder(changeValue[i]);
                System.out.println(changeNumber[i] + " x " + changeName[i]);
            }
            System.out.println("Należna reszta: " + restEnd);
            BigDecimal count = BigDecimal.ZERO;
            for(int i = 0; i < 14; i++) {
                count = count.add(changeValue[i].multiply(BigDecimal.valueOf(changeNumber[i].intValue())));
            }
            System.out.println("Wydana reszta: " + count);

        } catch (Exception e) {
            System.out.println("Wprowadzono zły rodzaj danych!");
            System.out.println(e.getMessage());
        }
        reader.close();
    }

    public static void main (String[] args) {
        Numbers6 numbers6 = new Numbers6();
        //numbers6.tilesCost();
        //numbers6.mortgageCalc();
        numbers6.changeReturn();
    }
}
