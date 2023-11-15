#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <vector>
#include <unordered_map>
#include <set>
#include <cmath>

using namespace std;

class MinimumForSum {
public:
    static void description() {
        cout << R"(XXX. Minimum for Sum:
    Note:  This was not a LeetCode challenge, rather it was a misunderstanding of a different challenge that I liked the answer for.
    Given an array of positive integers nums and a positive integer target, return the minimum number of elements whose sum is greater than or equal to target. If there is possible combination, return 0 instead.

    Example 1:
        Input: target = 7, nums = [2, 3, 1, 2, 4, 3]
        Output: 2
        Explanation:
            The 4 + 3 has the minimal number of values that is over teh target.

    Example 2:
        Input: target = 4, nums = [1, 4, 4]
        Output: 1

    Example 3:
        Input: target = 11, nums = [1, 1, 1, 1, 1, 1, 1, 1]
        Output: 0

    Constraints:
        1 ≤ target ≤ 10^9
        1 ≤ nums.length ≤ 10^5
        1 ≤ nums[i] ≤ 10^4)" << endl;
    }

    static int minForSum(int target, vector<int> &nums) {
        assert (1 <= target);
        assert (target <= pow(10, 9));
        assert (!nums.empty());
        assert (nums.size() <= pow(10, 4));
        auto result = 0;
        auto sum = 0;
        unordered_map<int, int> test_map;
        // make a map to group the numbers
        for (auto num: nums) {
            assert (1 <= num);
            assert (num <= pow(10, 4));
            if (!test_map.count(num)) {
                test_map[num] = 0;
            }
            test_map[num]++;
        }
        // Creat a set to find unique values in order of least to greatest
        set<int> keys;
        for (auto const &imap: test_map) {
            keys.insert(imap.first);
        }
        // convert to vector for easy access by index
        vector<int> values(keys.size());
        copy(keys.begin(), keys.end(), values.begin());
        // using ordered data, find answer
        for (int index = (int) values.size() - 1; index >= 0; index--) {
            while (test_map[values[index]] > 0) {
                sum += values[index];
                test_map[values[index]]--;
                result++;
                if (sum >= target) {
                    return result;
                }
            }
        }
        return 0;
    }
};

#pragma clang diagnostic pop