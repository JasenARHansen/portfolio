package Code.CTCI_SOURCE.other.Ch_01_Arrays_and_Strings.Q1_04_Palindrome_Permutation;

public class QuestionB {

    public static void main(String[] args) {
        String pali = "Ratzs live on no evil starz";
        System.out.println(isPermutationOfPalindrome(pali));
        String pali2 = "Zeus was deified, saw Suez";
        System.out.println(isPermutationOfPalindrome(pali2));
    }

    public static boolean isPermutationOfPalindrome(String phrase) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = Common.getCharNumber(c);
            if (x != -1) {
                table[x]++;

                if (table[x] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }


}
