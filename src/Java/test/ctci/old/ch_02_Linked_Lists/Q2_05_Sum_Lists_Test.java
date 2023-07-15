package Java.test.ctci.old.ch_02_Linked_Lists;

import Java.code.ctci.old.ch_02_Linked_Lists.LinkedList;
import Java.code.ctci.old.ch_02_Linked_Lists.Q2_05_Sum_Lists;
import Java.code.ctci.source.ctciLibrary.LinkedListNode;
import Java.code.unsorted.classes.CustomLinkedList;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@SuppressWarnings({"NewClassNamingConvention", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q2_05_Sum_Lists_Test {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void sumList() {
        int expected = 4;
        printTestHeader(name.getMethodName());
        CustomLinkedList<Integer> intValue1 = new CustomLinkedList<>();
        intValue1.insert(7);
        intValue1.insert(1);
        intValue1.insert(6);
        CustomLinkedList<Integer> intValue2 = new CustomLinkedList<>();
        intValue2.insert(5);
        intValue2.insert(9);
        intValue2.insert(3);
        System.out.format("\tOperand 1: %s\n", intValue1);
        System.out.format("\tOperand 2: %s\n", intValue2);
        CustomLinkedList<Integer> result = LinkedList.sumList(intValue1, intValue2);
        assertEquals(expected, result.getSize());
        System.out.format("\tResult: %s\n", result);
    }

    @Test
    public void sumListReverse() {
        int expected = 4;
        printTestHeader(name.getMethodName());
        CustomLinkedList<Integer> intValue1 = new CustomLinkedList<>();
        intValue1.insert(7);
        intValue1.insert(1);
        intValue1.insert(6);
        CustomLinkedList<Integer> intValue2 = new CustomLinkedList<>();
        intValue2.insert(5);
        intValue2.insert(9);
        intValue2.insert(3);
        System.out.format("\tOperand 1: %s\n", intValue1);
        System.out.format("\tOperand 2: %s\n", intValue2);
        CustomLinkedList<Integer> result = LinkedList.sumListReverse(intValue1, intValue2);
        assertEquals(expected, result.getSize());
        System.out.format("\tResult: %s\n", result);
    }

    @Test
    public void sumLists_solution_1() {
        int expected = 1000;
        System.out.format("\tList\n");
        LinkedListNode operand_a = new LinkedListNode(9, null, null);
        LinkedListNode operand_b = new LinkedListNode(9, null, operand_a);
        new LinkedListNode(9, null, operand_b);
        LinkedListNode operand_c = new LinkedListNode(1, null, null);
        LinkedListNode operand_d = new LinkedListNode(0, null, operand_c);
        new LinkedListNode(0, null, operand_d);
        LinkedListNode list3 = Q2_05_Sum_Lists.sumLists_solution_1(operand_a, operand_c);
        System.out.format("\tOperand 1: %s\n", operand_a.printForward());
        System.out.format("\tOperand 2: %s\n", operand_c.printForward());
        System.out.format("\tResult: %s\n", list3.printForward());
        int operand_1 = Q2_05_Sum_Lists.linkedListToIntReverse(operand_a);
        int operand_2 = Q2_05_Sum_Lists.linkedListToIntReverse(operand_c);
        int result = Q2_05_Sum_Lists.linkedListToIntReverse(list3);
        assertEquals(expected, result);
        System.out.format("\tResult from list addition: %d + %d = %d\n", operand_1, operand_2, result);
        System.out.format(
                "\tResult from normal addition: %d + %d = %d\n",
                operand_1, operand_2, (operand_1 + operand_2));
    }

    @Test
    public void sumLists_solution_2() {
        int expected = 622;
        System.out.format("\tList\n");
        LinkedListNode operand_a = new LinkedListNode(3, null, null);
        new LinkedListNode(1, null, operand_a);
        LinkedListNode operand_c = new LinkedListNode(5, null, null);
        LinkedListNode d = new LinkedListNode(9, null, operand_c);
        new LinkedListNode(1, null, d);
        System.out.format("\tOperand list 1: %s\n", operand_a.printForward());
        System.out.format("\tOperand list 2: %s\n", operand_c.printForward());
        LinkedListNode list3 = Q2_05_Sum_Lists.sumLists_solution_2(operand_a, operand_c);
        System.out.format("\tResult list: %s\n", list3.printForward());
        int operand_1 = Q2_05_Sum_Lists.linkedListToIntForward(operand_a);
        int operand_2 = Q2_05_Sum_Lists.linkedListToIntForward(operand_c);
        int result = Q2_05_Sum_Lists.linkedListToIntForward(list3);
        assertEquals(expected, result);
        System.out.format("\tResult from list addition: %d + %d = %d\n", operand_1, operand_2, result);
        System.out.format(
                "\tResult from normal addition: %d + %d = %d\n",
                operand_1, operand_2, (operand_1 + operand_2));
    }
}
