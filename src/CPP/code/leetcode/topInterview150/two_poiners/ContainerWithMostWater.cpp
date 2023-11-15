#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <cmath>
#include <vector>
#include <map>

using namespace std;

class ContainerWithMostWater {
public:
    static void description() {
        cout << R"(11. Container With Most Water
    You are given an integer array height of length n.
    There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
    Find two lines that together with the x-axis form a container, such that the container contains the most water.
    Return the maximum amount of water a container can store.
    Notice that you may not slant the container.

    Example 1:
        Input: height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
        Output: 49
        Explanation:
            The above vertical lines are represented by array [1, 8, 6, 2, 5, 4, 8, 3, 7].
            In this case, the max area of water (blue section) the container can contain is 49.

    Example 2:
        Input: height = [1, 1]
        Output: 1

    Constraints:
        n == height.length
        2 ≤ n ≤ 10^5
        0 ≤ height[i] ≤ 10^4)" << endl;
    }

    static int maxArea(vector<int> &height) {
        assert (2 <= height.size());
        assert (height.size() <= pow(10, 5));
        auto result = 0;
        auto leftIndex = 0;
        auto rightIndex = height.size() - 1;
        while (rightIndex > leftIndex) {
            if ((min(height.at(rightIndex), height.at(leftIndex)) * (rightIndex - leftIndex)) > result) {
                assert (0 <= height.at(rightIndex));
                assert (height.at(rightIndex) <= pow(10, 4));
                assert (0 <= height.at(leftIndex));
                assert (height.at(leftIndex) <= pow(10, 4));
                result = (int) (min(height.at(rightIndex), height.at(leftIndex)) * (rightIndex - leftIndex));
            }
            if (height.at(rightIndex) > (height.at(leftIndex))) {
                leftIndex++;
            } else if (height.at(rightIndex) < (height.at(leftIndex))) {
                rightIndex--;
            } else {
                leftIndex++;
                rightIndex--;
            }
        }
        return result;
    }

    static int maxArea_2(vector<int> &height) {
        assert (2 <= height.size());
        assert (height.size() <= pow(10, 5));
        map<int, int> values;
        for (auto value: height) {
            if (!values.count(value)) {
                values[value] = 0;
            }
            values[value]++;
        }
        auto result = 0;
        for (auto leftIndex = 0; leftIndex < height.size() - 1; leftIndex++) {
            for (auto rightIndex = leftIndex + 1; rightIndex < height.size(); rightIndex++) {
                auto test = (rightIndex - leftIndex) * min(height[leftIndex], height[rightIndex]);
                auto maxPossible = maxRemaining(values, leftIndex, height);
                if (result < test) {
                    result = test;
                }
                if (result > maxPossible) {
                    return result;
                }
            }
            values[leftIndex]--;
        }
        return result;
    }

private:
    static int maxRemaining(map<int, int> &values, int index, vector<int> &height) {
        auto largest = prev(values.end(), 1);
        while (values.at(largest->first) == 0) {
            values.erase(largest->first);
            largest = prev(values.end(), 1);
        }
        auto lValue = largest->first;
        int rValue;
        if (1 < largest->second) {
            rValue = largest->first;
        } else {
            auto second = prev(values.end(), 2);
            while (values.at(largest->first) == 0) {
                values.erase(second->first);
                second = prev(values.end(), 1);
            }
            rValue = second->first;
        }
        return min(lValue, rValue) * ((int) height.size() - index - 1);
    }
};

#pragma clang diagnostic pop