package Code.Java.CTCI.other.Ch_02_Linked_Lists;

import Code.Java.unsorted.classes.CustomLinkedList;
import Code.Java.unsorted.classes.NodeList;
import Code.Java.unsorted.classes.classesInstance.CirularLinkedList;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class Linked_List {

    public static void getDescription() {
        System.out.println("Section 2. Linked List");
    }

    public static void removeDuplicate(CustomLinkedList<Integer> input) {
        Set<Integer> testSet = new HashSet<>();
        int pointer = 0;
        int inputSize = input.getSize();
        for (int i = 0; i < inputSize; i++) {
            if (testSet.contains(input.getIndex(pointer).getData())) {
                input.removeIndex(pointer);
            } else {
                testSet.add(input.getIndex(pointer).getData());
                pointer++;
            }
        }
    }

    public static NodeList<String> intersects(
            CustomLinkedList<String> input1, CustomLinkedList<String> input2) {
        for (int i = 0; i < input1.getSize(); i++) {
            for (int j = 0; j < input2.getSize(); j++) {
                if (input1.getIndex(i) == input2.getIndex(j)) {
                    return input1.getIndex(i);
                }
            }
        }
        return null;
    }

    public static <T extends Comparable<T>> boolean isPalindrome(CustomLinkedList<T> input) {

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

    public static CustomLinkedList<Integer> sumList(
            CustomLinkedList<Integer> augend, CustomLinkedList<Integer> addend) {
        // Addition: Augend + Addend = Sum
        // Each list represents the digits of a number in forward order.
        // This method will add the lists together and return a new list representing the sum.

        int augend_size = augend.getSize();
        int addend_size = addend.getSize();

        CustomLinkedList<Integer> sumList = new CustomLinkedList<>();

        int carry = 0;
        int sum;
        int augend_digit;
        int addend_digit;
        for (int index = 0; index < Math.max(augend_size, addend_size); index++) {
            if (index < augend_size) {
                augend_digit = augend.getIndex(augend_size - index - 1).getData();
            } else {
                augend_digit = 0;
            }
            if (index < addend_size) {
                addend_digit = addend.getIndex(addend_size - index - 1).getData();
            } else {
                addend_digit = 0;
            }
            sum = augend_digit + addend_digit + carry;
            if (sum > 9) {
                sum = sum % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            sumList.insertIndex(sum, 0);
        }
        if (carry > 0) {
            sumList.insertIndex(carry, 0);
        }

        return sumList;
    }

    public static CustomLinkedList<Integer> sumListReverse(
            CustomLinkedList<Integer> augend, CustomLinkedList<Integer> addend) {
        // Addition: Augend + Addend = Sum
        // Each list represents the digits of a number in reverse order.
        // This method will add the lists together and return a new list representing the sum.

        int augend_size = augend.getSize();
        int addend_size = addend.getSize();

        CustomLinkedList<Integer> sumList = new CustomLinkedList<>();

        int carry = 0;
        int sum;
        int augend_digit;
        int addend_digit;
        for (int index = 0; index < Math.max(augend_size, addend_size); index++) {
            if (index < augend_size) {
                augend_digit = augend.getIndex(index).getData();
            } else {
                augend_digit = 0;
            }
            if (index < addend_size) {
                addend_digit = addend.getIndex(index).getData();
            } else {
                addend_digit = 0;
            }
            sum = augend_digit + addend_digit + carry;
            if (sum > 9) {
                sum = sum % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            sumList.insert(sum);
        }
        if (carry > 0) {
            sumList.insert(carry);
        }

        return sumList;
    }

    public static void partition(CustomLinkedList<Integer> inputList, Integer data) {
        // This will split the list into 2 partitions.
        // The left partition will all be smaller than the selector data
        // The right partition will all be greater than or equal to the data
        // The partition value does not need to be at the border of the second partition, it can be
        // anywhere in it.

        if (inputList.isEmpty()) {
            return;
        }

        CustomLinkedList<Integer> rightPartition = new CustomLinkedList<>();
        int index = 0;
        while (index < inputList.getSize()) {
            if (inputList.getIndex(index).getData() >= data) {
                rightPartition.insert(inputList.getIndex(index).getData());
                inputList.removeIndex(index);
            } else {
                index++;
            }
        }
        inputList.insert(rightPartition);
    }

    public static void removeDuplicateAlt(CustomLinkedList<Integer> input) {
        int startPointer = 0;
        while (startPointer < input.getSize()) {
            int testData = input.getIndex(startPointer).getData();
            int innerPointer = startPointer + 1;
            int inputSize = input.getSize();
            for (int i = innerPointer; i < inputSize; i++) {
                if (input.getIndex(innerPointer).getData() == testData) {
                    input.removeIndex(innerPointer);
                } else {
                    innerPointer++;
                }
            }
            startPointer++;
        }
    }

    public static void removeDuplicateAsNode(
            CustomLinkedList<Integer> toSimplify, NodeList<Integer> input) {
        // Sending in original list so I can use its remove method and not
        // reimplement
        NodeList<Integer> currentNode = input;
        int currentIndex = 0;
        while (currentNode.getNext() != null) {
            int offsetIndex = 0;
            NodeList<Integer> nextNode = currentNode;
            do {
                nextNode = nextNode.getNext();
                offsetIndex++;
                if (currentNode.getData().equals(nextNode.getData())) {
                    nextNode = nextNode.getPrevious();
                    toSimplify.removeIndex(currentIndex + offsetIndex);
                }
            } while (nextNode.getNext() != null);
            currentNode = currentNode.getNext();
            currentIndex++;
        }
    }

    public static void removeKthFromLast(int k, CustomLinkedList<Integer> input) {
        if (input.getSize() < k) {
            return;
        }
        input.removeIndex(input.getSize() - k);
    }

    public static void removeKthFromLast2(int k, CustomLinkedList<Integer> input) {
        if (input.getSize() < k) {
            return;
        }
        NodeList<Integer> pointerNode = input.getFirst();
        for (int i = 0; i < k - 1; i++) {
            pointerNode = pointerNode.getNext();
        }

        int deleteIndex = 0;
        for (int i = k; i < input.getSize(); i++) {
            pointerNode = pointerNode.getNext();
            deleteIndex++;
        }
        input.removeIndex(deleteIndex);
    }

    public static void removeMiddleNode(
            NodeList<Integer> inputNode, CustomLinkedList<Integer> inputList)
            throws IllegalAccessException {
        if (inputNode.getNext() == null) {
            return;
        }
        NodeList<Integer> tempNode = inputNode.getNext();
        // Since I do not have a previous pointer from this challenge, I must
        // migrate the next data to current. and than remove the next node. I
        // will have to reimplement a few things since I am using my linked list
        // implementation
        inputNode.setData(inputNode.getNext().getData());
        inputNode.setNext(inputNode.getNext().getNext());
        tempNode.setNext(null);
        tempNode.setPrevious(null);
        // Handle the pointer reallocation now since I have a doubly linked list
        if (inputNode.getNext() != null) {
            inputNode.getNext().setPrevious(inputNode);
        } else {
            // Reassigning tail. Only necessary because of the structure I am
            // using.
            Field declaredField;
            try {
                declaredField = CustomLinkedList.class.getDeclaredField("tail");
                declaredField.setAccessible(true);
                declaredField.set(inputList, inputNode);
            } catch (NoSuchFieldException | SecurityException | IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    public static NodeList<String> detectCycle(CirularLinkedList<String> input) {
        int slowPointer = 0;
        int fastPointer = 0;
        do {
            slowPointer++;
            fastPointer++;
            fastPointer++;
        } while ((input.getIndex(slowPointer) != input.getIndex(fastPointer))
                && (slowPointer != input.getSize()));

        if ((slowPointer == input.getSize()) && ((slowPointer * 2) == fastPointer)) {
            return null;
        }

        // 2 bad cases, single cycle or corrupt pointers that led to 2 non
        // intersecting cycled that fast and slow pointers are on.

        // Cycle detected, identify cycle node
        slowPointer = 0;
        while (input.getIndex(slowPointer) != input.getIndex(fastPointer)) {
            slowPointer++;
            fastPointer++;
        }

        return input.getIndex(slowPointer);
    }
}
