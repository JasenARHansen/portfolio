package Test.Java.CTCI.other.Ch_01_Arrays_and_Strings;

import Code.Java.CTCI.CTCI_SOURCE.other.CtCILibrary.AssortedMethods;
import Code.Java.CTCI.other.Ch_01_Arrays_and_Strings.Q1_07_Rotate_Matrix;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q1_07_Rotate_Matrix_Test {

  @Rule
  public TestName name = new TestName();

  @Test
  public void rotateMatrix() {
    System.out.format("%s:\n", name.getMethodName());
    int[][] matrix = AssortedMethods.randomMatrix(3, 3, 0, 9);
    AssortedMethods.printMatrix(matrix);
    boolean result = Q1_07_Rotate_Matrix.rotateMatrix(matrix);
    System.out.format("%s: Matrix rotated\n", name.getMethodName());
    AssortedMethods.printMatrix(matrix);
    assertTrue(result);
  }

  @Test
  public void rotateMatrix_in_place() {
    System.out.format("%s:\n", name.getMethodName());
    int[][] matrix = AssortedMethods.randomMatrix(4, 4, 0, 9);
    AssortedMethods.printMatrix(matrix);
    boolean result = Q1_07_Rotate_Matrix.rotateMatrix_in_place(matrix);
    System.out.format("%s: Matrix rotated\n", name.getMethodName());
    AssortedMethods.printMatrix(matrix);
    assertTrue(result);
  }

  @Test
  public void rotateMatrix_solution_1() {
    System.out.format("%s:\n", name.getMethodName());
    int[][] matrix = AssortedMethods.randomMatrix(3, 3, 0, 9);
    AssortedMethods.printMatrix(matrix);
    boolean result = Q1_07_Rotate_Matrix.rotateMatrix_solution_1(matrix);
    System.out.format("%s: Matrix rotated\n", name.getMethodName());
    AssortedMethods.printMatrix(matrix);
    assertTrue(result);
  }
}
