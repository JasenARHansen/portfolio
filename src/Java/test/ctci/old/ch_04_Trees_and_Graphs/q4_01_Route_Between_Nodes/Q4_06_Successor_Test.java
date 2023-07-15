package Java.test.ctci.old.ch_04_Trees_and_Graphs.q4_01_Route_Between_Nodes;

import Java.code.ctci.old.ch_04_Trees_and_Graphs.BinaryTree;
import Java.code.ctci.old.ch_04_Trees_and_Graphs.BinaryTree2;
import Java.code.ctci.old.ch_04_Trees_and_Graphs.BinaryTreeNode;
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
import static org.junit.Assert.assertNotNull;

@SuppressWarnings({"NewClassNamingConvention", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q4_06_Successor_Test {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void inorderSuccessor_other() {
        printTestHeader(name.getMethodName());
        BinaryTree<Integer> myTree = new BinaryTree<>();
        ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        System.out.format("\tInputs: %s\n", data);
        myTree.createMinimalBST(data);
        BinaryTreeNode<Integer> other = myTree.getRoot().getLeftChild();
        Integer result = myTree.inorderSuccessor(other);
        assertNotNull(result);
        System.out.format("\tThe successor of %s is %s\n", other.getData(), result);
    }

    @Test
    public void inorderSuccessor_root() {
        printTestHeader(name.getMethodName());
        BinaryTree<Integer> myTree = new BinaryTree<>();
        ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        System.out.format("\tInputs: %s\n", data);
        myTree.createMinimalBST(data);
        BinaryTreeNode<Integer> root = myTree.getRoot();
        Integer result = myTree.inorderSuccessor(root);
        assertNotNull(result);
        System.out.format("\tThe successor of %s is %s\n", root.getData(), result);
    }

    @Test
    public void inorderSuccessor_solution_1() {
        String expected = "(data: 5, Size: 1)";
        printTestHeader(name.getMethodName());
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        String result = root.toString();
        assertEquals(expected, result);
        for (int j : array) {
            TreeNode node = root.find(j);
            TreeNode next = BinaryTree2.inorderSuccessor(node);
            if (next != null) {
                System.out.format("\t%s->%s\n", node.data, next.data);
            } else {
                System.out.format("\t%s->null\n", node.data);
            }
        }
    }
}
