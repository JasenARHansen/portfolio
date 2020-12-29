package CTCI_SOURCE.other.Ch_01_Arrays_and_Strings.Q1_08_Zero_Matrix;

import CTCI_SOURCE.other.CtCILibrary.AssortedMethods;

public class Tester {
    public static boolean matricesAreEqual(int[][] m1, int[][] m2) {
        if (m1.length != m2.length || m1[0].length != m2[0].length) {
            return false;
        }

        for (int k = 0; k < m1.length; k++) {
            for (int j = 0; j < m1[0].length; j++) {
                if (m1[k][j] != m2[k][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] cloneMatrix(int[][] matrix) {
        int[][] c = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, c[i], 0, matrix[0].length);
        }
        return c;
    }

    public static void main(String[] args) {
        int nrows = 10;
        int ncols = 15;
        int[][] matrix1 = AssortedMethods.randomMatrix(nrows, ncols, -10, 10);
        int[][] matrix2 = cloneMatrix(matrix1);

        AssortedMethods.printMatrix(matrix1);

        QuestionA.setZeros(matrix1);
        QuestionB.setZeros(matrix2);

        System.out.println();

        AssortedMethods.printMatrix(matrix1);
        System.out.println();
        AssortedMethods.printMatrix(matrix2);

        if (matricesAreEqual(matrix1, matrix2)) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }
    }
}
