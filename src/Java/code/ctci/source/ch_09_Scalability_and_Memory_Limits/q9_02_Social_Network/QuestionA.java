package Java.code.ctci.source.ch_09_Scalability_and_Memory_Limits.q9_02_Social_Network;

import java.util.*;

@SuppressWarnings("DuplicatedCode")
public class QuestionA {
    public static void main(String[] args) {
        int nPeople = 11;
        HashMap<Integer, Person> people = new HashMap<>();
        for (int i = 0; i < nPeople; i++) {
            Person p = new Person(i);
            people.put(i, p);
        }
        int[][] edges = {
                {1, 4}, {1, 2}, {1, 3}, {3, 2}, {4, 6}, {3, 7}, {6, 9}, {9, 10}, {5, 10}, {2, 5}, {3, 7}
        };
        for (int[] edge : edges) {
            Person source = people.get(edge[0]);
            source.addFriend(edge[1]);
            Person destination = people.get(edge[1]);
            destination.addFriend(edge[0]);
        }
        int i = 1;
        int j = 10;
        LinkedList<Person> path1 = findPathBFS(people, i, j);
        Tester.printPeople(path1);
    }

    public static LinkedList<Person> findPathBFS(
            HashMap<Integer, Person> people, int source, int destination) {
        Queue<PathNode> toVisit = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        toVisit.add(new PathNode(people.get(source), null));
        visited.add(source);
        while (!toVisit.isEmpty()) {
            PathNode node = toVisit.poll();
            Person person = node.getPerson();
            if (person.getID() == destination) {
                return node.collapse(false);
            }
            /* Search friends. */
            ArrayList<Integer> friends = person.getFriends();
            for (int friendId : friends) {
                if (!visited.contains(friendId)) {
                    visited.add(friendId);
                    Person friend = people.get(friendId);
                    toVisit.add(new PathNode(friend, node));
                }
            }
        }
        return null;
    }
}
