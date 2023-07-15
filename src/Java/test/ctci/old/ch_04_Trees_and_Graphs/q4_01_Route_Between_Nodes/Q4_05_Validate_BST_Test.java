package Java.test.ctci.old.ch_04_Trees_and_Graphs.q4_01_Route_Between_Nodes;

import Java.code.ctci.old.ch_04_Trees_and_Graphs.BinaryTree;
import Java.code.ctci.old.ch_04_Trees_and_Graphs.BinaryTree2;
import Java.code.ctci.source.ctciLibrary.TreeNode;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Arrays;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.*;

@SuppressWarnings({"NewClassNamingConvention", "DuplicatedCode", "ConstantValue"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q4_05_Validate_BST_Test {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void checkBST_false() {
        printTestHeader(name.getMethodName());
        ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 3, 6, 5, 4, 7, 2));
        BinaryTree<Integer> myTree = new BinaryTree<>();
        myTree.createMinimalBT(data);
        System.out.format("\tInputs: %s\n", data);
        boolean result = myTree.validateBST();
        assertFalse(result);
        System.out.format("\tValid: %b\n", result);
    }

    @Test
    public void checkBST_solution_1() {
        printTestHeader(name.getMethodName());
        int[] array = {
                Integer.MIN_VALUE, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE
        };
        TreeNode result = TreeNode.createMinimalBST(array);
        assertNotNull(result);
        System.out.format("\tBalanced: %b\n", BinaryTree2.checkBST_1(result));
        BinaryTree2.test();
    }

    @Test
    public void checkBST_solution_2() {
        printTestHeader(name.getMethodName());
        /* Simple test -- create one. */
        int[] array = {Integer.MIN_VALUE, 3, 5, 6, 10, 13, 15, Integer.MAX_VALUE};
        TreeNode node = TreeNode.createMinimalBST(array);
        node.print();
        boolean isBst = BinaryTree2.checkBST_2(node);
        System.out.println(isBst);
    }

    @Test
    public void checkBST_true() {
        printTestHeader(name.getMethodName());
        BinaryTree<Integer> myTree = new BinaryTree<>();
        ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        System.out.format("\tInputs: %s\n", data);
        myTree.createMinimalBST(data);
        boolean result = myTree.validateBST();
        assertTrue(result);
        System.out.format("\tValid: %b\n", result);
    }
}
