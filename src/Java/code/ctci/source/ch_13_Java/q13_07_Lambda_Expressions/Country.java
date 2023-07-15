package Java.code.ctci.source.ch_13_Java.q13_07_Lambda_Expressions;

public class Country {
    private final String continent;
    private final String name;
    private final int size;

    public Country(String n, String c, int sz) {
        name = n;
        size = sz;
        continent = c;
    }

    public String getContinent() {
        return continent;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return size;
    }
}
