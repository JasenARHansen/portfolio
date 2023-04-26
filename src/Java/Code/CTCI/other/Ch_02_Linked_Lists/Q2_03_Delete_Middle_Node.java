package Java.Code.CTCI.other.Ch_02_Linked_Lists;

import Java.Code.CTCI.CTCI_SOURCE.other.CtCILibrary.LinkedListNode;

public class Q2_03_Delete_Middle_Node {

    public static boolean removeNextNode(LinkedListNode node) {
        // Since this is a single linked list I have limits.
        if ((node == null) || (node.next == null)) {
            // Either the node is null or it is the end of the list.
            return false;
        }
        // Make pointer to next node in chain.
        LinkedListNode next_node = node.next;
        // Override local data
        node.data = next_node.data;
        // Change local next node pointer
        node.next = next_node.next;
        // Eliminate next node reference i the old next node so garbage collection works
        next_node.next = null;

        return true;
    }

    public static boolean removeXFromHead(LinkedListNode head, int index) {
        // Since this is a single linked list I have limits.
        if (head == null) {
            // Either the node is null or it is the end of the list.
            return false;
        }
        if (index <= 1) {
            return false;
        }

        LinkedListNode local_node = head;
        for (int i = 0; i < index; i++) {
            if (local_node.next == null) {
                // Either the node is null or it is the end of the list.
                return false;
            } else {
                local_node = local_node.next;
            }
        }

        LinkedListNode next_node = local_node.next;
        // Override local data
        local_node.data = next_node.data;
        // Change local next node pointer
        local_node.next = next_node.next;
        // Eliminate next node reference i the old next node so garbage collection works
        next_node.next = null;

        return true;
    }

    public static boolean removeMiddleNode_solution_1(LinkedListNode n) {
        if (n == null || n.next == null) {
            return false; // Failure
        }
        LinkedListNode next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }

    public static void main(String[] args) {
    }
}
