package Code.Java.CTCI.other.Ch_01_Arrays_and_Strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q1_08_Zero_Matrix {

    public static void zeroMatrix(int[][] matrix) {
        Set<Integer> columns = new HashSet<>();
        Set<Integer> rows = new HashSet<>();
        // detect rows and columns that have zeros
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrix[rowIndex].length; columnIndex++) {
                if (matrix[rowIndex][columnIndex] == 0) {
                    columns.add(columnIndex);
                    rows.add(rowIndex);
                }
            }
        }

        // Zero column entries
        for (int i = 0; i < matrix.length; i++) {
            for (Integer column : columns) {
                matrix[i][column] = 0;
            }
        }

        // Zero row entries
        for (Integer row : rows) {
            Arrays.fill(matrix[row], 0);
        }
    }

    public static void zeroMatrix_solution_1(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        // Store the row and column index with value 0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        // Nullify rows
        for (int i = 0; i < row.length; i++) {
            if (row[i]) {
                nullifyRow(matrix, i);
            }
        }

        // Nullify columns
        for (int j = 0; j < column.length; j++) {
            if (column[j]) {
                nullifyColumn(matrix, j);
            }
        }
    }

    public static void nullifyRow(int[][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    public static void nullifyColumn(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    public static void zeroMatrix_solution_2(int[][] matrix) {
        boolean rowHasZero = false;
        boolean colHasZero = false;

        // Check if first row has a zero
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                rowHasZero = true;
                break;
            }
        }

        // Check if first column has a zero
        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                colHasZero = true;
                break;
            }
        }

        // Check for zeros in the rest of the array
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Nullify rows based on values in first column
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                nullifyRow(matrix, i);
            }
        }

        // Nullify columns based on values in first row
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                nullifyColumn(matrix, j);
            }
        }

        // Nullify first row
        if (rowHasZero) {
            nullifyRow(matrix, 0);
        }

        // Nullify first column
        if (colHasZero) {
            nullifyColumn(matrix, 0);
        }
    }

    public static void main(String[] args) {
    }
}
