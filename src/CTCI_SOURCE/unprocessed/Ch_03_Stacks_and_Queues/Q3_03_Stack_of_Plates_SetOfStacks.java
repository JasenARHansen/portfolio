package CTCI_SOURCE.unprocessed.Ch_03_Stacks_and_Queues;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Q3_03_Stack_of_Plates_SetOfStacks {
    public int capacity;
    ArrayList<Q3_03_Stack_of_Plates_Stack> stacks = new ArrayList<>();

    public Q3_03_Stack_of_Plates_SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    public Q3_03_Stack_of_Plates_Stack getLastStack() {
        if (stacks.size() == 0) {
            return null;
        }
        return stacks.get(stacks.size() - 1);
    }

    public void push(int v) {
        Q3_03_Stack_of_Plates_Stack last = getLastStack();
        if (last != null && !last.isFull()) { // add to last
            last.push(v);
        } else { // must create new stack
            Q3_03_Stack_of_Plates_Stack stack = new Q3_03_Stack_of_Plates_Stack(capacity);
            stack.push(v);
            stacks.add(stack);
        }
    }

    public int pop() {
        Q3_03_Stack_of_Plates_Stack last = getLastStack();
        if (last == null) throw new EmptyStackException();
        int v = last.pop();
        if (last.size == 0) {
            stacks.remove(stacks.size() - 1);
        }
        return v;
    }

    public int popAt(int index) {
        return leftShift(index, true);
    }

    public int leftShift(int index, boolean removeTop) {
        Q3_03_Stack_of_Plates_Stack stack = stacks.get(index);
        int removed_item;
        if (removeTop) removed_item = stack.pop();
        else removed_item = stack.removeBottom();
        if (stack.isEmpty()) {
            stacks.remove(index);
        } else if (stacks.size() > index + 1) {
            int v = leftShift(index + 1, false);
            stack.push(v);
        }
        return removed_item;
    }

    public boolean isEmpty() {
        Q3_03_Stack_of_Plates_Stack last = getLastStack();
        return last == null || last.isEmpty();
    }
}

