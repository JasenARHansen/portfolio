package Java.code.ctci.source.ch_17_Hard.q17_09_Kth_Multiple;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionA {
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println(i + " : " + getKthMagicNumber(i));
        }
    }

    public static int getKthMagicNumber(int k) {
        ArrayList<Integer> possibilities = allPossibleKFactors(k);
        Collections.sort(possibilities);
        return possibilities.get(k);
    }

    public static ArrayList<Integer> allPossibleKFactors(int k) {
        ArrayList<Integer> values = new ArrayList<>();
        for (int a = 0; a <= k; a++) { // 3
            int powA = (int) Math.pow(3, a);
            for (int b = 0; b <= k; b++) { // 5
                int powB = (int) Math.pow(5, b);
                for (int c = 0; c <= k; c++) { // 7
                    int powC = (int) Math.pow(7, c);
                    int value = powA * powB * powC;
                    if (value < 0
                            || powA == Integer.MAX_VALUE
                            || powB == Integer.MAX_VALUE
                            || powC == Integer.MAX_VALUE) {
                        value = Integer.MAX_VALUE;
                    }
                    values.add(value);
                }
            }
        }
        return values;
    }
}
