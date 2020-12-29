package CTCI.Ch_03_Stacks_and_Queues.old;

import unsorted.classesInstance.CustomLinkedList;
import unsorted.classesInstance.Tuple;

import java.util.*;

public class Stacks_and_Queues {

    public static void getDescription() {
        System.out.println("Section 3. Stacks and Queues");
    }

    static class MinStack<T extends Comparable<T>> {
        private final Stack<T> sortStack;
        private final Stack<T> stackStack;

        public MinStack() {
            sortStack = new Stack<>();
            stackStack = new Stack<>();
        }

        public int getSize() {
            return stackStack.size();
        }

        public boolean isEmpty() {
            return this.getSize() == 0;
        }

        public T peek() {
            return stackStack.peek();
        }

        public T pop() {
            return stackStack.pop();
        }

        public void push(T data) {
            while ((!this.stackStack.isEmpty()) && (data.compareTo(this.stackStack.peek()) > 0)) {
                this.sortStack.add(this.stackStack.pop());
            }
            this.stackStack.add(data);
            while (!this.sortStack.isEmpty()) {
                stackStack.add(this.sortStack.pop());
            }
        }

        @Override
        public String toString() {
            return stackStack.toString();
        }
    }

    class AnimalShelter {
        private final Queue<Animal> catQueue;
        private final Queue<Animal> dogQueue;
        private int idCounter = 0;

        public AnimalShelter() {
            this.catQueue = new LinkedList<>();
            this.dogQueue = new LinkedList<>();
        }

        public Animal dequeueAny() {
            if (this.dogQueue.isEmpty() && this.catQueue.isEmpty()) {
                return null;
            } else if (this.dogQueue.isEmpty()) {
                return this.dequeueCats();
            } else if (this.catQueue.isEmpty()) {
                return this.dequeueDogs();
            } else {
                if (this.dogQueue.peek().compareInputID(this.catQueue.peek())) {
                    return this.dequeueDogs();
                } else {
                    return this.dequeueCats();
                }
            }
        }

        public Animal dequeueCats() {
            return this.catQueue.remove();
        }

        public Animal dequeueDogs() {
            return this.dogQueue.remove();
        }

        public void enqueue(Animal animal) throws Exception {
            animal.setInoutID(this.idCounter);
            this.idCounter++;

            if (animal instanceof Dog) {
                this.dogQueue.add(animal);
            } else if (animal instanceof Cat) {
                this.catQueue.add(animal);
            } else {
                throw new Exception();
            }
        }

        public Animal peek() {
            if (this.dogQueue.isEmpty() && this.catQueue.isEmpty()) {
                return null;
            } else if (this.dogQueue.isEmpty()) {
                return this.catQueue.peek();
            } else if (this.catQueue.isEmpty()) {
                return this.dogQueue.peek();
            } else {
                if (this.dogQueue.peek().compareInputID(this.catQueue.peek())) {
                    return this.dogQueue.peek();
                } else {
                    return this.catQueue.peek();
                }
            }
        }

        public Animal peekCats() {
            return this.catQueue.peek();
        }

        public Animal peekDogs() {
            return this.dogQueue.peek();
        }

        public int size() {
            return this.catQueue.size() + this.dogQueue.size();
        }

        @Override
        public String toString() {
            return "Dogs: "
                    + this.dogQueue.toString()
                    + "\n"
                    + "Cats: "
                    + this.catQueue.toString()
                    + "\n";
        }

        abstract class Animal {

            protected String name;
            private int inputID;

            public Animal(String name) {
                this.name = name;
            }

            public boolean compareInputID(Animal a) {
                return this.inputID < a.getInputID();
            }

            public int getInputID() {
                return this.inputID;
            }

            public String getName() {
                return this.name;
            }

            public void setInoutID(int inputID) {
                this.inputID = inputID;
            }

            @Override
            public String toString() {
                return this.name;
            }
        }

        class Cat extends Animal {
            public Cat(String n) {
                super(n);
            }
        }

        class Dog extends Animal {
            public Dog(String n) {
                super(n);
            }
        }
    }

    class MultiStackArray {
        private final int defaultVolume = 2;
        private final int stackCount;
        private final List<Integer> stackSizes;
        private final List<Integer> stackIndex;
        private int[] stackValues;

        public MultiStackArray() {
            this(3);
        }

        public MultiStackArray(int count) {
            this.stackCount = count;
            this.stackSizes = new ArrayList<>();
            this.stackIndex = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                this.stackSizes.add(this.defaultVolume);
                this.stackIndex.add(0);
            }
            this.stackValues = new int[this.defaultVolume * count];
        }

        public int getSize(int stack) {
            return this.stackIndex.get(stack);
        }

        public int getStackCount() {
            return this.stackCount;
        }

        private void growStack(int stack) {
            // Define new stack array
            int[] newStackValues = new int[this.stackValues.length + this.defaultVolume];
            // copy items before growing stack
            int baseIndex = 0;
            int grownIndex = 0;
            // Copy items up to and including stack that is growing stack
            for (int i = 0; i <= stack; i++) {
                if (this.stackIndex.get(i) >= 0)
                    System.arraycopy(
                            this.stackValues, baseIndex, newStackValues, grownIndex, this.stackIndex.get(i));
                baseIndex += this.stackSizes.get(i);
                grownIndex += this.stackSizes.get(i);
            }
            // Alter values to account for grown stack
            grownIndex += defaultVolume;
            this.stackSizes.set(stack, this.stackSizes.get(stack) + this.defaultVolume);
            // copy items into stacks after grown stack
            for (int i = stack + 1; i < this.stackIndex.size(); i++) {
                if (this.stackIndex.get(i) >= 0)
                    System.arraycopy(
                            this.stackValues, baseIndex, newStackValues, grownIndex, this.stackIndex.get(i));
                baseIndex += this.stackSizes.get(i);
                grownIndex += this.stackSizes.get(i);
            }
            this.stackValues = newStackValues;
        }

        public boolean isEmpty(int stack) {
            return this.stackIndex.get(stack) == 0;
        }

        public int peek(int stack) {
            if (this.isEmpty(stack)) {
                throw new EmptyStackException();
            }
            // Identify relevant index
            int index = 0;
            for (int i = 0; i < stack; i++) {
                index += this.stackSizes.get(i);
            }
            index += this.stackIndex.get(stack) - 1;
            return this.stackValues[index];
        }

        public int pop(int stack) {
            if (this.isEmpty(stack)) {
                throw new EmptyStackException();
            }
            // Identify relevant index
            int index = 0;
            for (int i = 0; i < stack; i++) {
                index += this.stackSizes.get(i);
            }
            index += this.stackIndex.get(stack) - 1;
            this.stackIndex.get(stack);
            this.stackIndex.set(stack, this.stackIndex.get(stack) - 1);
            return this.stackValues[index];
        }

        public void push(int stack, int data) {
            // Determine if stack has to grow
            if (this.stackSizes.get(stack).equals(this.stackIndex.get(stack))) {
                this.growStack(stack);
            }
            // Identify relevant index
            int index = 0;
            for (int i = 0; i < stack; i++) {
                index += this.stackSizes.get(i);
            }
            // update array
            this.stackValues[index + this.stackIndex.get(stack)] = data;
            this.stackIndex.set(stack, this.stackIndex.get(stack) + 1);
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            int baseIndex = 0;
            for (int i = 0; i < this.stackSizes.size(); i++) {
                stringBuilder.append("Stack ").append(i).append(": ");
                if (this.isEmpty(i)) {
                    stringBuilder.append("empty");
                } else {
                    stringBuilder.append(this.stackValues[baseIndex + this.stackIndex.get(i) - 1]);
                    for (int j = 1; j < this.stackIndex.get(i); j++) {
                        stringBuilder
                                .append(", ")
                                .append(this.stackValues[baseIndex + this.stackIndex.get(i) - j - 1]);
                    }
                }
                stringBuilder.append("\n");
                baseIndex += this.stackSizes.get(i);
            }
            return stringBuilder.toString();
        }
    }

    class QueueFromStack<T> {

        private final Stack<T> queueStack;
        private final Stack<T> stackStack;

        public QueueFromStack() {
            queueStack = new Stack<>();
            stackStack = new Stack<>();
        }

        public void add(T data) {
            if (stackStack.isEmpty()) {
                this.transfer(queueStack, stackStack);
            }
            stackStack.push(data);
        }

        public int getSize() {
            return Math.max(queueStack.size(), stackStack.size());
        }

        public boolean isEmpty() {
            return this.getSize() == 0;
        }

        public T peek() {
            if (queueStack.isEmpty()) {
                this.transfer(stackStack, queueStack);
            }
            return queueStack.peek();
        }

        public T remove() {
            if (queueStack.isEmpty()) {
                this.transfer(stackStack, queueStack);
            }
            return queueStack.pop();
        }

        @Override
        public String toString() {
            if (queueStack.isEmpty()) {
                this.transfer(stackStack, queueStack);
            }
            return queueStack.toString();
        }

        private void transfer(Stack<T> source, Stack<T> receptical) {
            while (!source.isEmpty()) {
                receptical.add(source.pop());
            }
        }
    }

    class StackOfPlates<T extends Comparable<T>> {
        private final int maxVolume = 2;
        List<List<T>> stackList;
        private int currentStack = 0;

        /**
         * Constructor
         */
        public StackOfPlates() {
            this.stackList = new ArrayList<>();
        }

        public int getSize() {
            int size = 0;
            for (int i = 0; i <= currentStack; i++) {
                size += this.stackList.get(i).size();
            }
            return size;
        }

        public boolean isEmpty() {
            return this.getSize() == 0;
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
            if (this.stackList.get(this.currentStack).size() == this.maxVolume) {
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

    class StackWithMin<T extends Comparable<T>> {

        protected CustomLinkedList<Tuple<T, T>> innerList;

        /**
         * Constructor
         */
        public StackWithMin() {
            this.innerList = new CustomLinkedList<>();
        }

        public int getSize() {
            return this.innerList.getSize();
        }

        public boolean isEmpty() {
            return this.innerList.isEmpty();
        }

        public T min() {
            if (this.innerList.isEmpty()) {
                throw new EmptyStackException();
            }
            return this.innerList.getFirst().getData().getRightData();
        }

        public T peek() {
            if (this.innerList.isEmpty()) {
                throw new EmptyStackException();
            }
            return this.innerList.getFirst().getData().getLeftData();
        }

        public T pop() {
            if (this.innerList.isEmpty()) {
                throw new EmptyStackException();
            }
            return this.innerList.removeIndex(0).getData().getLeftData();
        }

        public void push(T data) {
            Tuple<T, T> insert;
            if (this.innerList.isEmpty()) {
                insert = new Tuple<>(data, data);
            } else {
                if (data.compareTo(this.min()) < 1) {
                    insert = new Tuple<>(data, data);
                } else {
                    insert = new Tuple<>(data, this.min());
                }
            }
            this.innerList.insertIndex(insert, 0);
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            if (!this.innerList.isEmpty()) {
                stringBuilder.append(this.innerList.getFirst().getData().getLeftData());
            }
            for (int i = 1; i < this.innerList.getSize(); i++) {
                stringBuilder.append(", ").append(this.innerList.getIndex(i).getData().getLeftData());
            }
            return stringBuilder.toString();
        }
    }
}
