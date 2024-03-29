package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_05_Online_Book_Reader;

import java.util.HashMap;

@SuppressWarnings("unused")
public class UserManager {
    private HashMap<Integer, User> users;

    public User addUser(int id, String details, int accountType) {
        if (users.containsKey(id)) {
            return null;
        }
        User user = new User(id, details, accountType);
        users.put(id, user);
        return user;
    }

    public User find(int id) {
        return users.get(id);
    }

    public boolean remove(User u) {
        return remove(u.getID());
    }

    public boolean remove(int id) {
        if (!users.containsKey(id)) {
            return false;
        }
        users.remove(id);
        return true;
    }
}
