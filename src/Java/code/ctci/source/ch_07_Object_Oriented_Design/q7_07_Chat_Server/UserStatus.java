package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_07_Chat_Server;

@SuppressWarnings("unused")
public class UserStatus {
    private final String message;
    private final UserStatusType type;

    public UserStatus(UserStatusType type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public UserStatusType getStatusType() {
        return type;
    }
}
