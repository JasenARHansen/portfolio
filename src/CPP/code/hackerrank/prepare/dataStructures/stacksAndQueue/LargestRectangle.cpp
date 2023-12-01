#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>

using namespace std;

class LargestRectangle {
public:
    static void description() {
        cout << R"(Largest Rectangle:
    Skyline Real Estate Developers is planning to demolish a number of old, unoccupied buildings and construct
     a shopping mall in their place.
    Your task is to find the largest solid area in which the mall can be constructed.

    There are a number of buildings in a certain two-dimensional landscape.
    Each building has a height, given by h[i].
    If you join adjacent buildings, they will form a solid rectangle of area k x min(h[i], h[i + 1], ..., h[i + k - 1]).

    Example:
        h = [3, 2, 3]
        A rectangle of height h = 2 and length k = 3 can be constructed within the boundaries.
        The area formed is h * k = 2 * 3 = 6.

    Function Description:
        Complete the function largestRectangle int the editor below.
        It should return an integer representing the largest rectangle that can be formed within the bounds
         of consecutive buildings.
        largestRectangle has the following parameter(s):
            int h[n]: the building heights

    Returns:
        long: the area of the largest rectangle that can be formed within the bounds of consecutive buildings

    Input Format:
        The first line contains n, the number of buildings.
        The second line contains n space-separated integers, each the height of a building.

    Constraints:
        1 ≤ n ≤ 10^5
        1 ≤ h[i] ≤ 10^6

    Sample Input:
        STDIN       Function
        -----       --------
        5           h[] size n = 5
        1 2 3 4 5   h = [1, 2, 3, 4, 5]

    Sample Output;
        9

    Explanation:
        An illustration of the test case follows.
              |   x
              v x x
              x x x   <--
            x x x x
          x x x x x
          1 2 3 4 5)" << endl;
    }

    static long largestRectangle(vector<int> h) {
        long result = 0;
        int minHeight;
        int localArea;
        for (auto start = 0; start < h.size(); start++) {
            minHeight = h.at(start);
            for (auto stop = start; stop < h.size(); stop++) {
                if (minHeight > h.at(stop)) {
                    minHeight = h.at(stop);
                }
                localArea = minHeight * (stop - start + 1);
                if (localArea > result) {
                    result = localArea;
                }
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop