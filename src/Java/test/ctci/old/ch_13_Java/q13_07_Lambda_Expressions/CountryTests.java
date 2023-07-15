package Java.test.ctci.old.ch_13_Java.q13_07_Lambda_Expressions;

import Java.code.ctci.source.ch_13_Java.q13_07_Lambda_Expressions.Country;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CountryTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void Country() {
        printTestHeader(name.getMethodName());
        String n = "name";
        String c = "c";
        int sz = 32;
        Country country = new Country(n, c, sz);
        assertNotNull(country);
    }

    @Test
    public void getContinent() {
        printTestHeader(name.getMethodName());
        String n = "name";
        String c = "continent";
        int sz = 32;
        Country country = new Country(n, c, sz);
        String result = country.getContinent();
        assertEquals(c, result);
        System.out.format("\tgetContinent %s\n", result);
    }

    @Test
    public void getName() {
        printTestHeader(name.getMethodName());
        String n = "name";
        String c = "continent";
        int sz = 32;
        Country country = new Country(n, c, sz);
        String result = country.getName();
        assertEquals(n, result);
        System.out.format("\tgetName %s\n", result);
    }

    @Test
    public void getPopulation() {
        printTestHeader(name.getMethodName());
        String n = "name";
        String c = "continent";
        int sz = 32;
        Country country = new Country(n, c, sz);
        int result = country.getPopulation();
        assertEquals(sz, result);
        System.out.format("\tgetPopulation %s\n", result);
    }
}
