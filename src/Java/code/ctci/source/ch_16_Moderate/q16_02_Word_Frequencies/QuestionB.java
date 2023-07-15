package Java.code.ctci.source.ch_16_Moderate.q16_02_Word_Frequencies;

import Java.code.ctci.source.ctciLibrary.AssortedMethods;

import java.util.HashMap;

public class QuestionB {
    public static void main(String[] args) {
        String[] wordlist = AssortedMethods.getLongTextBlobAsStringList();
        HashMap<String, Integer> dictionary = setupDictionary(wordlist);
        String[] words = {"the", "Lara", "and", "outcropping", "career", "it"};
        for (String word : words) {
            System.out.println(word + ": " + getFrequency(dictionary, word));
        }
    }

    public static HashMap<String, Integer> setupDictionary(String[] book) {
        HashMap<String, Integer> table = new HashMap<>();
        for (String word : book) {
            word = word.toLowerCase();
            if (!word.trim().equals("")) {
                if (!table.containsKey(word)) {
                    table.put(word, 0);
                }
                table.put(word, table.get(word) + 1);
            }
        }
        return table;
    }

    public static int getFrequency(HashMap<String, Integer> table, String word) {
        if (table == null || word == null) {
            return -1;
        }
        word = word.toLowerCase();
        if (table.containsKey(word)) {
            return table.get(word);
        }
        return 0;
    }
}
