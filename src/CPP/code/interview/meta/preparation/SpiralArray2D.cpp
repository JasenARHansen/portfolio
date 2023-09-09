#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include<vector>

using namespace std;

class SpiralArray2D {

public:
    static void description() {
        cout << R"(Question 1: 2D Spiral Array
    Find the pattern and complete the function:
        int[][] spiral(int n);
    where n is the size of the 2D array.

    Example 1:
        Input: 3
        Output:
            123
            894
            765

    Example 2:
        Input: 4
        Output:
            01 02 03 04
            12 13 14 05
            11 16 15 06
            10 09 08 07

    Example 3:
        Input: 8
        Output:
            1 2 3 4 5 6 7 8
            28 29 30 31 32 33 34 9
            27 48 49 50 51 52 35 10
            26 47 60 61 62 53 36 11
            25 46 59 64 63 54 37 12
            24 45 58 57 56 55 38 13
            23 44 43 42 41 40 39 14
            22 21 20 19 18 17 16 15)" << endl;
    }

    static vector<vector<int>> spiral(const int n) {
        // initialize vector so the spaces are available
        vector<vector<int>> result;
        result.reserve(n);
        for (auto index = 0; index < n; index++) {
            result.emplace_back(n, 0);
        }
        int counter = 1;
        for (auto shell = 0; shell <= n / 2; shell++) {
            // populate top
            for (auto index = 0; index < n - 2 * shell; index++) {
                result[shell][index + shell] = counter++;
            }
            // populate right
            for (auto index = 0; index < n - 2 * shell - 1; index++) {
                result[index + shell + 1][result.size() - shell - 1] = counter++;
            }
            // populate bottom
            for (auto index = 0; index < n - 2 * shell - 1; index++) {
                result[result.size() - shell - 1][result.size() - index - shell - 2] = counter++;
            }
            // populate left
            for (auto index = 0; index < n - 2 * shell - 2; index++) {
                result[result.size() - index - shell - 2][shell] = counter++;
            }
        }
        return result;
    }

};

#pragma clang diagnostic pop