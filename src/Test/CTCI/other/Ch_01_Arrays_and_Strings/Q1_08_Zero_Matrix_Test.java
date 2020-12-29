package Test.CTCI.other.Ch_01_Arrays_and_Strings;

import CTCI.Ch_01_Arrays_and_Strings.Q1_08_Zero_Matrix;
import CTCI_SOURCE.other.CtCILibrary.AssortedMethods;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q1_08_Zero_Matrix_Test {

  @Rule
  public TestName name = new TestName();

  @Test
  public void zeroMatrix() {
    System.out.format("%s:\n", name.getMethodName());
    int[][] matrix = AssortedMethods.randomMatrix(3, 3, 0, 9);
    AssortedMethods.printMatrix(matrix);
    Q1_08_Zero_Matrix.zeroMatrix(matrix);
    System.out.format("%s: Matrix zeroed\n", name.getMethodName());
    AssortedMethods.printMatrix(matrix);
  }

  @Test
  public void zeroMatrix_solution_1() {
    System.out.format("%s:\n", name.getMethodName());
    int[][] matrix = AssortedMethods.randomMatrix(3, 3, 0, 9);
    AssortedMethods.printMatrix(matrix);
    Q1_08_Zero_Matrix.zeroMatrix_solution_1(matrix);
    System.out.format("%s: Matrix zeroed\n", name.getMethodName());
    AssortedMethods.printMatrix(matrix);
  }

  @Test
  public void zeroMatrix_solution_2() {
    System.out.format("%s:\n", name.getMethodName());
    int[][] matrix = AssortedMethods.randomMatrix(3, 3, 0, 9);
    AssortedMethods.printMatrix(matrix);
    Q1_08_Zero_Matrix.zeroMatrix_solution_2(matrix);
    System.out.format("%s: Matrix zeroed\n", name.getMethodName());
    AssortedMethods.printMatrix(matrix);
  }
}
