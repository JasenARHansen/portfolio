package Java.code.ctci.source.ch_13_Java.q13_07_Lambda_Expressions;

import java.util.ArrayList;
import java.util.List;

public class QuestionA {
    public static void main(String... args) {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(new Country("United States", "North America", 1));
        countries.add(new Country("Canada", "North America", 5));
        countries.add(new Country("India", "Asia", 9));
        System.out.println(getPopulation(countries, "Asia"));
    }

    public static int getPopulation(List<Country> countries, String continent) {
        int sum = 0;
        for (Country c : countries) {
            if (c.getContinent().equals(continent)) {
                sum += c.getPopulation();
            }
        }
        return sum;
    }
}
