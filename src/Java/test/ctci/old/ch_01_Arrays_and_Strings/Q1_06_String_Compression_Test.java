package Java.test.ctci.old.ch_01_Arrays_and_Strings;

import static org.junit.Assert.assertEquals;

import Java.code.ctci.old.ch_01_Arrays_and_Strings.Q1_06_String_Compression;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"NewClassNamingConvention", "SpellCheckingInspection"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q1_06_String_Compression_Test {
  @Rule public final TestName name = new TestName();

  @Test
  public void stringCompression_small() {
    String expected = "aa";
    String source = "aa";
    String result = Q1_06_String_Compression.stringCompression(source);
    assertEquals(expected, result);
    System.out.format("%s: '%s' converts to '%s'\n", name.getMethodName(), source, result);
  }

  @Test
  public void stringCompression_large() {
    String expected = "a1b3a4";
    String source = "abbbaaaa";
    String result = Q1_06_String_Compression.stringCompression(source);
    assertEquals(expected, result);
    System.out.format("%s: '%s' converts to '%s'\n", name.getMethodName(), source, result);
  }

  @Test
  public void stringCompression_solution_1_small() {
    String expected = "bb";
    String source = "bb";
    String result = Q1_06_String_Compression.stringCompression_solution_1(source);
    assertEquals(expected, result);
    System.out.format("%s: '%s' converts to '%s'\n", name.getMethodName(), source, result);
  }

  @Test
  public void stringCompression_solution_1_large() {
    String expected = "a2b3";
    String source = "aabbb";
    String result = Q1_06_String_Compression.stringCompression_solution_1(source);
    assertEquals(expected, result);
    System.out.format("%s: '%s' converts to '%s'\n", name.getMethodName(), source, result);
  }

  @Test
  public void stringCompression_solution_2_small() {
    String expected = "cc";
    String source = "cc";
    String result = Q1_06_String_Compression.stringCompression_solution_2(source);
    assertEquals(expected, result);
    System.out.format("%s: '%s' converts to '%s'\n", name.getMethodName(), source, result);
  }

  @Test
  public void stringCompression_solution_2_large() {
    String expected = "a2b2c3";
    String source = "aabbccc";
    String result = Q1_06_String_Compression.stringCompression_solution_2(source);
    assertEquals(expected, result);
    System.out.format("%s: '%s' converts to '%s'\n", name.getMethodName(), source, result);
  }

  @Test
  public void stringCompression_solution_3_small() {
    String expected = "dd";
    String source = "dd";
    String result = Q1_06_String_Compression.stringCompression_solution_3(source);
    assertEquals(expected, result);
    System.out.format("%s: '%s' converts to '%s'\n", name.getMethodName(), source, result);
  }

  @Test
  public void stringCompression_solution_3_large() {
    String expected = "a5b4a4b2d2c1";
    String source = "aaaaabbbbaaaabbddc";
    String result = Q1_06_String_Compression.stringCompression_solution_3(source);
    assertEquals(expected, result);
    System.out.format("%s: '%s' converts to '%s'\n", name.getMethodName(), source, result);
  }
}
