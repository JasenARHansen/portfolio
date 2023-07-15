package Java.code.ctci.source.ch_09_Scalability_and_Memory_Limits.q9_02_Social_Network;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("BooleanMethodIsAlwaysInverted")
public class BFSData {
    public final Queue<PathNode> toVisit = new LinkedList<>();
    public final HashMap<Integer, PathNode> visited = new HashMap<>();

    public BFSData(Person root) {
        PathNode sourcePath = new PathNode(root, null);
        toVisit.add(sourcePath);
        visited.put(root.getID(), sourcePath);
    }

    public boolean isFinished() {
        return toVisit.isEmpty();
    }
}
