package Code.CTCI_SOURCE.other.Ch_09_Scalability_and_Memory_Limits.Q9_02_Social_Network;

import java.util.LinkedList;

public class PathNode {
    private final Person person;
    private final PathNode previousNode;

    public PathNode(Person p, PathNode previous) {
        person = p;
        previousNode = previous;
    }

    public Person getPerson() {
        return person;
    }

    public LinkedList<Person> collapse(boolean startsWithRoot) {
        LinkedList<Person> path = new LinkedList<>();
        PathNode node = this;
        while (node != null) {
            if (startsWithRoot) {
                path.addLast(node.person);
            } else {
                path.addFirst(node.person);
            }
            node = node.previousNode;
        }
        return path;
    }
}
