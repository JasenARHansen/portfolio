package unsorted.interfaces;

public interface MathOperation {
    static int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    int operation(int a, int b);
}