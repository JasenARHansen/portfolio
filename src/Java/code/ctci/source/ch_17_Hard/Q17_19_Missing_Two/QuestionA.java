package Java.code.ctci.source.ch_17_Hard.q17_19_Missing_Two;

import java.math.BigInteger;

@SuppressWarnings("DuplicatedCode")
public class QuestionA {
  public static void main(String[] args) {
    int max = 100;
    int x = 8;
    int len = max - 1;
    int count = 0;
    int[] array = new int[len];
    for (int i = 1; i <= max; i++) {
      if (i != x) {
        array[count] = i;
        count++;
      }
    }
    System.out.println(x);
    int solution = missingOne(array);
    System.out.println(solution);
  }

  public static int missingOne(int[] array) {
    BigInteger fullProduct = productToN(array.length + 1);
    BigInteger actualProduct = new BigInteger("1");
    for (int j : array) {
      BigInteger value = new BigInteger(String.valueOf(j));
      actualProduct = actualProduct.multiply(value);
    }
    BigInteger missingNumber = fullProduct.divide(actualProduct);
    return Integer.parseInt(missingNumber.toString());
  }

  public static BigInteger productToN(int n) {
    BigInteger fullProduct = new BigInteger("1");
    for (int i = 2; i <= n; i++) {
      fullProduct = fullProduct.multiply(new BigInteger(String.valueOf(i)));
    }
    return fullProduct;
  }
}
