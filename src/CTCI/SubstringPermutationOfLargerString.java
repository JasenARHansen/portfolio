package CTCI;

import java.util.HashSet;
import java.util.Set;

public class SubstringPermutationOfLargerString {

    public static void findPermutations(String first, String second) {

        String larger;
        String smaller;

        if (first.length() > second.length()) {
            larger = first;
            smaller = second;
        } else {
            smaller = first;
            larger = second;
        }

        Set<String> permutations = permuteString(smaller);

        StringBuilder outputBase = new StringBuilder();
        outputBase.append("-".repeat(larger.length()));

        System.out.format("Original String '%s' and substring '%s'\n", larger, smaller);

        for (String permutation : permutations) {
            for (int i = 0; i < (larger.length() - permutation.length() + 1); i++) {
                String temp = larger.substring(i, i + permutation.length());
                if (temp.equals(permutation)) {
                    String newString = outputBase.substring(0, i) + permutation
                            + outputBase.substring(i + permutation.length());
                    System.out.format("Permutation '%s' found and at '%s'\n", permutation, newString);

                }
            }
        }
    }

    public static void getDescription() {
        System.out.println(
                "Given a small string and a larger string.  Find all permustiaons of smaller string that withinthe larger string. Print all locations of the smaller string.");
    }

    public static Set<String> permuteString(String input) {
        Set<String> values = new HashSet<>();
        permuteString(input, values, "");
        return values;
    }

    private static void permuteString(String input, Set<String> values, String base) {
        // Base case if input is ""
        if (input.length() == 0) {
            values.add(base);
            return;
        }
        // when permutations are still possible
        for (int index = 0; index < input.length(); index++) {
            String atIndex = input.substring(index, index + 1);
            String removedCharacter = input.substring(0, index) + input.substring(index + 1);
            permuteString(removedCharacter, values, base + atIndex);
        }

    }

}
