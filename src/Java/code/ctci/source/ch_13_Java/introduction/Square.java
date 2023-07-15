package Java.code.ctci.source.ch_13_Java.introduction;

@SuppressWarnings("FieldCanBeLocal")
public class Square extends Shape {
    private final double len = 5;

    public double computeArea() {
        return len * len;
    }

    public void printMe() {
        System.out.println("I am a square.");
    }
}
