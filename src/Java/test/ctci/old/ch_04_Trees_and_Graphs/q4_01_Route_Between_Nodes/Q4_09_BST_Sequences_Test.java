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
import java.util.LinkedList;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.*;

@SuppressWarnings({"NewClassNamingConvention", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q4_09_BST_Sequences_Test {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void allSequences() {
        int expected = 20;
        printTestHeader(name.getMethodName());
        BinaryTree<Integer> myTree = new BinaryTree<>();
        ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        myTree.createMinimalBST(data);
        ArrayList<ArrayList<Integer>> result = myTree.allBSTBuildSequences();
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(expected, result.size());
        for (int i = 0; i < result.size(); i++) {
            {
                System.out.format("\tSequence %d: %s\n", i, result.get(i).toString());
            }
        }
    }

    @Test
    public void allSequences_solution_1() {
        String expected = "[[100, 1, 2, 3]]";
        printTestHeader(name.getMethodName());
        TreeNode node = new TreeNode(100);
        int[] array = {1, 2, 3};
        for (int a : array) {
            node.insertInOrder(a);
        }
        ArrayList<LinkedList<Integer>> result = BinaryTree2.allListSequences(node);
        assertEquals(expected, result.toString());
        for (LinkedList<Integer> list : result) {
            System.out.format("\tSequence: %s\n", list);
        }
        System.out.format("\tSize: %d\n", result.size());
    }
}
