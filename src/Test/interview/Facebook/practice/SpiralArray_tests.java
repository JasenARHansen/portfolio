package Test.interview.Facebook.practice;

import Code.interview.Facebook.practice.SpiralArray;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SpiralArray_tests {

  @Rule
  public TestName name = new TestName();

  @Test
  public void spiral_1() {
    int[][] expected = {{1}};
    int size = 1;
    int[][] result = SpiralArray.genSpiral(size);
    System.out.format(
            "%s: The spiral array with dimensions %dx%d:\n", name.getMethodName(), size, size);
    SpiralArray.printSpiral(result);
    for (int index = 0; index < size; index++) {
      assertEquals(Arrays.toString(expected[index]), Arrays.toString(result[index]));
    }
  }

  @Test
  public void spiral_2() {
    int[][] expected = {
            {1, 2},
            {4, 3}
    };
    int size = 2;
    int[][] result = SpiralArray.genSpiral(size);
    System.out.format(
            "%s: The spiral array with dimensions %dx%d:\n", name.getMethodName(), size, size);
    SpiralArray.printSpiral(result);
    for (int index = 0; index < size; index++) {
      assertEquals(Arrays.toString(expected[index]), Arrays.toString(result[index]));
    }
  }

  @Test
  public void spiral_3() {
    int[][] expected = {
            {1, 2, 3},
            {8, 9, 4},
            {7, 6, 5}
    };
    int size = 3;
    int[][] result = SpiralArray.genSpiral(size);
    System.out.format(
            "%s: The spiral array with dimensions %dx%d:\n", name.getMethodName(), size, size);
    SpiralArray.printSpiral(result);
    for (int index = 0; index < size; index++) {
      assertEquals(Arrays.toString(expected[index]), Arrays.toString(result[index]));
    }
  }

  @Test
  public void spiral_4() {
    int[][] expected = {
            {1, 2, 3, 4},
            {12, 13, 14, 5},
            {11, 16, 15, 6},
            {10, 9, 8, 7}
    };
    int size = 4;
    int[][] result = SpiralArray.genSpiral(size);
    System.out.format(
            "%s: The spiral array with dimensions %dx%d:\n", name.getMethodName(), size, size);
    SpiralArray.printSpiral(result);
    for (int index = 0; index < size; index++) {
      assertEquals(Arrays.toString(expected[index]), Arrays.toString(result[index]));
    }
  }

  @Test
  public void spiral_5() {
    int[][] expected = {
            {1, 2, 3, 4, 5},
            {16, 17, 18, 19, 6},
            {15, 24, 25, 20, 7},
            {14, 23, 22, 21, 8},
            {13, 12, 11, 10, 9}
    };
    int size = 5;
    int[][] result = SpiralArray.genSpiral(size);
    System.out.format(
            "%s: The spiral array with dimensions %dx%d:\n", name.getMethodName(), size, size);
    SpiralArray.printSpiral(result);
    for (int index = 0; index < size; index++) {
      assertEquals(Arrays.toString(expected[index]), Arrays.toString(result[index]));
    }
  }

  @Test
  public void spiral_6() {
    int[][] expected = {
            {1, 2, 3, 4, 5, 6},
            {20, 21, 22, 23, 24, 7},
            {19, 32, 33, 34, 25, 8},
            {18, 31, 36, 35, 26, 9},
            {17, 30, 29, 28, 27, 10},
            {16, 15, 14, 13, 12, 11}
    };
    int size = 6;
    int[][] result = SpiralArray.genSpiral(size);
    System.out.format(
            "%s: The spiral array with dimensions %dx%d:\n", name.getMethodName(), size, size);
    SpiralArray.printSpiral(result);
    for (int index = 0; index < size; index++) {
      assertEquals(Arrays.toString(expected[index]), Arrays.toString(result[index]));
    }
  }
}
