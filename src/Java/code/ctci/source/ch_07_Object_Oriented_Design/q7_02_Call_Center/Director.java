package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_02_Call_Center;

class Director extends Employee {
    public Director(CallHandler callHandler) {
        super(callHandler);
        rank = Rank.Director;
    }
}
