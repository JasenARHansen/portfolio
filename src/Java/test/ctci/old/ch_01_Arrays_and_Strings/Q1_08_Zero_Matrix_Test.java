package Java.test.ctci.old.ch_01_Arrays_and_Strings;

import Java.code.ctci.old.ch_01_Arrays_and_Strings.Q1_08_Zero_Matrix;
import Java.code.ctci.source.ctciLibrary.AssortedMethods;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;

@SuppressWarnings("NewClassNamingConvention")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q1_08_Zero_Matrix_Test {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void zeroMatrix() {
        printTestHeader(name.getMethodName());
        int[][] matrix = AssortedMethods.randomMatrix(3, 3, 0, 9);
        AssortedMethods.printMatrix(matrix);
        Q1_08_Zero_Matrix.zeroMatrix(matrix);
        System.out.format("\tMatrix zeroed\n");
        AssortedMethods.printMatrix(matrix);
    }

    @Test
    public void zeroMatrix_solution_1() {
        printTestHeader(name.getMethodName());
        int[][] matrix = AssortedMethods.randomMatrix(3, 3, 0, 9);
        AssortedMethods.printMatrix(matrix);
        Q1_08_Zero_Matrix.zeroMatrix_solution_1(matrix);
        System.out.format("\tMatrix zeroed\n");
        AssortedMethods.printMatrix(matrix);
    }

    @Test
    public void zeroMatrix_solution_2() {
        printTestHeader(name.getMethodName());
        int[][] matrix = AssortedMethods.randomMatrix(3, 3, 0, 9);
        AssortedMethods.printMatrix(matrix);
        Q1_08_Zero_Matrix.zeroMatrix_solution_2(matrix);
        System.out.format("\tMatrix zeroed\n");
        AssortedMethods.printMatrix(matrix);
    }
}
