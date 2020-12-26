package CTCI_SOURCE.Ch_01_Arrays_and_Strings;

public class Q1_04_Palindrome_Permutation_Tester {


    public static void main(String[] args) {
        String[] strings = {"Rats live on no evil star",
                "A man, a plan, a canal, panama",
                "Lleve",
                "Tacotac",
                "asda"};
        for (String s : strings) {
            boolean a = Q1_04_Palindrome_Permutation_QuestionA.isPermutationOfPalindrome(s);
            boolean b = Q1_04_Palindrome_Permutation_QuestionB.isPermutationOfPalindrome(s);
            boolean c = Q1_04_Palindrome_Permutation_QuestionC.isPermutationOfPalindrome(s);
            System.out.println(s);
            if (a == b && b == c) {
                System.out.println("Agree: " + a);
            } else {
                System.out.println("Disagree: " + a + ", " + b + ", " + c);
            }
            System.out.println();
        }

    }

}
