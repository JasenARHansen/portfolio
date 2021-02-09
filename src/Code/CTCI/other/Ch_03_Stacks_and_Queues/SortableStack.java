package Code.CTCI.other.Ch_03_Stacks_and_Queues;

import java.util.Stack;

public class SortableStack<T extends Comparable<T>> {
    private Stack<T> stack;

    public SortableStack() {
        stack = new Stack<>();
    }

    public boolean isEmpty() {
        return this.getSize() == 0;
    }

    public int getSize() {
        return stack.size();
    }

    public Stack<T> merge_sort(Stack<T> stack) {
        if (stack.size() <= 1) {
            return stack;
        }
        Stack<T> left = new Stack<>();
        Stack<T> right = new Stack<>();
        int index = 0;
        while (!stack.isEmpty()) {
            index++;
            if (index % 2 == 0) {
                left.push(stack.pop());
            } else {
                right.push(stack.pop());
            }
        }
        left = this.merge_sort(left);
        right = this.merge_sort(right);
        Stack<T> local_stack = new Stack<>();
        while (!left.isEmpty() || !right.isEmpty()) {
            if (left.isEmpty()) {
                local_stack.push(right.pop());
            } else if (right.isEmpty()) {
                local_stack.push(left.pop());
            } else {
                if (left.peek().compareTo(right.peek()) <= 0) {
                    local_stack.push(left.pop());
                } else {
                    local_stack.push(right.pop());
                }
            }
        }
        Stack<T> reverseStack = new Stack<>();
        while (local_stack.size() > 0) {
            reverseStack.push(local_stack.pop());
        }

        return reverseStack;
    }

    public T peek() {
        return stack.peek();
    }

    public T pop() {
        return stack.pop();
    }

    public void push(T data) {
        this.stack.add(data);
    }

    public void sort() {
        this.stack = this.merge_sort(this.stack);
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
