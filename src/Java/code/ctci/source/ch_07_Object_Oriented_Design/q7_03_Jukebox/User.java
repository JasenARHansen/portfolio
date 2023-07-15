package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_03_Jukebox;

@SuppressWarnings("unused")
public class User {
    private long ID;
    private String name;

    public User(String name, long iD) {
        this.name = name;
        ID = iD;
    }

    public static User addUser(String name, long iD) {
        return new User(name, iD);
    }

    public long getID() {
        return ID;
    }

    public void setID(long iD) {
        ID = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return this;
    }
}
