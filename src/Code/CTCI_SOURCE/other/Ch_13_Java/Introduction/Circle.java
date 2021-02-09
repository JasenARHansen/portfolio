package Code.CTCI_SOURCE.other.Ch_13_Java.Introduction;

public class Circle extends Shape {
    private final double rad = 5;

    public void printMe() {
        System.out.println("I am a circle.");
    }

    public double computeArea() {
        return rad * rad * 3.15;
    }
}
