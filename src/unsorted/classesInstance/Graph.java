package unsorted.classesInstance;

import java.util.Queue;
import java.util.*;

@SuppressWarnings("unchecked")
public class Graph<X extends Comparable<X>, Y, Z> {

    private final HashMap<X, NodeGraph<X, Y, Z>> mapNodes;
    private Object id;

    public Graph() {
        this.mapNodes = new HashMap<>();
    }

    public Graph(Object id) {
        this();
        this.id = id;
    }

    public void addNode(Object... values) {
        X id = null;
        Y data = null;

        if (values.length > 0) {
            if ((values[0] instanceof NodeGraph<?, ?, ?>)) {
                id = ((NodeGraph<X, Y, Z>) values[0]).getId();
            } else {
                id = (X) values[0];
            }
        }

        if (values.length > 1) {
            data = (Y) values[1];
        }

        if (mapNodes.containsKey(id)) {
            if (mapNodes.get(id).getData() == null) {
                System.err.format("Graph already contains a node with id '%s'\n", id);
            } else {
                System.err.format("Graph already contains a node with id '%s' and data '%s'\n", id,
                        mapNodes.get(id).getData());
            }
        } else {
            if ((values[0] instanceof NodeGraph<?, ?, ?>)) {
                mapNodes.put(id, (NodeGraph<X, Y, Z>) values[0]);
            } else {
                mapNodes.put(id, new NodeGraph<>(id, data));
            }
        }
    }

    public List<X> bredthFirstId(Object startPoint) {
        if (startPoint == null) {
            System.err.format("Starting Point not provided.'\n");
            return null;
        }

        Object id;
        if (startPoint instanceof NodeGraph<?, ?, ?>) {
            id = ((NodeGraph<?, ?, ?>) startPoint).getId();
        } else {
            id = startPoint;
        }

        List<X> path = new ArrayList<>();
        Set<X> visited = new HashSet<>();
        Queue<X> queue = new LinkedList<>(mapNodes.get(startPoint).getAdjacencyList());
        visited.add((X) id);

        while (!queue.isEmpty()) {
            X local = queue.remove();
            path.add(local);
            visited.add(local);
            for (X edgeId : mapNodes.get(local).getAdjacencyList()) {
                if (!visited.contains(edgeId)) {
                    queue.add(edgeId);
                    visited.add(edgeId);
                }
            }
        }
        return path;
    }

    public List<NodeGraph<?, ?, ?>> bredthFirstNode(Object startPoint) {
        List<X> ids = bredthFirstId(startPoint);
        List<NodeGraph<?, ?, ?>> nodes = new ArrayList<>();
        for (X id : ids) {
            nodes.add(mapNodes.get(id));
        }
        return nodes;
    }

    public List<X> findPathBredthFirstId(Object startPoint, Object endPoint) {
        X startId;
        X stopId;

        if (startPoint instanceof NodeGraph<?, ?, ?>) {
            startId = (X) ((NodeGraph<?, ?, ?>) startPoint).getId();
        } else {
            startId = (X) startPoint;
        }
        if (endPoint instanceof NodeGraph<?, ?, ?>) {
            stopId = (X) ((NodeGraph<?, ?, ?>) endPoint).getId();
        } else {
            stopId = (X) endPoint;
        }

        List<X> path = new ArrayList<>();
        Queue<X> queue = new LinkedList<>();
        Set<X> visited = new HashSet<>();
        Map<X, X> parent = new HashMap<>();

        boolean found = false;

        if (startId.compareTo(stopId) == 0) {
            found = true;
        }

        for (X edgeId : mapNodes.get(startId).getAdjacencyList()) {
            if (!parent.containsKey(edgeId)) {
                parent.put(edgeId, startId);
                queue.add(edgeId);
            }
        }
        visited.add(startId);

        while ((!found) && (!queue.isEmpty())) {
            X local = queue.remove();

            if (local.compareTo(stopId) == 0) {
                found = true;
                break;
            }

            for (X edgeId : mapNodes.get(local).getAdjacencyList()) {
                if (!visited.contains(edgeId)) {
                    if (!parent.containsKey(edgeId)) {
                        parent.put(edgeId, local);
                    }
                    if (!queue.contains(edgeId)) {
                        queue.add(edgeId);
                    }
                }
            }
            visited.add(local);
        }

        if (found) {
            X local = stopId;
            path.add(local);
            while (true) {
                local = parent.get(local);
                path.add(0, local);
                if (local.compareTo(startId) == 0) {
                    break;
                }
            }
        }
        return path;
    }

    public List<NodeGraph<?, ?, ?>> findPathBredthFirstNode(Object startPoint, Object endPoint) {
        List<X> ids = findPathBredthFirstId(startPoint, endPoint);
        List<NodeGraph<?, ?, ?>> nodes = new ArrayList<>();
        for (X id : ids) {
            nodes.add(mapNodes.get(id));
        }
        return nodes;
    }

    public List<List<X>> findPathDepthFirstAllId(Object... values) {
        Object startPoint = null;
        Object endPoint = null;

        if (values.length > 0) {
            startPoint = values[0];
        }
        if (values.length > 1) {
            endPoint = values[1];
        }

        X startId;
        X stopId = null;

        if (startPoint instanceof NodeGraph<?, ?, ?>) {
            startId = (X) ((NodeGraph<?, ?, ?>) startPoint).getId();
        } else {
            startId = (X) startPoint;
        }

        if (endPoint == null) {
        } else if (endPoint instanceof NodeGraph<?, ?, ?>) {
            stopId = (X) ((NodeGraph<?, ?, ?>) endPoint).getId();
        } else {
            stopId = (X) endPoint;
        }

        List<List<X>> paths = new ArrayList<>();
        Set<X> visited = new HashSet<>();
        Map<X, X> parent = new HashMap<>();

        findPathDepthFirstRecursiveId(startId, startId, stopId, visited, parent, paths, false);
        return paths;
    }

    public List<List<NodeGraph<?, ?, ?>>> findPathDepthFirstAllNode(Object startPoint, Object endPoint) {
        List<List<X>> pathsId = findPathDepthFirstAllId(startPoint, endPoint);
        List<List<NodeGraph<?, ?, ?>>> paths = new ArrayList<>();
        for (List<X> pathId : pathsId) {
            List<NodeGraph<?, ?, ?>> path = new ArrayList<>();
            for (X id : pathId) {
                path.add(mapNodes.get(id));
            }
            paths.add(path);
        }
        return paths;
    }

    public List<X> findPathDepthFirstLongestId(Object startPoint, Object endPoint) {
        X startId = null;
        X stopId = null;

        if (startPoint instanceof NodeGraph<?, ?, ?>) {
            startId = (X) ((NodeGraph<?, ?, ?>) startPoint).getId();
        } else {
            startId = (X) startPoint;
        }
        if (endPoint instanceof NodeGraph<?, ?, ?>) {
            stopId = (X) ((NodeGraph<?, ?, ?>) endPoint).getId();
        } else {
            stopId = (X) endPoint;
        }

        List<List<X>> paths = new ArrayList<>();
        Set<X> visited = new HashSet<>();
        Map<X, X> parent = new HashMap<>();

        findPathDepthFirstRecursiveId(startId, startId, stopId, visited, parent, paths, false);
        int test = Integer.MIN_VALUE;
        int found = -1;

        for (int i = 0; i < paths.size(); i++) {
            if (paths.get(i).size() > test) {
                found = i;
                test = paths.get(i).size();
            }

        }
        return paths.get(found);
    }

    public List<NodeGraph<?, ?, ?>> findPathDepthFirstLongestNode(Object startPoint, Object endPoint) {
        List<X> ids = findPathDepthFirstLongestId(startPoint, endPoint);
        List<NodeGraph<?, ?, ?>> nodes = new ArrayList<>();
        for (X id : ids) {
            nodes.add(mapNodes.get(id));
        }
        return nodes;
    }

    private void findPathDepthFirstRecursiveId(X startId, X currentId, X stopId, Set<X> visited, Map<X, X> parent,
                                               List<List<X>> paths, boolean terminateOnFirst) {
        if (mapNodes.isEmpty()) {
            return;
        }

        if (stopId == null) {
            // Check to see if all adjacent nodes have been visited. If they
            // have we are at a terminal node and I can make a path. and return,
            boolean generatePath = true;
            for (X edgeId : mapNodes.get(currentId).getAdjacencyList()) {
                if (!visited.contains(edgeId)) {
                    generatePath = false;
                    break;
                }
            }

            if (generatePath) {
                ArrayList<X> returnList = new ArrayList<>();
                X local = currentId;
                while (local != null) {
                    if (local.compareTo(startId) == 0) {
                        break;
                    } else {
                        returnList.add(0, local);
                    }
                    local = parent.get(local);
                }
                returnList.add(0, startId);
                paths.add(returnList);
            }
        }

        if ((stopId != null) && (currentId.compareTo(stopId) == 0)) {
            ArrayList<X> returnList = new ArrayList<>();
            X local = stopId;
            returnList.add(local);
            while (true) {
                local = parent.get(local);
                returnList.add(0, local);
                if (local.compareTo(startId) == 0) {
                    break;
                }
            }
            paths.add(returnList);
        } else {
            visited.add(currentId);
            for (X edgeId : mapNodes.get(currentId).getAdjacencyList()) {
                if (!visited.contains(edgeId)) {
                    parent.put(edgeId, currentId);
                    findPathDepthFirstRecursiveId(startId, edgeId, stopId, visited, parent, paths, terminateOnFirst);
                    if (terminateOnFirst && !paths.isEmpty()) {
                        return;
                    }
                }
            }
            visited.remove(currentId);
        }
    }

    public List<X> findPathDepthFirstShortestId(Object startPoint, Object endPoint, boolean terminateOnFirst) {
        X startId;
        X stopId;

        if (startPoint instanceof NodeGraph<?, ?, ?>) {
            startId = (X) ((NodeGraph<?, ?, ?>) startPoint).getId();
        } else {
            startId = (X) startPoint;
        }
        if (endPoint instanceof NodeGraph<?, ?, ?>) {
            stopId = (X) ((NodeGraph<?, ?, ?>) endPoint).getId();
        } else {
            stopId = (X) endPoint;
        }

        List<List<X>> paths = new ArrayList<>();
        Set<X> visited = new HashSet<>();
        Map<X, X> parent = new HashMap<>();

        findPathDepthFirstRecursiveId(startId, startId, stopId, visited, parent, paths, terminateOnFirst);
        int test = Integer.MAX_VALUE;
        int found = -1;

        for (int i = 0; i < paths.size(); i++) {
            if (paths.get(i).size() < test) {
                found = i;
                test = paths.get(i).size();
            }

        }
        if (found >= 0) {
            return paths.get(found);
        } else {
            return new ArrayList<>();
        }
    }

    public List<NodeGraph<?, ?, ?>> findPathDepthFirstShortestNode(Object startPoint, Object endPoint) {
        List<X> ids = findPathDepthFirstShortestId(startPoint, endPoint, false);
        List<NodeGraph<?, ?, ?>> nodes = new ArrayList<>();
        for (X id : ids) {
            nodes.add(mapNodes.get(id));
        }
        return nodes;
    }

    public Object getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public List<X> getNodes() {
        return new ArrayList<>(mapNodes.keySet());
    }

    public int getSize() {
        return mapNodes.size();
    }

    public boolean pathExistsPathBredthFirst(Object startPoint, Object endPoint) {
        return findPathBredthFirstId(startPoint, endPoint).size() != 0;
    }

    public boolean pathExistsPathDepthFirst(Object startPoint, Object endPoint) {
        return findPathDepthFirstShortestId(startPoint, endPoint, true).size() != 0;
    }

    public void printGraphBredthFirstId(Object startPoint) {
        String returnString = String.format("%s: -> %s", startPoint,
                bredthFirstId(startPoint).toString().replace("[", "").replace("]", ""));
        System.out.println(returnString);
    }

    public void printGraphBredthFirstNode(Object startPoint) {
        String returnString = String.format("%s: -> %s", startPoint,
                bredthFirstNode(startPoint).toString().replace("[", "").replace("]", ""));
        System.out.println(returnString);
    }

    public void printPathBredthFirstId(Object startPoint, Object endPoint) {
        String returnString;
        List<X> returnTest = findPathBredthFirstId(startPoint, endPoint);
        if (returnTest.isEmpty()) {
            returnString = String.format("%s:%s -> %s", startPoint, endPoint, "No Path");
        } else {
            returnString = String.format("%s:%s -> %s", startPoint, endPoint,
                    returnTest.toString().replace("[", "").replace("]", ""));
        }
        System.out.println(returnString);
    }

    public void printPathBredthFirstNode(Object startPoint, Object endPoint) {
        String returnString;
        List<NodeGraph<?, ?, ?>> returnTest = findPathBredthFirstNode(startPoint, endPoint);
        if (returnTest.isEmpty()) {
            returnString = String.format("%s:%s -> %s", startPoint, endPoint, "No Path");
        } else {
            returnString = String.format("%s:%s -> %s", startPoint, endPoint,
                    returnTest.toString().replace("[", "").replace("]", ""));
        }
        System.out.println(returnString);
    }

    public void printPathDepthFirstAllId(Object startPoint, Object endPoint) {
        StringBuilder returnString;
        List<List<X>> returnTest = findPathDepthFirstAllId(startPoint, endPoint);

        if (returnTest.isEmpty()) {
            returnString = new StringBuilder(String.format("%s:%s -> %s", startPoint, endPoint, "No Path"));
        } else {
            returnString = new StringBuilder(String.format("Paths for %s->%s", startPoint, endPoint));
            for (int i = 0; i < returnTest.size(); i++) {
                String pathString = String.format("\n\t%d:\t%s", i + 1,
                        returnTest.get(i).toString().replace("[", "").replace("]", ""));
                returnString.append(pathString);
            }
        }
        System.out.println(returnString);
    }

    public void printPathDepthFirstAllNode(Object... values) {
        Object startPoint = null;
        Object endPoint = null;

        if (values.length > 0) {
            startPoint = values[0];
        }
        if (values.length > 1) {
            endPoint = values[1];
        }

        StringBuilder returnString;
        List<List<NodeGraph<?, ?, ?>>> returnTest = findPathDepthFirstAllNode(startPoint, endPoint);

        if (returnTest.isEmpty()) {
            if (endPoint == null) {
                returnString = new StringBuilder(String.format("%s: -> %s", startPoint, "No Path"));
            } else {
                returnString = new StringBuilder(String.format("%s:%s -> %s", startPoint, endPoint, "No Path"));
            }
        } else {
            if (endPoint == null) {
                returnString = new StringBuilder(String.format("Paths for %s", startPoint));
            } else {
                returnString = new StringBuilder(String.format("Paths for %s->%s", startPoint, endPoint));
            }
            for (int i = 0; i < returnTest.size(); i++) {
                String pathString = String.format("\n\t%d:\t%s", i + 1,
                        returnTest.get(i).toString().replace("[", "").replace("]", ""));
                returnString.append(pathString);
            }
        }
        System.out.println(returnString);
    }

    public void printPathDepthFirstLongestId(Object startPoint, Object endPoint) {
        String returnString;
        List<X> returnTest = findPathDepthFirstLongestId(startPoint, endPoint);
        if (returnTest.isEmpty()) {
            returnString = String.format("%s:%s -> %s", startPoint, endPoint, "No Path");
        } else {
            returnString = String.format("%s:%s -> %s", startPoint, endPoint,
                    returnTest.toString().replace("[", "").replace("]", ""));
        }
        System.out.println(returnString);
    }

    public void printPathDepthFirstLongestNode(Object startPoint, Object endPoint) {
        String returnString;
        List<NodeGraph<?, ?, ?>> returnTest = findPathDepthFirstLongestNode(startPoint, endPoint);
        if (returnTest.isEmpty()) {
            returnString = String.format("%s:%s -> %s", startPoint, endPoint, "No Path");
        } else {
            returnString = String.format("%s:%s -> %s", startPoint, endPoint,
                    returnTest.toString().replace("[", "").replace("]", ""));
        }
        System.out.println(returnString);
    }

    public void printPathDepthFirstShortestId(Object startPoint, Object endPoint) {
        String returnString;
        List<X> returnTest = findPathDepthFirstShortestId(startPoint, endPoint, false);
        if (returnTest.isEmpty()) {
            returnString = String.format("%s:%s -> %s", startPoint, endPoint, "No Path");
        } else {
            returnString = String.format("%s:%s -> %s", startPoint, endPoint,
                    returnTest.toString().replace("[", "").replace("]", ""));
        }

        System.out.println(returnString);
    }

    public void printPathDepthFirstShortestNode(Object startPoint, Object endPoint) {
        String returnString;
        List<NodeGraph<?, ?, ?>> returnTest = findPathDepthFirstShortestNode(startPoint, endPoint);
        if (findPathDepthFirstShortestNode(startPoint, endPoint).isEmpty()) {
            returnString = String.format("%s:%s -> %s", startPoint, endPoint, "No Path");
        } else {
            returnString = String.format("%s:%s -> %s", startPoint, endPoint,
                    returnTest.toString().replace("[", "").replace("]", ""));
        }

        System.out.println(returnString);
    }

    public void setAdjacent(Object... values) {
        Object value1 = null;
        Object value2 = null;
        Object value3 = null;

        if (values.length > 0) {
            if (values[0] instanceof NodeGraph<?, ?, ?>) {
                value1 = ((NodeGraph<?, ?, ?>) values[0]).getId();
            } else {
                value1 = values[0];
            }
        }

        if (values.length > 1) {
            if (values[1] instanceof NodeGraph<?, ?, ?>) {
                value2 = ((NodeGraph<?, ?, ?>) values[1]).getId();
            } else {
                value2 = values[1];
            }
        }

        if (values.length > 2) {
            value3 = values[2];
        }

        if ((value1 == null) || (value2 == null)) {
            if (value1 == null) {
                System.err.format("Source node not provided");
            }
            if (value2 == null) {
                System.err.format("Adjacent node not provided");
            }
            return;
        }

        if (mapNodes.containsKey(value1) && mapNodes.containsKey(value2)) {
            mapNodes.get(value1).addAdjacent(value2, value3);
        } else {
            if (!mapNodes.containsKey(value1)) {
                System.err.format("Graph does not contain a node with id '%s'", value1);
            }
            if (!mapNodes.containsKey(value2)) {
                System.err.format("Graph does not contain a node with id '%s'", value2);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();
        if (getId() != null) {
            returnString.append(getId().toString()).append(" : (");
        } else {
            returnString.append("null : (");
        }
        List<X> forSorting = new ArrayList<>(mapNodes.keySet());
        Collections.sort(forSorting);
        if (forSorting.size() >= 1) {
            returnString.append(String.format("(node: %s, details: %s)", forSorting.get(0).toString(), mapNodes.get(forSorting.get(0)).toString()));
        }
        if (forSorting.size() > 1) {
            for (int i = 1; i < forSorting.size(); i++)
                returnString.append(String.format(", (node: %s, details: %s)", forSorting.get(i).toString(), mapNodes.get(forSorting.get(i)).toString()));
        }
        returnString.append(")");
        return returnString.toString();
    }
}
