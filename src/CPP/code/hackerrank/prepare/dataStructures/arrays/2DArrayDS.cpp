#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>

using namespace std;

class Arrays2DDS {
public:
    static void description() {
        cout << R"(Arrays: 2D Arrays DS
    Given a 6x6 2D Array, arr:
        1 1 1 0 0 0
        0 1 0 0 0 0
        1 1 1 0 0 0
        0 0 0 0 0 0
        0 0 0 0 0 0
        0 0 0 0 0 0
    An hourglass in A is a subset of values with indices falling in this pattern in ass's graphical representation:
        a b c
          d
        e f g
    There are 16 hourglasses in arr.
    An hourglass sum is the sum of an hourglass' values.
    Calculate the hourglass sum for every hourglass in arr, then print the maximum hourglass sum.
    The array will always be 6x6.
    Example:
    arr =
        -9 -9 -9  1 1 1
         0 -9  0  4 3 2
        -9 -9 -9  1 2 3
         0  0  8  6 6 0
         0  0  0 -2 0 0
         0  0  1  2 4 0
    The 16 hourglass sums are:
        -63, -34, -9, 12,
        -10,   0, 28, 23,
        -27, -11, -2, 10,
          9,  17, 25, 18
    The highest hourglass sum is 28 from the hourglass beginning at row 1, column 2:
        0 4 3
          1
        8 6 6
    Note: If you have already solved the Java domain's Java 2D Array challenge, you may wish to skip this challenge.
    Function Description:
        Complete the function hourglassSum in the editor below.
        hourglassSum has the following parameter(s):
            int arr[6][6]: an array of integers
        Returns:
            int: the maximum hourglass sum
        Input Format:
        Each of the 6 lines of inputs arr[i] contains 6 space-separated integers arr[i][j].
    Constraints:
        -9 ≤ arr[i][j] ≤ 9
        0 ≤ i, j ≤ 5
    Output Format:
        Print the largest (maximum) hourglass sum found in arr.
    Sample Input:
        1 1 1 0 0 0
        0 1 0 0 0 0
        1 1 1 0 0 0
        0 0 2 4 4 0
        0 0 0 2 0 0
        0 0 1 2 4 0
    Sample Output:
        19
    Explanation:
        arr contains the following hourglasses:
            111 110 100 000
             1   0   0   0
            111 110 100 000

            010 100 000 000
             1   1   0   0
            002 024 244 440

            111 110 100 000
             0   2   4   4
            000 002 020 200

            002 024 244 440
             0   0   2   0
            001 012 124 240
        The hourglass with the maximum sum (19) is:
            2 4 4
              2
            1 2 4.)" << endl;
    }

    static int hourglassSum(vector<vector<int>> arr) {
        auto result = INT_MIN;
        for (auto row = 0; row < arr.size() - 2; row++) {
            for (auto col = 0; col < arr.at(0).size() - 2; col++) {
                auto sum = 0;
                for (auto coordinate = 0; coordinate < 3; coordinate++) {
                    sum += arr.at(row).at(col + coordinate);
                }
                sum += arr.at(row + 1).at(col + 1);
                for (auto coordinate = 0; coordinate < 3; coordinate++) {
                    sum += arr.at(row + 2).at(col + coordinate);
                }
                if (sum > result) {
                    result = sum;
                }
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop