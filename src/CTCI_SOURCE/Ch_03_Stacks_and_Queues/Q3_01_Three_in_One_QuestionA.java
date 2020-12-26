package CTCI_SOURCE.Ch_03_Stacks_and_Queues;

import CTCI.CtCILibrary.AssortedMethods;

public class Q3_01_Three_in_One_QuestionA {
    public static void printStacks(Q3_01_Three_in_One_FixedMultiStack stacks) {
        System.out.println(AssortedMethods.arrayToString(stacks.getValues()));
    }

    public static void main(String[] args) throws Exception {
        Q3_01_Three_in_One_FixedMultiStack stacks = new Q3_01_Three_in_One_FixedMultiStack(4);
        printStacks(stacks);
        stacks.push(0, 10);
        printStacks(stacks);
        stacks.push(1, 20);
        printStacks(stacks);
        stacks.push(2, 30);
        printStacks(stacks);

        stacks.push(1, 21);
        printStacks(stacks);
        stacks.push(0, 11);
        printStacks(stacks);
        stacks.push(0, 12);
        printStacks(stacks);

        stacks.pop(0);
        printStacks(stacks);

        stacks.push(2, 31);
        printStacks(stacks);

        stacks.push(0, 13);
        printStacks(stacks);
        stacks.push(1, 22);
        printStacks(stacks);

        stacks.push(2, 31);
        printStacks(stacks);
        stacks.push(2, 32);
        printStacks(stacks);
    }
}
