package CTCI_SOURCE.Ch_03_Stacks_and_Queues;

public class Q3_03_Stack_of_Plates_Question {
    public static void main(String[] args) {
        int capacity_per_substack = 5;
        Q3_03_Stack_of_Plates_SetOfStacks set = new Q3_03_Stack_of_Plates_SetOfStacks(capacity_per_substack);
        for (int i = 0; i < 34; i++) {
            set.push(i);
        }
        for (int i = 0; i < 35; i++) {
            System.out.println("Popped " + set.pop());
        }
    }
}
