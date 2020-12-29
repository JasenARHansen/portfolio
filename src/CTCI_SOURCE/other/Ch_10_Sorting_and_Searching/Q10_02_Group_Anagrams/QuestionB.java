package CTCI_SOURCE.other.Ch_10_Sorting_and_Searching.Q10_02_Group_Anagrams;

import CTCI_SOURCE.other.CtCILibrary.AssortedMethods;
import CTCI_SOURCE.other.CtCILibrary.HashMapList;

import java.util.ArrayList;
import java.util.Arrays;

public class QuestionB {
    public static void sort(String[] array) {
        HashMapList<String, String> mapList = new HashMapList<>();

        /* Group words by anagram */
        for (String s : array) {
            String key = sortChars(s);
            mapList.put(key, s);
        }

        /* Convert hash table to array */
        int index = 0;
        for (String key : mapList.keySet()) {
            ArrayList<String> list = mapList.get(key);
            for (String t : list) {
                array[index] = t;
                index++;
            }
        }
    }

    public static String sortChars(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public static void main(String[] args) {
        String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
        sort(array);
        System.out.println(AssortedMethods.stringArrayToString(array));
    }
}
