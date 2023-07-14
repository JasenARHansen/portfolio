package Java.test.ctci.old.ch_04_Trees_and_Graphs;

import static org.junit.Assert.*;

import Java.code.ctci.old.ch_04_Trees_and_Graphs.BinaryTree;
import Java.code.ctci.old.ch_04_Trees_and_Graphs.BinaryTreeNode;
import java.util.ArrayList;
import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"ConstantValue", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BinaryTreeTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void BinaryTree_1() {
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> result = new BinaryTree<>();
    assertNotNull(result);
    System.out.format("\tNode: %s\n", result);
  }

  @Test
  public void BinaryTree_2() {
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> result = new BinaryTree<>(5);
    assertNotNull(result);
    System.out.format("\tNode: %s\n", result);
  }

  @Test
  public void countNodes() {
    int expected = 1;
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    int result = binaryTree.countNodes();
    assertEquals(expected, result);
    System.out.format("\tNodes: %d\n", result);
  }

  @Test
  public void remove() {
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(15);
    int count_1 = binaryTree.countNodes();
    binaryTree.remove(15);
    int count_2 = binaryTree.countNodes();
    assertNotEquals(count_1, count_2);
    System.out.format("\tRemove: %d\n", count_2);
  }

  @Test
  public void insert() {
    int expected = 3;
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(15);
    int result = binaryTree.countNodes();
    assertEquals(expected, result);
    System.out.format("\tInsert: %d\n", result);
  }

  @Test
  public void rootValue() {
    int expected = 10;
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(15);
    int result = binaryTree.rootValue();
    assertEquals(expected, result);
    System.out.format("\tRoot: %d\n", result);
  }

  @Test
  public void search() {
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(15);
    boolean result = binaryTree.search(5);
    assertTrue(result);
    System.out.format("\tSearch: %b\n", result);
  }

  @Test
  public void isBalanced_1() {
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(15);
    boolean result = binaryTree.isBalanced();
    assertTrue(result);
    System.out.format("\tBalanced: %b\n", result);
  }

  @Test
  public void isBalanced_2() {
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(15);
    binaryTree.insert(20);
    binaryTree.insert(21);
    binaryTree.insert(22);
    binaryTree.insert(23);
    binaryTree.insert(24);
    boolean result = binaryTree.isBalanced();
    assertTrue(result);
    System.out.format("\tBalanced: %b\n", result);
  }

  @Test
  public void listByDepth() {
    String expected =
        "[[(data: 10, height: 1 , weight: 0)], [(data: 5, height: 0 , weight: 0), (data: 15, height: 0 , weight: 0)]]";
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(15);
    List<ArrayList<BinaryTreeNode<Integer>>> data = binaryTree.listByDepth();
    String result = data.toString();
    assertEquals(expected, result);
    System.out.format("\tlistByDepth: %s\n", result);
  }

  @Test
  public void printResultBFS() {
    String expected = "Level 0: 10\nLevel 1: 5 15";
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(15);
    String result = binaryTree.printResultBFS();
    assertEquals(expected, result);
    System.out.format("%s\n", result);
  }

  @Test
  public void printResultDFS() {
    String expected = "Level 0: 10\n" + "Level 1: 5 15";
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(15);
    String result = binaryTree.printResultDFS();
    assertEquals(expected, result);
    System.out.format("%s\n", result);
  }

  @Test
  public void dataBreadth() {
    String expected = "10 5 15";
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(15);
    String result = binaryTree.dataBreadth();
    assertEquals(expected, result);
    System.out.format("\tBreadth: %s\n", result);
  }

  @Test
  public void outputInorder() {
    String expected = "5 10 15";
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(15);
    String result = binaryTree.outputInorder();
    assertEquals(expected, result);
    System.out.format("\tInorde: %s\n", result);
  }

  @Test
  public void outputPreorder() {
    String expected = "10 5 15 14 16";
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(14);
    binaryTree.insert(15);
    binaryTree.insert(16);
    String result = binaryTree.outputPreorder();
    assertEquals(expected, result);
    System.out.format("\tPreorder: %s\n", result);
  }

  @Test
  public void outputPostorder() {
    String expected = "5 14 16 15 10";
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(14);
    binaryTree.insert(15);
    binaryTree.insert(16);
    String result = binaryTree.outputPostorder();
    assertEquals(expected, result);
    System.out.format("\tPostorder: %s\n", result);
  }

  @Test
  public void outputBreadth() {
    String expected = "10 5 15";
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(15);
    String result = binaryTree.outputBreadth();
    assertEquals(expected, result);
    System.out.format("\tBreadth: %s\n", result);
  }

  @Test
  public void isEmpty() {
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(15);
    boolean result = binaryTree.isEmpty();
    assertFalse(result);
    System.out.format("\tEmpty: %b\n", result);
  }

  @Test
  public void clear() {
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(15);
    binaryTree.clear();
    boolean result = binaryTree.isEmpty();
    assertTrue(result);
    System.out.format("\tClear: %b\n", result);
  }

  @Test
  public void maxValue() {
    int expected = 15;
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(15);
    int result = binaryTree.maxValue();
    assertEquals(expected, result);
    System.out.format("\tmaxValue: %d\n", result);
  }

  @Test
  public void minValue() {
    int expected = 5;
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(15);
    int result = binaryTree.minValue();
    assertEquals(expected, result);
    System.out.format("\tminValue: %d\n", result);
  }

  @Test
  public void getHeight() {
    int expected = 3;
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(14);
    binaryTree.insert(15);
    binaryTree.insert(16);
    binaryTree.insert(17);
    binaryTree.insert(18);
    binaryTree.insert(19);
    int result = binaryTree.getHeight();
    assertEquals(expected, result);
    System.out.format("\tHeight: %d\n", result);
  }

  @Test
  public void allBSTBuildSequences() {
    String expected =
        "[[10, 5, 15, 14, 16], [10, 15, 5, 14, 16], [10, 15, 14, 5, 16], [10, 15, 14, 16, 5]]";
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(14);
    binaryTree.insert(15);
    binaryTree.insert(16);
    ArrayList<ArrayList<Integer>> data = binaryTree.allBSTBuildSequences();
    String result = data.toString();
    assertEquals(expected, result);
    System.out.format("\tallBSTBuildSequences: %s\n", data);
  }

  @Test
  public void buildOrder() {
    String expected = "[10, 5, 15, 14, 16]";
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(14);
    binaryTree.insert(15);
    binaryTree.insert(16);
    ArrayList<Integer> data = binaryTree.buildOrder();
    String result = data.toString();
    assertEquals(expected, result);
    System.out.format("\tbuildOrder: %s\n", data);
  }

  @Test
  public void createMinimalBST() {
    String expected = "[14, 10, 16, 5, 15]";
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(14);
    binaryTree.insert(15);
    binaryTree.insert(16);
    ArrayList<Integer> data = binaryTree.buildOrder();
    BinaryTree<Integer> binaryTree_2 = new BinaryTree<>();
    binaryTree_2.createMinimalBST(data);
    ArrayList<Integer> data_2 = binaryTree_2.buildOrder();
    String result = data_2.toString();
    assertEquals(expected, result);
    System.out.format("\tMinimalBSTP: %s\n", result);
  }

  @Test
  public void createMinimalBT() {
    String expected = "[15, 5, 16, 10, 14]";
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(14);
    binaryTree.insert(15);
    binaryTree.insert(16);
    ArrayList<Integer> data = binaryTree.buildOrder();
    BinaryTree<Integer> binaryTree_2 = new BinaryTree<>();
    binaryTree_2.createMinimalBT(data);
    ArrayList<Integer> data_2 = binaryTree_2.buildOrder();
    String result = data_2.toString();
    assertEquals(expected, result);
    System.out.format("\tMinimalBT: %s\n", result);
  }

  @Test
  public void commonAncestorBST() {
    String expected = "(data: 5, height: 0 , weight: 0)";
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(14);
    binaryTree.insert(15);
    binaryTree.insert(16);
    BinaryTreeNode<Integer> data = binaryTree.commonAncestorBST(5, 15);
    String result = data.toString();
    assertEquals(expected, result);
    System.out.format("\tcommonAncestorBST: %s\n", data);
  }

  @Test
  public void findPathBST() {
    String expected = "[(data: 10, height: 2 , weight: 0), (data: 5, height: 0 , weight: 0)]";
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(14);
    binaryTree.insert(15);
    binaryTree.insert(16);
    ArrayList<BinaryTreeNode<Integer>> data = binaryTree.findPathBST(5);
    String result = data.toString();
    assertEquals(expected, result);
    System.out.format("\tPathBST: %s\n", data);
  }

  @Test
  public void findPathBT() {
    String expected = "[(data: 10, height: 2 , weight: 0), (data: 5, height: 0 , weight: 0)]";
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(14);
    binaryTree.insert(15);
    binaryTree.insert(16);
    ArrayList<BinaryTreeNode<Integer>> data = binaryTree.findPathBT(5);
    String result = data.toString();
    assertEquals(expected, result);
    System.out.format("\tPathBT: %s\n", data);
  }

  @Test
  public void commonAncestorBT() {
    String expected = "(data: 5, height: 0 , weight: 0)";
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(14);
    binaryTree.insert(15);
    binaryTree.insert(16);
    BinaryTreeNode<Integer> data = binaryTree.commonAncestorBT(5, 15);
    String result = data.toString();
    assertEquals(expected, result);
    System.out.format("\tcommonAncestorBT: %s\n", data);
  }

  @Test
  public void findNodeBST() {
    String expected = "(data: 5, height: 0 , weight: 0)";
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(14);
    binaryTree.insert(15);
    binaryTree.insert(16);
    BinaryTreeNode<Integer> data = binaryTree.findNodeBST(5);
    String result = data.toString();
    assertEquals(expected, result);
    System.out.format("\tNodeBST: %s\n", data);
  }

  @Test
  public void validateBST() {
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(14);
    binaryTree.insert(15);
    binaryTree.insert(16);
    boolean result = binaryTree.validateBST();
    assertTrue(result);
    System.out.format("\tvalidateBST: %b\n", result);
  }

  @Test
  public void inorderSuccessor() {
    int expected = 14;
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(14);
    binaryTree.insert(15);
    binaryTree.insert(16);
    BinaryTreeNode<Integer> data = binaryTree.getRoot();
    int result = binaryTree.inorderSuccessor(data);
    assertEquals(expected, result);
    System.out.format("\tinorderSuccessor: %d\n", result);
  }

  @Test
  public void countPathsWithSum() {
    int expected = 1;
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(14);
    binaryTree.insert(15);
    binaryTree.insert(16);
    int result = binaryTree.countPathsWithSum(15);
    assertEquals(expected, result);
    System.out.format("\tcountPathsWithSum: %d\n", result);
  }

  @Test
  public void getRandomNode() {
    System.out.format("%s:\n", name.getMethodName());
    BinaryTree<Integer> binaryTree = new BinaryTree<>(5);
    binaryTree.insert(10);
    binaryTree.insert(14);
    binaryTree.insert(15);
    binaryTree.insert(16);
    int result = binaryTree.getRandomNode();
    System.out.format("\tgetRandomNode: %d\n", result);
  }
}
