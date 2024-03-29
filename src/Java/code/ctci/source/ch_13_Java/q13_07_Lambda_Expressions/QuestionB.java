package Java.code.ctci.source.ch_13_Java.q13_07_Lambda_Expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@SuppressWarnings("DuplicatedCode")
public class QuestionB {
    public static void main(String... args) {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(new Country("United States", "North America", 5));
        countries.add(new Country("Canada", "North America", 10));
        countries.add(new Country("India", "Asia", 30));
        System.out.println(getPopulation(countries, "North America"));
    }

    public static int getPopulation(List<Country> countries, String continent) {
        Stream<Country> sublist =
                countries.stream().filter(country -> country.getContinent().equals(continent));
        Stream<Integer> populations = sublist.map(Country::getPopulation);
        return populations.reduce(0, Integer::sum);
    }
}
