package CTCI.Ch_01_Arrays_and_Strings.Old;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public class Arrays_And_Strings {

    public static String compressedString(String input) {
        // Base case for short circuiting
        if ((input == null) || (input.length() <= 2)) {
            return input;
        }

        StringBuilder localString = new StringBuilder();

        char compareCharacter = input.charAt(0);
        int compareCount = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) != compareCharacter) {
                localString.append(compareCharacter);
                localString.append(compareCount);
                compareCharacter = input.charAt(i);
                compareCount = 1;
            } else {
                compareCount++;
            }
        }

        // Add items still being processed
        localString.append(compareCharacter);
        localString.append(compareCount);

        return (localString.length() < input.length()) ? localString.toString() : input;
    }

    public static void getDescription() {
        System.out.println("Section 1. Arrays and Strings");
    }

    public static boolean isPermutation(String left, String right) {
        return convertAndSort(left).equals(convertAndSort(right));
    }

    public static String convertAndSort(String input) {
        char[] content = input.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public static boolean isRotation(String first, String second) {
        String tempString = second + second;
        return tempString.contains(first);
    }

    public static boolean isUnique(String input) {
        Set<Character> charSet = new HashSet<>();
        for (char character : input.toCharArray()) {
            charSet.add(character);
        }
        return charSet.size() == input.length();
    }

    public static boolean palindromePermutation(String input) {
        HashMap<String, Integer> letterMap = new HashMap<>();
        String temp = input.toLowerCase().replaceAll("\\s+", "");
        for (int i = 0; i < temp.length(); i++) {
            String letter = temp.substring(i, i + 1);
            if (letterMap.containsKey(letter)) {
                letterMap.put(letter, letterMap.get(letter) + 1);
            } else {
                letterMap.put(letter, 1);
            }
        }
        // if Size is odd 1 odd character is required.
        boolean even = (temp.length() % 2 == 0);
        boolean firstOddFound = false;
        for (Entry<String, Integer> test : letterMap.entrySet()) {
            boolean oddCount = (test.getValue() % 2 == 1);
            if (oddCount && even) {
                return false;
            } else if (oddCount && firstOddFound) {
                return false;
            } else if (oddCount) {
                firstOddFound = true;
            }
        }
        return even || firstOddFound;
    }

    public static boolean rotate(int[][] matrix) {
        if ((matrix == null) || (matrix.length == 0) || (matrix.length != matrix[0].length)) {
            return false;
        }

        int size = matrix.length;
        int[][] temp = new int[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                temp[col][size - row - 1] = matrix[row][col];
            }
        }

        for (int row = 0; row < size; row++) {
            System.arraycopy(temp[row], 0, matrix[row], 0, size);
        }

        return true;
    }

    public static boolean singleEdit(String left, String right) {
        String longString;
        String shortString;
        if (left.length() > right.length()) {
            longString = left;
            shortString = right;
        } else {
            longString = right;
            shortString = left;
        }
        int longPointer = 0;
        int shortPointer = 0;

        boolean singleEdit = false;
        if (longString.length() != shortString.length()) {
            singleEdit = true;
        }

        while ((longPointer < longString.length()) && (shortPointer < shortString.length())) {
            // Base case no change
            if (longString.charAt(longPointer) != shortString.charAt(shortPointer)) {
                // Test to see if the difference is an insert
                if (((longPointer + 1) < longString.length())
                        && (longString.length() != shortString.length())) {
                    // Check character at pointer + 1
                    if (longString.charAt(longPointer + 1) == shortString.charAt(shortPointer)) {
                        longPointer++;
                    } else {
                        singleEdit = false;
                        break;
                    }
                } else {
                    if (singleEdit) {
                        singleEdit = false;
                        break;
                    }
                    singleEdit = true;
                }
            }
            longPointer++;
            shortPointer++;
        }
        return singleEdit;
    }

    public static String URLif(String string) {
        int writePointer = string.length() - 1;
        int readPointer = 0;

        char[] process = string.toCharArray();
        for (int i = writePointer; i >= 0; i--) {
            if (process[i] != ' ') {
                readPointer = i;
                break;
            }
        }

        for (; readPointer >= 0; readPointer--) {
            if (readPointer == writePointer) {
                break;
            } else if (process[readPointer] == ' ') {
                // space detected
                process[writePointer--] = '0';
                process[writePointer--] = '2';
                process[writePointer--] = '%';
            } else {
                process[writePointer--] = process[readPointer];
            }
        }
        return new String(process);
    }

    public static void zeroMatrix(int[][] matrix) {
        Set<Integer> outer = new HashSet<>();
        Set<Integer> inner = new HashSet<>();
        // detect rows and columns that have zeros
        for (int outerIndex = 0; outerIndex < matrix.length; outerIndex++) {
            for (int innerIndex = 0; innerIndex < matrix[outerIndex].length; innerIndex++) {
                if (matrix[outerIndex][innerIndex] == 0) {
                    outer.add(outerIndex);
                    inner.add(innerIndex);
                }
            }
        }

        // Zero
        for (int i = 0; i < matrix.length; i++) {
            for (Integer col : inner) {
                matrix[i][col] = 0;
            }
        }

        for (Integer row : outer) {
            Arrays.fill(matrix[row], 0);
        }
    }
}
