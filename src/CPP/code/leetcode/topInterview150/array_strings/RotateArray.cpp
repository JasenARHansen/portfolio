#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <vector>
#include <iostream>
#include <cassert>
#include <cmath>

using namespace std;

class RotateArray {
public:
    static void description() {
        cout << R"(189. Rotate Array
    Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

    Example 1:
        Input: nums = [1, 2, 3, 4, 5, 6, 7], k = 3
        Output: [5, 6, 7, 1, 2, 3, 4]
        Explanation:
            rotate 1 steps to the right: [7, 1, 2, 3, 4, 5, 6]
            rotate 2 steps to the right: [6, 7, 1, 2, 3, 4, 5]
            rotate 3 steps to the right: [5, 6, 7, 1, 2, 3, 4]

    Example 2:
        Input: nums = [-1, -100, 3, 99], k = 2
        Output: [3, 99, -1, -100]
        Explanation:
            rotate 1 steps to the right: [99, -1, -100, 3]
            rotate 2 steps to the right: [3, 99, -1, -100]

    Constraints:
        1 ≤ nums.length ≤ 10^5
        -2^31 ≤ nums[i] ≤ 2^31 - 1
        0 ≤ k ≤ 10^5)" << endl;
    }

    static void rotate(vector<int> &nums, int k) {
        assert (!nums.empty());
        assert (nums.size() <= pow(10, 5));
        assert (0 <= k);
        assert (k <= pow(10, 5));
        auto offset = k % nums.size();
        vector<bool> read(nums.size(), false);
        int current;
        int next;
        int lastIndex;
        int nextIndex;
        for (auto i = 0; i < nums.size(); i++) {
            if (!read[i]) {
                lastIndex = i;
                current = nums[lastIndex];
                nextIndex = (int) ((lastIndex + offset) % nums.size());
                read[lastIndex] = true;
                while (!read[nextIndex]) {
                    read[nextIndex] = true;
                    next = nums[nextIndex];
                    nums[nextIndex] = current;
                    lastIndex = nextIndex;
                    current = next;
                    nextIndex = (int) ((lastIndex + offset) % nums.size());
                }
                nums[nextIndex] = current;
            }
        }
    }
};

#pragma clang diagnostic pop