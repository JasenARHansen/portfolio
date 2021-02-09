package Code.CTCI.CTCI_SOURCE.other.Ch_13_Java.Q13_07_Lambda_Expressions;

public class Country {
    private final String name;
    private final int size;
    private final String continent;

    public Country(String n, String c, int sz) {
        name = n;
        size = sz;
        continent = c;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }

    public int getPopulation() {
        return size;
    }
}
