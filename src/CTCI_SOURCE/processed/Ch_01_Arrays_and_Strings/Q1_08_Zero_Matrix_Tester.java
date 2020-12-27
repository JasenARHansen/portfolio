package CTCI_SOURCE.processed.Ch_01_Arrays_and_Strings;

import CTCI.CtCILibrary.AssortedMethods;

public class Q1_08_Zero_Matrix_Tester {

    public static void main(String[] args) {
        int nrows = 10;
        int ncols = 15;
        int[][] matrix1 = AssortedMethods.randomMatrix(nrows, ncols, -10, 10);
        int[][] matrix2 = AssortedMethods.cloneMatrix(matrix1);

        AssortedMethods.printMatrix(matrix1);

        Q1_08_Zero_Matrix_QuestionA.setZeros(matrix1);
        Q1_08_Zero_Matrix_QuestionB.setZeros(matrix2);

        System.out.println();

        AssortedMethods.printMatrix(matrix1);
        System.out.println();
        AssortedMethods.printMatrix(matrix2);

        if (AssortedMethods.matricesAreEqual(matrix1, matrix2)) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }
    }
}
