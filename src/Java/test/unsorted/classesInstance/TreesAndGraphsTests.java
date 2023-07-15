package Java.test.unsorted.classesInstance;

import Java.code.unsorted.classes.classesInstance.BinarySearchTreeHeightBalanced;
import Java.code.unsorted.classes.classesInstance.NodeTree;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.*;

@SuppressWarnings("ConstantValue")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TreesAndGraphsTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void BinarySearchTreeHeightBalanced_1() {
        printTestHeader(name.getMethodName());
        BinarySearchTreeHeightBalanced<Integer> result =
                new BinarySearchTreeHeightBalanced<>();
        assertNotNull(result);
        System.out.format("\t%s\n", result);
    }

    @Test
    public void BinarySearchTreeHeightBalanced_2() {
        printTestHeader(name.getMethodName());
        BinarySearchTreeHeightBalanced<Integer> result = new BinarySearchTreeHeightBalanced<>(5);
        assertNotNull(result);
        System.out.format("\t%s\n", result);
    }

    @Test
    public void clear() {
        printTestHeader(name.getMethodName());
        BinarySearchTreeHeightBalanced<Integer> result =
                new BinarySearchTreeHeightBalanced<>(5);
        int count_1 = result.countNodes();
        System.out.format("\tBefore: %s\n", result);
        result.clear();
        int count_2 = result.countNodes();
        assertNotEquals(count_1, count_2);
        System.out.format("\tAfter: %s\n", result);
    }

    @Test
    public void countNodes() {
        int expected = 1;
        printTestHeader(name.getMethodName());
        BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
                new BinarySearchTreeHeightBalanced<>(5);
        int count = binarySearchTreeHeightBalanced.countNodes();
        assertEquals(expected, count);
        System.out.format("\t%d\n", count);
    }

    @Test
    public void dataInorder() {
        String expected = "5 10 15";
        printTestHeader(name.getMethodName());
        BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
                new BinarySearchTreeHeightBalanced<>(5);
        binarySearchTreeHeightBalanced.insert(10);
        binarySearchTreeHeightBalanced.insert(15);
        String result = binarySearchTreeHeightBalanced.dataInorder();
        assertEquals(expected, result);
        System.out.format("\t%s\n", result);
    }

    @Test
    public void dataPostorder() {
        String expected = "5 15 10";
        printTestHeader(name.getMethodName());
        BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
                new BinarySearchTreeHeightBalanced<>(5);
        binarySearchTreeHeightBalanced.insert(10);
        binarySearchTreeHeightBalanced.insert(15);
        String result = binarySearchTreeHeightBalanced.dataPostorder();
        assertEquals(expected, result);
        System.out.format("\t%s\n", result);
    }

    @Test
    public void dataPreorder() {
        String expected = "10 5 15";
        printTestHeader(name.getMethodName());
        BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
                new BinarySearchTreeHeightBalanced<>(5);
        binarySearchTreeHeightBalanced.insert(10);
        binarySearchTreeHeightBalanced.insert(15);
        String result = binarySearchTreeHeightBalanced.dataPreorder();
        assertEquals(expected, result);
        System.out.format("\t%s\n", result);
    }

    @Test
    public void getRoot() {
        int expected = 10;
        printTestHeader(name.getMethodName());
        BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
                new BinarySearchTreeHeightBalanced<>(5);
        binarySearchTreeHeightBalanced.insert(10);
        binarySearchTreeHeightBalanced.insert(15);
        int result = binarySearchTreeHeightBalanced.getRoot().getData();
        assertEquals(expected, result);
        System.out.format("\t%d\n", result);
    }

    @Test
    public void insert() {
        int expected = 2;
        printTestHeader(name.getMethodName());
        BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
                new BinarySearchTreeHeightBalanced<>(5);
        binarySearchTreeHeightBalanced.insert(10);
        int count = binarySearchTreeHeightBalanced.countNodes();
        assertEquals(expected, count);
        System.out.format("\t%d\n", count);
    }

    @Test
    public void isEmpty() {
        printTestHeader(name.getMethodName());
        BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
                new BinarySearchTreeHeightBalanced<>(5);
        binarySearchTreeHeightBalanced.insert(10);
        binarySearchTreeHeightBalanced.insert(15);
        boolean result = binarySearchTreeHeightBalanced.isEmpty();
        assertFalse(result);
        System.out.format("\t%b\n", result);
    }

    @Test
    public void listByDepth() {
        String expected = "[[(data: 10, height: 1 )], [(data: 5, height: 0 ), (data: 15, height: 0 )]]";
        printTestHeader(name.getMethodName());
        BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
                new BinarySearchTreeHeightBalanced<>(5);
        binarySearchTreeHeightBalanced.insert(10);
        binarySearchTreeHeightBalanced.insert(15);
        List<ArrayList<NodeTree<Integer>>> data = binarySearchTreeHeightBalanced.listByDepth();
        String result = data.toString();
        assertEquals(expected, result);
        System.out.format("\t%s\n", result);
    }

    @Test
    public void minValue() {
        int expected = 5;
        printTestHeader(name.getMethodName());
        BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
                new BinarySearchTreeHeightBalanced<>(5);
        binarySearchTreeHeightBalanced.insert(10);
        binarySearchTreeHeightBalanced.insert(15);
        int result = binarySearchTreeHeightBalanced.minValue();
        assertEquals(expected, result);
        System.out.format("\t%b\n", result);
    }

    @Test
    public void remove() {
        String expected = "5 10";
        printTestHeader(name.getMethodName());
        BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
                new BinarySearchTreeHeightBalanced<>(5);
        binarySearchTreeHeightBalanced.insert(10);
        binarySearchTreeHeightBalanced.insert(15);
        binarySearchTreeHeightBalanced.remove(15);
        String result = binarySearchTreeHeightBalanced.dataInorder();
        assertEquals(expected, result);
        System.out.format("\t%s\n", result);
    }

    @Test
    public void rootValue() {
        int expected = 10;
        printTestHeader(name.getMethodName());
        BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
                new BinarySearchTreeHeightBalanced<>(5);
        binarySearchTreeHeightBalanced.insert(10);
        binarySearchTreeHeightBalanced.insert(15);
        int result = binarySearchTreeHeightBalanced.rootValue();
        assertEquals(expected, result);
        System.out.format("\t%d\n", result);
    }

    @Test
    public void search() {
        printTestHeader(name.getMethodName());
        BinarySearchTreeHeightBalanced<Integer> binarySearchTreeHeightBalanced =
                new BinarySearchTreeHeightBalanced<>(5);
        binarySearchTreeHeightBalanced.insert(10);
        binarySearchTreeHeightBalanced.insert(15);
        boolean result = binarySearchTreeHeightBalanced.search(5);
        assertTrue(result);
        System.out.format("\t%b\n", result);
    }
}
