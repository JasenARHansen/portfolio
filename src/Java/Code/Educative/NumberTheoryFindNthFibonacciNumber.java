package Java.Code.Educative;

public class NumberTheoryFindNthFibonacciNumber {
  /*
  In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation
      Fn = Fn-1 + Fn-2
  with seed values
     F0 = 0 and F1 = 1.

  The Fibonacci sequence is a series of numbers where a number is the addition of the last two numbers, starting
   with 0, and 1.
  The Fibonacci Sequence: …, −8, 5, −3, 2, −1, 1, 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, …
  Written as a rule, the expression is:
      Positive values of n:\tXn = Xn-1 + Xn-2
      Negative values of n:\tXn-2 = Xn - Xn-1
  */

  public static int getFibonacci(int count) {
    int even = 0;
    int odd = 1;
    boolean flip = true;
    if (count > 1) {
      int iterate = count - 1;
      while (iterate > 0) {
        if (flip) {
          even += odd;
        } else {
          odd += even;
        }
        flip = !flip;
        iterate--;
      }
    } else if (count < 0) {
      int iterate = count;
      while (iterate < 0) {
        if (flip) {
          even -= odd;
        } else {
          odd -= even;
        }
        flip = !flip;
        iterate++;
      }
    }
    return (count % 2 == 0) ? even : odd;
  }
}
