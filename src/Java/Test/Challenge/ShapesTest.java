package Test.Java.Challenge;

import Java.Code.Challenge.Shapes;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShapesTest {

    @Rule
    public TestName name = new TestName();

    @Test
    public void Shapes() {
        System.out.format("%s: ", name.getMethodName());
        Shapes.getDescription();
    }


    @Test
    public void triangleLeftJustifiedPointDown_1() {
        int defaultCount = 4;
        System.out.format("%s: Left Justified Triangle Point Down %d characters wide\n", name.getMethodName(), defaultCount);
        Shapes.triangleLeftJustifiedPointDown(defaultCount);
    }

    @Test
    public void triangleLeftJustifiedPointDown_2() {
        int defaultCount = 5;
        char firstSymbol = '@';
        System.out.format("%s: Left Justified Triangle Point Down %d characters wide using character '%s'\n", name.getMethodName(), defaultCount, firstSymbol);
        Shapes.triangleLeftJustifiedPointDown(defaultCount, firstSymbol);
    }

    @Test
    public void triangleLeftJustifiedPointDown_3() {
        int defaultCount = 6;
        System.out.format("%s: Left Justified Triangle Point Down %d characters wide, inscribed '%b'\n", name.getMethodName(), defaultCount, true);
        Shapes.triangleLeftJustifiedPointDown(defaultCount, true);
    }

    @Test
    public void triangleLeftJustifiedPointDown_4() {
        int defaultCount = 7;
        char firstSymbol = '@';
        System.out.format("%s: Left Justified Triangle Point Down %d characters wide using character '%s', inscribed '%b'\n", name.getMethodName(), defaultCount, firstSymbol, true);
        Shapes.triangleLeftJustifiedPointDown(defaultCount, true, firstSymbol);
    }

    @Test
    public void triangleLeftJustifiedPointDown_6() {
        int defaultCount = 1;
        System.out.format("%s: Left Justified Triangle Point Down %d characters wide\n", name.getMethodName(), defaultCount);
        Shapes.triangleLeftJustifiedPointDown(defaultCount);
    }

    @Test
    public void triangleLeftJustifiedPointDown_5() {
        int defaultCount = 8;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format("%s: Left Justified Triangle Point Down %d characters wide using characters: '%s' and '%s'\n", name.getMethodName(), defaultCount, firstSymbol, secondSymbol);
        Shapes.triangleLeftJustifiedPointDown(defaultCount, firstSymbol, secondSymbol);
    }

    @Test
    public void triangleLeftJustifiedPointUp_1() {
        int defaultCount = 4;
        System.out.format("%s: Left Justified Triangle Point Up %d characters wide\n", name.getMethodName(), defaultCount);
        Shapes.triangleLeftJustifiedPointUp(defaultCount);
    }

    @Test
    public void triangleLeftJustifiedPointUp_2() {
        int defaultCount = 5;
        char firstSymbol = '@';
        System.out.format("%s: Left Justified Triangle Point Up %d characters wide using character '%s'\n", name.getMethodName(), defaultCount, firstSymbol);
        Shapes.triangleLeftJustifiedPointUp(defaultCount, firstSymbol);
    }

    @Test
    public void triangleLeftJustifiedPointUp_3() {
        int defaultCount = 6;
        System.out.format("%s: Left Justified Triangle Point Up %d characters wide, inscribed '%b'\n", name.getMethodName(), defaultCount, true);
        Shapes.triangleLeftJustifiedPointUp(defaultCount, true);
    }

    @Test
    public void triangleLeftJustifiedPointUp_4() {
        int defaultCount = 7;
        char firstSymbol = '@';
        System.out.format("%s: Left Justified Triangle Point Up %d characters wide using character '%s', inscribed '%b'\n", name.getMethodName(), defaultCount, firstSymbol, true);
        Shapes.triangleLeftJustifiedPointUp(defaultCount, true, firstSymbol);
    }

    @Test
    public void triangleLeftJustifiedPointUp_5() {
        int defaultCount = 8;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format("%s: Left Justified Triangle Point Up %d characters wide using characters: '%s' and '%s', inscribed '%b'\n", name.getMethodName(), defaultCount, firstSymbol, secondSymbol, true);
        Shapes.triangleLeftJustifiedPointUp(defaultCount, true, firstSymbol, secondSymbol);
    }

    @Test
    public void triangleLeftJustifiedPointUp_6() {
        int defaultCount = 1;
        System.out.format("%s: Left Justified Triangle Point Up %d characters wide\n", name.getMethodName(), defaultCount);
        Shapes.triangleLeftJustifiedPointUp(defaultCount);
    }

    @Test
    public void triangleRightJustifiedPointDown_1() {
        int defaultCount = 4;
        System.out.format("%s: Right Justified Triangle Point Down %d characters wide\n", name.getMethodName(), defaultCount);
        Shapes.triangleRightJustifiedPointDown(defaultCount);
    }

    @Test
    public void triangleRightJustifiedPointDown_2() {
        int defaultCount = 5;
        char firstSymbol = '@';
        System.out.format("%s: Right Justified Triangle Point Down %d characters wide using character '%s'\n", name.getMethodName(), defaultCount, firstSymbol);
        Shapes.triangleRightJustifiedPointDown(defaultCount, firstSymbol);
    }

    @Test
    public void triangleRightJustifiedPointDown_3() {
        int defaultCount = 6;
        System.out.format("%s: Right Justified Triangle Point Down %d characters wide, inscribed '%b'\n", name.getMethodName(), defaultCount, true);
        Shapes.triangleRightJustifiedPointDown(defaultCount, true);
    }

    @Test
    public void triangleRightJustifiedPointDown_4() {
        int defaultCount = 7;
        char firstSymbol = '@';
        System.out.format("%s: Right Justified Triangle Point Down %d characters wide using character '%s', inscribed '%b'\n", name.getMethodName(), defaultCount, firstSymbol, true);
        Shapes.triangleRightJustifiedPointDown(defaultCount, true, firstSymbol);
    }

    @Test
    public void triangleRightJustifiedPointDown_5() {
        int defaultCount = 8;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format("%s: Right Justified Triangle Point Down %d characters wide using characters: '%s' and '%s'\n", name.getMethodName(), defaultCount, firstSymbol, secondSymbol);
        Shapes.triangleRightJustifiedPointDown(defaultCount, firstSymbol, secondSymbol);
    }

    @Test
    public void triangleRightJustifiedPointDown_6() {
        int defaultCount = 1;
        System.out.format("%s: Right Justified Triangle Point Down %d characters wide\n", name.getMethodName(), defaultCount);
        Shapes.triangleRightJustifiedPointDown(defaultCount);
    }

    @Test
    public void triangleRightJustifiedPointUp_1() {
        int defaultCount = 4;
        System.out.format("%s: Right Justified Triangle Point Up %d characters wide\n", name.getMethodName(), defaultCount);
        Shapes.triangleRightJustifiedPointUp(defaultCount);
    }

    @Test
    public void triangleRightJustifiedPointUp_2() {
        int defaultCount = 5;
        char firstSymbol = '@';
        System.out.format("%s: Right Justified Triangle Point Up %d characters wide using character '%s'\n", name.getMethodName(), defaultCount, firstSymbol);
        Shapes.triangleRightJustifiedPointUp(defaultCount, firstSymbol);
    }

    @Test
    public void triangleRightJustifiedPointUp_3() {
        int defaultCount = 6;
        System.out.format("%s: Right Justified Triangle Point Up %d characters wide, inscribed '%b'\n", name.getMethodName(), defaultCount, true);
        Shapes.triangleRightJustifiedPointUp(defaultCount, true);
    }

    @Test
    public void triangleRightJustifiedPointUp_4() {
        int defaultCount = 7;
        char firstSymbol = '@';
        System.out.format("%s: Right Justified Triangle Point Up %d characters wide using character '%s', inscribed '%b'\n", name.getMethodName(), defaultCount, firstSymbol, true);
        Shapes.triangleRightJustifiedPointUp(defaultCount, true, firstSymbol);
    }

    @Test
    public void triangleRightJustifiedPointUp_5() {
        int defaultCount = 8;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format("%s: Right Justified Triangle Point Up %d characters wide using characters: '%s' and '%s'\n", name.getMethodName(), defaultCount, firstSymbol, secondSymbol);
        Shapes.triangleRightJustifiedPointUp(defaultCount, firstSymbol, secondSymbol);
    }

    @Test
    public void triangleRightJustifiedPointUp_6() {
        int defaultCount = 1;
        System.out.format("%s: Right Justified Triangle Point Up %d characters wide\n", name.getMethodName(), defaultCount);
        Shapes.triangleRightJustifiedPointUp(defaultCount);
    }

    @Test
    public void trianglePointDown_1() {
        int defaultCount = 4;
        System.out.format("%s: Triangle Point Down %d layers tall\n", name.getMethodName(), defaultCount);
        Shapes.trianglePointDown(defaultCount);
    }

    @Test
    public void trianglePointDown_2() {
        int defaultCount = 5;
        char firstSymbol = '@';
        System.out.format("%s: Triangle Point Down %d layers tall using character '%s'\n", name.getMethodName(), defaultCount, firstSymbol);
        Shapes.trianglePointDown(defaultCount, firstSymbol);
    }

    @Test
    public void trianglePointDown_3() {
        int defaultCount = 6;
        System.out.format("%s: Triangle Point Down %d layers tall, inscribed '%b'\n", name.getMethodName(), defaultCount, true);
        Shapes.trianglePointDown(defaultCount, true);
    }

    @Test
    public void trianglePointDown_4() {
        int defaultCount = 7;
        char firstSymbol = '@';
        System.out.format("%s: Triangle Point Down %d layers tall using character '%s', inscribed '%b'\n", name.getMethodName(), defaultCount, firstSymbol, true);
        Shapes.trianglePointDown(defaultCount, true, firstSymbol);
    }

    @Test
    public void trianglePointDown_5() {
        int defaultCount = 8;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format("%s: Triangle Point Down %d layers tall using characters: '%s' and '%s'\n", name.getMethodName(), defaultCount, firstSymbol, secondSymbol);
        Shapes.trianglePointDown(defaultCount, firstSymbol, secondSymbol);
    }

    @Test
    public void trianglePointDown_6() {
        int defaultCount = 1;
        System.out.format("%s: Triangle Point Down %d layers tall\n", name.getMethodName(), defaultCount);
        Shapes.trianglePointDown(defaultCount);
    }

    @Test
    public void trianglePointUp_1() {
        int defaultCount = 4;
        System.out.format("%s: Triangle Point Up %d layers tall\n", name.getMethodName(), defaultCount);
        Shapes.trianglePointUp(defaultCount);
    }

    @Test
    public void trianglePointUp_2() {
        int defaultCount = 5;
        char firstSymbol = '@';
        System.out.format("%s: Triangle Point Up %d layers tall using character '%s'\n", name.getMethodName(), defaultCount, firstSymbol);
        Shapes.trianglePointUp(defaultCount, firstSymbol);
    }

    @Test
    public void trianglePointUp_3() {
        int defaultCount = 6;
        System.out.format("%s: Triangle Point Up %d layers tall, inscribed '%b'\n", name.getMethodName(), defaultCount, true);
        Shapes.trianglePointUp(defaultCount, true);
    }

    @Test
    public void trianglePointUp_4() {
        int defaultCount = 7;
        char firstSymbol = '@';
        System.out.format("%s: Triangle Point Up %d layers tall using character '%s', inscribed '%b'\n", name.getMethodName(), defaultCount, firstSymbol, true);
        Shapes.trianglePointUp(defaultCount, true, firstSymbol);
    }

    @Test
    public void trianglePointUp_5() {
        int defaultCount = 8;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format("%s: Triangle Point Up %d layers tall using characters: '%s' and '%s'\n", name.getMethodName(), defaultCount, firstSymbol, secondSymbol);
        Shapes.trianglePointUp(defaultCount, firstSymbol, secondSymbol);
    }

    @Test
    public void trianglePointUp_6() {
        int defaultCount = 1;
        System.out.format("%s: Triangle Point Up %d layers tall\n", name.getMethodName(), defaultCount);
        Shapes.trianglePointUp(defaultCount);
    }

    @Test
    public void trianglePointLeft_1() {
        int defaultCount = 4;
        System.out.format("%s: Triangle Point Left %d characters wide\n", name.getMethodName(), defaultCount);
        Shapes.trianglePointLeft(defaultCount);
    }

    @Test
    public void trianglePointLeft_2() {
        int defaultCount = 5;
        char firstSymbol = '@';
        System.out.format("%s: Triangle Point Left %d characters wide using character '%s'\n", name.getMethodName(), defaultCount, firstSymbol);
        Shapes.trianglePointLeft(defaultCount, firstSymbol);
    }

    @Test
    public void trianglePointLeft_3() {
        int defaultCount = 6;
        System.out.format("%s: Triangle Point Left %d characters wide, inscribed '%b'\n", name.getMethodName(), defaultCount, true);
        Shapes.trianglePointLeft(defaultCount, true);
    }

    @Test
    public void trianglePointLeft_4() {
        int defaultCount = 7;
        char firstSymbol = '@';
        System.out.format("%s: Triangle Point Left %d characters wide using character '%s', inscribed '%b'\n", name.getMethodName(), defaultCount, firstSymbol, true);
        Shapes.trianglePointLeft(defaultCount, true, firstSymbol);
    }

    @Test
    public void trianglePointLeft_5() {
        int defaultCount = 8;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format("%s: Triangle Point Left %d characters wide using characters: '%s' and '%s''\n", name.getMethodName(), defaultCount, firstSymbol, secondSymbol);
        Shapes.trianglePointLeft(defaultCount, firstSymbol, secondSymbol);
    }

    @Test
    public void trianglePointLeft_6() {
        int defaultCount = 1;
        System.out.format("%s: Triangle Point Left %d characters wide\n", name.getMethodName(), defaultCount);
        Shapes.trianglePointLeft(defaultCount);
    }

    @Test
    public void trianglePointRight_1() {
        int defaultCount = 4;
        System.out.format("%s: Triangle Point Right %d characters wide\n", name.getMethodName(), defaultCount);
        Shapes.trianglePointRight(defaultCount);
    }

    @Test
    public void trianglePointRight_2() {
        int defaultCount = 5;
        char firstSymbol = '@';
        System.out.format("%s: Triangle Point Right %d characters wide using character '%s'\n", name.getMethodName(), defaultCount, firstSymbol);
        Shapes.trianglePointRight(defaultCount, firstSymbol);
    }

    @Test
    public void trianglePointRight_3() {
        int defaultCount = 6;
        System.out.format("%s: Triangle Point Right %d characters wide, inscribed '%b'\n", name.getMethodName(), defaultCount, true);
        Shapes.trianglePointRight(defaultCount, true);
    }

    @Test
    public void trianglePointRight_4() {
        int defaultCount = 7;
        char firstSymbol = '@';
        System.out.format("%s: Triangle Point Right %d characters wide using character '%s', inscribed '%b'\n", name.getMethodName(), defaultCount, firstSymbol, true);
        Shapes.trianglePointRight(defaultCount, true, firstSymbol);
    }

    @Test
    public void trianglePointRight_5() {
        int defaultCount = 8;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format("%s: Triangle Point Right %d characters wide using characters: '%s' and '%s'\n", name.getMethodName(), defaultCount, firstSymbol, secondSymbol);
        Shapes.trianglePointRight(defaultCount, firstSymbol, secondSymbol);
    }

    @Test
    public void trianglePointRight_6() {
        int defaultCount = 1;
        System.out.format("%s: Triangle Point Right %d characters wide\n", name.getMethodName(), defaultCount);
        Shapes.trianglePointRight(defaultCount);
    }

    @Test
    public void parallelogramPointRight_1() {
        int defaultCount = 4;
        System.out.format("%s: Right Leaning Parallelogram %d characters wide\n", name.getMethodName(), defaultCount);
        Shapes.parallelogramPointRight(defaultCount);
    }

    @Test
    public void parallelogramPointRight_2() {
        int defaultCount = 5;
        char firstSymbol = '@';
        System.out.format("%s: Right Leaning Parallelogram %d characters wide using character '%s'\n", name.getMethodName(), defaultCount, firstSymbol);
        Shapes.parallelogramPointRight(defaultCount, firstSymbol);
    }

    @Test
    public void parallelogramPointRight_3() {
        int defaultCount = 6;
        System.out.format("%s: Right Leaning Parallelogram %d characters wide, inscribed '%b'\n", name.getMethodName(), defaultCount, true);
        Shapes.parallelogramPointRight(defaultCount, true);
    }

    @Test
    public void parallelogramPointRight_4() {
        int defaultCount = 7;
        char firstSymbol = '@';
        System.out.format("%s: Right Leaning Parallelogram %d characters wide using character '%s', inscribed '%b'\n", name.getMethodName(), defaultCount, firstSymbol, true);
        Shapes.parallelogramPointRight(defaultCount, true, firstSymbol);
    }

    @Test
    public void parallelogramPointRight_5() {
        int defaultCount = 8;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format("%s: Right Leaning Parallelogram %d characters wide using characters: '%s' and '%s'\n", name.getMethodName(), defaultCount, firstSymbol, secondSymbol);
        Shapes.parallelogramPointRight(defaultCount, firstSymbol, secondSymbol);
    }

    @Test
    public void parallelogramPointRight_6() {
        int defaultCount = 1;
        System.out.format("%s: Right Leaning Parallelogram %d characters wide\n", name.getMethodName(), defaultCount);
        Shapes.parallelogramPointRight(defaultCount);
    }

    @Test
    public void parallelogramPointLeft_1() {
        int defaultCount = 4;
        System.out.format("%s: Left Leaning Parallelogram %d characters wide\n", name.getMethodName(), defaultCount);
        Shapes.parallelogramPointLeft(defaultCount);
    }

    @Test
    public void parallelogramPointLeft_2() {
        int defaultCount = 5;
        char firstSymbol = '@';
        System.out.format("%s: Left Leaning Parallelogram %d characters wide using character '%s'\n", name.getMethodName(), defaultCount, firstSymbol);
        Shapes.parallelogramPointLeft(defaultCount, firstSymbol);
    }

    @Test
    public void parallelogramPointLeft_3() {
        int defaultCount = 6;
        System.out.format("%s: Left Leaning Parallelogram %d characters wide, inscribed '%b'\n", name.getMethodName(), defaultCount, true);
        Shapes.parallelogramPointLeft(defaultCount, true);
    }

    @Test
    public void parallelogramPointLeft_4() {
        int defaultCount = 7;
        char firstSymbol = '@';
        System.out.format("%s: Left Leaning Parallelogram %d characters wide using character '%s', inscribed '%b'\n", name.getMethodName(), defaultCount, firstSymbol, true);
        Shapes.parallelogramPointLeft(defaultCount, true, firstSymbol);
    }

    @Test
    public void parallelogramPointLeft_5() {
        int defaultCount = 8;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format("%s: Left Leaning Parallelogram %d characters wide using characters: '%s' and '%s'\n", name.getMethodName(), defaultCount, firstSymbol, secondSymbol);
        Shapes.parallelogramPointLeft(defaultCount, firstSymbol, secondSymbol);
    }

    @Test
    public void parallelogramPointLeft_6() {
        int defaultCount = 1;
        System.out.format("%s: Left Leaning Parallelogram %d characters wide\n", name.getMethodName(), defaultCount);
        Shapes.parallelogramPointLeft(defaultCount);
    }

    @Test
    public void diamond_1() {
        int defaultCount = 4;
        System.out.format("%s: Diamond %d characters wide\n", name.getMethodName(), defaultCount);
        Shapes.diamond(defaultCount);
    }

    @Test
    public void diamond_2() {
        int defaultCount = 5;
        char firstSymbol = '@';
        System.out.format("%s: Diamond %d characters wide using character '%s'\n", name.getMethodName(), defaultCount, firstSymbol);
        Shapes.diamond(defaultCount, firstSymbol);
    }

    @Test
    public void diamond_3() {
        int defaultCount = 6;
        System.out.format("%s: Diamond %d characters wide, inscribed '%b'\n", name.getMethodName(), defaultCount, true);
        Shapes.diamond(defaultCount, true);
    }

    @Test
    public void diamond_4() {
        int defaultCount = 7;
        char firstSymbol = '@';
        System.out.format("%s: Diamond %d characters wide using character '%s', inscribed '%b'\n", name.getMethodName(), defaultCount, firstSymbol, true);
        Shapes.diamond(defaultCount, true, firstSymbol);
    }

    @Test
    public void diamond_5() {
        int defaultCount = 8;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format("%s: Diamond %d characters wide using characters: '%s' and '%s'\n", name.getMethodName(), defaultCount, firstSymbol, secondSymbol);
        Shapes.diamond(defaultCount, firstSymbol, secondSymbol);
    }

    @Test
    public void diamond_6() {
        int defaultCount = 1;
        System.out.format("%s: Diamond %d characters wide\n", name.getMethodName(), defaultCount);
        Shapes.diamond(defaultCount);
    }

    @Test
    public void hourglass_1() {
        int defaultCount = 4;
        System.out.format("%s: Hourglass %d characters wide\n", name.getMethodName(), defaultCount);
        Shapes.hourglass(defaultCount);
    }

    @Test
    public void hourglass_2() {
        int defaultCount = 5;
        char firstSymbol = '@';
        System.out.format("%s: Hourglass %d characters wide using character '%s'\n", name.getMethodName(), defaultCount, firstSymbol);
        Shapes.hourglass(defaultCount, firstSymbol);
    }

    @Test
    public void hourglass_3() {
        int defaultCount = 6;
        System.out.format("%s: Hourglass %d characters wide, inscribed '%b'\n", name.getMethodName(), defaultCount, true);
        Shapes.hourglass(defaultCount, true);
    }

    @Test
    public void hourglass_4() {
        int defaultCount = 7;
        char firstSymbol = '@';
        System.out.format("%s: Hourglass %d characters wide using character '%s', inscribed '%b'\n", name.getMethodName(), defaultCount, firstSymbol, true);
        Shapes.hourglass(defaultCount, true, firstSymbol);
    }

    @Test
    public void hourglass_5() {
        int defaultCount = 8;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format("%s: Hourglass %d characters wide using characters: '%s' and '%s'\n", name.getMethodName(), defaultCount, firstSymbol, secondSymbol);
        Shapes.hourglass(defaultCount, firstSymbol, secondSymbol);
    }

    @Test
    public void hourglass_6() {
        int defaultCount = 1;
        System.out.format("%s: Hourglass %d characters wide\n", name.getMethodName(), defaultCount);
        Shapes.hourglass(defaultCount);
    }

    @Test
    public void rectangle_1() {
        int height = 4;
        int width = 6;
        System.out.format("%s: Rectangle %d characters high and %d characters wide\n", name.getMethodName(), height, width);
        Shapes.rectangle(height, width);
    }

    @Test
    public void rectangle_2() {
        int height = 4;
        int width = 6;
        char firstSymbol = '@';

        System.out.format("%s: Rectangle %d characters high and %d characters wide using character '%s'\n", name.getMethodName(), height, width, firstSymbol);
        Shapes.rectangle(height, width, firstSymbol);
    }

    @Test
    public void rectangle_3() {
        int height = 4;
        int width = 6;
        System.out.format("%s: Rectangle %d characters high and %d characters wide, inscribed '%b'\n", name.getMethodName(), height, width, true);
        Shapes.rectangle(height, width, true);
    }

    @Test
    public void rectangle_4() {
        int height = 6;
        int width = 4;
        char firstSymbol = '@';
        System.out.format("%s: Rectangle %d characters high and %d characters wide using character '%s, inscribed '%b'\n", name.getMethodName(), height, width, firstSymbol, true);
        Shapes.rectangle(height, width, true, firstSymbol);
    }

    @Test
    public void rectangle_5() {
        int height = 6;
        int width = 4;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format("%s: Rectangle %d characters high and %d characters wide using characters: '%s' and '%s'\n", name.getMethodName(), height, width, firstSymbol, secondSymbol);
        Shapes.rectangle(height, width, firstSymbol, secondSymbol);
    }

    @Test
    public void rectangle_6() {
        int height = 1;
        int width = 6;
        System.out.format("%s: Rectangle %d characters high and %d characters wide\n", name.getMethodName(), height, width);
        Shapes.rectangle(height, width);
    }

    @Test
    public void rectangle_7() {
        int height = 6;
        int width = 1;
        System.out.format("%s: Rectangle %d characters high and %d characters wide\n", name.getMethodName(), height, width);
        Shapes.rectangle(height, width);
    }

    @Test
    public void square_1() {
        int width = 6;
        System.out.format("%s: square %d characters wide\n", name.getMethodName(), width);
        Shapes.square(width);
    }

    @Test
    public void square_2() {
        int width = 6;
        char firstSymbol = '@';

        System.out.format("%s: square %d characters wide using character '%s'\n", name.getMethodName(), width, firstSymbol);
        Shapes.square(width, firstSymbol);
    }

    @Test
    public void square_3() {
        int width = 6;
        System.out.format("%s: square %d characters wide, inscribed '%b'\n", name.getMethodName(), width, true);
        Shapes.square(width, true);
    }

    @Test
    public void square_4() {
        int width = 4;
        char firstSymbol = '@';
        System.out.format("%s: square %d characters wide using character '%s, inscribed '%b'\n", name.getMethodName(), width, firstSymbol, true);
        Shapes.square(width, true, firstSymbol);
    }

    @Test
    public void square_5() {
        int width = 4;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format("%s: square %d characters wide using characters: '%s' and '%s'\n", name.getMethodName(), width, firstSymbol, secondSymbol);
        Shapes.square(width, firstSymbol, secondSymbol);
    }

    @Test
    public void squareX_1() {
        int defaultCount = 4;
        System.out.format("%s: Square of Triangles %d characters wide\n", name.getMethodName(), defaultCount);
        Shapes.squareX(defaultCount);
    }

    @Test
    public void squareX_2() {
        int defaultCount = 5;
        char firstSymbol = '@';
        System.out.format("%s: Square of Triangles %d characters wide using character '%s'\n", name.getMethodName(), defaultCount, firstSymbol);
        Shapes.squareX(defaultCount, firstSymbol);
    }

    @Test
    public void squareX_3() {
        int defaultCount = 5;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format("%s: Square of Triangles %d characters wide using characters: '%s' and '%s'\n", name.getMethodName(), defaultCount, firstSymbol, secondSymbol);
        Shapes.squareX(defaultCount, firstSymbol, secondSymbol);
    }

    @Test
    public void squareX_4() {
        int defaultCount = 1;
        System.out.format("%s: Square of Triangles %d characters wide\n", name.getMethodName(), defaultCount);
        Shapes.squareX(defaultCount);
    }

    @Test
    public void splitSquarePointDown_1() {
        int defaultCount = 4;
        System.out.format("%s: Split Square Point Down %d characters wide\n", name.getMethodName(), defaultCount);
        Shapes.splitSquarePointDown(defaultCount);
    }

    @Test
    public void splitSquarePointDown_2() {
        int defaultCount = 5;
        char firstSymbol = '@';
        System.out.format("%s: Split Square Point Down %d characters wide using character '%s'\n", name.getMethodName(), defaultCount, firstSymbol);
        Shapes.splitSquarePointDown(defaultCount, firstSymbol);
    }

    @Test
    public void splitSquarePointDown_3() {
        int defaultCount = 5;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format("%s: Split Square Point Down %d characters wide using characters: '%s' and '%s'\n", name.getMethodName(), defaultCount, firstSymbol, secondSymbol);
        Shapes.splitSquarePointDown(defaultCount, firstSymbol, secondSymbol);
    }

    @Test
    public void splitSquarePointDown_4() {
        int defaultCount = 1;
        System.out.format("%s: Split Square Point Down %d characters wide\n", name.getMethodName(), defaultCount);
        Shapes.splitSquarePointDown(defaultCount);
    }

    @Test
    public void splitSquarePointUp_1() {
        int defaultCount = 4;
        System.out.format("%s: Split Square Point Up %d characters wide\n", name.getMethodName(), defaultCount);
        Shapes.splitSquarePointUp(defaultCount);
    }

    @Test
    public void splitSquarePointUp_2() {
        int defaultCount = 5;
        char firstSymbol = '@';
        System.out.format("%s: Split Square Point Up %d characters wide using character '%s'\n", name.getMethodName(), defaultCount, firstSymbol);
        Shapes.splitSquarePointUp(defaultCount, firstSymbol);
    }

    @Test
    public void splitSquarePointUp_3() {
        int defaultCount = 5;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format("%s: Split Square Point Up %d characters wide using characters: '%s' and '%s'\n", name.getMethodName(), defaultCount, firstSymbol, secondSymbol);
        Shapes.splitSquarePointUp(defaultCount, firstSymbol, secondSymbol);
    }

    @Test
    public void splitSquarePointUp_4() {
        int defaultCount = 1;
        System.out.format("%s: Split Square Point Up %d characters wide\n", name.getMethodName(), defaultCount);
        Shapes.splitSquarePointUp(defaultCount);
    }

    @Test
    public void inscribedSquare_1() {
        int width = 6;
        System.out.format("%s: Inscribed Square %d characters wide\n", name.getMethodName(), width);
        Shapes.inscribedSquare(width);
    }

    @Test
    public void inscribedSquare_2() {
        int width = 5;
        char firstSymbol = '@';
        System.out.format("%s: Inscribed Square %d characters wide using character '%s'\n", name.getMethodName(), width, firstSymbol);
        Shapes.inscribedSquare(width, firstSymbol);
    }

    @Test
    public void inscribedSquare_3() {
        int width = 6;
        System.out.format("%s: Inscribed Square %d characters wide, inscribed '%b'\n", name.getMethodName(), width, true);
        Shapes.inscribedSquare(width, true);
    }

    @Test
    public void inscribedSquare_4() {
        int width = 4;
        char firstSymbol = '@';
        System.out.format("%s: Inscribed Square %d characters wide using character '%s', inscribed '%b'\n", name.getMethodName(), width, firstSymbol, true);
        Shapes.inscribedSquare(width, true, firstSymbol);
    }

    @Test
    public void inscribedSquare_5() {
        int width = 4;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format("%s: Inscribed Square %d characters wide using characters: '%s' and '%s'\n", name.getMethodName(), width, firstSymbol, secondSymbol);
        Shapes.inscribedSquare(width, firstSymbol, secondSymbol);
    }

    @Test
    public void inscribedSquare_6() {
        int width = 1;
        System.out.format("%s: Inscribed Square %d characters wide\n", name.getMethodName(), width);
        Shapes.inscribedSquare(width);
    }

    @Test
    public void hexagon_1() {
        int width = 3;
        System.out.format("%s: Hexagon %d characters wide\n", name.getMethodName(), width);
        Shapes.hexagon(width);
    }

    @Test
    public void hexagon_2() {
        int width = 3;
        char firstSymbol = '@';
        System.out.format("%s: Hexagon %d characters wide using character '%s'\n", name.getMethodName(), width, firstSymbol);
        Shapes.hexagon(width, firstSymbol);
    }

    @Test
    public void hexagon_3() {
        int width = 3;
        System.out.format("%s: Hexagon %d characters wide, inscribed '%b'\n", name.getMethodName(), width, true);
        Shapes.hexagon(width, true);
    }

    @Test
    public void hexagon_4() {
        int width = 3;
        char firstSymbol = '@';
        System.out.format("%s: Hexagon %d characters wide using character '%s, inscribed '%b'\n", name.getMethodName(), width, firstSymbol, true);
        Shapes.hexagon(width, true, firstSymbol);
    }

    @Test
    public void hexagon_5() {
        int width = 3;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format("%s: Hexagon %d characters wide using characters: '%s' and '%s'\n", name.getMethodName(), width, firstSymbol, secondSymbol);
        Shapes.hexagon(width, firstSymbol, secondSymbol);
    }

    @Test
    public void hexagon_6() {
        int width = 1;
        System.out.format("%s: Hexagon %d characters wide\n", name.getMethodName(), width);
        Shapes.hexagon(width);
    }
}
