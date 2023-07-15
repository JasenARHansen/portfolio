package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_02_Call_Center;

class Respondent extends Employee {
    public Respondent(CallHandler callHandler) {
        super(callHandler);
        rank = Rank.Responder;
    }
}
