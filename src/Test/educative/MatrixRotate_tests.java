package Test.educative;

import Code.educative.MatrixRotate;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MatrixRotate_tests {

  @Rule
  public TestName name = new TestName();

  //@Test
  public void rotateMatrix_1() {
    int[][] expected = {{1}};
    int[][] source = {{1}};
    System.out.format(
            "%s: The array with dimensions %dx%d:\n",
            name.getMethodName(), source.length, source[0].length);
    MatrixRotate.printArray(source);
    MatrixRotate.rotateMatrix_square(source);
    System.out.format(
            "\tIs rotated into the array with dimensions %dx%d:\n", source.length, source[0].length);
    MatrixRotate.printArray(source);
    for (int index = 0; index < source.length; index++) {
      assertEquals(Arrays.toString(expected[index]), Arrays.toString(source[index]));
    }
  }

  //@Test
  public void rotateMatrix_2() {
    int[][] expected = {
            {3, 1},
            {4, 2}
    };
    int[][] source = {
            {1, 2},
            {3, 4}
    };
    System.out.format(
            "%s: The array with dimensions %dx%d:\n",
            name.getMethodName(), source.length, source[0].length);
    MatrixRotate.printArray(source);
    MatrixRotate.rotateMatrix_square(source);
    System.out.format(
            "\tIs rotated into the array with dimensions %dx%d:\n", source.length, source[0].length);
    MatrixRotate.printArray(source);
    for (int index = 0; index < source.length; index++) {
      assertEquals(Arrays.toString(expected[index]), Arrays.toString(source[index]));
    }
  }

  //@Test
  public void rotateMatrix_3() {
    int[][] expected = {
            {7, 4, 1},
            {8, 5, 2},
            {9, 6, 3}
    };
    int[][] source = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };
    System.out.format(
            "%s: The array with dimensions %dx%d:\n",
            name.getMethodName(), source.length, source[0].length);
    MatrixRotate.printArray(source);
    MatrixRotate.rotateMatrix_square(source);
    System.out.format(
            "\tIs rotated into the array with dimensions %dx%d:\n", source.length, source[0].length);
    MatrixRotate.printArray(source);
    for (int index = 0; index < source.length; index++) {
      assertEquals(Arrays.toString(expected[index]), Arrays.toString(source[index]));
    }
  }

  //@Test
  public void rotateMatrix_4() {
    int[][] expected = {
            {13, 9, 5, 1},
            {14, 10, 6, 2},
            {15, 11, 7, 3},
            {16, 12, 8, 4}
    };
    int[][] source = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
    };
    System.out.format(
            "%s: The array with dimensions %dx%d:\n",
            name.getMethodName(), source.length, source[0].length);
    MatrixRotate.printArray(source);
    MatrixRotate.rotateMatrix_square(source);
    System.out.format(
            "\tIs rotated into the array with dimensions %dx%d:\n", source.length, source[0].length);
    MatrixRotate.printArray(source);
    for (int index = 0; index < source.length; index++) {
      assertEquals(Arrays.toString(expected[index]), Arrays.toString(source[index]));
    }
  }

  //@Test
  public void rotateMatrix_5() {
    int[][] expected = {
            {21, 16, 11, 6, 1},
            {22, 17, 12, 7, 2},
            {23, 18, 13, 8, 3},
            {24, 19, 14, 9, 4},
            {25, 20, 15, 10, 5}
    };
    int[][] source = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}
    };
    System.out.format(
            "%s: The array with dimensions %dx%d:\n",
            name.getMethodName(), source.length, source[0].length);
    MatrixRotate.printArray(source);
    MatrixRotate.rotateMatrix_square(source);
    System.out.format(
            "\tIs rotated into the array with dimensions %dx%d:\n", source.length, source[0].length);
    MatrixRotate.printArray(source);
    for (int index = 0; index < source.length; index++) {
      assertEquals(Arrays.toString(expected[index]), Arrays.toString(source[index]));
    }
  }

  @Test
  public void rotateMatrix_6() {
    int[][] expected = {
            {4, 1},
            {5, 2},
            {6, 3}
    };
    int[][] source = {
            {1, 2, 3},
            {4, 5, 6}
    };
    System.out.format(
            "%s: The array with dimensions %dx%d:\n",
            name.getMethodName(), source.length, source[0].length);
    MatrixRotate.printArray(source);
    int[][] result = MatrixRotate.rotateMatrix_rectangle(source);
    System.out.format(
            "\tIs rotated into the array with dimensions %dx%d:\n", source.length, source[0].length);
    MatrixRotate.printArray(result);
    for (int index = 0; index < expected.length; index++) {
      assertEquals(Arrays.toString(expected[index]), Arrays.toString(result[index]));
    }
  }

}
