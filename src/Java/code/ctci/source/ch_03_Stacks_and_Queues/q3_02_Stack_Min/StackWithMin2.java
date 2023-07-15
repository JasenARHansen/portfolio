package Java.code.ctci.source.ch_03_Stacks_and_Queues.q3_02_Stack_Min;

import java.util.Stack;

public class StackWithMin2 extends Stack<Integer> {
    final Stack<Integer> s2;

    public StackWithMin2() {
        s2 = new Stack<>();
    }

    public Integer pop() {
        int value = super.pop();
        if (value == min()) {
            s2.pop();
        }
        return value;
    }

    public void push(int value) {
        if (value <= min()) {
            s2.push(value);
        }
        super.push(value);
    }

    public int min() {
        if (s2.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return s2.peek();
        }
    }
}
