package CTCI_SOURCE.unprocessed.Ch_03_Stacks_and_Queues;

import java.util.Stack;

public class Q3_02_Stack_Min_StackWithMin2 extends Stack<Integer> {
    Stack<Integer> s2;

    public Q3_02_Stack_Min_StackWithMin2() {
        s2 = new Stack<>();
    }

    public void push(int value) {
        if (value <= min()) {
            s2.push(value);
        }
        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();
        if (value == min()) {
            s2.pop();
        }
        return value;
    }

    public int min() {
        if (s2.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return s2.peek();
        }
    }
}


