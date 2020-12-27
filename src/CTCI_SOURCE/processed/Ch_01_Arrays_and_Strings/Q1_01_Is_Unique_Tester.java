package CTCI_SOURCE.processed.Ch_01_Arrays_and_Strings;

public class Q1_01_Is_Unique_Tester {

    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            boolean wordA = Q1_01_Is_Unique_QuestionA.isUniqueChars(word);
            boolean wordB = Q1_01_Is_Unique_QuestionB.isUniqueChars(word);
            if (wordA == wordB) {
                System.out.println(word + ": " + wordA);
            } else {
                System.out.println(word + ": " + wordA + " vs " + wordB);
            }
        }
    }
}
