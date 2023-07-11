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
    System.out.format("%s: clear\n", name.getMethodName());
  }

  @Test
  public void countNodes() {
    BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
        new BinarySearchTreeHeightBalanced<>(5);
    int count = binarySearchTreeHeightBalanced.countNodes();
    assertEquals(1, count);
    System.out.format("%s: countNodes %d\n", name.getMethodName(), count);
  }

  @Test
  public void insert() {
    BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
        new BinarySearchTreeHeightBalanced<>(5);

    binarySearchTreeHeightBalanced.insert(10);
    int count = binarySearchTreeHeightBalanced.countNodes();
    assertEquals(2, count);
    System.out.format("%s: insert %d\n", name.getMethodName(), count);
  }

  @Test
  public void listByDepth() {
    BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
        new BinarySearchTreeHeightBalanced<>(5);

    binarySearchTreeHeightBalanced.insert(10);
    binarySearchTreeHeightBalanced.insert(15);
    List<ArrayList<NodeTree<Integer>>> data = binarySearchTreeHeightBalanced.listByDepth();
    String data_string = data.toString();
    assertEquals(
        "[[(data: 10, height: 1 )], [(data: 5, height: 0 ), (data: 15, height: 0 )]]", data_string);
    System.out.format("%s: listByDepth %s\n", name.getMethodName(), data_string);
  }

  @Test
  public void dataInorder() {
    BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
        new BinarySearchTreeHeightBalanced<>(5);

    binarySearchTreeHeightBalanced.insert(10);
    binarySearchTreeHeightBalanced.insert(15);
    String data = binarySearchTreeHeightBalanced.dataInorder();
    assertEquals("5 10 15", data);
    System.out.format("%s: dataInorder %s\n", name.getMethodName(), data);
  }

  @Test
  public void dataPostorder() {
    BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
        new BinarySearchTreeHeightBalanced<>(5);

    binarySearchTreeHeightBalanced.insert(10);
    binarySearchTreeHeightBalanced.insert(15);
    String data = binarySearchTreeHeightBalanced.dataPostorder();
    assertEquals("5 15 10", data);
    System.out.format("%s: dataPostorder %s\n", name.getMethodName(), data);
  }

  @Test
  public void dataPreorder() {
    BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
        new BinarySearchTreeHeightBalanced<>(5);

    binarySearchTreeHeightBalanced.insert(10);
    binarySearchTreeHeightBalanced.insert(15);
    String data = binarySearchTreeHeightBalanced.dataPreorder();
    assertEquals("10 5 15", data);
    System.out.format("%s: dataPreorder %s\n", name.getMethodName(), data);
  }

  @Test
  public void getRoot() {
    BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
        new BinarySearchTreeHeightBalanced<>(5);

    binarySearchTreeHeightBalanced.insert(10);
    binarySearchTreeHeightBalanced.insert(15);
    NodeTree<Integer> data = binarySearchTreeHeightBalanced.getRoot();
    assertEquals(10, (int) data.getData());
    System.out.format("%s: getRoot %d\n", name.getMethodName(), data.getData());
  }

  @Test
  public void rootValue() {
    BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
        new BinarySearchTreeHeightBalanced<>(5);

    binarySearchTreeHeightBalanced.insert(10);
    binarySearchTreeHeightBalanced.insert(15);
    int data = binarySearchTreeHeightBalanced.rootValue();
    assertEquals(10, data);
    System.out.format("%s: rootValue %d\n", name.getMethodName(), data);
  }

  @Test
  public void isEmpty() {
    BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
        new BinarySearchTreeHeightBalanced<>(5);

    binarySearchTreeHeightBalanced.insert(10);
    binarySearchTreeHeightBalanced.insert(15);
    boolean data = binarySearchTreeHeightBalanced.isEmpty();
    assertFalse(data);
    System.out.format("%s: isEmpty %b\n", name.getMethodName(), data);
  }

  @Test
  public void search() {
    BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
        new BinarySearchTreeHeightBalanced<>(5);

    binarySearchTreeHeightBalanced.insert(10);
    binarySearchTreeHeightBalanced.insert(15);
    boolean data = binarySearchTreeHeightBalanced.search(5);
    assertTrue(data);
    System.out.format("%s: search %b\n", name.getMethodName(), data);
  }

  @Test
  public void minValue() {
    BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
        new BinarySearchTreeHeightBalanced<>(5);

    binarySearchTreeHeightBalanced.insert(10);
    binarySearchTreeHeightBalanced.insert(15);
    int data = binarySearchTreeHeightBalanced.minValue();
    assertEquals(5, data);
    System.out.format("%s: minValue %b\n", name.getMethodName(), data);
  }

  @Test
  public void remove() {
    BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
        new BinarySearchTreeHeightBalanced<>(5);

    binarySearchTreeHeightBalanced.insert(10);
    binarySearchTreeHeightBalanced.insert(15);
    binarySearchTreeHeightBalanced.remove(15);
    String data = binarySearchTreeHeightBalanced.dataInorder();
    assertEquals("5 10", data);
    System.out.format("%s: remove %s\n", name.getMethodName(), data);
  }
}
