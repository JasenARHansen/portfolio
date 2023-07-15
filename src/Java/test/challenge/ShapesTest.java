package Java.test.challenge;

import Java.code.challenge.Shapes;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShapesTest {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void diamond_1() {
        printTestHeader(name.getMethodName());
        int defaultCount = 4;
        System.out.format("\tDiamond %d characters wide\n", defaultCount);
        Shapes.diamond(defaultCount);
    }

    @Test
    public void diamond_2() {
        printTestHeader(name.getMethodName());
        int defaultCount = 5;
        char firstSymbol = '@';
        System.out.format(
                "\tDiamond %d characters wide using character '%s'\n", defaultCount, firstSymbol);
        Shapes.diamond(defaultCount, firstSymbol);
    }

    @Test
    public void diamond_3() {
        printTestHeader(name.getMethodName());
        int defaultCount = 6;
        System.out.format("\tDiamond %d characters wide, inscribed '%b'\n", defaultCount, true);
        Shapes.diamond(defaultCount, true);
    }

    @Test
    public void diamond_4() {
        printTestHeader(name.getMethodName());
        int defaultCount = 7;
        char firstSymbol = '@';
        System.out.format(
                "\tDiamond %d characters wide using character '%s', inscribed '%b'\n",
                defaultCount, firstSymbol, true);
        Shapes.diamond(defaultCount, true, firstSymbol);
    }

    @Test
    public void diamond_5() {
        printTestHeader(name.getMethodName());
        int defaultCount = 8;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format(
                "\tDiamond %d characters wide using characters: '%s' and '%s'\n",
                defaultCount, firstSymbol, secondSymbol);
        Shapes.diamond(defaultCount, firstSymbol, secondSymbol);
    }

    @Test
    public void diamond_6() {
        printTestHeader(name.getMethodName());
        int defaultCount = 1;
        System.out.format("\tDiamond %d characters wide\n", defaultCount);
        Shapes.diamond(defaultCount);
    }

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        Shapes.getDescription();
    }

    @Test
    public void hexagon_1() {
        printTestHeader(name.getMethodName());
        int width = 3;
        System.out.format("\tHexagon %d characters wide\n", width);
        Shapes.hexagon(width);
    }

    @Test
    public void hexagon_2() {
        printTestHeader(name.getMethodName());
        int width = 3;
        char firstSymbol = '@';
        System.out.format("\tHexagon %d characters wide using character '%s'\n", width, firstSymbol);
        Shapes.hexagon(width, firstSymbol);
    }

    @Test
    public void hexagon_3() {
        printTestHeader(name.getMethodName());
        int width = 3;
        System.out.format("\tHexagon %d characters wide, inscribed '%b'\n", width, true);
        Shapes.hexagon(width, true);
    }

    @Test
    public void hexagon_4() {
        printTestHeader(name.getMethodName());
        int width = 3;
        char firstSymbol = '@';
        System.out.format(
                "\tHexagon %d characters wide using character '%s, inscribed '%b'\n",
                width, firstSymbol, true);
        Shapes.hexagon(width, true, firstSymbol);
    }

    @Test
    public void hexagon_5() {
        printTestHeader(name.getMethodName());
        int width = 3;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format(
                "\tHexagon %d characters wide using characters: '%s' and '%s'\n",
                width, firstSymbol, secondSymbol);
        Shapes.hexagon(width, firstSymbol, secondSymbol);
    }

    @Test
    public void hexagon_6() {
        printTestHeader(name.getMethodName());
        int width = 1;
        System.out.format("\tHexagon %d characters wide\n", width);
        Shapes.hexagon(width);
    }

    @Test
    public void hourglass_1() {
        printTestHeader(name.getMethodName());
        int defaultCount = 4;
        System.out.format("\tHourglass %d characters wide\n", defaultCount);
        Shapes.hourglass(defaultCount);
    }

    @Test
    public void hourglass_2() {
        printTestHeader(name.getMethodName());
        int defaultCount = 5;
        char firstSymbol = '@';
        System.out.format(
                "\tHourglass %d characters wide using character '%s'\n", defaultCount, firstSymbol);
        Shapes.hourglass(defaultCount, firstSymbol);
    }

    @Test
    public void hourglass_3() {
        printTestHeader(name.getMethodName());
        int defaultCount = 6;
        System.out.format("\tHourglass %d characters wide, inscribed '%b'\n", defaultCount, true);
        Shapes.hourglass(defaultCount, true);
    }

    @Test
    public void hourglass_4() {
        printTestHeader(name.getMethodName());
        int defaultCount = 7;
        char firstSymbol = '@';
        System.out.format(
                "\tHourglass %d characters wide using character '%s', inscribed '%b'\n",
                defaultCount, firstSymbol, true);
        Shapes.hourglass(defaultCount, true, firstSymbol);
    }

    @Test
    public void hourglass_5() {
        printTestHeader(name.getMethodName());
        int defaultCount = 8;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format(
                "\tHourglass %d characters wide using characters: '%s' and '%s'\n",
                defaultCount, firstSymbol, secondSymbol);
        Shapes.hourglass(defaultCount, firstSymbol, secondSymbol);
    }

    @Test
    public void hourglass_6() {
        printTestHeader(name.getMethodName());
        int defaultCount = 1;
        System.out.format("\tHourglass %d characters wide\n", defaultCount);
        Shapes.hourglass(defaultCount);
    }

    @Test
    public void inscribedSquare_1() {
        printTestHeader(name.getMethodName());
        int width = 6;
        System.out.format("\tInscribed Square %d characters wide\n", width);
        Shapes.inscribedSquare(width);
    }

    @Test
    public void inscribedSquare_2() {
        printTestHeader(name.getMethodName());
        int width = 5;
        char firstSymbol = '@';
        System.out.format(
                "\tInscribed Square %d characters wide using character '%s'\n", width, firstSymbol);
        Shapes.inscribedSquare(width, firstSymbol);
    }

    @Test
    public void inscribedSquare_3() {
        printTestHeader(name.getMethodName());
        int width = 6;
        System.out.format("\tInscribed Square %d characters wide, inscribed '%b'\n", width, true);
        Shapes.inscribedSquare(width, true);
    }

    @Test
    public void inscribedSquare_4() {
        printTestHeader(name.getMethodName());
        int width = 4;
        char firstSymbol = '@';
        System.out.format(
                "\tInscribed Square %d characters wide using character '%s', inscribed '%b'\n",
                width, firstSymbol, true);
        Shapes.inscribedSquare(width, true, firstSymbol);
    }

    @Test
    public void inscribedSquare_5() {
        printTestHeader(name.getMethodName());
        int width = 4;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format(
                "\tInscribed Square %d characters wide using characters: '%s' and '%s'\n",
                width, firstSymbol, secondSymbol);
        Shapes.inscribedSquare(width, firstSymbol, secondSymbol);
    }

    @Test
    public void inscribedSquare_6() {
        printTestHeader(name.getMethodName());
        int width = 1;
        System.out.format("\tInscribed Square %d characters wide\n", width);
        Shapes.inscribedSquare(width);
    }

    @Test
    public void parallelogramPointLeft_1() {
        printTestHeader(name.getMethodName());
        int defaultCount = 4;
        System.out.format("\tLeft Leaning Parallelogram %d characters wide\n", defaultCount);
        Shapes.parallelogramPointLeft(defaultCount);
    }

    @Test
    public void parallelogramPointLeft_2() {
        printTestHeader(name.getMethodName());
        int defaultCount = 5;
        char firstSymbol = '@';
        System.out.format(
                "\tLeft Leaning Parallelogram %d characters wide using character '%s'\n",
                defaultCount, firstSymbol);
        Shapes.parallelogramPointLeft(defaultCount, firstSymbol);
    }

    @Test
    public void parallelogramPointLeft_3() {
        printTestHeader(name.getMethodName());
        int defaultCount = 6;
        System.out.format(
                "\tLeft Leaning Parallelogram %d characters wide, inscribed '%b'\n", defaultCount, true);
        Shapes.parallelogramPointLeft(defaultCount, true);
    }

    @Test
    public void parallelogramPointLeft_4() {
        printTestHeader(name.getMethodName());
        int defaultCount = 7;
        char firstSymbol = '@';
        System.out.format(
                "\tLeft Leaning Parallelogram %d characters wide using character '%s', inscribed '%b'\n",
                defaultCount, firstSymbol, true);
        Shapes.parallelogramPointLeft(defaultCount, true, firstSymbol);
    }

    @Test
    public void parallelogramPointLeft_5() {
        printTestHeader(name.getMethodName());
        int defaultCount = 8;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format(
                "\tLeft Leaning Parallelogram %d characters wide using characters: '%s' and '%s'\n",
                defaultCount, firstSymbol, secondSymbol);
        Shapes.parallelogramPointLeft(defaultCount, firstSymbol, secondSymbol);
    }

    @Test
    public void parallelogramPointLeft_6() {
        printTestHeader(name.getMethodName());
        int defaultCount = 1;
        System.out.format("\tLeft Leaning Parallelogram %d characters wide\n", defaultCount);
        Shapes.parallelogramPointLeft(defaultCount);
    }

    @Test
    public void parallelogramPointRight_1() {
        printTestHeader(name.getMethodName());
        int defaultCount = 4;
        System.out.format("\tRight Leaning Parallelogram %d characters wide\n", defaultCount);
        Shapes.parallelogramPointRight(defaultCount);
    }

    @Test
    public void parallelogramPointRight_2() {
        printTestHeader(name.getMethodName());
        int defaultCount = 5;
        char firstSymbol = '@';
        System.out.format(
                "\tRight Leaning Parallelogram %d characters wide using character '%s'\n",
                defaultCount, firstSymbol);
        Shapes.parallelogramPointRight(defaultCount, firstSymbol);
    }

    @Test
    public void parallelogramPointRight_3() {
        printTestHeader(name.getMethodName());
        int defaultCount = 6;
        System.out.format(
                "\tRight Leaning Parallelogram %d characters wide, inscribed '%b'\n", defaultCount, true);
        Shapes.parallelogramPointRight(defaultCount, true);
    }

    @Test
    public void parallelogramPointRight_4() {
        printTestHeader(name.getMethodName());
        int defaultCount = 7;
        char firstSymbol = '@';
        System.out.format(
                "\tRight Leaning Parallelogram %d characters wide using character '%s', inscribed '%b'\n",
                defaultCount, firstSymbol, true);
        Shapes.parallelogramPointRight(defaultCount, true, firstSymbol);
    }

    @Test
    public void parallelogramPointRight_5() {
        printTestHeader(name.getMethodName());
        int defaultCount = 8;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format(
                "\tRight Leaning Parallelogram %d characters wide using characters: '%s' and '%s'\n",
                defaultCount, firstSymbol, secondSymbol);
        Shapes.parallelogramPointRight(defaultCount, firstSymbol, secondSymbol);
    }

    @Test
    public void parallelogramPointRight_6() {
        printTestHeader(name.getMethodName());
        int defaultCount = 1;
        System.out.format("\tRight Leaning Parallelogram %d characters wide\n", defaultCount);
        Shapes.parallelogramPointRight(defaultCount);
    }

    @Test
    public void rectangle_1() {
        printTestHeader(name.getMethodName());
        int height = 4;
        int width = 6;
        System.out.format("\tRectangle %d characters high and %d characters wide\n", height, width);
        Shapes.rectangle(height, width);
    }

    @Test
    public void rectangle_2() {
        printTestHeader(name.getMethodName());
        int height = 4;
        int width = 6;
        char firstSymbol = '@';
        System.out.format(
                "\tRectangle %d characters high and %d characters wide using character '%s'\n",
                height, width, firstSymbol);
        Shapes.rectangle(height, width, firstSymbol);
    }

    @Test
    public void rectangle_3() {
        printTestHeader(name.getMethodName());
        int height = 4;
        int width = 6;
        System.out.format(
                "\tRectangle %d characters high and %d characters wide, inscribed '%b'\n",
                height, width, true);
        Shapes.rectangle(height, width, true);
    }

    @Test
    public void rectangle_4() {
        printTestHeader(name.getMethodName());
        int height = 6;
        int width = 4;
        char firstSymbol = '@';
        System.out.format(
                "\tRectangle %d characters high and %d characters wide using character '%s, inscribed '%b'\n",
                height, width, firstSymbol, true);
        Shapes.rectangle(height, width, true, firstSymbol);
    }

    @Test
    public void rectangle_5() {
        printTestHeader(name.getMethodName());
        int height = 6;
        int width = 4;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format(
                "\tRectangle %d characters high and %d characters wide using characters: '%s' and '%s'\n",
                height, width, firstSymbol, secondSymbol);
        Shapes.rectangle(height, width, firstSymbol, secondSymbol);
    }

    @Test
    public void rectangle_6() {
        printTestHeader(name.getMethodName());
        int height = 1;
        int width = 6;
        System.out.format("\tRectangle %d characters high and %d characters wide\n", height, width);
        Shapes.rectangle(height, width);
    }

    @Test
    public void rectangle_7() {
        printTestHeader(name.getMethodName());
        int height = 6;
        int width = 1;
        System.out.format("\tRectangle %d characters high and %d characters wide\n", height, width);
        Shapes.rectangle(height, width);
    }

    @Test
    public void splitSquarePointDown_1() {
        printTestHeader(name.getMethodName());
        int defaultCount = 4;
        System.out.format("\tSplit Square Point Down %d characters wide\n", defaultCount);
        Shapes.splitSquarePointDown(defaultCount);
    }

    @Test
    public void splitSquarePointDown_2() {
        printTestHeader(name.getMethodName());
        int defaultCount = 5;
        char firstSymbol = '@';
        System.out.format(
                "\tSplit Square Point Down %d characters wide using character '%s'\n",
                defaultCount, firstSymbol);
        Shapes.splitSquarePointDown(defaultCount, firstSymbol);
    }

    @Test
    public void splitSquarePointDown_3() {
        printTestHeader(name.getMethodName());
        int defaultCount = 5;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format(
                "\tSplit Square Point Down %d characters wide using characters: '%s' and '%s'\n",
                defaultCount, firstSymbol, secondSymbol);
        Shapes.splitSquarePointDown(defaultCount, firstSymbol, secondSymbol);
    }

    @Test
    public void splitSquarePointDown_4() {
        printTestHeader(name.getMethodName());
        int defaultCount = 1;
        System.out.format("\tSplit Square Point Down %d characters wide\n", defaultCount);
        Shapes.splitSquarePointDown(defaultCount);
    }

    @Test
    public void splitSquarePointUp_1() {
        printTestHeader(name.getMethodName());
        int defaultCount = 4;
        System.out.format("\tSplit Square Point Up %d characters wide\n", defaultCount);
        Shapes.splitSquarePointUp(defaultCount);
    }

    @Test
    public void splitSquarePointUp_2() {
        printTestHeader(name.getMethodName());
        int defaultCount = 5;
        char firstSymbol = '@';
        System.out.format(
                "\tSplit Square Point Up %d characters wide using character '%s'\n",
                defaultCount, firstSymbol);
        Shapes.splitSquarePointUp(defaultCount, firstSymbol);
    }

    @Test
    public void splitSquarePointUp_3() {
        printTestHeader(name.getMethodName());
        int defaultCount = 5;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format(
                "\tSplit Square Point Up %d characters wide using characters: '%s' and '%s'\n",
                defaultCount, firstSymbol, secondSymbol);
        Shapes.splitSquarePointUp(defaultCount, firstSymbol, secondSymbol);
    }

    @Test
    public void splitSquarePointUp_4() {
        printTestHeader(name.getMethodName());
        int defaultCount = 1;
        System.out.format("\tSplit Square Point Up %d characters wide\n", defaultCount);
        Shapes.splitSquarePointUp(defaultCount);
    }

    @Test
    public void squareX_1() {
        printTestHeader(name.getMethodName());
        int defaultCount = 4;
        System.out.format("\tSquare of Triangles %d characters wide\n", defaultCount);
        Shapes.squareX(defaultCount);
    }

    @Test
    public void squareX_2() {
        printTestHeader(name.getMethodName());
        int defaultCount = 5;
        char firstSymbol = '@';
        System.out.format(
                "\tSquare of Triangles %d characters wide using character '%s'\n",
                defaultCount, firstSymbol);
        Shapes.squareX(defaultCount, firstSymbol);
    }

    @Test
    public void squareX_3() {
        printTestHeader(name.getMethodName());
        int defaultCount = 5;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format(
                "\tSquare of Triangles %d characters wide using characters: '%s' and '%s'\n",
                defaultCount, firstSymbol, secondSymbol);
        Shapes.squareX(defaultCount, firstSymbol, secondSymbol);
    }

    @Test
    public void squareX_4() {
        printTestHeader(name.getMethodName());
        int defaultCount = 1;
        System.out.format("\tSquare of Triangles %d characters wide\n", defaultCount);
        Shapes.squareX(defaultCount);
    }

    @Test
    public void square_1() {
        printTestHeader(name.getMethodName());
        int width = 6;
        System.out.format("\tsquare %d characters wide\n", width);
        Shapes.square(width);
    }

    @Test
    public void square_2() {
        printTestHeader(name.getMethodName());
        int width = 6;
        char firstSymbol = '@';
        System.out.format("\tsquare %d characters wide using character '%s'\n", width, firstSymbol);
        Shapes.square(width, firstSymbol);
    }

    @Test
    public void square_3() {
        printTestHeader(name.getMethodName());
        int width = 6;
        System.out.format("\tsquare %d characters wide, inscribed '%b'\n", width, true);
        Shapes.square(width, true);
    }

    @Test
    public void square_4() {
        printTestHeader(name.getMethodName());
        int width = 4;
        char firstSymbol = '@';
        System.out.format(
                "\tsquare %d characters wide using character '%s, inscribed '%b'\n",
                width, firstSymbol, true);
        Shapes.square(width, true, firstSymbol);
    }

    @Test
    public void square_5() {
        printTestHeader(name.getMethodName());
        int width = 4;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format(
                "\tsquare %d characters wide using characters: '%s' and '%s'\n",
                width, firstSymbol, secondSymbol);
        Shapes.square(width, firstSymbol, secondSymbol);
    }

    @Test
    public void triangleLeftJustifiedPointDown_1() {
        printTestHeader(name.getMethodName());
        int defaultCount = 4;
        System.out.format("\tLeft Justified Triangle Point Down %d characters wide\n", defaultCount);
        Shapes.triangleLeftJustifiedPointDown(defaultCount);
    }

    @Test
    public void triangleLeftJustifiedPointDown_2() {
        printTestHeader(name.getMethodName());
        int defaultCount = 5;
        char firstSymbol = '@';
        System.out.format(
                "\tLeft Justified Triangle Point Down %d characters wide using character '%s'\n",
                defaultCount, firstSymbol);
        Shapes.triangleLeftJustifiedPointDown(defaultCount, firstSymbol);
    }

    @Test
    public void triangleLeftJustifiedPointDown_3() {
        printTestHeader(name.getMethodName());
        int defaultCount = 6;
        System.out.format(
                "\tLeft Justified Triangle Point Down %d characters wide, inscribed '%b'\n",
                defaultCount, true);
        Shapes.triangleLeftJustifiedPointDown(defaultCount, true);
    }

    @Test
    public void triangleLeftJustifiedPointDown_4() {
        printTestHeader(name.getMethodName());
        int defaultCount = 7;
        char firstSymbol = '@';
        System.out.format(
                "\tLeft Justified Triangle Point Down %d characters wide using character '%s', inscribed '%b'\n",
                defaultCount, firstSymbol, true);
        Shapes.triangleLeftJustifiedPointDown(defaultCount, true, firstSymbol);
    }

    @Test
    public void triangleLeftJustifiedPointDown_5() {
        printTestHeader(name.getMethodName());
        int defaultCount = 8;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format(
                "\tLeft Justified Triangle Point Down %d characters wide using characters: '%s' and '%s'\n",
                defaultCount, firstSymbol, secondSymbol);
        Shapes.triangleLeftJustifiedPointDown(defaultCount, firstSymbol, secondSymbol);
    }

    @Test
    public void triangleLeftJustifiedPointDown_6() {
        printTestHeader(name.getMethodName());
        int defaultCount = 1;
        System.out.format("\tLeft Justified Triangle Point Down %d characters wide\n", defaultCount);
        Shapes.triangleLeftJustifiedPointDown(defaultCount);
    }

    @Test
    public void triangleLeftJustifiedPointUp_1() {
        printTestHeader(name.getMethodName());
        int defaultCount = 4;
        System.out.format("\tLeft Justified Triangle Point Up %d characters wide\n", defaultCount);
        Shapes.triangleLeftJustifiedPointUp(defaultCount);
    }

    @Test
    public void triangleLeftJustifiedPointUp_2() {
        printTestHeader(name.getMethodName());
        int defaultCount = 5;
        char firstSymbol = '@';
        System.out.format(
                "\tLeft Justified Triangle Point Up %d characters wide using character '%s'\n",
                defaultCount, firstSymbol);
        Shapes.triangleLeftJustifiedPointUp(defaultCount, firstSymbol);
    }

    @Test
    public void triangleLeftJustifiedPointUp_3() {
        printTestHeader(name.getMethodName());
        int defaultCount = 6;
        System.out.format(
                "\tLeft Justified Triangle Point Up %d characters wide, inscribed '%b'\n",
                defaultCount, true);
        Shapes.triangleLeftJustifiedPointUp(defaultCount, true);
    }

    @Test
    public void triangleLeftJustifiedPointUp_4() {
        printTestHeader(name.getMethodName());
        int defaultCount = 7;
        char firstSymbol = '@';
        System.out.format(
                "\tLeft Justified Triangle Point Up %d characters wide using character '%s', inscribed '%b'\n",
                defaultCount, firstSymbol, true);
        Shapes.triangleLeftJustifiedPointUp(defaultCount, true, firstSymbol);
    }

    @Test
    public void triangleLeftJustifiedPointUp_5() {
        printTestHeader(name.getMethodName());
        int defaultCount = 8;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format(
                "\tLeft Justified Triangle Point Up %d characters wide using characters: '%s' and '%s', inscribed '%b'\n",
                defaultCount, firstSymbol, secondSymbol, true);
        Shapes.triangleLeftJustifiedPointUp(defaultCount, true, firstSymbol, secondSymbol);
    }

    @Test
    public void triangleLeftJustifiedPointUp_6() {
        printTestHeader(name.getMethodName());
        int defaultCount = 1;
        System.out.format("\tLeft Justified Triangle Point Up %d characters wide\n", defaultCount);
        Shapes.triangleLeftJustifiedPointUp(defaultCount);
    }

    @Test
    public void trianglePointDown_1() {
        printTestHeader(name.getMethodName());
        int defaultCount = 4;
        System.out.format("\tTriangle Point Down %d layers tall\n", defaultCount);
        Shapes.trianglePointDown(defaultCount);
    }

    @Test
    public void trianglePointDown_2() {
        printTestHeader(name.getMethodName());
        int defaultCount = 5;
        char firstSymbol = '@';
        System.out.format(
                "\tTriangle Point Down %d layers tall using character '%s'\n", defaultCount, firstSymbol);
        Shapes.trianglePointDown(defaultCount, firstSymbol);
    }

    @Test
    public void trianglePointDown_3() {
        printTestHeader(name.getMethodName());
        int defaultCount = 6;
        System.out.format("\tTriangle Point Down %d layers tall, inscribed '%b'\n", defaultCount, true);
        Shapes.trianglePointDown(defaultCount, true);
    }

    @Test
    public void trianglePointDown_4() {
        printTestHeader(name.getMethodName());
        int defaultCount = 7;
        char firstSymbol = '@';
        System.out.format(
                "\tTriangle Point Down %d layers tall using character '%s', inscribed '%b'\n",
                defaultCount, firstSymbol, true);
        Shapes.trianglePointDown(defaultCount, true, firstSymbol);
    }

    @Test
    public void trianglePointDown_5() {
        printTestHeader(name.getMethodName());
        int defaultCount = 8;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format(
                "\tTriangle Point Down %d layers tall using characters: '%s' and '%s'\n",
                defaultCount, firstSymbol, secondSymbol);
        Shapes.trianglePointDown(defaultCount, firstSymbol, secondSymbol);
    }

    @Test
    public void trianglePointDown_6() {
        printTestHeader(name.getMethodName());
        int defaultCount = 1;
        System.out.format("\tTriangle Point Down %d layers tall\n", defaultCount);
        Shapes.trianglePointDown(defaultCount);
    }

    @Test
    public void trianglePointLeft_1() {
        printTestHeader(name.getMethodName());
        int defaultCount = 4;
        System.out.format("\tTriangle Point Left %d characters wide\n", defaultCount);
        Shapes.trianglePointLeft(defaultCount);
    }

    @Test
    public void trianglePointLeft_2() {
        printTestHeader(name.getMethodName());
        int defaultCount = 5;
        char firstSymbol = '@';
        System.out.format(
                "\tTriangle Point Left %d characters wide using character '%s'\n",
                defaultCount, firstSymbol);
        Shapes.trianglePointLeft(defaultCount, firstSymbol);
    }

    @Test
    public void trianglePointLeft_3() {
        printTestHeader(name.getMethodName());
        int defaultCount = 6;
        System.out.format(
                "\tTriangle Point Left %d characters wide, inscribed '%b'\n", defaultCount, true);
        Shapes.trianglePointLeft(defaultCount, true);
    }

    @Test
    public void trianglePointLeft_4() {
        printTestHeader(name.getMethodName());
        int defaultCount = 7;
        char firstSymbol = '@';
        System.out.format(
                "\tTriangle Point Left %d characters wide using character '%s', inscribed '%b'\n",
                defaultCount, firstSymbol, true);
        Shapes.trianglePointLeft(defaultCount, true, firstSymbol);
    }

    @Test
    public void trianglePointLeft_5() {
        printTestHeader(name.getMethodName());
        int defaultCount = 8;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format(
                "\tTriangle Point Left %d characters wide using characters: '%s' and '%s''\n",
                defaultCount, firstSymbol, secondSymbol);
        Shapes.trianglePointLeft(defaultCount, firstSymbol, secondSymbol);
    }

    @Test
    public void trianglePointLeft_6() {
        printTestHeader(name.getMethodName());
        int defaultCount = 1;
        System.out.format("\tTriangle Point Left %d characters wide\n", defaultCount);
        Shapes.trianglePointLeft(defaultCount);
    }

    @Test
    public void trianglePointRight_1() {
        printTestHeader(name.getMethodName());
        int defaultCount = 4;
        System.out.format("\tTriangle Point Right %d characters wide\n", defaultCount);
        Shapes.trianglePointRight(defaultCount);
    }

    @Test
    public void trianglePointRight_2() {
        printTestHeader(name.getMethodName());
        int defaultCount = 5;
        char firstSymbol = '@';
        System.out.format(
                "\tTriangle Point Right %d characters wide using character '%s'\n",
                defaultCount, firstSymbol);
        Shapes.trianglePointRight(defaultCount, firstSymbol);
    }

    @Test
    public void trianglePointRight_3() {
        printTestHeader(name.getMethodName());
        int defaultCount = 6;
        System.out.format(
                "\tTriangle Point Right %d characters wide, inscribed '%b'\n", defaultCount, true);
        Shapes.trianglePointRight(defaultCount, true);
    }

    @Test
    public void trianglePointRight_4() {
        printTestHeader(name.getMethodName());
        int defaultCount = 7;
        char firstSymbol = '@';
        System.out.format(
                "\tTriangle Point Right %d characters wide using character '%s', inscribed '%b'\n",
                defaultCount, firstSymbol, true);
        Shapes.trianglePointRight(defaultCount, true, firstSymbol);
    }

    @Test
    public void trianglePointRight_5() {
        printTestHeader(name.getMethodName());
        int defaultCount = 8;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format(
                "\tTriangle Point Right %d characters wide using characters: '%s' and '%s'\n",
                defaultCount, firstSymbol, secondSymbol);
        Shapes.trianglePointRight(defaultCount, firstSymbol, secondSymbol);
    }

    @Test
    public void trianglePointRight_6() {
        printTestHeader(name.getMethodName());
        int defaultCount = 1;
        System.out.format("\tTriangle Point Right %d characters wide\n", defaultCount);
        Shapes.trianglePointRight(defaultCount);
    }

    @Test
    public void trianglePointUp_1() {
        printTestHeader(name.getMethodName());
        int defaultCount = 4;
        System.out.format("\tTriangle Point Up %d layers tall\n", defaultCount);
        Shapes.trianglePointUp(defaultCount);
    }

    @Test
    public void trianglePointUp_2() {
        printTestHeader(name.getMethodName());
        int defaultCount = 5;
        char firstSymbol = '@';
        System.out.format(
                "\tTriangle Point Up %d layers tall using character '%s'\n", defaultCount, firstSymbol);
        Shapes.trianglePointUp(defaultCount, firstSymbol);
    }

    @Test
    public void trianglePointUp_3() {
        printTestHeader(name.getMethodName());
        int defaultCount = 6;
        System.out.format("\tTriangle Point Up %d layers tall, inscribed '%b'\n", defaultCount, true);
        Shapes.trianglePointUp(defaultCount, true);
    }

    @Test
    public void trianglePointUp_4() {
        printTestHeader(name.getMethodName());
        int defaultCount = 7;
        char firstSymbol = '@';
        System.out.format(
                "\tTriangle Point Up %d layers tall using character '%s', inscribed '%b'\n",
                defaultCount, firstSymbol, true);
        Shapes.trianglePointUp(defaultCount, true, firstSymbol);
    }

    @Test
    public void trianglePointUp_5() {
        printTestHeader(name.getMethodName());
        int defaultCount = 8;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format(
                "\tTriangle Point Up %d layers tall using characters: '%s' and '%s'\n",
                defaultCount, firstSymbol, secondSymbol);
        Shapes.trianglePointUp(defaultCount, firstSymbol, secondSymbol);
    }

    @Test
    public void trianglePointUp_6() {
        printTestHeader(name.getMethodName());
        int defaultCount = 1;
        System.out.format("\tTriangle Point Up %d layers tall\n", defaultCount);
        Shapes.trianglePointUp(defaultCount);
    }

    @Test
    public void triangleRightJustifiedPointDown_1() {
        printTestHeader(name.getMethodName());
        int defaultCount = 4;
        System.out.format("\tRight Justified Triangle Point Down %d characters wide\n", defaultCount);
        Shapes.triangleRightJustifiedPointDown(defaultCount);
    }

    @Test
    public void triangleRightJustifiedPointDown_2() {
        printTestHeader(name.getMethodName());
        int defaultCount = 5;
        char firstSymbol = '@';
        System.out.format(
                "\tRight Justified Triangle Point Down %d characters wide using character '%s'\n",
                defaultCount, firstSymbol);
        Shapes.triangleRightJustifiedPointDown(defaultCount, firstSymbol);
    }

    @Test
    public void triangleRightJustifiedPointDown_3() {
        printTestHeader(name.getMethodName());
        int defaultCount = 6;
        System.out.format(
                "\tRight Justified Triangle Point Down %d characters wide, inscribed '%b'\n",
                defaultCount, true);
        Shapes.triangleRightJustifiedPointDown(defaultCount, true);
    }

    @Test
    public void triangleRightJustifiedPointDown_4() {
        printTestHeader(name.getMethodName());
        int defaultCount = 7;
        char firstSymbol = '@';
        System.out.format(
                "\tRight Justified Triangle Point Down %d characters wide using character '%s', inscribed '%b'\n",
                defaultCount, firstSymbol, true);
        Shapes.triangleRightJustifiedPointDown(defaultCount, true, firstSymbol);
    }

    @Test
    public void triangleRightJustifiedPointDown_5() {
        printTestHeader(name.getMethodName());
        int defaultCount = 8;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format(
                "\tRight Justified Triangle Point Down %d characters wide using characters: '%s' and '%s'\n",
                defaultCount, firstSymbol, secondSymbol);
        Shapes.triangleRightJustifiedPointDown(defaultCount, firstSymbol, secondSymbol);
    }

    @Test
    public void triangleRightJustifiedPointDown_6() {
        printTestHeader(name.getMethodName());
        int defaultCount = 1;
        System.out.format("\tRight Justified Triangle Point Down %d characters wide\n", defaultCount);
        Shapes.triangleRightJustifiedPointDown(defaultCount);
    }

    @Test
    public void triangleRightJustifiedPointUp_1() {
        printTestHeader(name.getMethodName());
        int defaultCount = 4;
        System.out.format("\tRight Justified Triangle Point Up %d characters wide\n", defaultCount);
        Shapes.triangleRightJustifiedPointUp(defaultCount);
    }

    @Test
    public void triangleRightJustifiedPointUp_2() {
        printTestHeader(name.getMethodName());
        int defaultCount = 5;
        char firstSymbol = '@';
        System.out.format(
                "\tRight Justified Triangle Point Up %d characters wide using character '%s'\n",
                defaultCount, firstSymbol);
        Shapes.triangleRightJustifiedPointUp(defaultCount, firstSymbol);
    }

    @Test
    public void triangleRightJustifiedPointUp_3() {
        printTestHeader(name.getMethodName());
        int defaultCount = 6;
        System.out.format(
                "\tRight Justified Triangle Point Up %d characters wide, inscribed '%b'\n",
                defaultCount, true);
        Shapes.triangleRightJustifiedPointUp(defaultCount, true);
    }

    @Test
    public void triangleRightJustifiedPointUp_4() {
        printTestHeader(name.getMethodName());
        int defaultCount = 7;
        char firstSymbol = '@';
        System.out.format(
                "\tRight Justified Triangle Point Up %d characters wide using character '%s', inscribed '%b'\n",
                defaultCount, firstSymbol, true);
        Shapes.triangleRightJustifiedPointUp(defaultCount, true, firstSymbol);
    }

    @Test
    public void triangleRightJustifiedPointUp_5() {
        printTestHeader(name.getMethodName());
        int defaultCount = 8;
        char firstSymbol = '@';
        char secondSymbol = '$';
        System.out.format(
                "\tRight Justified Triangle Point Up %d characters wide using characters: '%s' and '%s'\n",
                defaultCount, firstSymbol, secondSymbol);
        Shapes.triangleRightJustifiedPointUp(defaultCount, firstSymbol, secondSymbol);
    }

    @Test
    public void triangleRightJustifiedPointUp_6() {
        printTestHeader(name.getMethodName());
        int defaultCount = 1;
        System.out.format("\tRight Justified Triangle Point Up %d characters wide\n", defaultCount);
        Shapes.triangleRightJustifiedPointUp(defaultCount);
    }
}
