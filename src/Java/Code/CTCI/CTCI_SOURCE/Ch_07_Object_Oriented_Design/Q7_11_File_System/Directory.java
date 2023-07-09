package Java.Code.CTCI.CTCI_SOURCE.Ch_07_Object_Oriented_Design.Q7_11_File_System;

import java.util.ArrayList;

public class Directory extends Entry {
  protected ArrayList<Entry> contents;

  public Directory(String n, Directory p) {
    super(n, p);
    contents = new ArrayList<>();
  }

  public int size() {
    int size = 0;
    for (Entry e : contents) {
      size += e.size();
    }
    return size;
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

  public boolean deleteEntry(Entry entry) {
    return contents.remove(entry);
  }

  public void addEntry(Entry entry) {
    contents.add(entry);
  }

  protected ArrayList<Entry> getContents() {
    return contents;
  }
}
