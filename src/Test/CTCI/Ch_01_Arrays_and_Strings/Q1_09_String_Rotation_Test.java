package Test.CTCI.Ch_01_Arrays_and_Strings;

import CTCI.Ch_01_Arrays_and_Strings.Q1_09_String_Rotation;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q1_09_String_Rotation_Test {

  @Rule
  public TestName name = new TestName();

  @Test
  public void isRotation_true() {
    String left = "waterbottle";
    String right = "erbottlewat";
    boolean success = Q1_09_String_Rotation.isRotation(left, right);
    System.out.format("%s: string '%s' is  rotation of '%s': %b\n", name.getMethodName(), left, right, success);
    assertTrue(success);
  }

  @Test
  public void isRotation_false() {
    String left = "water";
    String right = "waterbottle";
    boolean success = Q1_09_String_Rotation.isRotation(left, right);
    System.out.format("%s: string '%s' is  rotation of '%s': %b\n", name.getMethodName(), left, right, success);
    assertFalse(success);
  }

  @Test
  public void isRotation_solution_1() {
    String left = "waterbottle";
    String right = "erbottlewat";
    boolean success = Q1_09_String_Rotation.isRotation_solution_1(left, right);
    System.out.format("%s: string '%s' is  rotation of '%s': %b\n", name.getMethodName(), left, right, success);
    assertTrue(success);
  }
}
