package Java.code.ctci.source.ch_17_Hard.q17_15_Longest_Word;

import java.util.Comparator;

public class LengthComparator implements Comparator<String> {
    public int compare(String o1, String o2) {
        return Integer.compare(o2.length(), o1.length());
    }
}
