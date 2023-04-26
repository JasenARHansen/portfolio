package Java.Code.Interview.Facebook.Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseOperations {
    public static void getDescription() {
        System.out.println("""
                Reverse Operations
                You are given a singly-linked list that contains N integers.
                A subpart of the list is a contiguous set of even elements, bordered either by either end of the list or an odd element.
                For example, if the list is [1, 2, 8, 9, 12, 16], the sub-parts of the list are [2, 8] and [12, 16].
                Then, for each subpart, the order of the elements is reversed.
                In the example, this would result in the new list, [1, 8, 2, 9, 16, 12].
                The goal of this question is: given a resulting list, determine the original order of the elements.
                Implementation detail:
                 You must use the following definition for elements in the linked list:
                 class Node {
                  int data;
                  Node next;
                 }
                Signature
                 Node reverse(Node head)
                Constraints
                 1 <= N <= 1000, where N is the size of the list
                 1 <= Li <= 10^9, where Li is the ith element of the list
                Example
                 Input:
                  N = 6
                  list = [1, 2, 8, 9, 12, 16]
                 Output:
                  [1, 8, 2, 9, 16, 12]
                """.indent(2));
    }

    public static Node reverse(Node head) {
        Node start = head;
        Node current;
        Node next;
        Stack<Integer> stack = new Stack<>();
        while (start != null) {
            current = start;
            if (current.data % 2 == 0) {
                stack.push(current.data);
                next = current.next;
                while ((next != null) && (next.data % 2 == 0)) {
                    stack.push(next.data);
                    current = current.next;
                    next = current.next;
                }
            }
            current = start;
            if (stack.isEmpty()) {
                current = current.next;
            } else while (!stack.isEmpty()) {
                current.data = stack.pop();
                current = current.next;
            }
            start = current;
        }
        return head;
    }

    public static Object[] createArray(Node node) {
        List<Integer> returnList = new ArrayList<>();
        while (node != null) {
            returnList.add(node.data);
            node = node.next;
        }
        return returnList.toArray();
    }

    public static Node createLinkedList(int[] arr) {
        Node head = null;
        Node tempHead = null;
        for (int v : arr) {
            if (head == null) {
                head = new Node(v);
                tempHead = head;
            } else {
                head.next = new Node(v);
                head = head.next;
            }
        }
        return tempHead;
    }

    public static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }
}
