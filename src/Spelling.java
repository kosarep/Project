import java.util.HashMap;
import java.util.Map;

/**
 * Created by Grzegorz on 18.02.2017.
 */
public class Spelling {
    Map<Integer,String> map = new HashMap<>();

    void dictionary () {
        map.put(0, "");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "ten");
        map.put(11, "eleven");
        map.put(12, "twelve");
        map.put(13, "thirteen");
        map.put(14, "fourteen");
        map.put(15, "fifteen");
        map.put(16, "sixteen");
        map.put(17, "seventeen");
        map.put(18, "eighteen");
        map.put(19, "nineteen");
        map.put(20, "twenty");
        map.put(30, "thirty");
        map.put(40, "forty");
        map.put(50, "fifty");
        map.put(60, "sixty");
        map.put(70, "seventy");
        map.put(80, "eighty");
        map.put(90, "ninety");
    }

    String subStr (int part) {
        String name = "";
        if (part > 99) name = name + map.get(part/100) + " hundred ";
        if (part > 99 && part % 100 != 0) name = name + "and ";
        if (part%100 < 20) name = name + map.get(part%100);
        if (part%100 >= 20 && part%10 != 0) name = name + map.get(part%100/10*10) + "-" + map.get(part%100%10);
        if (part%100 >= 20 && part%10 == 0) name = name + map.get(part%100/10*10);
        return name;
    }

    void howSpell (int number) {
        dictionary();
        String word = "";
        if (number >= 1000000)
            word = word + subStr(number/1000000%1000) + " milion ";
        if (number >= 1000)
            word = word + subStr(number/1000%1000) + " thousand ";
        if (number%1000 != 0)
            word = word + subStr(number%1000);
        System.out.print(word);
    }

    public static void main(String[] args) {
        Spelling spelling = new Spelling();
        spelling.howSpell(178123456);
    }
}
