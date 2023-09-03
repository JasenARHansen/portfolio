#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <cassert>
#include <cmath>

using namespace std;

class SingleNumber {

public:

    static void description() {
        cout << R"(136. Single Number
    Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
    You must implement a solution with a linear runtime complexity and use only constant extra space.

    Example 1:
        Input: nums = [2,2,1]
        Output: 1

    Example 2:
        Input: nums = [4,1,2,1,2]
        Output: 4

    Example 3:
        Input: nums = [1]
        Output: 1

    Constraints:
        1 <= nums.length <= 3 * 10^4
        -3 * 10^4 <= nums[i] <= 3 * 10^4
        Each element in the array appears twice except for one element which appears only once.)" << endl;
    }

    static int singleNumber(vector<int> &nums) {
        assert (!nums.empty());
        assert (nums.size() <= 3 * pow(10, 4));
        auto result = 0;
        for (auto number: nums) {
            assert (-3 * pow(10, 4) <= number);
            assert (number <= 3 * pow(10, 4));
            result ^= number;
        }
        return result;
    }
};

#pragma clang diagnostic pop