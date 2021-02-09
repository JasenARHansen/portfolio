package Code.CTCI.CTCI_SOURCE.other.Ch_03_Stacks_and_Queues.Q3_03_Stack_of_Plates;

public class Question {
    public static void main(String[] args) {
        int capacity_per_sub_stack = 5;
        SetOfStacks set = new SetOfStacks(capacity_per_sub_stack);
        for (int i = 0; i < 34; i++) {
            set.push(i);
        }
        for (int i = 0; i < 35; i++) {
            System.out.println("Popped " + set.pop());
        }
    }
}
