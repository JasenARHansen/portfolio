package Java.Code.CTCI.CTCI_SOURCE.other.Ch_16_Moderate.Q16_09_Operations;

import Java.Code.CTCI.CTCI_SOURCE.other.CtCILibrary.AssortedMethods;

public class Question {
  /* Flip a positive sign to negative, or a negative sign to pos. */
  public static int negate(int a) {
    int neg = 0;
    int newSign = a < 0 ? 1 : -1;
    while (a != 0) {
      neg += newSign;
      a += newSign;
    }
    return neg;
  }

  public static int negateOptimized(int a) {
    /* Flip a positive sign to negative, or a negative sign to pos. */
    int neg = 0;
    int newSign = a < 0 ? 1 : -1;
    int delta = newSign;
    while (a != 0) {
      boolean differentSigns = (a + delta > 0) != (a > 0);
      if (a + delta != 0 && differentSigns) { // If delta is too big, reset it.
        delta = newSign;
      }
      neg += delta;
      a += delta;
      delta += delta; // Double the delta
    }
    return neg;
  }

  public static int minus(int a, int b) {
    /* Subtract two numbers by negating b and adding them. */
    return a + negate(b);
  }

  public static int abs(int a) {
    /* Return absolute value. */
    if (a < 0) {
      return negateOptimized(a);
    } else return a;
  }

  public static int multiply(int a, int b) {
    /* Multiply a by b by adding a to itself b times. */
    if (a < b) {
      return multiply(b, a); // algo is faster if b < a
    }
    int sum = 0;
    for (int i = abs(b); i > 0; i = minus(i, 1)) {
      sum += a;
    }
    if (b < 0) {
      sum = negateOptimized(sum);
    }
    return sum;
  }

  public static int divide(int a, int b) throws java.lang.ArithmeticException {
    /* Divide a by b by literally counting how many times b can go into
    a. That is, count how many times you can add b to itself until you reach a. */
    if (b == 0) {
      throw new java.lang.ArithmeticException("ERROR: Divide by zero.");
    }
    int absa = abs(a);
    int absb = abs(b);
    int product = 0;
    int x = 0;
    while (product + absb <= absa) {
      /* don't go past a. */
      product += absb;
      x++;
    }
    if ((a < 0 && b < 0) || (a > 0 && b > 0)) {
      return x;
    } else {
      return negateOptimized(x);
    }
  }

  public static void main(String[] args) {
    int minRange = -100;
    int maxRange = 100;
    int cycles = 100;
    for (int i = 0; i < cycles; i++) {
      int a = AssortedMethods.randomIntInRange(minRange, maxRange);
      int b = AssortedMethods.randomIntInRange(minRange, maxRange);
      int ans = minus(a, b);
      if (ans != a - b) {
        System.out.println("ERROR");
      }
      System.out.println(a + " - " + b + " = " + ans);
    }
    for (int i = 0; i < cycles; i++) {
      int a = AssortedMethods.randomIntInRange(minRange, maxRange);
      int b = AssortedMethods.randomIntInRange(minRange, maxRange);
      int ans = multiply(a, b);
      if (ans != a * b) {
        System.out.println("ERROR");
      }
      System.out.println(a + "   " + b + " = " + ans);
    }
    for (int i = 0; i < cycles; i++) {
      int a = AssortedMethods.randomIntInRange(minRange, maxRange);
      int b = AssortedMethods.randomIntInRange(minRange, maxRange);
      System.out.print(a + " / " + b + " = ");
      int ans = divide(a, b);
      if (ans != a / b) {
        System.out.println("ERROR");
      }
      System.out.println(ans);
    }
  }
}
