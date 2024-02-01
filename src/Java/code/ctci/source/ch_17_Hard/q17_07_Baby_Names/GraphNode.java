package Java.code.ctci.source.ch_17_Hard.q17_07_Baby_Names;

import java.util.ArrayList;
import java.util.HashMap;

@SuppressWarnings("UnusedReturnValue")
public class Node {
    private final int frequency;
    private final HashMap<String, Node> map;
    private final String name;
    private final ArrayList<Node> neighbors;
    private boolean visited = false;

    public Node(String nm, int freq) {
        name = nm;
        frequency = freq;
        neighbors = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean addNeighbor(Node node) {
        if (map.containsKey(node.getName())) {
            return false;
        }
        neighbors.add(node);
        map.put(node.getName(), node);
        return true;
    }

    public String getName() {
        return name;
    }

    public int getFrequency() {
        return frequency;
    }

    public ArrayList<Node> getNeighbors() {
        return neighbors;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setIsVisited(boolean v) {
        visited = v;
    }
}
