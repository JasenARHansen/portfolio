package Code.CTCI.CTCI_SOURCE.other.Ch_01_Arrays_and_Strings.Q1_03_URLify;

import Code.CTCI.CTCI_SOURCE.other.CtCILibrary.AssortedMethods;

public class Question {
    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        char[] arr = str.toCharArray();
        int trueLength = findLastCharacter(arr) + 1;
        replaceSpaces(arr, trueLength);
        System.out.println("\"" + AssortedMethods.charArrayToString(arr) + "\"");
    }

    // Assume string has sufficient free space at the end
    public static void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0, index, i;
        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        index = trueLength + spaceCount * 2;
        if (trueLength < str.length) str[trueLength] = '\0';
        for (i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }

    public static int findLastCharacter(char[] str) {
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] != ' ') {
                return i;
            }
        }
        return -1;
    }
}
