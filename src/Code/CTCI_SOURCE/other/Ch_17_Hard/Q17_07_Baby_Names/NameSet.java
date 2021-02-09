package Code.CTCI_SOURCE.other.Ch_17_Hard.Q17_07_Baby_Names;

import java.util.HashSet;
import java.util.Set;

public class NameSet {
    private final Set<String> names = new HashSet<>();
    private final String rootName;
    private int frequency;

    public NameSet(String name, int freq) {
        names.add(name);
        frequency = freq;
        rootName = name;
    }

    public Set<String> getNames() {
        return names;
    }

    public String getRootName() {
        return rootName;
    }

    public void copyNamesWithFrequency(Set<String> more, int freq) {
        names.addAll(more);
        frequency += freq;
    }

    public int getFrequency() {
        return frequency;
    }

    public int size() {
        return names.size();
    }
}
