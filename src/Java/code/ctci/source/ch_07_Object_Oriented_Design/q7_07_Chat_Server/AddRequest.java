package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_07_Chat_Server;

import java.util.Date;

@SuppressWarnings("unused")
public class AddRequest {
    private final Date date;
    private final User fromUser;
    private final User toUser;
    RequestStatus status;

    public AddRequest(User from, User to, Date date) {
        fromUser = from;
        toUser = to;
        this.date = date;
        status = RequestStatus.Unread;
    }

    public Date getDate() {
        return date;
    }

    public User getFromUser() {
        return fromUser;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public User getToUser() {
        return toUser;
    }
}
