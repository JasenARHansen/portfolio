package Java.test.ctci.old.ch_01_Arrays_and_Strings;

import Java.code.ctci.old.ch_01_Arrays_and_Strings.Q1_07_Rotate_Matrix;
import Java.code.ctci.source.ctciLibrary.AssortedMethods;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("NewClassNamingConvention")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q1_07_Rotate_Matrix_Test {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void rotateMatrix() {
        printTestHeader(name.getMethodName());
        int[][] matrix = AssortedMethods.randomMatrix(3, 3, 0, 9);
        AssortedMethods.printMatrix(matrix);
        boolean result = Q1_07_Rotate_Matrix.rotateMatrix(matrix);
        assertTrue(result);
        System.out.format("\tMatrix rotated\n");
        AssortedMethods.printMatrix(matrix);
    }

    @Test
    public void rotateMatrix_in_place() {
        printTestHeader(name.getMethodName());
        int[][] matrix = AssortedMethods.randomMatrix(4, 4, 0, 9);
        AssortedMethods.printMatrix(matrix);
        boolean result = Q1_07_Rotate_Matrix.rotateMatrix_in_place(matrix);
        assertTrue(result);
        System.out.format("\tMatrix rotated\n");
        AssortedMethods.printMatrix(matrix);
    }

    @Test
    public void rotateMatrix_solution_1() {
        printTestHeader(name.getMethodName());
        int[][] matrix = AssortedMethods.randomMatrix(3, 3, 0, 9);
        AssortedMethods.printMatrix(matrix);
        boolean result = Q1_07_Rotate_Matrix.rotateMatrix_solution_1(matrix);
        assertTrue(result);
        System.out.format("\tMatrix rotated\n");
        AssortedMethods.printMatrix(matrix);
    }
}
