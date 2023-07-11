package Java.test.hackerrank.dictionariesAndHashmaps;

import Java.code.hackerrank.dictionariesAndHashmaps.HashTablesRansomNote;
import java.util.Arrays;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HashTablesRansomNoteTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void checkMagazine_1() {
    String[] magazine = {"give", "me", "one", "grand", "today", "night"};
    String[] note = {"give", "one", "grand", "today"};
    System.out.format(
        "%s: Can you make a ransom note '%s' using '%s'?\n",
        name.getMethodName(), Arrays.toString(note), Arrays.toString(magazine));
    HashTablesRansomNote.checkMagazine(magazine, note);
  }

  @Test
  public void checkMagazine_2() {
    String[] magazine = {"two", "times", "three", "is", "not", "four"};
    String[] note = {"two", "times", "two", "is", "four"};
    System.out.format(
        "%s: Can you make a ransom note '%s' using '%s'?\n",
        name.getMethodName(), Arrays.toString(note), Arrays.toString(magazine));
    HashTablesRansomNote.checkMagazine(magazine, note);
  }

  @Test
  public void checkMagazine_3() {
    String[] magazine = {"ive", "got", "a", "lovely", "bunch", "of", "coconuts"};
    String[] note = {"ive", "got", "some", "coconuts"};
    System.out.format(
        "%s: Can you make a ransom note '%s' using '%s'?\n",
        name.getMethodName(), Arrays.toString(note), Arrays.toString(magazine));
    HashTablesRansomNote.checkMagazine(magazine, note);
  }
}
