package Java.Code.CTCI.CTCI_SOURCE.Ch_07_Object_Oriented_Design.Q7_07_Chat_Server;

import java.util.Date;
import java.util.HashMap;

@SuppressWarnings({"unused", "MismatchedQueryAndUpdateOfCollection"})
public class UserManager {
  /* UserManager serves as the central place for the core user actions. */
  private static UserManager instance;
  private final HashMap<Integer, User> usersById = new HashMap<>();
  private final HashMap<String, User> usersByAccountName = new HashMap<>();
  private final HashMap<Integer, User> onlineUsers = new HashMap<>();

  public static UserManager getInstance() {
    if (instance == null) {
      instance = new UserManager();
    }
    return instance;
  }

  public void addUser(User fromUser, String toAccountName) {
    User toUser = usersByAccountName.get(toAccountName);
    AddRequest req = new AddRequest(fromUser, toUser, new Date());
    toUser.receivedAddRequest(req);
    fromUser.sentAddRequest(req);
  }

  public void approveAddRequest(AddRequest req) {
    req.status = RequestStatus.Accepted;
    User from = req.getFromUser();
    User to = req.getToUser();
    from.addContact(to);
    to.addContact(from);
  }

  public void rejectAddRequest(AddRequest req) {
    req.status = RequestStatus.Rejected;
    User from = req.getFromUser();
    User to = req.getToUser();
    from.removeAddRequest(req);
    to.removeAddRequest(req);
  }

  public void userSignedOn(String accountName) {
    User user = usersByAccountName.get(accountName);
    if (user != null) {
      user.setStatus(new UserStatus(UserStatusType.Available, ""));
      onlineUsers.put(user.getId(), user);
    }
  }

  public void userSignedOff(String accountName) {
    User user = usersByAccountName.get(accountName);
    if (user != null) {
      user.setStatus(new UserStatus(UserStatusType.Offline, ""));
      onlineUsers.remove(user.getId());
    }
  }
}
