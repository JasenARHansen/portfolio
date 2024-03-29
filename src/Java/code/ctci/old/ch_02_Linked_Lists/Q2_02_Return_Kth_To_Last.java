package Java.code.ctci.old.ch_02_Linked_Lists;

import Java.code.ctci.source.ctciLibrary.LinkedListNode;
import Java.code.unsorted.classes.CustomLinkedList;
import Java.code.unsorted.classes.NodeList;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("DuplicatedCode")
public class Q2_02_Return_Kth_To_Last {
    public static String printKthToLast_solution_1(LinkedListNode head, int k) {
        List<String> answer = new ArrayList<>();
        printKthToLast_solution_1(head, k, answer);
        if (answer.isEmpty()) {
            return "Unknown";
        }
        return answer.get(0);
    }

    private static int printKthToLast_solution_1(LinkedListNode head, int k, List<String> answer) {
        if (head == null) {
            return 0;
        }
        int index = printKthToLast_solution_1(head.next, k, answer) + 1;
        if (index == k) {
            answer.add(String.format("%dth to last node is %d", index, head.data));
        }
        return index;
    }

    public static LinkedListNode printKthToLast_solution_2(LinkedListNode head, int k) {
        Index idx = new Index();
        return printKthToLast_solution_2(head, k, idx);
    }

    public static LinkedListNode printKthToLast_solution_2(LinkedListNode head, int k, Index idx) {
        if (head == null) {
            return null;
        }
        LinkedListNode node = printKthToLast_solution_2(head.next, k, idx);
        idx.value = idx.value + 1;
        if (idx.value == k) {
            return head;
        }
        return node;
    }

    public static LinkedListNode printKthToLast_solution_3(LinkedListNode head, int k) {
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;
        /* Move p1 k nodes into the list. */
        for (int i = 0; i < k; i++) {
            if (p1 == null) return null; // Out of bounds
            p1 = p1.next;
        }
    /* Move them at the same pace. When p1 hits the end,
    p2 will be at the right element. */
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public static NodeList<Integer> returnKthToLast(int k, CustomLinkedList<Integer> input) {
        if (input.getSize() < k) {
            return null;
        }
        return input.getIndex(input.getSize() - k);
    }

    public static class Index {
        public int value = 0;
    }
}
