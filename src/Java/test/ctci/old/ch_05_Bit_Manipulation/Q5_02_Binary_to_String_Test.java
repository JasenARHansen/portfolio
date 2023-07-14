package Java.test.ctci.old.ch_05_Bit_Manipulation;

import static org.junit.Assert.*;

import Java.code.ctci.old.ch_05_Bit_Manipulation.BitShift;
import Java.code.ctci.old.ch_05_Bit_Manipulation.BitShift2;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"NewClassNamingConvention", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q5_02_Binary_to_String_Test {
  @Rule public final TestName name = new TestName();

  @Test
  public void convertBinaryLessThanOne() {
    String[] expected = {"0.001", "Error", "0.01", "0.1", "0.11"};
    System.out.format("%s:\n", name.getMethodName());
    double[] values = {.125, 0.1, 0.25, 0.5, 0.75};
    for (int i = 0; i < values.length; i++) {
      String result = BitShift.convertBinaryLessThanOne(values[i]);
      assertEquals(expected[i], result);
      System.out.format("\t%.3f converted to binary is %s\n", values[i], result);
    }
  }

  @Test
  public void convertBinaryLessThanOne_solution_1() {
    String[] expected = {"0.001", "Error", "0.01", "0.1", "0.11"};
    System.out.format("%s:\n", name.getMethodName());
    double[] values = {.125, 0.1, 0.25, 0.5, 0.75};
    for (int i = 0; i < values.length; i++) {
      double num = values[i];
      String result = BitShift2.convertBinaryLessThanOne1(num);
      assertNotNull(result);
      assertEquals(expected[i], result);
      System.out.format("\t%.3f converted to binary is %s\n", values[i], result);
    }
  }

  @Test
  public void convertBinaryLessThanOne_solution_2() {
    String[] expected = {"0.001", "Error", "0.01", "0.1", "0.11"};
    System.out.format("%s:\n", name.getMethodName());
    double[] values = {.125, 0.1, 0.25, 0.5, 0.75};
    for (int i = 0; i < values.length; i++) {
      double num = values[i];
      String result = BitShift2.convertBinaryLessThanOne2(num);
      assertNotNull(result);
      assertEquals(expected[i], result);
      System.out.format("\t%.3f converted to binary is %s\n", values[i], result);
    }
  }
}
