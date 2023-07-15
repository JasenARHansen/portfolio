package Java.code.ctci.source.ch_02_Linked_Lists.q2_01_Remove_Duplicates;

import Java.code.ctci.source.ctciLibrary.LinkedListNode;

@SuppressWarnings("DuplicatedCode")
public class Tester {
    public static void main(String[] args) {
        LinkedListNode first =
                new LinkedListNode(0, null, null);
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
