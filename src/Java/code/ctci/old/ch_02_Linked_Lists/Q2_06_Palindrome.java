package Java.code.ctci.old.ch_02_Linked_Lists;

import Java.code.ctci.source.ctciLibrary.LinkedListNode;
import Java.code.unsorted.classes.CustomLinkedList;

import java.util.Stack;

@SuppressWarnings({"DuplicatedCode", "unused"})
public class Q2_06_Palindrome {
    public static boolean isPalindromeInRange(CustomLinkedList<String> input) {
        int offset = 0;
        int size = input.getSize();
        while (offset < (size / 2)) {
            if (!input.getIndex(offset).getData().equals(input.getIndex(size - offset - 1).getData())) {
                return false;
            }
            offset++;
        }
        return true;
    }

    public static boolean isPalindrome_solution_1(LinkedListNode head) {
        LinkedListNode reversed = reverseAndClone(head);
        return isEqual(head, reversed);
    }

    public static LinkedListNode reverseAndClone(LinkedListNode node) {
        LinkedListNode head = null;
        while (node != null) {
            LinkedListNode n = new LinkedListNode(node.data); // Clone
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    public static boolean isEqual(LinkedListNode one, LinkedListNode two) {
        while (one != null && two != null) {
            if (one.data != two.data) {
                return false;
            }
            one = one.next;
            two = two.next;
        }
        return one == null && two == null;
    }

    public static boolean isPalindrome_solution_2(LinkedListNode head) {
        LinkedListNode fast = head;
        LinkedListNode slow = head;
        Stack<Integer> stack = new Stack<>();
        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
        /* Has odd number of elements, so skip the middle. */
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            int top = stack.pop();
            if (top != slow.data) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public static boolean isPalindrome_solution_3(LinkedListNode head) {
        int length = lengthOfList(head);
        Result p = isPalindrome_solution_3_Recurse(head, length);
        return p.result;
    }

    public static Result isPalindrome_solution_3_Recurse(LinkedListNode head, int length) {
        if (head == null || length <= 0) { // Even number of nodes
            return new Result(head, true);
        } else if (length == 1) { // Odd number of nodes
            return new Result(head.next, true);
        }
        /* Recurse on sublist. */
        Result res = isPalindrome_solution_3_Recurse(head.next, length - 2);
    /* If child calls are not a palindrome, pass back up
    a failure. */
        if (!res.result || res.node == null) {
            return res;
        }
        /* Check if matches corresponding node on other side. */
        res.result = (head.data == res.node.data);
        /* Return corresponding node. */
        res.node = res.node.next;
        return res;
    }

    public static int lengthOfList(LinkedListNode n) {
        int size = 0;
        while (n != null) {
            size++;
            n = n.next;
        }
        return size;
    }

    public static class Result {
        public LinkedListNode node;
        public boolean result;

        public Result(LinkedListNode n, boolean res) {
            node = n;
            result = res;
        }
    }
}
