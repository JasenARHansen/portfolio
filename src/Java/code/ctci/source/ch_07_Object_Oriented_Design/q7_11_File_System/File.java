package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_11_File_System;

@SuppressWarnings("unused")
public class File extends Entry {
    private final int size;
    private String content;

    public File(String n, Directory p, int sz) {
        super(n, p);
        size = sz;
    }

    public String getContents() {
        return content;
    }

    public void setContents(String c) {
        content = c;
    }

    public int size() {
        return size;
    }
}
