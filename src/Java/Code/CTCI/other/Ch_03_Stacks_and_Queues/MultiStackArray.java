package Java.Code.CTCI.other.Ch_03_Stacks_and_Queues;

import java.util.EmptyStackException;

public class MultiStackArray {

    private final int stackCount;
    private final int[] indexes;
    private int[] stack;
    private int stackSize;

    public MultiStackArray() {
        this(3, 3);
    }

    public MultiStackArray(int size, int count) {
        this.stackCount = count;
        this.indexes = new int[this.stackCount];
        this.stackSize = size;
        this.stack = new int[this.stackCount * this.stackSize];
        for (int i = 0; i < this.stackCount; i++) {
            this.indexes[i] = -1;
        }
    }

    public int getStackCount() {
        return this.stackCount;
    }

    public int peek(int stack) {
        if (this.isEmpty(stack)) {
            throw new EmptyStackException();
        }
        return this.stack[this.stackSize * stack + this.indexes[stack]];
    }

    public boolean isEmpty(int stack) {
        return this.indexes[stack] < 0;
    }

    public int pop(int stack) {
        if (this.isEmpty(stack)) {
            throw new EmptyStackException();
        }
        this.indexes[stack]--;
        return this.stack[(this.stackSize * stack) + this.indexes[stack] + 1];
    }

    public void push(int stack, int data) {
        // Determine if stack has to grow
        if ((this.indexes[stack] + 1) == this.stackSize) {
            this.growStack();
        }
        // update array
        this.indexes[stack]++;
        this.stack[(this.stackSize * stack) + this.indexes[stack]] = data;
    }

    private void growStack() {
        // Define new stack array
        int[] newStack = new int[this.stack.length * 2];

        // Copy data to new array adding padding
        for (int i = 0; i < this.stackCount; i++) {
            if (this.indexes[i] + 1 >= 0)
                System.arraycopy(
                        this.stack,
                        (this.stackSize * i),
                        newStack,
                        (this.stackSize * 2 * i),
                        this.indexes[i] + 1);
        }
        this.stack = newStack;
        this.stackSize *= 2;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.stackCount; i++) {
            stringBuilder.append("Stack ").append(i).append(": ");
            if (this.isEmpty(i)) {
                stringBuilder.append("empty\n");
            } else {
                stringBuilder.append(stackToString(getStack(i))).append("\n");
            }
        }

        return stringBuilder.toString().trim();
    }

    public static String stackToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append(array[array.length - 1]);
        for (int i = 0; i < array.length - 1; i++) {
            sb.append(", ").append(array[array.length - i - 2]);
        }
        return sb.toString();
    }

    public int[] getStack(int stack) {
        if (isEmpty(stack)) {
            return new int[0];
        }
        int[] items = new int[this.getSize(stack) + 1];
        if (items.length >= 0)
            System.arraycopy(this.stack, (this.stackSize * stack), items, 0, items.length);
        return items;
    }

    public int getSize(int stack) {
        return this.indexes[stack];
    }
}
