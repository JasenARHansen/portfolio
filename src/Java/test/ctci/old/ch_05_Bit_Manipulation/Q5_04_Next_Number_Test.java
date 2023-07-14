package Java.test.ctci.old.ch_05_Bit_Manipulation;

import static org.junit.Assert.assertEquals;

import Java.code.ctci.old.ch_05_Bit_Manipulation.BitShift;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"unused", "DuplicatedCode", "NewClassNamingConvention"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q5_04_Next_Number_Test {
  @Rule public final TestName name = new TestName();

  @Test
  public void getNext() {
    int[] expected = {207, 198, 7735, 13967};
    System.out.format("%s:\n", name.getMethodName());
    int[] values = {190, 197, 7727, 13948};
    for (int i = 0; i < values.length; i++) {
      int result = BitShift.getNext(values[i]);
      assertEquals(expected[i], result);
      System.out.format("\tInitial number is %d with %d as next\n", values[i], result);
    }
  }

  @Test
  public void getPrev() {
    int[] expected = {189, 195, 7711, 13946};
    System.out.format("%s:\n", name.getMethodName());
    int[] values = {190, 197, 7727, 13948};
    for (int i = 0; i < values.length; i++) {
      int result = BitShift.getPrev(values[i]);
      assertEquals(expected[i], result);
      System.out.format("\tInitial number is %d with %d as previous\n", values[i], result);
    }
  }
}
