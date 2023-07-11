package Java.test.ctci.old.ch_13_Java.q13_07_Lambda_Expressions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import Java.code.ctci.source.ch_13_Java.q13_07_Lambda_Expressions.Country;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CountryTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void Country() {
    String n = "name";
    String c = "c";
    int sz = 32;
    Country country = new Country(n, c, sz);
    assertNotNull(country);
    System.out.format("%s:\n", name.getMethodName());
  }

  @Test
  public void getName() {
    String n = "name";
    String c = "continent";
    int sz = 32;
    Country country = new Country(n, c, sz);
    String result = country.getName();
    assertEquals(n, result);
    System.out.format("%s: getName %s\n", name.getMethodName(), result);
  }

  @Test
  public void getContinent() {
    String n = "name";
    String c = "continent";
    int sz = 32;
    Country country = new Country(n, c, sz);
    String result = country.getContinent();
    assertEquals(c, result);
    System.out.format("%s: getContinent %s\n", name.getMethodName(), result);
  }

  @Test
  public void getPopulation() {
    String n = "name";
    String c = "continent";
    int sz = 32;
    Country country = new Country(n, c, sz);
    int result = country.getPopulation();
    assertEquals(sz, result);
    System.out.format("%s: getPopulation %s\n", name.getMethodName(), result);
  }
}
