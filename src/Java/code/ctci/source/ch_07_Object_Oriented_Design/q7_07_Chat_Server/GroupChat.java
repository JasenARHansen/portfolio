package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_07_Chat_Server;

@SuppressWarnings("unused")
public class GroupChat extends Conversation {
    public void addParticipant(User user) {
        participants.add(user);
    }

    public void removeParticipant(User user) {
        participants.remove(user);
    }
}
