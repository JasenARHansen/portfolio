#pragma clang diagnostic push
#pragma ide diagnostic ignored "ConstantConditionsOC"
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <vector>
#include <iostream>
#include <cassert>
#include <cmath>

using namespace std;

class JumpGameII {
public:

    static void description() {
        cout << R"(45. Jump Game II
    You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
    Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
        0 <= j <= nums[i] and
        i + j < n
    Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

    Example 1:
        Input: nums = [2,3,1,1,4]
        Output: 2
        Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

    Example 2:
        Input: nums = [2,3,0,1,4]
        Output: 2

    Constraints:
        1 <= nums.length <= 10^4
        0 <= nums[i] <= 1000
        It's guaranteed that you can reach nums[n - 1].)" << endl;
    }

    static int jump(vector<int> &nums) {
        assert (!nums.empty());
        assert (nums.size() <= pow(10, 4));
        vector<int> processed(nums.size(), -1);
        int result = jump(0, nums, processed) - 1;
        return max(0, result);
    }

private:
    static int jump(int position, vector<int> &nums, vector<int> &processed) {
        assert (0 <= nums[position]);
        assert (nums[position] <= pow(10, 5));
        if (position == nums.size() - 1) {
            return 1;
        }
        if (processed[position] >= 0) {
            return processed[position];
        }
        int jumps = INT_MAX;
        for (int i = nums[position]; 0 < i; i--) {
            if ((nums.size() - 1 >= position + i)) {
                int value = jump(position + i, nums, processed);
                if ((value > 0) && (value < jumps)) {
                    jumps = value;
                }
            }
        }
        if ((-1 < jumps) && (jumps < INT_MAX)) {
            processed[position] = jumps + 1;
        } else {
            processed[position] = 0;
        }
        return processed[position];
    }
};

#pragma clang diagnostic pop