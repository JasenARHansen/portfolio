package CTCI_SOURCE.other.Ch_04_Trees_and_Graphs.Q4_07_Build_Order.DFS;

import java.util.ArrayList;
import java.util.HashMap;

public class Project {
    private final ArrayList<Project> children = new ArrayList<>();

    private final HashMap<String, Project> map = new HashMap<>();
    private final String name;
    private State state = State.BLANK;

    public Project(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void addNeighbor(Project node) {
        if (!map.containsKey(node.getName())) {
            children.add(node);
            map.put(node.getName(), node);
        }
    }

    public State getState() {
        return state;
    }

    public void setState(State st) {
        state = st;
    }

    public ArrayList<Project> getChildren() {
        return children;
    }

    public enum State {COMPLETE, PARTIAL, BLANK}
}
