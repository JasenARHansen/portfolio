package Java.code.ctci.source.ch_09_Scalability_and_Memory_Limits.q9_02_Social_Network;

import java.util.LinkedList;

public class PathNode {
    private final Person person;
    private final PathNode previousNode;

    public PathNode(Person p, PathNode previous) {
        person = p;
        previousNode = previous;
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

    public Person getPerson() {
        return person;
    }
}
