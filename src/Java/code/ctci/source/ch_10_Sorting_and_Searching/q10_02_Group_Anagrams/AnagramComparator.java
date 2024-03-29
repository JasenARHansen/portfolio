package Java.code.ctci.source.ch_10_Sorting_and_Searching.q10_02_Group_Anagrams;

import java.util.Arrays;
import java.util.Comparator;

public class AnagramComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
        return sortChars(s1).compareTo(sortChars(s2));
    }

    private String sortChars(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
}
