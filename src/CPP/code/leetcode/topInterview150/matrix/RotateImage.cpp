#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <cassert>

using namespace std;

class RotateImage {
public:
    static void description() {
        cout << R"(48: Rotate Image
    You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
    You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
    DO NOT allocate another 2D matrix and do the rotation.
    Example 1:
        Input: matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
        Output: [[7, 4, 1], [8, 5, 2], [9, 6, 3]]
    Example 2:
        Input: matrix = [[5, 1, 9, 11], [2, 4, 8, 10], [13, 3, 6, 7], [15, 14, 12, 16]]
        Output: [[15, 13, 2, 5], [14, 3, 4, 1], [12, 6, 8, 9], [16, 7, 10, 11]]
    Constraints:
        n == matrix.length == matrix[i].length
        1 ≤ n ≤ 20
        -1000 ≤ matrix[i][j] ≤ 1000)" << endl;
    }

    static void rotate(vector<vector<int>> &matrix) {
        assert (!matrix.empty());
        assert (matrix.size() <= 20);
        for (const auto &i: matrix) {
            assert (!i.empty());
            assert (i.size() == matrix.size());
        }
        int swap;
        int rowTarget;
        int columnTarget;
        int rowSource;
        int columnSource;
        for (auto ring = 0; ring < (matrix.size() + 1) / 2; ring++) {
            for (auto index = 0 + ring; index < matrix.size() - ring - 1; index++) {
                // Store upper left
                rowSource = ring;
                columnSource = index;
                swap = matrix[rowSource][columnSource];
                // Move lower left to upper left
                rowTarget = rowSource;
                columnTarget = columnSource;
                rowSource = (int) matrix.size() - index - 1;
                columnSource = ring;
                store(matrix, matrix[rowSource][columnSource], rowTarget, columnTarget);
                // Move lower right to lower left
                rowTarget = rowSource;
                columnTarget = columnSource;
                rowSource = (int) matrix.size() - ring - 1;
                columnSource = (int) matrix.size() - index - 1;
                store(matrix, matrix[rowSource][columnSource], rowTarget, columnTarget);
                // Move upper right to lower right
                rowTarget = rowSource;
                columnTarget = columnSource;
                rowSource = index;
                columnSource = (int) matrix.size() - ring - 1;
                store(matrix, matrix[rowSource][columnSource], rowTarget, columnTarget);
                // Move stored value to upper right
                rowTarget = rowSource;
                columnTarget = columnSource;
                store(matrix, swap, rowTarget, columnTarget);
            }
        }
    }

private:
    static void store(vector<vector<int>> &matrix, int value, int row, int column) {
        assert (-1000 <= value);
        assert (value <= 1000);
        matrix[row][column] = value;
    }
};

#pragma clang diagnostic pop