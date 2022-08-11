package Code.Interview.Amazon.Assessment;

import java.util.List;

public class assessment_demo_1 {
  /*
  Sum Array
  */

  /*
   * Complete the 'fizzBuzz' function below.
   *
   * The function accepts INTEGER n as parameter.
   */

  public static int sumList(List<Integer> numbers) {
    // Write your code here
    int sum = 0;
    for (int number : numbers) {
      sum += number;
    }

    return sum;
  }
}
