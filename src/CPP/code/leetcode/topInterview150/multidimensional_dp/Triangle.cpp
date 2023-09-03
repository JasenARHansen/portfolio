#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <cmath>
#include <vector>

using namespace std;

class Triangle {

public:

    static void description() {
        cout << R"(120. Triangle
    Given a triangle array, return the minimum path sum from top to bottom.
    For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

    Example 1:
        Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
        Output: 11
        Explanation:
            The triangle looks like:
               2
              3 4
             6 5 7
            4 1 8 3
            The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

    Example 2:
        Input: triangle = [[-10]]
        Output: -10

    Constraints:
        1 <= triangle.length <= 200
        triangle[0].length == 1
        triangle[i].length == triangle[i - 1].length + 1
        -10^4 <= triangle[i][j] <= 10^4)" << endl;
    }

    static int minimumTotal(const vector<vector<int>> &triangle) {
        assert (!triangle.empty());
        assert (triangle.size() <= 200);
        assert (triangle[0].size() == 1);
        if (triangle.size() == 1) {
            assert (-pow(10, 4) <= triangle[0][0]);
            assert (triangle[0][0] <= pow(10, 4));
            return triangle[0][0];
        }
        return minimumTotal(triangle, 0)[0];
    }

private:

    static vector<int> minimumTotal(const vector<vector<int>> &triangle, int row) {
        assert (triangle[row].size() + 1 == triangle[row + 1].size());
        vector<int> result;
        vector<int> n0 = triangle[row];
        vector<int> n1;
        if ((triangle.size() - 1 - row) > 1) {
            n1 = minimumTotal(triangle, row + 1);
        } else {
            n1 = triangle[row + 1];
        }
        for (int index = 0; index < n0.size(); index++) {
            auto first = n0[index] + n1[index];
            auto second = n0[index] + n1[index + 1];
            if (first < second) {
                result.push_back(first);
            } else {
                result.push_back(second);
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop