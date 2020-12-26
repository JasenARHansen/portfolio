package CTCI_SOURCE.Ch_16_Moderate;

import CTCI.CtCILibrary.AssortedMethods;

public class Q16_02_Word_Frequencies_QuestionA {
    public static int getFrequency(String[] book, String word) {
        word = word.trim().toLowerCase();
        int count = 0;
        for (String w : book) {
            if (w.trim().toLowerCase().equals(word)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] wordlist = AssortedMethods.getLongTextBlobAsStringList();

        String[] words = {"the", "Lara", "and", "outcropping", "career", "it"};
        for (String word : words) {
            System.out.println(word + ": " + getFrequency(wordlist, word));
        }
    }

}
