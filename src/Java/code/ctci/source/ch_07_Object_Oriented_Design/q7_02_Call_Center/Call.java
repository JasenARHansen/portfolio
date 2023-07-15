package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_02_Call_Center;

@SuppressWarnings({"unused", "FieldCanBeLocal", "UnusedReturnValue"})
public class Call {
    /* Represents a call from a user. Calls have a minimum rank and are assigned to the
    first employee who can handle that call. */
    /* Person who is calling. */
    private final Caller caller;
    /* Employee who is handling call. */
    private Employee handler;
    /* Minimal rank of employee who can handle this call. */
    private Rank rank;

    public Call(Caller c) {
        rank = Rank.Responder;
        caller = c;
    }

    public void disconnect() {
        /* Disconnect call. */
        reply("Thank you for calling");
    }

    public void reply(String message) {
        /* Play recorded message to the customer. */
        System.out.println(message);
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank r) {
        rank = r;
    }

    public Rank incrementRank() {
        if (rank == Rank.Responder) {
            rank = Rank.Manager;
        } else if (rank == Rank.Manager) {
            rank = Rank.Director;
        }
        return rank;
    }

    public void setHandler(Employee e) {
        /* Set employee who is handling call. */
        handler = e;
    }
}
