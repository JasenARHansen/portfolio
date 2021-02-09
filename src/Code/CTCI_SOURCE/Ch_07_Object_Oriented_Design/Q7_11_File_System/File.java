package Code.CTCI_SOURCE.Ch_07_Object_Oriented_Design.Q7_11_File_System;

public class File extends Entry {
    private final int size;
    private String content;

    public File(String n, Directory p, int sz) {
        super(n, p);
        size = sz;
    }

    public int size() {
        return size;
    }

    public String getContents() {
        return content;
    }

    public void setContents(String c) {
        content = c;
    }
}
