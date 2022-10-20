package Code.Java.CTCI.other.Ch_03_Stacks_and_Queues;

import java.util.Stack;

public class QueueFromStack<T> {

    private final Stack<T> queue;
    private final Stack<T> stack;

    public QueueFromStack() {
        queue = new Stack<>();
        stack = new Stack<>();
    }

    public void add(T data) {
        this.transfer(queue, stack);
        stack.push(data);
    }

    private void transfer(Stack<T> source, Stack<T> receptacle) {
        while (!source.isEmpty()) {
            receptacle.add(source.pop());
        }
    }

    public boolean isEmpty() {
        return this.getSize() == 0;
    }

    public int getSize() {
        return Math.max(queue.size(), stack.size());
    }

    public T peek() {
        this.transfer(stack, queue);
        return queue.peek();
    }

    public T remove() {
        this.transfer(stack, queue);
        return queue.pop();
    }

    @Override
    public String toString() {
        if (queue.isEmpty()) {
            this.transfer(stack, queue);
        }
        return queue.toString();
    }
}
