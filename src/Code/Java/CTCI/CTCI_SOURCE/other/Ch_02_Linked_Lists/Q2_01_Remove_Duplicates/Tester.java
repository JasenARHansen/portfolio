package Code.Java.CTCI.CTCI_SOURCE.other.Ch_02_Linked_Lists.Q2_01_Remove_Duplicates;

import Code.Java.CTCI.CTCI_SOURCE.other.CtCILibrary.LinkedListNode;

public class Tester {

    public static void main(String[] args) {
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
        QuestionA.deleteDuplicates(cloneA);
        QuestionA.deleteDuplicates(cloneB);
        QuestionA.deleteDuplicates(cloneC);

        System.out.println(cloneA.printForward());
        System.out.println(cloneB.printForward());
        System.out.println(cloneC.printForward());
    }

}
