package Java.code.interview.Amazon.assessment.demo2;

public class FizzBuzz {
  public static void getDescription() {
    System.out.println(
        """
                Given a number n, for each integer in the range of 1 to n inclusive, print one value per line as follows:
                1. If i is a multiple of both 3 and 5, print FizzBuzz
                2. If i is a multiple of 3 but not 5, print Fizz
                3. If i is a multiple of 5 but not 2, print Buzz
                4. If i is a not a multiple of 3 or 5, print i"""
            .indent(2));
  }

  public static void fizzBuzz(int n) {
    // Write your code here
    for (int i = 1; i <= n; i++) {
      if ((i % 3 == 0) && (i % 5 == 0)) {
        System.out.println("FizzBuzz");
      } else if (i % 3 == 0) {
        System.out.println("Fizz");
      } else if (i % 5 == 0) {
        System.out.println("Buzz");
      } else {
        System.out.println(i);
      }
    }
  }
}
