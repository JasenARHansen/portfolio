package CTCI_SOURCE.Ch_07_Object_Oriented_Design.Q7_07_Chat_Server;

import java.util.Date;

public class Message {
    private final String content;
    private final Date date;

    public Message(String content, Date date) {
        this.content = content;
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }
}
