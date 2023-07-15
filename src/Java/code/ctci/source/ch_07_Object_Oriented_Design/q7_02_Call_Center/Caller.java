package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_02_Call_Center;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class Caller {
    private final String name;
    private final int userId;

    public Caller(int id, String nm) {
        name = nm;
        userId = id;
    }
}
