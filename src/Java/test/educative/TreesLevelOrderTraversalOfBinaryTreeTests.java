package Java.test.educative;

import Java.code.educative.TreesLevelOrderTraversalOfBinaryTree;
import Java.code.educative.TreesLevelOrderTraversalOfBinaryTree.Node;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;

@SuppressWarnings("DuplicatedCode")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TreesLevelOrderTraversalOfBinaryTreeTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void level_order_traversal_1() {
        printTestHeader(name.getMethodName());
        Node N_25 = new Node(25);
        Node N_50 = new Node(50);
        Node N_75 = new Node(75);
        Node N_100 = new Node(100);
        Node N_200 = new Node(200);
        Node N_350 = new Node(350);
        // Make tree
        N_100.left = N_50;
        N_100.right = N_200;
        N_50.left = N_25;
        N_50.right = N_75;
        N_200.right = N_350;
        printTestHeader(name.getMethodName());
        String result = TreesLevelOrderTraversalOfBinaryTree.level_order_traversal(N_100);
        System.out.println(result);
    }
}
