package Java.code.ctci.source.ch_02_Linked_Lists.q2_01_Remove_Duplicates;

import Java.code.ctci.source.ctciLibrary.LinkedListNode;

import java.util.HashSet;

@SuppressWarnings("DuplicatedCode")
public class QuestionA {
    public static void main(String[] args) {
        LinkedListNode first =
                new LinkedListNode(0, null, null); // AssortedMethods.randomLinkedList(1000, 0, 2);
        LinkedListNode head = first;
        LinkedListNode second;
        for (int i = 1; i < 8; i++) {
            second = new LinkedListNode(i % 2, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }
        System.out.println(head.printForward());
        deleteDuplicates(head);
        System.out.println(head.printForward());
    }

    public static void deleteDuplicates(LinkedListNode n) {
        HashSet<Integer> set = new HashSet<>();
        LinkedListNode previous = null;
        while (n != null) {
            if (set.contains(n.data)) {
                previous.next = n.next;
            } else {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }
}
