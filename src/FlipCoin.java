import java.util.Random;
import java.util.Scanner;

/**
 * Created by Grzegorz on 18.02.2017.
 */
public class FlipCoin {
    String singleThrow () {
        Random random = new Random();
        int number = random.nextInt(2);
        if(number == 0) return "tail";
        if(number == 1) return "head";
        return "BLAD";
    }

    int tail1 = 0;
    int head1 = 0;
    int rest1 = 0;

    void handFlip () {
        Scanner reader = new Scanner(System.in);
        String coin;
        try {
            System.out.print("Rzucasz? t/n ");
            String choise = reader.next();
            if(choise.equals("t")) {
                coin = singleThrow();
                if (coin == "tail") tail1++;
                if (coin == "head") head1++;
                if (coin == "BLAD") rest1++;
                handFlip();
            } else {
                System.out.println("Tail: " + tail1);
                System.out.println("Head: " + head1);
                System.out.println("Rest: " + rest1);
            }
        } catch (Exception e) {
            System.out.print("Złe dane. Koniec.");
        }
    }

    void autoFlip (int howMany) {
        int tail = 0;
        int head = 0;
        int rest = 0;
        String tailOrHead;
        for (int i = 0; i < howMany; i++) {
            tailOrHead = singleThrow();
            if (tailOrHead == "tail") tail++;
            if (tailOrHead == "head") head++;
            if (tailOrHead == "BLAD") rest++;
        }
        System.out.println("Tail: " + tail);
        System.out.println("Head: " + head);
        System.out.println("Rest: " + rest);
    }

    public static void main(String[] args) {
        FlipCoin flipCoin = new FlipCoin();
        //flipCoin.autoFlip(100);
        flipCoin.handFlip();
    }
}
