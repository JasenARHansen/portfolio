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
import static org.junit.Assert.assertEquals;

@SuppressWarnings({"NewClassNamingConvention", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q4_12_Paths_with_Sum_Test {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void countPathsWithSum() {
        int expected = 5;
        printTestHeader(name.getMethodName());
        BinaryTree<Integer> myTree = new BinaryTree<>();
        ArrayList<Integer> data =
                new ArrayList<>(Arrays.asList(-2, 4, 0, 2, -1, 3, 3, 1, 0, 1, 1, 3, 0, -1, 2));
        myTree.createMinimalBT(data);
        int sum = 5;
        int result = myTree.countPathsWithSum(sum);
        assertEquals(expected, result);
        System.out.format(
                "\tThe tree with values %s has %d paths that have a sum of %d\n", myTree, result, sum);
        assertEquals(5, result);
    }

    @Test
    public void countPathsWithSumSolution_1() {
        int[] expected = {15, 0};
        printTestHeader(name.getMethodName());
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.left.right = new TreeNode(0);
        root.right.right = new TreeNode(0);
        int[] data = {0, 4};
        for (int i = 0; i < data.length; i++) {
            int result = BinaryTree2.countPathsWithSum_solution_1(root, data[i]);
            assertEquals(expected[i], result);
            System.out.format("\t%d countPathsWithSum of %s from %S: %d\n", i, root, data[i], result);
        }
    }

    @Test
    public void countPathsWithSumSolution_2() {
        int[] expected = {15, 0};
        printTestHeader(name.getMethodName());
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.left.right = new TreeNode(0);
        root.right.right = new TreeNode(0);
        int[] data = {0, 4};
        for (int i = 0; i < data.length; i++) {
            int result = BinaryTree2.countPathsWithSum_solution_2(root, data[i]);
            assertEquals(expected[i], result);
            System.out.format("\t%d countPathsWithSum of %s from %S: %d\n", i, root, data[i], result);
        }
    }
}
