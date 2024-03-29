package Java.code.ctci.old.ch_04_Trees_and_Graphs;

import Java.code.unsorted.classes.classesInstance.BinarySearchTreeHeightBalanced;
import Java.code.unsorted.classes.classesInstance.Graph;
import Java.code.unsorted.classes.classesInstance.NodeGraph;
import Java.code.unsorted.classes.classesInstance.NodeTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class TreesAndGraphs {
    public static <T extends Comparable<T>> BinarySearchTreeHeightBalanced<T> convertToBST(
            T[] array) {
        BinarySearchTreeHeightBalanced<T> tree = new BinarySearchTreeHeightBalanced<>();
        Arrays.sort(array);
        convertToBST(0, array.length - 1, tree, array);
        return tree;
    }

    private static <T extends Comparable<T>> void convertToBST(
            int start, int stop, BinarySearchTreeHeightBalanced<T> tree, T[] array) {
        // Determine mid-point of range
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

    public static <X extends Comparable<X>, Y, Z> List<X> findPath(
            Graph<X, Y, Z> graph, NodeGraph<X, Y, Z> start, NodeGraph<X, Y, Z> stop) {
        return graph.findPathBreadthFirstId(start, stop);
    }

    public static void getDescription() {
        System.out.println("Section 4. Trees And Graphs");
    }

    public static List<ArrayList<NodeTree<Integer>>> listOfDepths(
            BinarySearchTreeHeightBalanced<Integer> tree) {
        return tree.listByDepth();
    }
}
