package Java.test.unsorted.classesInstance;

import static org.junit.Assert.*;

import Java.code.unsorted.classes.classesInstance.BinarySearchTreeHeightBalanced;
import Java.code.unsorted.classes.classesInstance.NodeTree;
import java.util.ArrayList;
import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings("ConstantValue")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TreesAndGraphsTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void BinarySearchTreeHeightBalanced_1() {
    BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
        new BinarySearchTreeHeightBalanced<>();
    assertNotNull(binarySearchTreeHeightBalanced);
    System.out.format("%s:\n", name.getMethodName());
  }

  @Test
  public void BinarySearchTreeHeightBalanced_2() {
    BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
        new BinarySearchTreeHeightBalanced<>(5);
    assertNotNull(binarySearchTreeHeightBalanced);
    System.out.format("%s:\n", name.getMethodName());
  }

  @Test
  public void clear() {
    BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
        new BinarySearchTreeHeightBalanced<>(5);
    int count_1 = binarySearchTreeHeightBalanced.countNodes();
    binarySearchTreeHeightBalanced.clear();
    int count_2 = binarySearchTreeHeightBalanced.countNodes();
    assertNotEquals(count_1, count_2);
    System.out.format("%s:\n", name.getMethodName());
  }

  @Test
  public void countNodes() {
    int expected = 1;
    BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
        new BinarySearchTreeHeightBalanced<>(5);
    int count = binarySearchTreeHeightBalanced.countNodes();
    assertEquals(expected, count);
    System.out.format("%s: %d\n", name.getMethodName(), count);
  }

  @Test
  public void insert() {
    int expected = 2;
    BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
        new BinarySearchTreeHeightBalanced<>(5);
    binarySearchTreeHeightBalanced.insert(10);
    int count = binarySearchTreeHeightBalanced.countNodes();
    assertEquals(expected, count);
    System.out.format("%s: %d\n", name.getMethodName(), count);
  }

  @Test
  public void listByDepth() {
    String expected = "[[(data: 10, height: 1 )], [(data: 5, height: 0 ), (data: 15, height: 0 )]]";
    BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
        new BinarySearchTreeHeightBalanced<>(5);
    binarySearchTreeHeightBalanced.insert(10);
    binarySearchTreeHeightBalanced.insert(15);
    List<ArrayList<NodeTree<Integer>>> data = binarySearchTreeHeightBalanced.listByDepth();
    String result = data.toString();
    assertEquals(expected, result);
    System.out.format("%s: %s\n", name.getMethodName(), result);
  }

  @Test
  public void dataInorder() {
    String expected = "5 10 15";
    BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
        new BinarySearchTreeHeightBalanced<>(5);
    binarySearchTreeHeightBalanced.insert(10);
    binarySearchTreeHeightBalanced.insert(15);
    String result = binarySearchTreeHeightBalanced.dataInorder();
    assertEquals(expected, result);
    System.out.format("%s: %s\n", name.getMethodName(), result);
  }

  @Test
  public void dataPostorder() {
    String expected = "5 15 10";
    BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
        new BinarySearchTreeHeightBalanced<>(5);
    binarySearchTreeHeightBalanced.insert(10);
    binarySearchTreeHeightBalanced.insert(15);
    String result = binarySearchTreeHeightBalanced.dataPostorder();
    assertEquals(expected, result);
    System.out.format("%s: %s\n", name.getMethodName(), result);
  }

  @Test
  public void dataPreorder() {
    String expected = "10 5 15";
    BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
        new BinarySearchTreeHeightBalanced<>(5);
    binarySearchTreeHeightBalanced.insert(10);
    binarySearchTreeHeightBalanced.insert(15);
    String result = binarySearchTreeHeightBalanced.dataPreorder();
    assertEquals(expected, result);
    System.out.format("%s: %s\n", name.getMethodName(), result);
  }

  @Test
  public void getRoot() {
    int expected = 10;
    BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
        new BinarySearchTreeHeightBalanced<>(5);
    binarySearchTreeHeightBalanced.insert(10);
    binarySearchTreeHeightBalanced.insert(15);
    int result = binarySearchTreeHeightBalanced.getRoot().getData();
    assertEquals(expected, result);
    System.out.format("%s: %d\n", name.getMethodName(), result);
  }

  @Test
  public void rootValue() {
    int expected = 10;
    BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
        new BinarySearchTreeHeightBalanced<>(5);
    binarySearchTreeHeightBalanced.insert(10);
    binarySearchTreeHeightBalanced.insert(15);
    int result = binarySearchTreeHeightBalanced.rootValue();
    assertEquals(expected, result);
    System.out.format("%s: %d\n", name.getMethodName(), result);
  }

  @Test
  public void isEmpty() {
    BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
        new BinarySearchTreeHeightBalanced<>(5);
    binarySearchTreeHeightBalanced.insert(10);
    binarySearchTreeHeightBalanced.insert(15);
    boolean result = binarySearchTreeHeightBalanced.isEmpty();
    assertFalse(result);
    System.out.format("%s: %b\n", name.getMethodName(), result);
  }

  @Test
  public void search() {
    BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
        new BinarySearchTreeHeightBalanced<>(5);
    binarySearchTreeHeightBalanced.insert(10);
    binarySearchTreeHeightBalanced.insert(15);
    boolean result = binarySearchTreeHeightBalanced.search(5);
    assertTrue(result);
    System.out.format("%s: %b\n", name.getMethodName(), result);
  }

  @Test
  public void minValue() {
    int expected = 5;
    BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
        new BinarySearchTreeHeightBalanced<>(5);
    binarySearchTreeHeightBalanced.insert(10);
    binarySearchTreeHeightBalanced.insert(15);
    int result = binarySearchTreeHeightBalanced.minValue();
    assertEquals(expected, result);
    System.out.format("%s: %b\n", name.getMethodName(), result);
  }

  @Test
  public void remove() {
    String expected = "5 10";
    BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
        new BinarySearchTreeHeightBalanced<>(5);
    binarySearchTreeHeightBalanced.insert(10);
    binarySearchTreeHeightBalanced.insert(15);
    binarySearchTreeHeightBalanced.remove(15);
    String result = binarySearchTreeHeightBalanced.dataInorder();
    assertEquals(expected, result);
    System.out.format("%s: %s\n", name.getMethodName(), result);
  }
}
