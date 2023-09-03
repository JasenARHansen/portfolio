#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <vector>
#include <cmath>

using namespace std;

class MinimumSizeSubarraySum {

public:

    static void description() {
        cout << R"(209. Minimum Size Subarray Sum
    Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

    Example 1:
        Input: target = 7, nums = [2,3,1,2,4,3]
        Output: 2
        Explanation:
            The subarray [4,3] has the minimal length under the problem constraint.

    Example 2:
        Input: target = 4, nums = [1,4,4]
        Output: 1

    Example 3:
        Input: target = 11, nums = [1,1,1,1,1,1,1,1]
        Output: 0

    Constraints:
        1 <= target <= 10^9
        1 <= nums.length <= 10^5
        1 <= nums[i] <= 10^4)" << endl;
    }

    static int minSubArrayLen(int target, vector<int> &nums) {
        assert (1 <= target);
        assert (target <= pow(10, 9));
        assert (!nums.empty());
        assert (nums.size() <= pow(10, 5));
        auto index1 = 0;
        auto index2 = 0;
        auto sum = 0;
        auto detected = INT_MAX;
        while (index2 < nums.size()) {
            // expand window to find a potential value
            while ((sum < target) && (index2 < nums.size())) {
                auto value = nums[index2];
                assert (1 <= value);
                assert (value <= pow(10, 4));
                sum += value;
                index2++;
            }
            // contract the window
            while ((sum > target) && (index1 < index2)) {
                detected = min(detected, (index2 - index1));
                auto value = nums[index1];
                sum -= value;
                index1++;

            }
            if (sum == target) {
                detected = min(detected, (index2 - index1));
                auto value = nums[index1];
                sum -= value;
                index1++;
            }
        }
        if (detected == INT_MAX) {
            return 0;
        }
        return detected;
    }
};

#pragma clang diagnostic pop