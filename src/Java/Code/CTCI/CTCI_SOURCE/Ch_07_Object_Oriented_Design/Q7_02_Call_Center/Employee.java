package Java.Code.CTCI.CTCI_SOURCE.Ch_07_Object_Oriented_Design.Q7_02_Call_Center;

abstract class Employee {
  /* Employee is a super class for the Director, Manager, and Respondent.
  It is implemented as an abstract class, since there should be no reason
   to instantiate an Employee type directly. */
  private final CallHandler callHandler;
  protected Rank rank;
  private Call currentCall = null;

  public Employee(CallHandler handler) {
    callHandler = handler;
  }

  public void receiveCall(Call call) {
    /* Start the conversation. */
    currentCall = call;
  }

  public void callCompleted() {
    /* the issue is resolved, finish the call. */
    if (currentCall != null) {
      /* Disconnect the call. */
      currentCall.disconnect();
      /* Free the employee. */
      currentCall = null;
    }
    /* Check if there is a call waiting in queue. */
    assignNewCall();
  }

  public boolean assignNewCall() {
    /* Assign a new call to an employee, if the employee is free. */
    if (!isFree()) {
      return false;
    }
    return callHandler.assignCall(this);
  }

  public boolean isFree() {
    /* Returns whether-or-not the employee is free. */
    return currentCall == null;
  }

  public void escalateAndReassign() {
    /* The issue has not been resolved. Escalate the call, and assign a new call
    to the employee. */
    if (currentCall != null) {
      /* escalate call. */
      currentCall.incrementRank();
      callHandler.dispatchCall(currentCall);
      /* free the employee. */
      currentCall = null;
    }
    /* assign a new call. */
    assignNewCall();
  }

  public Rank getRank() {
    return rank;
  }
}
