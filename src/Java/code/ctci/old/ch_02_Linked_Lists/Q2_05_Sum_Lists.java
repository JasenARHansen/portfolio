package Java.code.ctci.old.ch_02_Linked_Lists;

import Java.code.ctci.source.ctciLibrary.LinkedListNode;

@SuppressWarnings("DuplicatedCode")
public class Q2_05_Sum_Lists {
    private static LinkedListNode insertBefore(LinkedListNode list, int data) {
        LinkedListNode node = new LinkedListNode(data);
        if (list != null) {
            node.next = list;
        }
        return node;
    }

    private static int length(LinkedListNode l) {
        if (l == null) {
            return 0;
        } else {
            return 1 + length(l.next);
        }
    }

    public static int linkedListToIntForward(LinkedListNode node) {
        int value = 0;
        while (node != null) {
            value = value * 10 + node.data;
            node = node.next;
        }
        return value;
    }

    public static int linkedListToIntReverse(LinkedListNode node) {
        int value = 0;
        int multiplier = 1;
        while (node != null) {
            value = value + node.data * multiplier;
            multiplier *= 10;
            node = node.next;
        }
        return value;
    }

    private static LinkedListNode padList(LinkedListNode l, int padding) {
        LinkedListNode head = l;
        for (int i = 0; i < padding; i++) {
            head = insertBefore(head, 0);
        }
        return head;
    }

    private static LinkedListNode sumLists_solution_1(
            LinkedListNode l1, LinkedListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        LinkedListNode result = new LinkedListNode();
        int value = carry;
        if (l1 != null) {
            value += l1.data;
        }
        if (l2 != null) {
            value += l2.data;
        }
        result.data = value % 10;
        if (l1 != null || l2 != null) {
            LinkedListNode more =
                    sumLists_solution_1(
                            l1 == null ? null : l1.next, l2 == null ? null : l2.next, value >= 10 ? 1 : 0);
            result.setNext(more);
        }
        return result;
    }

    public static LinkedListNode sumLists_solution_1(LinkedListNode l1, LinkedListNode l2) {
        return sumLists_solution_1(l1, l2, 0);
    }

    public static LinkedListNode sumLists_solution_2(LinkedListNode l1, LinkedListNode l2) {
        int len1 = length(l1);
        int len2 = length(l2);
        if (len1 < len2) {
            l1 = padList(l1, len2 - len1);
        } else {
            l2 = padList(l2, len1 - len2);
        }
        PartialSum sum = sumLists_solution_2_Helper(l1, l2);
        if (sum.carry == 0) {
            return sum.sum;
        } else {
            return insertBefore(sum.sum, sum.carry);
        }
    }

    private static PartialSum sumLists_solution_2_Helper(LinkedListNode l1, LinkedListNode l2) {
        if (l1 == null && l2 == null) {
            return new PartialSum();
        }
        assert l1 != null;
        assert l2 != null;
        PartialSum sum = sumLists_solution_2_Helper(l1.next, l2.next);
        int val = sum.carry + l1.data + l2.data;
        sum.sum = insertBefore(sum.sum, val % 10);
        sum.carry = val / 10;
        return sum;
    }

    public static class PartialSum {
        public int carry = 0;
        public LinkedListNode sum = null;
    }
}
