#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <vector>
#include <iostream>
#include <cassert>
#include <cmath>
#include <list>

using namespace std;

class JumpGameII {
public:

    static void description() {
        cout << R"(55. Jump Game
    You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
    Return true if you can reach the last index, or false otherwise.

    Example 1:
        Input: nums = [2,3,1,1,4]
        Output: true
        Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

    Example 2:
        Input: nums = [3,2,1,0,4]
        Output: false
        Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

    Constraints:
        1 <= nums.length <= 10^4
        0 <= nums[i] <= 10^5)" << endl;
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
        if ((-1 < jumps) && (jumps < INT_MAX)){
            processed[position] = jumps + 1;
        }
        else {
            processed[position] = 0;
        }
        return processed[position];
    }
};

#pragma clang diagnostic pop