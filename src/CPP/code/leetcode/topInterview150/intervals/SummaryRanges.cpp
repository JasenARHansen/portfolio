#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <set>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

class SummaryRanges {
public:

    static void description() {
        cout << R"(228. Summary Ranges
    You are given a sorted unique integer array nums.
    A range [a,b] is the set of all integers from a to b (inclusive).
    Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
    Each range [a,b] in the list should be output as:
        "a->b" if a != b
        "a" if a == b

    Example 1:
        Input: nums = [0,1,2,4,5,7]
        Output: ["0->2","4->5","7"]
        Explanation: The ranges are:
            [0,2] --> "0->2"
            [4,5] --> "4->5"
            [7,7] --> "7"

    Example 2:
        Input: nums = [0,2,3,4,6,8,9]
        Output: ["0","2->4","6","8->9"]
        Explanation: The ranges are:
            [0,0] --> "0"
            [2,4] --> "2->4"
            [6,6] --> "6"
            [8,9] --> "8->9"

    Constraints:
        0 <= nums.length <= 20
        -2^31 <= nums[i] <= 2^31 - 1
        All the values of nums are unique.
    nums is sorted in ascending order.)" << endl;
    }

    static vector<string> summaryRanges(vector<int> &nums) {
        assert (nums.size() <= 20);
        vector<string> result;
        if (nums.empty()) {
            return result;
        }
        set<int> used;
        for (int num: nums) {
            used.insert(num);
        }
        vector<int> uniques(used.size());
        copy(used.begin(), used.end(), uniques.begin());
        int startIndex = 0;
        int stopIndex = 0;
        for (int index = 1; index < uniques.size(); index++) {
            if (uniques[index - 1] + 1 == uniques[index]) {
                stopIndex++;
            } else {
                if ((stopIndex - startIndex) == 0) {
                    result.push_back(to_string(uniques[startIndex]));
                } else {
                    result.push_back(to_string(uniques[startIndex]) + "->" + to_string(uniques[stopIndex]));
                }
                startIndex = index;
                stopIndex = index;
            }
        }
        if (startIndex == stopIndex) {
            result.push_back(to_string(uniques[startIndex]));
        } else {
            result.push_back(to_string(uniques[startIndex]) + "->" + to_string(uniques[stopIndex]));
        }
        return result;
    }
};

#pragma clang diagnostic pop