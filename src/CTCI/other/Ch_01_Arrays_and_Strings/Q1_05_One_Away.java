package CTCI.other.Ch_01_Arrays_and_Strings;

public class Q1_05_One_Away {

    public static boolean oneAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        String longString;
        String shortString;
        int longPointer = 0;
        int shortPointer = 0;
        if (first.length() > second.length()) {
            longString = first;
            shortString = second;
        } else {
            longString = second;
            shortString = first;
        }

        boolean singleEdit = false;
        while ((longPointer < longString.length()) && (shortPointer < shortString.length())) {
            if (Character.toLowerCase(longString.charAt(longPointer))
                    != Character.toLowerCase(shortString.charAt(shortPointer))) {
                if (singleEdit) {
                    return false;
                }
                singleEdit = true;
                if (longString.length() == shortString.length()) {
                    shortPointer++;
                }
            } else {
                shortPointer++;
            }
            longPointer++;
        }

        return true;
    }

    public static boolean oneEditReplace(String s1, String s2) {
        boolean foundDifference = false;
        // Iterate through list and find first character that is different
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                // If second difference is found fail
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }

    /* Check if you can insert a character into s1 to make s2. */
    public static boolean oneEditInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        // Iterate through list and find first character that is different
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    // if second difference is found fail
                    return false;
                }
            } else {
                // If the characters were the sae increment index 1
                index1++;
            }
            // Always increment index 2
            index2++;
        }
        return true;
    }

    public static boolean oneAway_solution_1(String first, String second) {
        if (first.length() == second.length()) {
            // If length is the same than it is a replace
            return oneEditReplace(first, second);
        } else if (first.length() + 1 == second.length()) {
            // If first is smaller, insert 1 into first
            return oneEditInsert(first, second);
        } else if (first.length() - 1 == second.length()) {
            // If first is larger, insert 1 into second
            return oneEditInsert(second, first);
        }
        return false;
    }

    public static boolean oneAway_solution_2(String first, String second) {
        /* Length checks. */
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        /* Get shorter and longer string.*/
        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                /* Ensure that this is the first difference found.*/
                if (foundDifference) return false;
                foundDifference = true;
                if (s1.length() == s2.length()) { // On replace, move shorter pointer
                    index1++;
                }
            } else {
                index1++; // If matching, move shorter pointer
            }
            index2++; // Always move pointer for longer string
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
