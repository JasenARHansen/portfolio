package Java.test.interview.Facebook.practice;

import static org.junit.Assert.assertArrayEquals;

import Java.code.interview.Facebook.practice.RevenueMilestones;
import java.util.Arrays;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RevenueMilestonesTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void RevenueMilestones() {
    System.out.format("%s: ", name.getMethodName());
    RevenueMilestones.getDescription();
  }

  @Test
  public void getMilestoneDays_1() {
    int[] expected = {4, 6, 10};
    int[] revenues = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    int[] milestones = {100, 200, 500};
    int[] result = RevenueMilestones.getMilestoneDays(revenues, milestones);
    System.out.format(
        "%s: With an income of '%s', the milestones '%s' were reached on these days '%s'\n",
        name.getMethodName(),
        Arrays.toString(revenues),
        Arrays.toString(milestones),
        Arrays.toString(result));
    assertArrayEquals(expected, result);
  }

  @Test
  public void getMilestoneDays_2() {
    int[] expected = {2, 4, 4, 5};
    int[] revenues = {100, 200, 300, 400, 500};
    int[] milestones = {300, 800, 1000, 1400};
    int[] result = RevenueMilestones.getMilestoneDays(revenues, milestones);
    System.out.format(
        "%s: With an income of '%s', the milestones '%s' were reached on these days '%s'\n",
        name.getMethodName(),
        Arrays.toString(revenues),
        Arrays.toString(milestones),
        Arrays.toString(result));
    assertArrayEquals(expected, result);
  }

  @Test
  public void getMilestoneDays_3() {
    int[] expected = {5, 4, 2, 3, 2};
    int[] revenues = {700, 800, 600, 400, 600, 700};
    int[] milestones = {3100, 2200, 800, 2100, 1000};
    int[] result = RevenueMilestones.getMilestoneDays(revenues, milestones);
    System.out.format(
        "%s: With an income of '%s', the milestones '%s' were reached on these days '%s'\n",
        name.getMethodName(),
        Arrays.toString(revenues),
        Arrays.toString(milestones),
        Arrays.toString(result));
    assertArrayEquals(expected, result);
  }

  @Test
  public void getMilestoneDays_4() {
    int[] expected = {5, 4, 2, 3, 2, -1, -1};
    int[] revenues = {700, 800, 600, 400, 600, 700};
    int[] milestones = {3100, 2200, 800, 2100, 1000, 10000, 8000};
    int[] result = RevenueMilestones.getMilestoneDays(revenues, milestones);
    System.out.format(
        "%s: With an income of '%s', the milestones '%s' were reached on these days '%s'\n",
        name.getMethodName(),
        Arrays.toString(revenues),
        Arrays.toString(milestones),
        Arrays.toString(result));
    assertArrayEquals(expected, result);
  }
}
