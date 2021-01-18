package Test.chalenge;

import chalenge.StairCase;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StairCaseTest {

  @Rule
  public TestName name = new TestName();

  @Test
  public void triangleLeftJustifiedPointDown_1() {
    int defaultCount = 4;
    System.out.format(
            "%s: Left Justified Triangle Point Down %d characters wide\n",
            name.getMethodName(), defaultCount);
    StairCase.triangleLeftJustifiedPointDown(defaultCount);
  }

  @Test
  public void triangleLeftJustifiedPointDown_2() {
    int defaultCount = 5;
    char firstSymbol = '@';
    System.out.format(
            "%s: Left Justified Triangle Point Down %d characters wide using character '%s'\n",
            name.getMethodName(), defaultCount, firstSymbol);
    StairCase.triangleLeftJustifiedPointDown(defaultCount, firstSymbol);
  }

  @Test
  public void triangleLeftJustifiedPointDown_3() {
    int defaultCount = 6;
    boolean defaultInscribed = true;
    System.out.format(
            "%s: Left Justified Triangle Point Down %d characters wide, inscribed '%b'\n",
            name.getMethodName(), defaultCount, defaultInscribed);
    StairCase.triangleLeftJustifiedPointDown(defaultCount, defaultInscribed);
  }

  @Test
  public void triangleLeftJustifiedPointDown_4() {
    int defaultCount = 7;
    char firstSymbol = '@';
    boolean defaultInscribed = true;
    System.out.format(
            "%s: Left Justified Triangle Point Down %d characters wide using character '%s', inscribed '%b'\n",
            name.getMethodName(), defaultCount, firstSymbol, defaultInscribed);
    StairCase.triangleLeftJustifiedPointDown(defaultCount, defaultInscribed, firstSymbol);
  }

  @Test
  public void triangleLeftJustifiedPointDown_5() {
    int defaultCount = 8;
    char firstSymbol = '@';
    char secondSymbol = '$';
    boolean defaultInscribed = true;
    System.out.format(
            "%s: Left Justified Triangle Point Down %d characters wide using characters: '%s' and '%s', inscribed '%b'\n",
            name.getMethodName(), defaultCount, firstSymbol, secondSymbol, defaultInscribed);
    StairCase.triangleLeftJustifiedPointDown(
            defaultCount, defaultInscribed, firstSymbol, secondSymbol);
  }

  @Test
  public void triangleLeftJustifiedPointUp_1() {
    int defaultCount = 4;
    System.out.format(
            "%s: Left Justified Triangle Point Up %d characters wide\n",
            name.getMethodName(), defaultCount);
    StairCase.triangleLeftJustifiedPointUp(defaultCount);
  }

  @Test
  public void triangleLeftJustifiedPointUp_2() {
    int defaultCount = 5;
    char firstSymbol = '@';
    System.out.format(
            "%s: Left Justified Triangle Point Up %d characters wide using character '%s'\n",
            name.getMethodName(), defaultCount, firstSymbol);
    StairCase.triangleLeftJustifiedPointUp(defaultCount, firstSymbol);
  }

  @Test
  public void triangleLeftJustifiedPointUp_3() {
    int defaultCount = 6;
    boolean defaultInscribed = true;
    System.out.format(
            "%s: Left Justified Triangle Point Up %d characters wide, inscribed '%b'\n",
            name.getMethodName(), defaultCount, defaultInscribed);
    StairCase.triangleLeftJustifiedPointUp(defaultCount, defaultInscribed);
  }

  @Test
  public void triangleLeftJustifiedPointUp_4() {
    int defaultCount = 7;
    char firstSymbol = '@';
    boolean defaultInscribed = true;
    System.out.format(
            "%s: Left Justified Triangle Point Up %d characters wide using character '%s', inscribed '%b'\n",
            name.getMethodName(), defaultCount, firstSymbol, defaultInscribed);
    StairCase.triangleLeftJustifiedPointUp(defaultCount, defaultInscribed, firstSymbol);
  }

  @Test
  public void triangleLeftJustifiedPointUp_5() {
    int defaultCount = 8;
    char firstSymbol = '@';
    char secondSymbol = '$';
    boolean defaultInscribed = true;
    System.out.format(
            "%s: Left Justified Triangle Point Up %d characters wide using characters: '%s' and '%s', inscribed '%b'\n",
            name.getMethodName(), defaultCount, firstSymbol, secondSymbol, defaultInscribed);
    StairCase.triangleLeftJustifiedPointUp(
            defaultCount, defaultInscribed, firstSymbol, secondSymbol);
  }
}
