package Java.test.ctci.old.ch_04_Trees_and_Graphs;

import static org.junit.Assert.*;

import Java.code.ctci.old.ch_04_Trees_and_Graphs.BinaryTreeNode;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"ConstantValue", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BinaryTreeNodeTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void BinaryTreeNodeTree_1() {
    BinaryTreeNode<Integer> node = new BinaryTreeNode<>();
    assertNotNull(node);
    System.out.format("%s:\n", name.getMethodName());
  }

  @Test
  public void BinaryTreeNodeTree_2() {
    BinaryTreeNode<Integer> node = new BinaryTreeNode<>(10);
    assertNotNull(node);
    System.out.format("%s:\n", name.getMethodName());
  }

  @Test
  public void getData() {
    int value = 10;
    BinaryTreeNode<Integer> node = new BinaryTreeNode<>(value);
    int data = node.getData();
    assertEquals(value, data);
    System.out.format("%s: getData %d\n", name.getMethodName(), data);
  }

  @Test
  public void setData() {
    int value_1 = 10;
    BinaryTreeNode<Integer> node = new BinaryTreeNode<>(value_1);
    int value_2 = 15;
    node.setData(value_2);
    int data = node.getData();
    assertNotEquals(value_1, data);
    assertEquals(value_2, data);
    System.out.format("%s: setData %d\n", name.getMethodName(), data);
  }

  @Test
  public void getHeight() {
    BinaryTreeNode<Integer> node = new BinaryTreeNode<>();
    int data = node.getHeight();
    assertEquals(0, data);
    System.out.format("%s: getHeight %d\n", name.getMethodName(), data);
  }

  @Test
  public void setHeight() {
    BinaryTreeNode<Integer> node = new BinaryTreeNode<>();
    int data_1 = node.getHeight();
    int value = 15;
    node.setHeight(value);
    int data_2 = node.getHeight();
    assertNotEquals(value, data_1);
    assertEquals(value, data_2);
    System.out.format("%s: setHeight %d\n", name.getMethodName(), data_2);
  }

  @Test
  public void getWeight() {
    BinaryTreeNode<Integer> node = new BinaryTreeNode<>();
    int data = node.getWeight();
    assertEquals(0, data);
    System.out.format("%s: getWeight %d\n", name.getMethodName(), data);
  }

  @Test
  public void setLeftChild() {
    BinaryTreeNode<Integer> node = new BinaryTreeNode<>();
    BinaryTreeNode<Integer> child = new BinaryTreeNode<>();
    boolean data_1 = node.hasLeftChild();
    node.setLeftChild(child);
    boolean data_2 = node.hasLeftChild();
    assertFalse(data_1);
    assertTrue(data_2);
    System.out.format("%s: setLeftChild %b - %b\n", name.getMethodName(), data_1, data_2);
  }

  @Test
  public void hasLeftChild() {
    BinaryTreeNode<Integer> node = new BinaryTreeNode<>();
    BinaryTreeNode<Integer> child = new BinaryTreeNode<>();
    boolean data_1 = node.hasLeftChild();
    node.setLeftChild(child);
    boolean data_2 = node.hasLeftChild();
    assertFalse(data_1);
    assertTrue(data_2);
    System.out.format("%s: hasLeftChild %b - %b\n", name.getMethodName(), data_1, data_2);
  }

  @Test
  public void getLeftChild() {
    BinaryTreeNode<Integer> node = new BinaryTreeNode<>();
    BinaryTreeNode<Integer> child = new BinaryTreeNode<>();
    node.setLeftChild(child);
    BinaryTreeNode<Integer> result = node.getLeftChild();
    assertEquals(child, result);
    System.out.format("%s: getLeftChild %s\n", name.getMethodName(), result.toString());
  }

  @Test
  public void setRightChild() {
    BinaryTreeNode<Integer> node = new BinaryTreeNode<>();
    BinaryTreeNode<Integer> child = new BinaryTreeNode<>();
    boolean data_1 = node.hasRightChild();
    node.setRightChild(child);
    boolean data_2 = node.hasRightChild();
    assertFalse(data_1);
    assertTrue(data_2);
    System.out.format("%s: setRightChild %b - %b\n", name.getMethodName(), data_1, data_2);
  }

  @Test
  public void hasRightChild() {
    BinaryTreeNode<Integer> node = new BinaryTreeNode<>();
    BinaryTreeNode<Integer> child = new BinaryTreeNode<>();
    boolean data_1 = node.hasRightChild();
    node.setRightChild(child);
    boolean data_2 = node.hasRightChild();
    assertFalse(data_1);
    assertTrue(data_2);
    System.out.format("%s: hasRightChild %b - %b\n", name.getMethodName(), data_1, data_2);
  }

  @Test
  public void getRightChild() {
    BinaryTreeNode<Integer> node = new BinaryTreeNode<>();
    BinaryTreeNode<Integer> child = new BinaryTreeNode<>();
    node.setRightChild(child);
    BinaryTreeNode<Integer> result = node.getRightChild();
    assertEquals(child, result);
    System.out.format("%s: getRightChild %s\n", name.getMethodName(), result.toString());
  }

  @Test
  public void print() {
    BinaryTreeNode<Integer> node = new BinaryTreeNode<>(5);
    System.out.format("%s: toString %s\n", name.getMethodName(), node);
  }
}
