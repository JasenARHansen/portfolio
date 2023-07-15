package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_05_Online_Book_Reader;

@SuppressWarnings("unused")
public class User {
    private int accountType;
    private String details;
    private int userId;

    public User(int id, String details, int accountType) {
        userId = id;
        this.details = details;
        this.accountType = accountType;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getID() {
        /* getters and setters. */
        return userId;
    }

    public void setID(int id) {
        userId = id;
    }

    public void renewMembership() {
        System.out.println("Membership renewed");
    }
}
