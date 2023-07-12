package Java.test.challenge;

import static org.junit.Assert.*;

import Java.code.challenge.ThiefAndSensors;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings("DuplicatedCode")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ThiefAndSensorsTest {
  @Rule public final TestName name = new TestName();

  @Test
  public void getDescription() {
    System.out.format("%s: ", name.getMethodName());
    ThiefAndSensors.getDescription();
  }

  @Test
  public void thiefAndSensors_1() {
    String expected_1 = "There is no path available";
    String expected_2 = "There is no path from Left to Right";
    String expected_3 = "There is no path from Bottom to Top";
    int lowerRightX = 0;
    int lowerRightY = 0;
    int width = 10;
    int height = 10;
    System.out.format(
        "%s: The room with corner (%d, %d) with a width of '%d' and a height of of '%d'\n",
        name.getMethodName(), lowerRightX, lowerRightY, width, height);
    ThiefAndSensors.constructRoom(lowerRightX, lowerRightY, width, height);
    ThiefAndSensors.add_circle(1, 1, 1);
    ThiefAndSensors.add_circle(3, 3, 3);
    ThiefAndSensors.add_circle(5, 8, 4);
    ThiefAndSensors.add_circle(8, 8, 2);
    String result_1 = ThiefAndSensors.pathExists();
    String result_2 = ThiefAndSensors.pathBottomTop();
    String result_3 = ThiefAndSensors.pathLeftRight();
    assertNotNull(result_1);
    assertEquals(expected_1, result_1);
    assertNotNull(result_2);
    assertEquals(expected_2, result_2);
    assertNotNull(result_3);
    assertEquals(expected_3, result_3);
    System.out.format("\t%s\n", result_1);
    System.out.format("\t%s\n", result_2);
    System.out.format("\t%s\n", result_3);
  }

  @Test
  public void thiefAndSensors_2() {
    String expected_1 = "There is a path available";
    String expected_2 = "There is no path from Left to Right";
    String expected_3 = "There is a path from Bottom to Top";
    int lowerRightX = -1;
    int lowerRightY = 0;
    int width = 10;
    int height = 10;
    System.out.format(
        "%s: The room with corner (%d, %d) with a width of '%d' and a height of of '%d'\n",
        name.getMethodName(), lowerRightX, lowerRightY, width, height);
    ThiefAndSensors.constructRoom(lowerRightX, lowerRightY, width, height);
    ThiefAndSensors.add_circle(1, 1, 1);
    ThiefAndSensors.add_circle(3, 3, 3);
    ThiefAndSensors.add_circle(5, 8, 4);
    ThiefAndSensors.add_circle(8, 8, 2);
    String result_1 = ThiefAndSensors.pathExists();
    String result_2 = ThiefAndSensors.pathBottomTop();
    String result_3 = ThiefAndSensors.pathLeftRight();
    assertNotNull(result_1);
    assertEquals(expected_1, result_1);
    assertNotNull(result_2);
    assertEquals(expected_2, result_2);
    assertNotNull(result_3);
    assertEquals(expected_3, result_3);
    System.out.format("\t%s\n", result_1);
    System.out.format("\t%s\n", result_2);
    System.out.format("\t%s\n", result_3);
  }

  @Test
  public void thiefAndSensors_3() {
    String expected_1 = "There is a path available";
    String expected_2 = "There is a path from Left to Right";
    String expected_3 = "There is no path from Bottom to Top";
    int lowerRightX = 0;
    int lowerRightY = -1;
    int width = 10;
    int height = 10;
    System.out.format(
        "%s: The room with corner (%d, %d) with a width of '%d' and a height of of '%d'\n",
        name.getMethodName(), lowerRightX, lowerRightY, width, height);
    ThiefAndSensors.constructRoom(lowerRightX, lowerRightY, width, height);
    ThiefAndSensors.add_circle(1, 1, 1);
    ThiefAndSensors.add_circle(3, 3, 3);
    ThiefAndSensors.add_circle(5, 8, 4);
    ThiefAndSensors.add_circle(8, 8, 2);
    String result_1 = ThiefAndSensors.pathExists();
    String result_2 = ThiefAndSensors.pathBottomTop();
    String result_3 = ThiefAndSensors.pathLeftRight();
    assertNotNull(result_1);
    assertEquals(expected_1, result_1);
    assertNotNull(result_2);
    assertEquals(expected_2, result_2);
    assertNotNull(result_3);
    assertEquals(expected_3, result_3);
    System.out.format("\t%s\n", result_1);
    System.out.format("\t%s\n", result_2);
    System.out.format("\t%s\n", result_3);
  }
}
