/**
 * Created by Grzegorz on 19.02.2017.
 */
public class ColConAlgorithm {

    void howManySteps (int n, int count) {
        if (n == 1) {
            System.out.print("Potrzebna ilość kroków: " + count);
        } else if (n % 2 == 0) {
            howManySteps(n / 2, count + 1);
        } else if (n % 2 != 0) {
            howManySteps(n * 3 +1, count + 1);
        }
    }

    public static void main(String[] args) {
        ColConAlgorithm algorithm = new ColConAlgorithm();
        algorithm.howManySteps(8,0);
    }
}
