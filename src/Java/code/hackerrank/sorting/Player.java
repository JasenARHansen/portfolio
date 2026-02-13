package Java.code.hackerrank.sorting;

public record Player(String name, int points) {

    public String name() {
        return this.name;
    }

    public int points() {
        return this.points;
    }
}
