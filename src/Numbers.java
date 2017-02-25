import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.lang.*;
import java.util.Scanner;

/**
 * Created by Grzegorz on 04.02.2017.
 */
public class Numbers {
    void findPi () {
        Scanner reader = new Scanner(System.in);
        System.out.print("Ile cyfr po przecinku liczby PI: ");
        try {
            int n = reader.nextInt();
            if (n <= 10) {
                Double pi = Math.PI;
                String piString = pi.toString();
                System.out.println("Liczba PI: " + piString.substring(0,n+2));

                String a = "Liczba PI: %." + n + "f";
                System.out.println(String.format(a,Math.PI));

                Double number = BigDecimal.valueOf(Math.PI).setScale(n, BigDecimal.ROUND_HALF_UP).doubleValue();
                System.out.println("Liczba PI: " + number);
                System.out.print("Liczba PI: " + Math.PI);
            } else if (n > 10) {
                System.out.print("Zbyt wysoki numer :(");
            }
        } catch (Exception e) {
            System.out.print("Zły rodzaj danych wejściowych!");
            System.out.print(e.getMessage());
        }
    }

    void findE () {
        Scanner reader = new Scanner(System.in);
        System.out.print("Ile cyfr po przecinku liczby e: ");
        try {
            int n = reader.nextInt();
            if (n <= 10) {
                Double e = Math.E;
                String eString = e.toString();
                System.out.println("Liczba e: " + eString.substring(0,n+2));

                String a = "Liczba e: %." + n + "f";

                Double number = BigDecimal.valueOf(Math.E).setScale(n, BigDecimal.ROUND_HALF_UP).doubleValue();
                System.out.println(String.format(a,Math.E));
                System.out.println("Liczba e: " + number);
                System.out.print("Liczba e: " + Math.E);
            } else if (n > 10) {
                System.out.print("Zbyt wysoki numer :(");
            }
        } catch (Exception e) {
            System.out.print("Zły rodzaj danych wejściowych!");
            System.out.print(e.getMessage());
        }
    }

    void fibonacciSeq () {
        Scanner reader = new Scanner(System.in);
        System.out.print("Ile wyrazów ciągu Fibonacciego: ");
        try {
            int n = reader.nextInt();
            List<Integer> sequence = new ArrayList<Integer>();
            for (int i = 0; i <= n; i++) {
                if (i == 0) {
                    sequence.add(0);
                } else if (i == 1) {
                    sequence.add(1);
                } else {
                    sequence.add(sequence.get(i - 2) + sequence.get(i - 1));
                }
            }
            System.out.print(sequence.toString());
        } catch (Exception e) {
            System.out.print("Zły rodzaj danych wejściowych!");
            System.out.print(e.getMessage());
        }
    }

    List<Integer> integerList = new ArrayList<>();
    Scanner moreOrNot = new Scanner(System.in);

    void primes2 (int n, int i) {
        if (n == i) {
            if (!integerList.contains(i)) integerList.add(i);
            System.out.println("To już wszystko.");
        } else if (n % i == 0) {
            if (!integerList.contains(i)) {
                integerList.add(i);
            }
            primes(n/i, i);
        } else {
            i++;
            primes(n, i);
        }
    }

    void primes (int n, int i) {
        boolean flag = true;
        if (n == i) {
            if (!integerList.contains(i)) integerList.add(i);
            System.out.println(i);
            System.out.println("To już wszystko.");
        } else if (n % i == 0) {
            if (!integerList.contains(i)) {
                integerList.add(i);
                System.out.println(i);
                try {
                    System.out.println("Czy kolejną? y/n" );
                    String next = moreOrNot.next();
                    if(next.equals("y")) flag = true;
                    if(next.equals("n")) {
                        System.out.print("Nie to nie.");
                        flag = false;
                    }
                    if(!next.equals("y") && !next.equals("n")) {
                        System.out.println("Źle podajesz no to koniec.");
                        flag = false;
                    }
                } catch (Exception e) {
                    System.out.print("Zły rodzaj danych wejściowych!");
                    System.out.print(e.getMessage());
                    flag = false;
                }
            }
            if (flag) {
                primes(n / i, i);
            }
        } else {
            i++;
            primes(n, i);
        }
    }

    void primeFactors2 () {
        Scanner reader = new Scanner(System.in);
        System.out.print("Jaka liczba do rozłożenia na czynniki pierwsze: ");
        try {
            int n = reader.nextInt();
            primes2(n,2);
            System.out.print(integerList.toString());
        } catch (Exception e) {
            System.out.print("Zły rodzaj danych wejściowych!");
            System.out.print(e.getMessage());
        }
    }

    void primeFactors () {
        Scanner reader = new Scanner(System.in);
        System.out.print("Jaka liczba do rozłożenia na czynniki pierwsze: ");
        try {
            int n = reader.nextInt();
            primes(n,2);
            //System.out.print(integerList.toString());
        } catch (Exception e) {
            System.out.print("Zły rodzaj danych wejściowych!");
            System.out.print(e.getMessage());
        }
    }

    public static void main(String args[]) {

        Numbers numbers = new Numbers();
        //numbers.findPi();
        //numbers.findE();
        //numbers.fibonacciSeq();
        //numbers.primeFactors2();
        numbers.primeFactors();
    }
}
