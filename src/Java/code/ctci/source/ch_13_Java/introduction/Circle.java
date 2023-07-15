package Java.code.ctci.source.ch_13_Java.introduction;

@SuppressWarnings("FieldCanBeLocal")
public class Circle extends Shape {
    private final double rad = 5;

    public double computeArea() {
        return rad * rad * 3.15;
    }

    public void printMe() {
        System.out.println("I am a circle.");
    }
}
