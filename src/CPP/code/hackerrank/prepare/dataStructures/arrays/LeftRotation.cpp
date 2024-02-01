#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

class LeftRotation {
public:
    static void description() {
        cout << R"(Arrays: Left Rotation
    A left rotation operation on an array os size n shifts each of the array's elements 1 unit to the left.
    Given an integer, d, rotate the array that many steps left and return the result.
    Example:
        d = 2
        arr = [1, 2, 3, 4, 5]
        After 2 rotations arr' = [3, 4, 5, 1, 2]
    Note that the lowest index item moves to the highest index in a rotation.
    This is called a circular array.
    Return the updated array to be printed as a single line of space-separated integers.
    Function Description:
        Complete the function rotateLeft in the editor below.
        rotateLeft has the following parameter(s):
            int d: the amount to rotate by
            int arr[n]: the array to rotate
    Returns:
        int a'[n]: the rotated array
    Input Format:
        The first line contains two space-separated integers that denote n, the number of integers, and d,
         the number of left rotations to perform.
        The second line contains space-separated integers that describe arr[].
    Constraints:
        1 ≤ n ≤ 10^5
        1 ≤ d ≤ n
        1 ≤ a[i] ≤ 10^6
    Sample Input:
        5 4
        1 2 3 4 5
    Sample Output:
        5 1 2 3 4
    Explanation:
        When we perform d = 4 left rotations, the array undergoes the following sequence of changes:
        [1, 2, 3, 4, 5] -> [2, 3, 4, 5, 1] -> [3, 4, 5, 1, 2] -> [4, 5, 1, 2, 3] -> [5, 1, 2, 3, 4])" << endl;
    }

    static vector<int> rotateLeft(int d, vector<int> arr) {
        vector<int> result;
        if (d < 0) {
            d = arr.size() - abs(d) % arr.size();
        } else {
            d = d % arr.size();
        }
        // add portion from right of rotation to result
        for (auto it = arr.begin() + d; it != arr.end(); ++it) {
            result.push_back(*it);
        }
        // add rotated values to end of result
        for (auto it = arr.begin(); it != arr.begin() + d; ++it) {
            result.push_back(*it);
        }
        return result;
    }
};

#pragma clang diagnostic pop