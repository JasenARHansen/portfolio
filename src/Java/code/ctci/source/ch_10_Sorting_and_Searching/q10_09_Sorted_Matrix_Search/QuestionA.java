package Java.code.ctci.source.ch_10_Sorting_and_Searching.q10_09_Sorted_Matrix_Search;

import Java.code.ctci.source.ctciLibrary.AssortedMethods;

public class QuestionA {

    public static void main(String[] args) {
        int M = 10;
        int N = 5;
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = 10 * i + j;
            }
        }

        AssortedMethods.printMatrix(matrix);

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                int v = 10 * i + j;
                System.out.println(v + ": " + findElement(matrix, v));
            }
        }
    }

    public static boolean findElement(int[][] matrix, int elem) {
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == elem) {
                return true;
            } else if (matrix[row][col] > elem) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
