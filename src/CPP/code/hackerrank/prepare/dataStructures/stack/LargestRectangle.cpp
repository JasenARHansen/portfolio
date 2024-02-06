#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <stack>

using namespace std;

class LargestRectangle {
public:
    static void description() {
        cout << R"(Stacks: Largest Rectangle
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
              x x x   ←
            x x x x
          x x x x x
          1 2 3 4 5)" << endl;
    }

    static long largestRectangle(vector<int> h) {
        long result = 0;
        stack<int> height;
        height.emplace(0);
        for (auto index = 0; index < h.size(); index++) {
            while ((!height.empty()) and (h.at(index) <= height.top())) {
                height.pop();
            }
            if (height.empty()) {
                // allow for vacant lot
                height.emplace(0);
            } else {
                if (h.at(index) > height.top()) {
                    height.emplace(h.at(index));
                    auto indexLeft = index - 1;
                    while ((indexLeft >= 0) and (h.at(indexLeft) > h.at(index))) {
                        indexLeft--;
                    }
                    indexLeft++;
                    auto indexRight = index;
                    while ((indexRight < h.size()) and (h.at(indexRight) >= h.at(index))) {
                        indexRight++;
                    }
                    auto value = h.at(index) * (indexRight - indexLeft);
                    if (result < value) {
                        result = value;
                    }
                }
            }
        }
        return result;
    }

    /*
    // This code does collapse the stack as expected and passes all my test cases, but it fails some automated
     tests and I do not know why
     static long largestRectangle_stack(vector<int> h) {
        long result = 0;
        stack<pair<long, int>> houses;
        for (auto index = 0; index < h.size(); index++) {
            // No previous houses so calculate current block
            if (h.at(index) <= 0) {
                // empty lot so no previous heights matter
                stack<pair<long, int>>().swap(houses);
            } else {
                if (houses.empty()) {
                    houses.emplace((long) h.at(index), index);
                    auto value = h.at(index);
                    if (result < value) {
                        result = value;
                    }
                } else {
                    auto house = pair<long, int>(h.at(index), index);
                    if (houses.top().first == house.first) {
                        // 1. If no change in height, collapse on level and calculate
                        auto value = house.first * (index - houses.top().second + 1);
                        if (result < value) {
                            result = value;
                        }
                    } else if (houses.top().first > house.first) {
                        // 2. If height goes down, collapse to new level and calculate
                        while ((!houses.empty()) and (houses.top().first >= house.first)) {
                            auto value = house.first * (index - houses.top().second + 1);
                            if (result < value) {
                                result = value;
                            }
                            houses.top().first = house.first;
                            house = houses.top();
                            houses.pop();
                        }
                        // add current house to stack
                        houses.emplace(house);
                    } else {
                        // 3. If height goes up, calculate all values down the stack
                        stack<pair<long, int>> swap;
                        while (!houses.empty()) {
                            auto value = houses.top().first * (index - houses.top().second + 1);
                            if (result < value) {
                                result = value;
                            }
                            swap.emplace(houses.top());
                            houses.pop();
                        }
                        // put houses back on the stack
                        while (!swap.empty()) {
                            houses.emplace(swap.top());
                            swap.pop();
                        }
                        // add current house to stack
                        houses.emplace(house);
                    }
                }
            }
        }
        return result;
    }
    */
};

#pragma clang diagnostic pop