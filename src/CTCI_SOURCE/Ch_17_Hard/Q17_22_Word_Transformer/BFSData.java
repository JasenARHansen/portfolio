package CTCI_SOURCE.Ch_17_Hard.Q17_22_Word_Transformer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFSData {
	public Queue<PathNode> toVisit = new LinkedList<>();
	public HashMap<String, PathNode> visited = new HashMap<>();

	public BFSData(String root) {
		PathNode sourcePath = new PathNode(root, null);
		toVisit.add(sourcePath);
		visited.put(root, sourcePath);
	}

	public boolean isFinished() {
		return toVisit.isEmpty();
	}
}

