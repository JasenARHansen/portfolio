package Java.Code.CTCI.CTCI_SOURCE.Ch_07_Object_Oriented_Design.Q7_02_Call_Center;

class Respondent extends Employee {
  public Respondent(CallHandler callHandler) {
    super(callHandler);
    rank = Rank.Responder;
  }
}
