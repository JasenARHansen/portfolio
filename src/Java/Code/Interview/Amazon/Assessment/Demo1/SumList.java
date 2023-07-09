package Java.Code.Interview.Amazon.Assessment.Demo1;
import java.util.List;

public class SumList {
  public static void getDescription() {
    System.out.println("""
                Sum the contents of a List.""".indent(2));
  }

  public static int sumList(List<Integer> numbers) {
    // Write your code here
    int sum = 0;
    for (int number : numbers) {
      sum += number;
    }
    return sum;
  }
}
