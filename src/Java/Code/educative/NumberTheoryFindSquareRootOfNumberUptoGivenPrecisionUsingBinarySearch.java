package Java.code.educative;

public class NumberTheoryFindSquareRootOfNumberUptoGivenPrecisionUsingBinarySearch {
  /*
  Given a positive number n and precision p, find the square root of number upto p decimal places using binary search.
  Note : Prerequisite : Binary search
  Examples:
  Input : number = 50, precision = 3
  Output : 7.071
  Input : number = 10, precision = 4
  Output : 3.1622
  Recommended: Please try your approach on {IDE} first, before moving on to the solution.
  We have discussed how to compute integral value of square root in Square Root using Binary Search
  Approach :
  1) As the square root of number lies in range 0 <= squareRoot <= number, therefore, initialize start and end
   as : start = 0, end = number.
  2) Compare the square of mid-integer with the given number. If it is equal to the number, then we found our
   integral part, else look for the same in left or right side depending upon the scenario.
  3) Once we are done with finding the integral part, start computing the fractional part.
  4) Initialize the increment variable by 0.1 and iteratively compute the fractional part upto p places. For each
   iteration, increment changes to 1/10th of its previous value.
  5) Finally return the answer computed.
  Below is the implementation of above approach :
  Output:
  7.071
  3.1622
  Time Complexity : The time required to compute the integral part is O(log(number)) and constant i.e, = precision
   for computing the fractional part. Therefore, overall time complexity is O(log(number) + precision) which is
   approximately equal to O(log(number)). */
  public static float squareRoot(int number, int precision) {
    double result;
    int start = 0;
    int end = number / 2;
    int middle;
    double increment = 0.1;
    // Find integer portion
    while (start <= end) {
      middle = (start + end) / 2;
      if (Math.pow(middle, 2) == number) {
        return middle;
      }
      if (Math.pow(middle, 2) < number) {
        start = middle + 1;
      } else {
        end = middle - 1;
      }
    }
    // find decimal portion
    result = start - 1;
    for (int depth = 0; depth < precision; depth++) {
      while (Math.pow(result, 2) <= number) {
        result += increment;
      }
      result -= increment;
      increment = increment / 10;
    }
    return (float) result;
  }

  public static float nThRoot(int number, int root, int precision) {
    double result;
    int start = 0;
    int end = number / 2;
    int middle;
    double increment = 0.1;
    // Find integer portion
    while (start <= end) {
      middle = (start + end) / 2;
      if (Math.pow(middle, root) == number) {
        return middle;
      }
      if (Math.pow(middle, root) < number) {
        start = middle + 1;
      } else {
        end = middle - 1;
      }
    }
    // find decimal portion
    result = start - 1;
    for (int depth = 0; depth < precision; depth++) {
      while (Math.pow(result, root) <= number) {
        result += increment;
      }
      result -= increment;
      increment = increment / 10;
    }
    return (float) result;
  }
}
