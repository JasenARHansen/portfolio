package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_07_Chat_Server;

import java.util.Date;

@SuppressWarnings("unused")
public record Message(String content, Date date) {

    public String content() {
        return this.content;
    }

    public Date date() {
        return this.date;
    }
}
