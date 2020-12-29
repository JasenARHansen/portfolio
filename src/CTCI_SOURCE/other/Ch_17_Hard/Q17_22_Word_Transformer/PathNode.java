package CTCI_SOURCE.other.Ch_17_Hard.Q17_22_Word_Transformer;

import java.util.LinkedList;

public class PathNode {
    private String word;
    private PathNode previousNode;

    public PathNode(String word, PathNode previous) {
        this.word = word;
        previousNode = previous;
    }

    public String getWord() {
        return word;
    }

    /* Traverse path and return linked list of nodes. */
    public LinkedList<String> collapse(boolean startsWithRoot) {
        LinkedList<String> path = new LinkedList<>();
        PathNode node = this;
        while (node != null) {
            if (startsWithRoot) {
                path.addLast(node.word);
            } else {
                path.addFirst(node.word);
            }
            node = node.previousNode;
        }
        return path;
    }
}
