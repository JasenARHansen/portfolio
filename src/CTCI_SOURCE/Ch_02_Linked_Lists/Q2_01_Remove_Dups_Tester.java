package CTCI_SOURCE.Ch_02_Linked_Lists;

import CTCI.CtCILibrary.LinkedListNode;

public class Q2_01_Remove_Dups_Tester {

    public static void main(String[] args) throws CloneNotSupportedException {
        LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
        LinkedListNode head = first;
        LinkedListNode second;
        for (int i = 1; i < 8; i++) {
            second = new LinkedListNode(i % 2, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }
        System.out.println(head.printForward());

        LinkedListNode cloneA = head.clone();
        LinkedListNode cloneB = head.clone();
        LinkedListNode cloneC = head.clone();
        Q2_01_Remove_Dups_QuestionA.deleteDups(cloneA);
        Q2_01_Remove_Dups_QuestionA.deleteDups(cloneB);
        Q2_01_Remove_Dups_QuestionA.deleteDups(cloneC);

        System.out.println(cloneA.printForward());
        System.out.println(cloneB.printForward());
        System.out.println(cloneC.printForward());
    }

}
