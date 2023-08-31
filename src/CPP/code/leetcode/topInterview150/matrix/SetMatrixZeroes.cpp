#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <cassert>

using namespace std;

class SetMatrixZeroes {
public:

    static void description() {
        cout << R"(73. Set Matrix Zeroes
    Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
    You must do it in place.

    Example 1:
        Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
        Output: [[1,0,1],[0,0,0],[1,0,1]]

    Example 2:
        Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
        Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

    Constraints:
        m == matrix.length
        n == matrix[0].length
        1 <= m, n <= 200
        -2^31 <= matrix[i][j] <= 2^31 - 1)" << endl;
    }

    static void setZeroes(vector<vector<int>> &matrix) {
        assert (!matrix.empty());
        assert (matrix.size() <= 200);
        vector<vector<bool>> test;
        int size = matrix[0].size();
        for (const auto &i: matrix) {
            assert (!i.empty());
            assert (i.size() == size);
            assert (i.size() <= 200);
            test.emplace_back(size, true);
        }
        for (int row = 0; row < matrix.size(); row++) {
            for (int column = 0; column < matrix[row].size(); column++) {
                if ((matrix[row][column] == 0) && test[row][column]) {
                    // flip row
                    for (int index = 0; index < matrix[row].size(); index++) {
                        if (matrix[row][index] != 0) {
                            {
                                matrix[row][index] = 0;
                                test[row][index] = false;
                            }
                        }
                    }
                    // flip column
                    for (int index = 0; index < matrix.size(); index++) {
                        if (matrix[index][column] != 0) {
                            matrix[index][column] = 0;
                            test[index][column] = false;
                        }
                    }
                }
            }
        }
    }
};

#pragma clang diagnostic pop