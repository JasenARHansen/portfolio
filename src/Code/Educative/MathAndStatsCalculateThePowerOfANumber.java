package Code.Educative;

public class MathAndStatsCalculateThePowerOfANumber {
  /*
  Given a double, x, and an integer, n, write a function to calculate x raised to the power n. For example:

  power (2, 5) = 32

  power (3, 4) = 81

  power (1.5, 3) = 3.375

  power (2, -2) = 0.25

  Runtime complexity: Logarithmic, O(log n)
  Memory Complexity: Logarithmic, O(log n)

  A simple algorithm for this problem is to multiply x by n times. The time complexity of this algorithm would be O(n).
   We can use the divide and conquer approach to solve this problem more efficiently.

  In the dividing step, we keep dividing n by 2 recursively until we reach the base case i.e. n == 1

  In the combining step, we get the result, r, of the sub-problem and compute the result of the current problem using
   the two rules below:
      If nnn is even, the result is r∗rr * rr∗r (where rrr is the result of sub-problem)
      If nnn is odd, the result is x∗r∗rx * r * rx∗r∗r (where rrr is the result of sub-problem).

  */

    public static double power(double base, double power) {
        // any number to the power of 0 = 1
        if (power == 0) {
            return 1;
        }
        // if power is negative =  base^(-power) -> 1/(base^power)
        boolean negative = false;
        if (power < 0) {
            negative = true;
            power *= -1;
        }
        // if power is decimal greater than 1= base^(power.decimal) = (base^power)*(base^(0.decimal))
        double alt_power = power - Math.floor(power);
        power = Math.floor(power);
        // if power is decimal= base^(decimal) = base^(a/b) = bth root of base^a I am not doing this
        // part so using a library
        double alt_value = Math.pow(base, alt_power);
        // Manipulations may have dropped the power to zero so setting a default
        double value = 1;
        // Manipulations may have dropped the power to 1 so setting equal to base
        if (power == 1) {
            value = base;
        }
        // if power is greater than 1 the
        if (power > 1) {
            boolean powerOdd = false;
            if (power % 2 == 1) {
                power -= 1;
                powerOdd = true;
            }
            double recursive = power(base, power / 2);
            value = recursive * recursive;
            if (powerOdd) {
                value *= base;
            }
        }
        value *= alt_value;
        if (negative) {
            value = 1 / value;
        }
        return value;
    }
}
