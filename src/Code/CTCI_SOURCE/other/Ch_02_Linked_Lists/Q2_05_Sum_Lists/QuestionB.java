package Code.CTCI_SOURCE.other.Ch_02_Linked_Lists.Q2_05_Sum_Lists;

import Code.CTCI_SOURCE.other.CtCILibrary.LinkedListNode;

public class QuestionB {
    public static int linkedListToInt(LinkedListNode node) {
        int value = 0;
        while (node != null) {
            value = value * 10 + node.data;
            node = node.next;
        }
        return value;
    }

    public static void main(String[] args) {
        LinkedListNode lA1 = new LinkedListNode(3, null, null);
        LinkedListNode lA2 = new LinkedListNode(1, null, lA1);

        LinkedListNode lB1 = new LinkedListNode(5, null, null);
        LinkedListNode lB2 = new LinkedListNode(9, null, lB1);
        LinkedListNode lB3 = new LinkedListNode(1, null, lB2);

        LinkedListNode list3 = addLists(lA1, lB1);

        System.out.println("  " + lA1.printForward());
        System.out.println("+ " + lB1.printForward());
        System.out.println("= " + list3.printForward());

        int l1 = linkedListToInt(lA1);
        int l2 = linkedListToInt(lB1);
        int l3 = linkedListToInt(list3);

        System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
        System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));
    }

    private static int length(LinkedListNode l) {
        if (l == null) {
            return 0;
        } else {
            return 1 + length(l.next);
        }
    }

    private static PartialSum addListsHelper(LinkedListNode l1, LinkedListNode l2) {
        if (l1 == null && l2 == null) {
            return new PartialSum();
        }
        assert l1 != null;
        assert l2 != null;
        PartialSum sum = addListsHelper(l1.next, l2.next);
        int val = sum.carry + l1.data + l2.data;
        sum.sum = insertBefore(sum.sum, val % 10);
        sum.carry = val / 10;
        return sum;
    }

    private static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
        int len1 = length(l1);
        int len2 = length(l2);
        if (len1 < len2) {
            l1 = padList(l1, len2 - len1);
        } else {
            l2 = padList(l2, len1 - len2);
        }
        PartialSum sum = addListsHelper(l1, l2);
        if (sum.carry == 0) {
            return sum.sum;
        } else {
            return insertBefore(sum.sum, sum.carry);
        }
    }

    private static LinkedListNode padList(LinkedListNode l, int padding) {
        LinkedListNode head = l;
        for (int i = 0; i < padding; i++) {
            head = insertBefore(head, 0);
        }
        return head;
    }

    private static LinkedListNode insertBefore(LinkedListNode list, int data) {
        LinkedListNode node = new LinkedListNode(data);
        if (list != null) {
            node.next = list;
        }
        return node;
    }
}
