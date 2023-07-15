package Java.test.interview.Facebook.practice;

import Java.code.interview.Facebook.practice.NodesInASubtree;
import Java.code.interview.Facebook.practice.NodesInASubtree.Node;
import Java.code.interview.Facebook.practice.NodesInASubtree.Query;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Arrays;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertArrayEquals;

@SuppressWarnings("SpellCheckingInspection")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NodesInASubtreeTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void countOfNodes_1() {
        int[] expected = {2};
        printTestHeader(name.getMethodName());
        String s_1 = "aba";
        Node root = new Node(1);
        root.children.add(new Node(2));
        root.children.add(new Node(3));
        ArrayList<Query> queries_1 = new ArrayList<>();
        queries_1.add(new Query(1, 'a'));
        int[] result = NodesInASubtree.countOfNodes(root, queries_1, s_1);
        assertArrayEquals(expected, result);
    }

    @Test
    public void countOfNodes_2() {
        int[] expected = {4, 1, 2};
        printTestHeader(name.getMethodName());
        String s_2 = "abaacab";
        Node root_2 = new Node(1);
        root_2.children.add(new Node(2));
        root_2.children.add(new Node(3));
        root_2.children.add(new Node(7));
        root_2.children.get(0).children.add(new Node(4));
        root_2.children.get(0).children.add(new Node(5));
        root_2.children.get(1).children.add(new Node(6));
        ArrayList<Query> queries_2 = new ArrayList<>();
        queries_2.add(new Query(1, 'a'));
        queries_2.add(new Query(2, 'b'));
        queries_2.add(new Query(3, 'a'));
        int[] result = NodesInASubtree.countOfNodes(root_2, queries_2, s_2);
        System.out.format("\tThe array %s\n", Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        NodesInASubtree.getDescription();
    }
}
