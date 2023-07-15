package Java.test.ctci.old.ch_05_Bit_Manipulation;

import Java.code.ctci.old.ch_05_Bit_Manipulation.BitShift;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;

@SuppressWarnings({"NewClassNamingConvention", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q5_08_Draw_Line_Test {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void drawLine() {
        printTestHeader(name.getMethodName());
        int height = 4;
        // Width is a byte so if you wanted to know pixel width multiply by 8
        int width = 2;
        int y = 3;
        int startBit = 2;
        int stopBit = 27;
        byte[] screen = new byte[height * width];
        BitShift.drawLine(screen, width, startBit, stopBit, y);
    }
}
