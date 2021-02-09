package Test.CTCI.Ch_05_Bit_Manipulation;

import Code.CTCI.other.Ch_05_Bit_Manipulation.BitShift;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Arrays;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q5_02_Binary_to_String_Test {

  @Rule
  public TestName name = new TestName();

  @Test
  public void printBinary() {
    System.out.format("%s: \n", name.getMethodName());
    ArrayList<Double> values = new ArrayList<>(Arrays.asList(0.5, 0.1, 0.25, 0.75));
    for (Double value : values) {
      String result = BitShift.convertBinaryLessThanOne(value);
      System.out.format("%s: %f converted to binary is %s\n", name.getMethodName(), value, result);
    }
  }

  @Test
  public void printBinary_solution_1() {
    System.out.format("%s: \n", name.getMethodName());
    String bs = printBinary(.125);
    System.out.println(bs);

    for (int i = 0; i < 1000; i++) {
      double num = i / 1000.0;
      String binary = printBinary(num);
      String binary2 = printBinary2(num);
      if (!binary.equals("ERROR") || !binary2.equals("ERROR")) {
        System.out.println(num + " : " + binary + " " + binary2);
      }
    }
  }

  public static String printBinary(double num) {
    if (num >= 1 || num <= 0) {
      return "ERROR";
    }

    StringBuilder binary = new StringBuilder();
    binary.append(".");
    while (num > 0) {
      /* Setting a limit on length: 32 characters */
      if (binary.length() > 32) {
        return "ERROR";
      }
      double r = num * 2;
      if (r >= 1) {
        binary.append(1);
        num = r - 1;
      } else {
        binary.append(0);
        num = r;
      }
    }
    return binary.toString();
  }

  public static String printBinary2(double num) {
    if (num >= 1 || num <= 0) {
      return "ERROR";
    }

    StringBuilder binary = new StringBuilder();
    double frac = 0.5;
    binary.append(".");
    while (num > 0) {
      /* Setting a limit on length: 32 characters */
      if (binary.length() >= 32) {
        return "ERROR";
      }
      if (num >= frac) {
        binary.append(1);
        num -= frac;
      } else {
        binary.append(0);
      }
      frac /= 2;
    }
    return binary.toString();
  }
}
