package CTCI_SOURCE.other.Ch_07_Object_Oriented_Design.Q7_06_Jigsaw;

public enum Orientation {
    LEFT, TOP, RIGHT, BOTTOM; // Should stay in this order

    public Orientation getOpposite() {
        return switch (this) {
            case LEFT -> RIGHT;
            case RIGHT -> LEFT;
            case TOP -> BOTTOM;
            case BOTTOM -> TOP;
        };
    }
}
