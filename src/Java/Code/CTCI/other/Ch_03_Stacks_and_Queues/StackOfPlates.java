package Java.Code.CTCI.other.Ch_03_Stacks_and_Queues;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class StackOfPlates<T extends Comparable<T>> {
    List<List<T>> stackList;
    private int currentStack = 0;

    public StackOfPlates() {
        this.stackList = new ArrayList<>();
    }

    public boolean isEmpty() {
        return this.getSize() == 0;
    }

    public int getSize() {
        int size = 0;
        for (int i = 0; i <= currentStack; i++) {
            size += this.stackList.get(i).size();
        }
        return size;
    }

    public T peek() {
        // empty stack case
        if ((this.stackList == null)
                || (this.stackList.size() == 0)
                || (this.stackList.get(0).size() == 0)) {
            throw new EmptyStackException();
        }
        return this.stackList.get(this.currentStack).get(0);
    }

    public T pop() {
        // empty stack case
        if ((this.stackList == null)
                || (this.stackList.size() == 0)
                || (this.stackList.get(0).size() == 0)) {
            throw new EmptyStackException();
        }
        T toReturn = this.stackList.get(this.currentStack).remove(0);
        if (this.stackList.get(this.currentStack).isEmpty()) {
            this.currentStack--;
        }
        return toReturn;
    }

    public T popAt(int index) throws Exception {

        // Input validation
        if ((this.stackList == null)
                || (this.stackList.size() == 0)
                || (this.currentStack < index)
                || (this.stackList.get(index).size() == 0)) {
            throw new Exception();
        }
        T toReturn = this.stackList.get(index).remove(0);

        // Roll down items
        for (int i = index; i < this.currentStack; i++) {
            this.stackList
                    .get(i)
                    .add(0, this.stackList.get(i + 1).remove(this.stackList.get(i + 1).size() - 1));
        }
        // Test to see if the current stack is empty
        if (this.stackList.get(this.currentStack).isEmpty()) {
            this.currentStack--;
        }

        return toReturn;
    }

    public void push(T data) {
        // initial insert case
        if (this.stackList.size() == 0) {
            this.stackList.add(new ArrayList<>());
        }
        // if current stack is full, create next
        int maxVolume = 2;
        if (this.stackList.get(this.currentStack).size() == maxVolume) {
            this.stackList.add(new ArrayList<>());
            this.currentStack++;
        }
        // insert to stack
        this.stackList.get(this.currentStack).add(0, data);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = this.currentStack; i >= 0; i--) {
            for (int j = 0; j < this.stackList.get(i).size(); j++) {
                stringBuilder.append(this.stackList.get(i).get(j)).append(", ");
            }
        }
        stringBuilder.setLength(stringBuilder.length() - 2);
        return stringBuilder.toString();
    }
}
