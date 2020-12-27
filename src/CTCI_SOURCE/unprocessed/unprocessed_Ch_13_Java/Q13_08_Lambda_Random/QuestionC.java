package CTCI_SOURCE.unprocessed.unprocessed_Ch_13_Java.Q13_08_Lambda_Random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class QuestionC {
    public static Random random = new Random();
    public static Predicate<Object> flipCoin = o -> random.nextBoolean();

    public static List<Integer> getRandomSubset(List<Integer> list) {
        return list.stream().filter(flipCoin).
                collect(Collectors.toList());
    }

    public static void main(String... args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        List<Integer> subset = getRandomSubset(list);
        System.out.println(subset.toString());
    }

}