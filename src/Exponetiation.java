/**
 * Created by Grzegorz on 18.02.2017.
 */
public class Exponetiation {
    int exp = 1;
    int number = 1;

    int fast (int a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }
        if (b % 2 == 0) {
            return a*a*fast(a*a,(b/2) - 1);
        }
        if (b % 2 != 0) {
            return a*a*a*fast(a*a,(b/2) - 1);
        }
        return 1;
    }

    public static void main(String[] args) {
        Exponetiation exponetiation = new Exponetiation();
        int value = exponetiation.fast(2,15);
        System.out.print("Twoja liczba to: " + value);

    }
}
