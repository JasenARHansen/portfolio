package CTCI_SOURCE.unprocessed_Ch_07_Object_Oriented_Design.Q7_02_Call_Center;

public enum Rank {
    Responder(0),
    Manager(1),
    Director(2);

    private int value;

    Rank(int v) {
        value = v;
    }

    public int getValue() {
        return value;
    }
}
