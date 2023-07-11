package Java.code.unsorted.classes.classesInstance;

@SuppressWarnings("unused")
public record Tuple<X extends Comparable<X>, Y extends Comparable<Y>>(X leftData, Y rightData)
    implements Comparable<Tuple<X, Y>> {

  @Override
  public int compareTo(Tuple<X, Y> target) {
    int leftCompare = this.leftData.compareTo(target.leftData);
    if (leftCompare == 0) {
      return this.rightData.compareTo(target.rightData);
    }
    return leftCompare;
  }

  public X leftData() {
    return this.leftData;
  }

  public Y rightData() {
    return this.rightData;
  }

  @Override
  public String toString() {
    return String.format("(%s,%s)", this.leftData.toString(), this.rightData.toString());
  }
}
