package Java.Test.Challenge;

import Java.Code.Challenge.ThiefAndSensors;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings("DuplicatedCode")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ThiefAndSensorsTest {
  @Rule public TestName name = new TestName();

  @Test
  public void ThiefAndSensors() {
    System.out.format("%s: ", name.getMethodName());
    ThiefAndSensors.getDescription();
  }

  @Test
  public void thiefAndSensors_1() {
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
    ThiefAndSensors.pathExists();
    ThiefAndSensors.pathBottomTop();
    ThiefAndSensors.pathLeftRight();
  }

  @Test
  public void thiefAndSensors_2() {
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
    ThiefAndSensors.pathExists();
    ThiefAndSensors.pathBottomTop();
    ThiefAndSensors.pathLeftRight();
  }

  @Test
  public void thiefAndSensors_3() {
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
    ThiefAndSensors.pathExists();
    ThiefAndSensors.pathBottomTop();
    ThiefAndSensors.pathLeftRight();
  }
}
