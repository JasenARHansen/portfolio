package CTCI_SOURCE.other.Introduction.Ch_17_Hard.Q17_25_Word_Rectangle;

import java.util.ArrayList;
import java.util.HashMap;

/* A container for a group of words of the same length. */
public class WordGroup {
    private final HashMap<String, Boolean> lookup = new HashMap<>();
    private final ArrayList<String> group = new ArrayList<>();

    public WordGroup() {

    }

    public static WordGroup[] createWordGroups(String[] list) {
        WordGroup[] groupList;
        int maxWordLength = 0;
        // Find out the length of the longest word
        for (String value : list) {
            if (value.length() > maxWordLength) {
                maxWordLength = value.length();
            }
        }

        /* Group the words in the dictionary into lists of words of
         * same length.groupList[i] will contain a list of words, each
         * of length (i+1). */
        groupList = new WordGroup[maxWordLength];
        for (String s : list) {
            /* We do wordLength - 1 instead of just wordLength since this is used as
             * an index and no words are of length 0 */
            int wordLength = s.length() - 1;
            if (groupList[wordLength] == null) {
                groupList[wordLength] = new WordGroup();
            }
            groupList[wordLength].addWord(s);
        }
        return groupList;
    }

    public boolean containsWord(String s) {
        return lookup.containsKey(s);
    }

    public void addWord(String s) {
        group.add(s);
        lookup.put(s, true);
    }

    public int length() {
        return group.size();
    }

    public String getWord(int i) {
        return group.get(i);
    }

    public ArrayList<String> getWords() {
        return group;
    }
}
