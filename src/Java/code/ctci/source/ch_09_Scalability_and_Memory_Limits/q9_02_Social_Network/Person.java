package Java.code.ctci.source.ch_09_Scalability_and_Memory_Limits.q9_02_Social_Network;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class Person {
    private final ArrayList<Integer> friends = new ArrayList<>();
    private final int personID;
    private String info;

    public Person(int id) {
        this.personID = id;
    }

    public void addFriend(int id) {
        friends.add(id);
    }

    public ArrayList<Integer> getFriends() {
        return friends;
    }

    public int getID() {
        return personID;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
