package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_07_Chat_Server;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@SuppressWarnings({"unused", "SuspiciousMethodCalls", "UnusedReturnValue"})
public class User {
    private final String accountName;
    private final HashMap<Integer, User> contacts = new HashMap<>();
    private final String fullName;
    private final ArrayList<GroupChat> groupChats = new ArrayList<>();
    private final int id;
    private final HashMap<Integer, PrivateChat> privateChats = new HashMap<>();
    private final HashMap<Integer, AddRequest> receivedAddRequests = new HashMap<>();
    private final HashMap<Integer, AddRequest> sentAddRequests = new HashMap<>();
    private UserStatus status = null;

    public User(int id, String accountName, String fullName) {
        this.accountName = accountName;
        this.fullName = fullName;
        this.id = id;
    }

    public boolean addContact(User user) {
        if (contacts.containsKey(user.getId())) {
            return false;
        } else {
            contacts.put(user.getId(), user);
            return true;
        }
    }

    public int getId() {
        return id;
    }

    public void addConversation(PrivateChat conversation) {
        User otherUser = conversation.getOtherParticipant(this);
        privateChats.put(otherUser.getId(), conversation);
    }

    public void addConversation(GroupChat conversation) {
        groupChats.add(conversation);
    }

    public String getAccountName() {
        return accountName;
    }

    public String getFullName() {
        return fullName;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public void receivedAddRequest(AddRequest req) {
        int senderId = req.getFromUser().getId();
        if (!receivedAddRequests.containsKey(senderId)) {
            receivedAddRequests.put(senderId, req);
        }
    }

    public void removeAddRequest(AddRequest req) {
        if (req.getToUser() == this) {
            receivedAddRequests.remove(req);
        } else if (req.getFromUser() == this) {
            sentAddRequests.remove(req);
        }
    }

    public void requestAddUser(String accountName) {
        UserManager.getInstance().addUser(this, accountName);
    }

    public boolean sendMessageToGroupChat(int groupId, String content) {
        GroupChat chat = groupChats.get(groupId);
        if (chat != null) {
            Message message = new Message(content, new Date());
            return chat.addMessage(message);
        }
        return false;
    }

    public boolean sendMessageToUser(User toUser, String content) {
        PrivateChat chat = privateChats.get(toUser.getId());
        if (chat == null) {
            chat = new PrivateChat(this, toUser);
            privateChats.put(toUser.getId(), chat);
        }
        Message message = new Message(content, new Date());
        return chat.addMessage(message);
    }

    public void sentAddRequest(AddRequest req) {
        int receiverId = req.getFromUser().getId();
        if (!sentAddRequests.containsKey(receiverId)) {
            sentAddRequests.put(receiverId, req);
        }
    }
}
