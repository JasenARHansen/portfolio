package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_07_Chat_Server;

import java.util.ArrayList;

@SuppressWarnings("unused")
public abstract class Conversation {
  protected final ArrayList<User> participants = new ArrayList<>();
  protected final ArrayList<Message> messages = new ArrayList<>();
  protected int id;

  public ArrayList<Message> getMessages() {
    return messages;
  }

  public boolean addMessage(Message m) {
    messages.add(m);
    return true;
  }

  public int getId() {
    return id;
  }
}
