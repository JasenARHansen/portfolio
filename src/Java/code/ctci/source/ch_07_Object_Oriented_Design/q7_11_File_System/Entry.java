package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_11_File_System;

@SuppressWarnings("unused")
public abstract class Entry {
    protected final long created;
    protected final Directory parent;
    protected long lastAccessed;
    protected long lastUpdated;
    protected String name;

    public Entry(String n, Directory p) {
        name = n;
        parent = p;
        created = System.currentTimeMillis();
    }

    public void changeName(String n) {
        name = n;
    }

    public boolean delete() {
        if (parent == null) {
            return false;
        }
        return parent.deleteEntry(this);
    }

    public long getCreationTime() {
        return created;
    }

    public String getFullPath() {
        if (parent == null) {
            return name;
        } else {
            return parent.getFullPath() + "/" + name;
        }
    }

    public long getLastAccessedTime() {
        return lastAccessed;
    }

    public long getLastUpdatedTime() {
        return lastUpdated;
    }

    public String getName() {
        return name;
    }

    public abstract int size();
}
