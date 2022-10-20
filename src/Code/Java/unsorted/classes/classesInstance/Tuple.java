package Code.Java.unsorted.classes.classesInstance;

public class Tuple<X extends Comparable<X>, Y extends Comparable<Y>>
        implements Comparable<Tuple<X, Y>> {
    private final X leftData;
    private final Y rightData;

    public Tuple(X leftData, Y rightData) {
        this.leftData = leftData;
        this.rightData = rightData;
    }

    @Override
    public int compareTo(Tuple<X, Y> target) {
        int leftCompair = this.leftData.compareTo(target.leftData);
        if (leftCompair == 0) {
            return this.rightData.compareTo(target.rightData);
        }
        return leftCompair;
    }

    public X getLeftData() {
        return this.leftData;
    }

    public Y getRightData() {
        return this.rightData;
    }

    @Override
    public String toString() {
        return String.format("(%s,%s)", this.leftData.toString(), this.rightData.toString());
    }
}
