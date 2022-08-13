package Code.Interview.Facebook.Practice;

import java.util.ArrayList;
import java.util.List;

public class NodesInASubtree {
    /*
    Nodes in a Subtree
    You are given a tree that contains N nodes, each containing an integer u which corresponds to a lowercase character c in the string s using 1-based indexing.
    You are required to answer Q queries of type [u, c], where u is an integer and c is a lowercase letter. The query result is the number of nodes in the subtree of node u containing c.
    Signature
    int[] countOfNodes(Node root, ArrayList<Query> queries, String s)
    Input
    A pointer to the root node, an array list containing Q queries of type [u, c], and a string s
    Constraints
    N and Q are the integers between 1 and 1,000,000
    u is a unique integer between 1 and N
    s is of the length of N, containing only lowercase letters
    c is a lowercase letter contained in string s
    Node 1 is the root of the tree
    Output
    An integer array containing the response to each query
    Example

            1(a)
            /   \
          2(b)  3(a)

    s = "aba"
    RootNode = 1
    query = [[1, 'a']]
    Note: Node 1 corresponds to first letter 'a', Node 2 corresponds to second letter of the string 'b', Node 3 corresponds to third letter of the string 'a'.
    output = [2]
    Both Node 1 and Node 3 contain 'a', so the number of nodes within the subtree of Node 1 containing 'a' is 2.
    */
    public static int[] countOfNodes(Node root, ArrayList<Query> queries, String s) {
        int[] count = new int[queries.size()];
        char[] characters = s.toCharArray();
        for (int index = 0; index < queries.size(); index++) {
            Query query = queries.get(index);
            // find node
            List<Node> search = new ArrayList<>();
            search.add(root);
            Node current = null;
            while (!search.isEmpty()) {
                current = search.remove(0);
                if (current.val == query.u) {
                    search.clear();
                } else {
                    search.addAll(current.children);
                }
            }
            search.add(current);
            while (!search.isEmpty()) {
                current = search.remove(0);
                search.addAll(current.children);
                if (query.c == characters[current.val - 1]) {
                    count[index]++;
                }
            }
        }
        return count;
    }

    // Tree Node
    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
            val = 0;
            children = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static class Query {
        int u;
        char c;

        public Query(int u, char c) {
            this.u = u;
            this.c = c;
        }
    }
}
