package Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_07_Build_Order.edge_removal;

import java.util.ArrayList;
import java.util.HashMap;

public class Project {
    private final ArrayList<Project> children = new ArrayList<>();
    private final HashMap<String, Project> map = new HashMap<>();
    private final String name;
    private int dependencies = 0;

    public Project(String n) {
        name = n;
    }

    public void addNeighbor(Project node) {
        if (!map.containsKey(node.getName())) {
            children.add(node);
            map.put(node.getName(), node);
            node.incrementDependencies();
        }
    }

    public String getName() {
        return name;
    }

    public void incrementDependencies() {
        dependencies++;
    }

    public void decrementDependencies() {
        dependencies--;
    }

    public ArrayList<Project> getChildren() {
        return children;
    }

    public int getNumberDependencies() {
        return dependencies;
    }
}
