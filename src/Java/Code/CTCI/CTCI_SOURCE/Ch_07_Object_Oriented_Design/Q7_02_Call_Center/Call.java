package Java.Code.CTCI.CTCI_SOURCE.Ch_07_Object_Oriented_Design.Q7_02_Call_Center;
/* Represents a call from a user. Calls have a minimum rank and are assigned to the
   first employee who can handle that call. */
public class Call {
  /** Person who is calling. */
  private final Caller caller;
  /* Minimal rank of employee who can handle this call. */
  private Rank rank;
  /* Employee who is handling call. */
  private Employee handler;

  public Call(Caller c) {
    rank = Rank.Responder;
    caller = c;
  }

  public void setHandler(Employee e) {
    /* Set employee who is handling call. */
    handler = e;
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

  public void disconnect() {
    /* Disconnect call. */
    reply("Thank you for calling");
  }

  public void reply(String message) {
    /* Play recorded message to the customer. */
    System.out.println(message);
  }
}
