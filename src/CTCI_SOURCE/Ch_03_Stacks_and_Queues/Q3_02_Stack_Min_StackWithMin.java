package CTCI_SOURCE.Ch_03_Stacks_and_Queues;

import java.util.Stack;

public class Q3_02_Stack_Min_StackWithMin extends Stack<Q3_02_Stack_Min_NodeWithMin> {

    public void push(int value) {
        int newMin = Math.min(value, min());
        super.push(new Q3_02_Stack_Min_NodeWithMin(value, newMin));
    }

    public int min() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return peek().min;
        }
    }
}
