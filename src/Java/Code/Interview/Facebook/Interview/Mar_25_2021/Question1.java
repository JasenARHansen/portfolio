package Java.Code.Interview.Facebook.Interview.Mar_25_2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Question1 {

    public static void getDescription() {
        System.out.println("""
                Notes:
                  Assume nodes are not Null
                Given two nodes on a tree try and find the first ancestor they have in common. Nodes have pointers to their parent and their children.
                      A
                    /   \\
                   B     C
                  / \\    / \\
                 D   E F   G
                /        /
                H       I

                A: A
                C: A -> C
                Size left = 1
                Size right = 2
                Return the Node
                Space:
                O(log N)
                Worst case O(N)
                Memory Order N
                                
                Given an array of integers of length n, determine if the array consists exactly of the integers 0, 1, ..., n-1.
                [0, 2, 1]  True
                [0, 2, 3]  False
                [2, 1, 2]  False
                Assume array is not Null
                If no duplicates this could be O(C) but duplicated = O(N)""".indent(2));
    }

    public static Node commonAncestor(Node Left, Node Right) {
        List<Node> leftList = ancestorList(Left);
        List<Node> rightList = ancestorList(Right);

        int index = 0;
        int maxIndex = Math.min(rightList.size(), leftList.size());
        while ((index < maxIndex) && (leftList.get(index) == rightList.get(index))) {
            index++;
        }
        return leftList.get(index - 1);
    }

    private static List<Node> ancestorList(Node node) {
        List<Node> returnList = new ArrayList<>();
        returnList.add(node);
        Node working = node;
        while (working.parent != null) {
            working = working.parent;
            returnList.add(0, working);
        }

        return returnList;
    }

    public static boolean NValues(int... array) {
        Set<Integer> working = Arrays.stream(array).boxed().collect(Collectors.toSet());
        if (working.size() != array.length) {
            return false;
        }

        int index = 0;
        while (index < array.length) {
            if (!working.contains(index)) {
                return false;
            }
            index++;
        }
        return true;
    }

    public static boolean NValues_2(int... array) {
        // This can be done with constant memory by modifying the initial data source
        // requires that values be >= 0
        int swap;
        for (int index = 0; index < array.length; index++) {
            while (array[index] >= 0) {
                if (array[index] >= array.length) {
                    return false;
                }
                if (array[index] == index) {
                    array[index] = -1;
                } else {
                    if (array[index] == array[array[index]]) {
                        return false;
                    }
                    swap = array[array[index]];
                    array[array[index]] = array[index];
                    array[index] = swap;
                }
            }
        }
        return true;
    }

    public static class Node {
        public Node parent;
        public Node left;
        public Node right;
        public String data;

        public Node(String data) {
            this.data = data;
            this.parent = null;
            this.left = null;
            this.right = null;
        }
    }
}
