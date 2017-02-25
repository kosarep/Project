/**
 * Created by Grzegorz on 20.02.2017.
 */
public class SortAlg {
    boolean flag = true;
    void bubble (int[] table) {
        int change = 0;
        for(int i = 0; i < table.length - 1; i++) {
            if(table[i] > table[i + 1]) {
                change = table[i];
                table[i] = table[i + 1];
                table[i + 1] = change;
                flag = false;
            }
            if (i == (table.length - 2) && flag == false) {
                i = 0;
                flag = true;
            }
            if (i == (table.length - 2) && flag == true) {
                for (int j = 0; j < table.length; j++) {
                    System.out.print(table[j] + ", ");
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] table = {2,1,3,5,4,10,21,3,6,90,100,32,1,4,6,8,9};
        SortAlg sortAlg = new SortAlg();
        sortAlg.bubble(table);
        System.out.print("");
    }
}
