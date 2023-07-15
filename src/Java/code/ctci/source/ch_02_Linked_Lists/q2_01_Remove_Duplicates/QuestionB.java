package Java.code.ctci.source.ch_02_Linked_Lists.q2_01_Remove_Duplicates;

import Java.code.ctci.source.ctciLibrary.LinkedListNode;

@SuppressWarnings("DuplicatedCode")
public class QuestionB {
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
    }

    public static void deleteDuplicates(LinkedListNode head) {
        LinkedListNode current = head;
        while (current != null) {
            /* Remove all future nodes that have the same value. */
            LinkedListNode runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
}
