package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_11_File_System;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class Directory extends Entry {
    protected final ArrayList<Entry> contents;

    public Directory(String n, Directory p) {
        super(n, p);
        contents = new ArrayList<>();
    }

    public void addEntry(Entry entry) {
        contents.add(entry);
    }

    public boolean deleteEntry(Entry entry) {
        return contents.remove(entry);
    }

    protected ArrayList<Entry> getContents() {
        return contents;
    }

    public int numberOfFiles() {
        int count = 0;
        for (Entry e : contents) {
            if (e instanceof Directory d) {
                count++; // Directory counts as a file
                count += d.numberOfFiles();
            } else if (e instanceof File) {
                count++;
            }
        }
        return count;
    }

    public int size() {
        int size = 0;
        for (Entry e : contents) {
            size += e.size();
        }
        return size;
    }
}
