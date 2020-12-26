package CTCI_SOURCE.unprocessed_Ch_07_Object_Oriented_Design.Q7_06_Jigsaw;

public enum Shape {
    INNER, OUTER, FLAT;

    public Shape getOpposite() {
        return switch (this) {
            case INNER -> OUTER;
            case OUTER -> INNER;
            default -> null;
        };
    }
}
