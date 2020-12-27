package CTCI_SOURCE.unprocessed.Ch_03_Stacks_and_Queues;

public class Q3_02_Stack_Min_Question {
    public static void main(String[] args) {
        Q3_02_Stack_Min_StackWithMin stack = new Q3_02_Stack_Min_StackWithMin();
        Q3_02_Stack_Min_StackWithMin2 stack2 = new Q3_02_Stack_Min_StackWithMin2();
        int[] array = {2, 1, 3, 1};
        for (int value : array) {
            stack.push(value);
            stack2.push(value);
            System.out.print(value + ", ");
        }
        System.out.println('\n');
        for (int i = 0; i < array.length; i++) {
            System.out.println("Popped " + stack.pop().value + ", " + stack2.pop());
            System.out.println("New min is " + stack.min() + ", " + stack2.min());
        }
    }

}
