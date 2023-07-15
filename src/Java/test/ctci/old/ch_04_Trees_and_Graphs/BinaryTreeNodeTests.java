package Java.test.ctci.old.ch_04_Trees_and_Graphs;

import Java.code.ctci.old.ch_04_Trees_and_Graphs.BinaryTreeNode;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.*;

@SuppressWarnings({"ConstantValue", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BinaryTreeNodeTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void BinaryTreeNodeTree_1() {
        printTestHeader(name.getMethodName());
        BinaryTreeNode<Integer> result = new BinaryTreeNode<>();
        assertNotNull(result);
        System.out.format("\tNode: %s\n", result);
    }

    @Test
    public void BinaryTreeNodeTree_2() {
        printTestHeader(name.getMethodName());
        BinaryTreeNode<Integer> result = new BinaryTreeNode<>(10);
        assertNotNull(result);
        System.out.format("\tNode: %s\n", result);
    }

    @Test
    public void getData() {
        int expected = 10;
        printTestHeader(name.getMethodName());
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(expected);
        int result = node.getData();
        assertEquals(expected, result);
        System.out.format("\tData: %d\n", result);
    }

    @Test
    public void getHeight() {
        int expected = 0;
        printTestHeader(name.getMethodName());
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>();
        int result = node.getHeight();
        assertEquals(expected, result);
        System.out.format("\tHeight: %d\n", result);
    }

    @Test
    public void getLeftChild() {
        printTestHeader(name.getMethodName());
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> expected = new BinaryTreeNode<>();
        node.setLeftChild(expected);
        BinaryTreeNode<Integer> result = node.getLeftChild();
        assertEquals(expected, result);
        System.out.format("\tLeftChild: %s\n", result.toString());
    }

    @Test
    public void getRightChild() {
        printTestHeader(name.getMethodName());
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> expected = new BinaryTreeNode<>();
        node.setRightChild(expected);
        BinaryTreeNode<Integer> result = node.getRightChild();
        assertEquals(expected, result);
        System.out.format("\tRightChild: %s\n", result.toString());
    }

    @Test
    public void getWeight() {
        int expected = 0;
        printTestHeader(name.getMethodName());
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>();
        int data = node.getWeight();
        assertEquals(expected, data);
        System.out.format("\tWeight: %d\n", data);
    }

    @Test
    public void hasLeftChild() {
        printTestHeader(name.getMethodName());
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> child = new BinaryTreeNode<>();
        boolean expected_1 = node.hasLeftChild();
        node.setLeftChild(child);
        boolean expected_2 = node.hasLeftChild();
        assertFalse(expected_1);
        assertTrue(expected_2);
        System.out.format("\tLeftChild: %b - %b\n", expected_1, expected_2);
    }

    @Test
    public void hasRightChild() {
        printTestHeader(name.getMethodName());
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> child = new BinaryTreeNode<>();
        boolean expected_1 = node.hasRightChild();
        node.setRightChild(child);
        boolean expected_2 = node.hasRightChild();
        assertFalse(expected_1);
        assertTrue(expected_2);
        System.out.format("\tRightChild: %b - %b\n", expected_1, expected_2);
    }

    @Test
    public void setData() {
        int expected_1 = 10;
        int expected_2 = 15;
        printTestHeader(name.getMethodName());
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(expected_1);
        node.setData(expected_2);
        int result = node.getData();
        assertNotEquals(expected_1, result);
        assertEquals(expected_2, result);
        System.out.format("\tData: %d\n", result);
    }

    @Test
    public void setHeight() {
        int expected = 15;
        printTestHeader(name.getMethodName());
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>();
        int result_1 = node.getHeight();
        node.setHeight(expected);
        int result_2 = node.getHeight();
        assertNotEquals(expected, result_1);
        assertEquals(expected, result_2);
        System.out.format("\tHeight: %d\n", result_2);
    }

    @Test
    public void setLeftChild() {
        printTestHeader(name.getMethodName());
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> child = new BinaryTreeNode<>();
        boolean result_1 = node.hasLeftChild();
        node.setLeftChild(child);
        boolean result_2 = node.hasLeftChild();
        assertFalse(result_1);
        assertTrue(result_2);
        System.out.format("\tLeftChild: %b - %b\n", result_1, result_2);
    }

    @Test
    public void setRightChild() {
        printTestHeader(name.getMethodName());
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> child = new BinaryTreeNode<>();
        boolean result_1 = node.hasRightChild();
        node.setRightChild(child);
        boolean result_2 = node.hasRightChild();
        assertFalse(result_1);
        assertTrue(result_2);
        System.out.format("\tRightChild: %b - %b\n", result_1, result_2);
    }

    @Test
    public void to_string() {
        printTestHeader(name.getMethodName());
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(5);
        System.out.format("\ttoString: %s\n", node);
    }
}
