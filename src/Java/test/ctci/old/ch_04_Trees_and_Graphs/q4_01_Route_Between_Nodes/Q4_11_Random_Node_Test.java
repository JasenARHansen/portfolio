package Java.test.ctci.old.ch_04_Trees_and_Graphs.q4_01_Route_Between_Nodes;

import Java.code.ctci.old.ch_04_Trees_and_Graphs.BinaryTree;
import Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_11_Random_Node.Tree;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static Java.test.library.Library.printTestHeader;

@SuppressWarnings({"NewClassNamingConvention"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q4_11_Random_Node_Test {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void getRandomNode() {
        printTestHeader(name.getMethodName());
        int size = 10;
        int[] counts = new int[size];
        BinaryTree<Integer> leftTree = new BinaryTree<>();
        for (int i = 0; i < counts.length; i++) {
            leftTree.insert(i);
        }
        for (int i = 0; i < 1000; i++) {
            int d = leftTree.getRandomNode();
            counts[d]++;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.format("\t%d:%d\n", i, counts[i]);
        }
    }

    @Test
    public void getRandomNode_solution_1() {
        printTestHeader(name.getMethodName());
        int size = 10;
        int[] counts = new int[size];
        for (int i = 0; i < 1000; i++) {
            Tree tree = new Tree();
            List<Integer> digits = IntStream.range(0, size).boxed().collect(Collectors.toList());
            Collections.shuffle(digits);
            Integer[] array = digits.toArray(new Integer[0]);
            for (int x : array) {
                tree.insertInOrder(x);
            }
            int d = tree.getRandomNode().data;
            counts[d]++;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.format("\t%d:%d\n", i, counts[i]);
        }
    }
}
