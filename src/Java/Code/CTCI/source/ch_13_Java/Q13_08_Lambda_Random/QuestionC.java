package Java.code.ctci.source.ch_13_Java.q13_08_Lambda_Random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@SuppressWarnings("DuplicatedCode")
public class QuestionC {
  public static final Random random = new Random();
  public static final Predicate<Object> flipCoin = o -> random.nextBoolean();

  public static void main(String... args) {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    List<Integer> subset = getRandomSubset(list);
    System.out.println(subset.toString());
  }

  public static List<Integer> getRandomSubset(List<Integer> list) {
    return list.stream().filter(flipCoin).collect(Collectors.toList());
  }
}
