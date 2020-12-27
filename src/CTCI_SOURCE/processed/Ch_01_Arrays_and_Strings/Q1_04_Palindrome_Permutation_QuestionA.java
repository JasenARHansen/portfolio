package CTCI_SOURCE.processed.Ch_01_Arrays_and_Strings;

public class Q1_04_Palindrome_Permutation_QuestionA {
    public static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    public static boolean isPermutationOfPalindrome(String phrase) {
        int[] table = Q1_04_Palindrome_Permutation_Common.buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }

    public static void main(String[] args) {
        String pali = "Rats live on no evil star";
        System.out.println(isPermutationOfPalindrome(pali));
    }


}
