package Code.CTCI.other.Ch_04_Trees_and_Graphs.old;

import Code.unsorted.classes.classesInstance.BinarySearchTreeHeightBalanced;
import Code.unsorted.classes.classesInstance.Graph;
import Code.unsorted.classes.classesInstance.NodeGraph;
import Code.unsorted.classes.classesInstance.NodeTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Trees_And_Graphs {

    public static void getDescription() {
        System.out.println("Section 4. Trees And Graphs");
    }

    public static <T extends Comparable<T>> BinarySearchTreeHeightBalanced<T> convertToBST(
            T[] array) {
        BinarySearchTreeHeightBalanced<T> tree = new BinarySearchTreeHeightBalanced<>();
        Arrays.sort(array);
        convertToBST(0, array.length - 1, tree, array);
        return tree;
    }

    public static <X extends Comparable<X>, Y, Z> List<X> findPath(
            Graph<X, Y, Z> graph, NodeGraph<X, Y, Z> start, NodeGraph<X, Y, Z> stop) {
        return graph.findPathBredthFirstId(start, stop);
    }

    public static List<ArrayList<NodeTree<Integer>>> listOfDepths(
            BinarySearchTreeHeightBalanced<Integer> tree) {
        return tree.listByDepth();
    }

    private static <T extends Comparable<T>> void convertToBST(
            int start, int stop, BinarySearchTreeHeightBalanced<T> tree, T[] array) {

        // Determine mid point of range
        int middle = (start + stop) / 2;
        tree.insert(array[middle]);
        // Recursive step for sub range
        if (start != stop) {

            if (start < middle) {
                convertToBST(start, middle - 1, tree, array);
            }
            if (middle < stop) {
                convertToBST(middle + 1, stop, tree, array);
            }
        }
    }
}
