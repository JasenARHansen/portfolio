#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <bitset>
#include <cassert>

using namespace std;

class SpiralMatrix {

public:

    static void description() {
        cout << R"(54. Spiral Matrix
    Given an m x n matrix, return all elements of the matrix in spiral order.

    Example 1:
        Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
        Output: [1,2,3,6,9,8,7,4,5]

    Example 2:
        Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
        Output: [1,2,3,4,8,12,11,10,9,5,6,7]

    Constraints:
        m == matrix.length
        n == matrix[i].length
        1 <= m, n <= 10
        -100 <= matrix[i][j] <= 100)" << endl;
    }

    static vector<int> spiralOrder(vector<vector<int>> &matrix) {
        assert (!matrix.empty());
        assert (matrix.size() <= 10);
        int rows = matrix.size();
        int columns = matrix[0].size();
        for (const auto &i: matrix) {
            assert (!i.empty());
            assert (i.size() <= 10);
            assert (i.size() == columns);
        }
        vector<bitset<10>> test;
        for (int i = 0; i < matrix.size(); i++) {
            bitset<10> temp;
            test.push_back(temp);
        }
        vector<int> result;
        int row;
        int column;
        for (int ring = 0; ring < (min(rows, columns) + 1) / 2; ring++) {
            // Navigate right
            for (int index = 0 + ring; index < matrix[ring].size() - ring; index++) {
                row = ring;
                column = index;
                validate(matrix, test, result, row, column);
            }
            // Navigate down
            for (int index = ring + 1; index < matrix.size() - ring; index++) {
                row = index;
                column = columns - ring - 1;
                validate(matrix, test, result, row, column);
            }
            // Navigate left
            for (int index = matrix[ring].size() - ring - 2; index >= ring; index--) {
                row = matrix.size() - ring - 1;
                column = index;
                validate(matrix, test, result, row, column);
            }
            // Navigate up
            for (int index = matrix.size() - ring - 2; index > ring; index--) {
                row = index;
                column = ring;
                validate(matrix, test, result, row, column);
            }
        }
        return result;
    }

private:

    static void
    validate(const vector<vector<int>> &matrix, vector<bitset<10>> &test, vector<int> &result, int row,
             int column) {
        if (!test[row].test(column)) {
            test[row].flip(column);
            int value = matrix[row][column];
            assert (-100 <= value);
            assert (value <= 100);
            result.push_back(value);
        }
    }
};

#pragma clang diagnostic pop