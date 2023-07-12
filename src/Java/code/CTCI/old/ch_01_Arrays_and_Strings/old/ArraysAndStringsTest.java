package Java.code.ctci.old.ch_01_Arrays_and_Strings.old;

import static org.junit.Assert.*;

import Java.code.ctci.old.unsorted.RansomNote;
import Java.code.ctci.old.unsorted.SubstringPermutationOfLargerString;
import Java.code.ctci.old.unsorted.SumOfCubes;
import Java.code.unsorted.classesStatic.Utilities;
import java.util.Set;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings("SpellCheckingInspection")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArraysAndStringsTest {
  @Rule public final TestName name = new TestName();

  @Test
  public void compressedString() {
    System.out.format("\n%s:\n", name.getMethodName());
    String[] words = {"aa", "aaaaabbbbaaaabbddc", "c", ""};
    for (String word : words) {
      System.out.format(
          "Words '%s' compressed is '%s'\n", word, ArraysAndStrings.compressedString(word));
    }
  }

  @Test
  public void isPermutation() {
    System.out.format("\n%s:\n", name.getMethodName());
    String[][] pairs = {{"apple", "cat"}, {"carrot", "fish"}, {"hello", "llloh"}};
    for (String[] pair : pairs) {
      String word1 = pair[0];
      String word2 = pair[1];
      System.out.format(
          "Words '%s' and '%s' are permutations '%s'\n",
          word1, word2, ArraysAndStrings.isPermutation(word1, word2));
    }
  }

  @Test
  public void isSubstring() {
    System.out.format("\n%s:\n", name.getMethodName());
    String first = "cat";
    String second = "dog";
    System.out.format(
        "'%s' is a rotation of '%s' : '%s'\n",
        second, first, ArraysAndStrings.isRotation(first, second));
    first = "waterbottle";
    second = "erbottlewat";
    System.out.format(
        "'%s' is a rotation of '%s' : '%s'\n",
        second, first, ArraysAndStrings.isRotation(first, second));
  }

  @Test
  public void isUnique() {
    System.out.format("\n%s:\n", name.getMethodName());
    String[] words = {"abcde", "hello", "apple", "kite", "padle"};
    for (String word : words) {
      System.out.format("Word '%s' '%s'\n", word, ArraysAndStrings.isUnique(word));
    }
  }

  @Test
  public void palindromePermutation() {
    System.out.format("\n%s:\n", name.getMethodName());
    String[] strings = {
      "Tact Coa",
      "Rats live on no evil star",
      "Ratzs live on no evil starz",
      "Zeus was deified, saw Suez",
      "test"
    };
    for (String string : strings) {
      System.out.format(
          "Value '%s' tested for palindrome conversion is '%s'\n",
          string, ArraysAndStrings.palindromePermutation(string));
    }
  }

  @Test
  public void permuteString() {
    System.out.format("\n%s:\n", name.getMethodName());
    String smaller = "abbc";
    Set<String> returnSet = SubstringPermutationOfLargerString.permuteString(smaller);
    assertNotNull("Valid", returnSet);
  }

  @Test
  public void RansomNote() {
    System.out.format("\n%s:\n", name.getMethodName());
    String note = "give me your money";
    String magazine1 =
        "If you want to give your money to charity you can take it from me that it will save lives.";
    String magazine2 =
        "good can be used for everything from driving, making deliveries, and taking your dog to the vet.";
    String magazine3 = "this music rocks!";
    boolean testBool = RansomNote.findNoteWords(note, magazine1);
    assertTrue("Valid", testBool);
    testBool = RansomNote.findNoteWords(note, magazine2);
    assertFalse("Invalid", testBool);
    testBool = RansomNote.findNoteLetters(note, magazine2);
    assertTrue("Valid", testBool);
    testBool = RansomNote.findNoteLetters(note, magazine3);
    assertFalse("Invalid", testBool);
  }

  @Test
  public void rotate() {
    System.out.format("\n%s:\n", name.getMethodName());
    int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    Utilities.printMatrix(matrix);
    System.out.print("\n");
    ArraysAndStrings.rotate(matrix);
    Utilities.printMatrix(matrix);
  }

  @Test
  public void getDescription() {
    System.out.format("\n%s:\n", name.getMethodName());
    ArraysAndStrings.getDescription();
  }

  @Test
  public void singleEdit() {
    System.out.format("\n%s:\n", name.getMethodName());
    String[][] pairs = {
      {"palee", "pale"},
      {"pale", "pkle"},
      {"pse", "pale"},
      {"pale", "pale"},
      {"a", "b"},
      {"", "d"},
      {"d", "de"},
      {"pale", "pse"},
      {"acdsfdsfadsf", "acdsgdsfadsf"},
      {"acdsfdsfadsf", "acdsfdfadsf"},
      {"acdsfdsfadsf", "acdsfdsfads"},
      {"acdsfdsfadsf", "cdsfdsfadsf"},
      {"adfdsfadsf", "acdfdsfdsf"},
      {"adfdsfadsf", "bdfdsfadsg"},
      {"adfdsfadsf", "affdsfads"},
      {"pale", "pkle"},
      {"pkle", "pable"}
    };
    for (String[] pair : pairs) {
      String word1 = pair[0];
      String word2 = pair[1];
      System.out.format(
          "Words '%s' and '%s' are single edits '%s'\n",
          word1, word2, ArraysAndStrings.singleEdit(word1, word2));
    }
  }

  @Test
  public void SubstringPermutationOfLargerString() {
    System.out.format("\n%s:\n", name.getMethodName());
    String smaller = "abbc";
    String larger = "cbabadcbbabbcbabaabccbabc";
    SubstringPermutationOfLargerString.findPermutations(larger, smaller);
  }

  @Test
  public void findValues() {
    System.out.format("\n%s:\n", name.getMethodName());
    SumOfCubes.findValues(5);
  }

  @Test
  public void URLif() {
    System.out.format("\n%s:\n", name.getMethodName());
    String value = "Mr John Smith    ";
    System.out.format("Value '%s' converted is '%s'\n", value, ArraysAndStrings.URLif(value));
  }

  @Test
  public void zeroMatrix() {
    System.out.format("\n%s:\n", name.getMethodName());
    int[][] matrix = {{0, 2, 0}, {4, 5, 6}, {7, 8, 9}};
    Utilities.printMatrix(matrix);
    System.out.print("\n");
    ArraysAndStrings.zeroMatrix(matrix);
    Utilities.printMatrix(matrix);
  }
}
