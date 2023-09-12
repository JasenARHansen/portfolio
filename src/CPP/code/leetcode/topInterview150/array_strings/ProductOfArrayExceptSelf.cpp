#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <vector>
#include <cmath>

using namespace std;

class ProductOfArrayExceptSelf {

public:

    static void description() {
        cout << R"(238. Product of Array Except Self
    Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    You must write an algorithm that runs in O(n) time and without using the division operation.

    Example 1:
        Input: nums = [1,2,3,4]
        Output: [24,12,8,6]

    Example 2:
        Input: nums = [-1,1,0,-3,3]
        Output: [0,0,9,0,0]

    Constraints:
        2 ≤ nums.length ≤ 10^5
        -30 ≤ nums[i] ≤ 30
        The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

    Follow up:
        Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.))"
             << endl;
    }

    static vector<int> productExceptSelf(vector<int> &nums) {
        assert (2 <= nums.size());
        assert (nums.size() <= pow(10, 5));
        vector<int> left(nums.size(), 1);
        vector<int> right(nums.size(), 1);
        vector<int> result(nums.size(), 1);
        assert(-30 <= nums[0]);
        assert(nums[0] <= 30);
        left[0] = nums[0];
        for (auto i = 1; i < nums.size(); i++) {
            assert(-30 <= nums[i]);
            assert(nums[i] <= 30);
            left[i] = left[i - 1] * nums[i];
        }
        right[nums.size() - 1] = nums[nums.size() - 1];
        for (int i = (int) nums.size() - 2; i > 0; i--) {
            right[i] = right[i + 1] * nums[i];
        }
        result[0] = right[1];
        result[nums.size() - 1] = left[nums.size() - 2];
        for (auto i = 1; i < nums.size() - 1; i++) {
            result[i] = left[i - 1] * right[i + 1];
        }
        return result;
    }
};

#pragma clang diagnostic pop