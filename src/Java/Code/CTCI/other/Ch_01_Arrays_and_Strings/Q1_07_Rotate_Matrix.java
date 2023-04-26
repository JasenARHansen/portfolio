package Java.Code.CTCI.other.Ch_01_Arrays_and_Strings;

public class Q1_07_Rotate_Matrix {

    public static boolean rotateMatrix(int[][] matrix) {
        if ((matrix == null) || (matrix.length == 0) || (matrix.length != matrix[0].length)) {
            return false;
        }

        int size = matrix.length;
        int[][] temp = new int[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                temp[col][size - row - 1] = matrix[row][col];
            }
        }

        for (int row = 0; row < size; row++) {
            System.arraycopy(temp[row], 0, matrix[row], 0, size);
        }

        return true;
    }

    public static boolean rotateMatrix_in_place(int[][] matrix) {
        if ((matrix == null) || (matrix.length == 0) || (matrix.length != matrix[0].length)) {
            return false;
        }

        int size = matrix.length;
        int shells = size / 2;
        for (int shell = 0; shell < shells; shell++) {
            int shell_steps = size - 1 - shell;
            for (int step = shell; step < shell_steps; step++) {
                int offset = step - shell;
                // pass 1
                int save = matrix[shell][step];
                // Upper left
                matrix[shell][step] = matrix[shell_steps - offset][shell];
                // Upper right
                matrix[shell_steps - offset][shell] = matrix[shell_steps][shell_steps - offset];
                // (2, 2) Lower right
                matrix[shell_steps][shell_steps - offset] = matrix[step][shell_steps];
                // (2, 0) Lower left
                matrix[step][shell_steps] = save;
            }
        }
        return true;
    }

    public static boolean rotateMatrix_solution_1(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false; // Not a square
        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int last = n - 1 - layer;
            for (int i = layer; i < last; i++) {
                int offset = i - layer;
                int top = matrix[layer][i]; // save top

                // left -> top
                matrix[layer][i] = matrix[last - offset][layer];

                // bottom -> left
                matrix[last - offset][layer] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top; // right <- saved top
            }
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
