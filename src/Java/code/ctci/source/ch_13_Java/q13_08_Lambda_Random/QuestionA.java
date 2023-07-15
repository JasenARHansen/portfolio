package Java.code.ctci.source.ch_13_Java.q13_08_Lambda_Random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("DuplicatedCode")
public class QuestionA {
    public static void main(String... args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        List<Integer> subset = getRandomSubset(list);
        System.out.println(subset);
    }

    public static List<Integer> getRandomSubset(List<Integer> list) {
        List<Integer> subset = new ArrayList<>();
        Random random = new Random();
        for (int item : list) {
            if (random.nextBoolean()) {
                subset.add(item);
            }
        }
        return subset;
    }
}
