package Java.Test.Interview.Facebook.Practice;

import static org.junit.Assert.assertEquals;

import Java.Code.Interview.Facebook.Practice.CountingTriangles;
import Java.Code.Interview.Facebook.Practice.CountingTriangles.Sides;
import java.util.ArrayList;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CountingTrianglesTests {
  @Rule public TestName name = new TestName();

  @Test
  public void CountingTriangles() {
    System.out.format("%s: ", name.getMethodName());
    CountingTriangles.getDescription();
  }

  @Test
  public void countDistinctTriangles_1() {
    int expected = 2;
    ArrayList<Sides> inputs = new ArrayList<>();
    inputs.add(new Sides(2, 2, 3));
    inputs.add(new Sides(3, 2, 2));
    inputs.add(new Sides(2, 5, 6));
    int result = CountingTriangles.countDistinctTriangles(inputs);
    System.out.format(
        "%s: The set %d triangles has %d distinct triangles.\n",
        name.getMethodName(), inputs.size(), result);
    assertEquals(expected, result);
  }

  @Test
  public void countDistinctTriangles_2() {
    int expected = 3;
    ArrayList<Sides> inputs = new ArrayList<>();
    inputs.add(new Sides(8, 4, 6));
    inputs.add(new Sides(100, 101, 102));
    inputs.add(new Sides(84, 96, 173));
    int result = CountingTriangles.countDistinctTriangles(inputs);
    System.out.format(
        "%s: The set %d triangles has %d distinct triangles.\n",
        name.getMethodName(), inputs.size(), result);
    assertEquals(expected, result);
  }

  @Test
  public void countDistinctTriangles_3() {
    int expected = 1;
    ArrayList<Sides> inputs = new ArrayList<>();
    inputs.add(new Sides(5, 8, 9));
    inputs.add(new Sides(5, 9, 8));
    inputs.add(new Sides(9, 5, 8));
    inputs.add(new Sides(9, 8, 5));
    inputs.add(new Sides(8, 9, 5));
    inputs.add(new Sides(8, 5, 9));
    int result = CountingTriangles.countDistinctTriangles(inputs);
    System.out.format(
        "%s: The set %d triangles has %d distinct triangles.\n",
        name.getMethodName(), inputs.size(), result);
    assertEquals(expected, result);
  }

  @Test
  public void countDistinctTriangles_4() {
    int expected = 3;
    ArrayList<Sides> inputs = new ArrayList<>();
    inputs.add(new Sides(7, 6, 5));
    inputs.add(new Sides(5, 7, 6));
    inputs.add(new Sides(8, 2, 9));
    inputs.add(new Sides(2, 3, 4));
    inputs.add(new Sides(2, 4, 3));
    int result = CountingTriangles.countDistinctTriangles(inputs);
    System.out.format(
        "%s: The set %d triangles has %d distinct triangles.\n",
        name.getMethodName(), inputs.size(), result);
    assertEquals(expected, result);
  }

  @Test
  public void countDistinctTriangles_5() {
    int expected = 3;
    ArrayList<Sides> inputs = new ArrayList<>();
    inputs.add(new Sides(3, 4, 5));
    inputs.add(new Sides(8, 8, 9));
    inputs.add(new Sides(7, 7, 7));
    int result = CountingTriangles.countDistinctTriangles(inputs);
    System.out.format(
        "%s: The set %d triangles has %d distinct triangles.\n",
        name.getMethodName(), inputs.size(), result);
    assertEquals(expected, result);
  }

  @Test
  public void countDistinctTriangles_6() {
    int expected = 2;
    int[][] inputs = new int[3][3];
    inputs[0] = new int[] {2, 2, 3};
    inputs[1] = new int[] {3, 2, 2};
    inputs[2] = new int[] {2, 5, 6};
    int result = CountingTriangles.countDistinctTriangles(inputs);
    System.out.format(
        "%s: The set %d triangles has %d distinct triangles.\n",
        name.getMethodName(), inputs.length, result);
    assertEquals(expected, result);
  }

  @Test
  public void countDistinctTriangles_7() {
    int expected = 3;
    int[][] inputs = new int[3][3];
    inputs[0] = new int[] {8, 4, 6};
    inputs[1] = new int[] {100, 101, 102};
    inputs[2] = new int[] {84, 96, 173};
    int result = CountingTriangles.countDistinctTriangles(inputs);
    System.out.format(
        "%s: The set %d triangles has %d distinct triangles.\n",
        name.getMethodName(), inputs.length, result);
    assertEquals(expected, result);
  }

  @Test
  public void countDistinctTriangles_8() {
    int expected = 1;
    int[][] inputs = new int[6][3];
    inputs[0] = new int[] {5, 8, 9};
    inputs[1] = new int[] {5, 9, 8};
    inputs[2] = new int[] {9, 5, 8};
    inputs[3] = new int[] {9, 8, 5};
    inputs[4] = new int[] {8, 9, 5};
    inputs[5] = new int[] {8, 5, 9};
    int result = CountingTriangles.countDistinctTriangles(inputs);
    System.out.format(
        "%s: The set %d triangles has %d distinct triangles.\n",
        name.getMethodName(), inputs.length, result);
    assertEquals(expected, result);
  }

  @Test
  public void countDistinctTriangles_9() {
    int expected = 3;
    int[][] inputs = new int[5][3];
    inputs[0] = new int[] {7, 6, 5};
    inputs[1] = new int[] {5, 7, 6};
    inputs[2] = new int[] {8, 2, 9};
    inputs[3] = new int[] {2, 3, 4};
    inputs[4] = new int[] {2, 4, 3};
    int result = CountingTriangles.countDistinctTriangles(inputs);
    System.out.format(
        "%s: The set %d triangles has %d distinct triangles.\n",
        name.getMethodName(), inputs.length, result);
    assertEquals(expected, result);
  }

  @Test
  public void countDistinctTriangles_10() {
    int expected = 3;
    int[][] inputs = new int[3][3];
    inputs[0] = new int[] {3, 4, 5};
    inputs[1] = new int[] {8, 8, 9};
    inputs[2] = new int[] {7, 7, 7};
    int result = CountingTriangles.countDistinctTriangles(inputs);
    System.out.format(
        "%s: The set %d triangles has %d distinct triangles.\n",
        name.getMethodName(), inputs.length, result);
    assertEquals(expected, result);
  }
}
