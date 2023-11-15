#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <set>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

class LongestConsecutiveSequence {
public:
    static void description() {
        cout << R"(128. Longest Consecutive Sequence
    Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
    You must write an algorithm that runs in O(n) time.

    Example 1:
        Input: nums = [100, 4, 200, 1, 3, 2]
        Output: 4
        Explanation:
            The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

    Example 2:
        Input: nums = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
        Output: 9

    Constraints:
        0 ≤ nums.length ≤ 10^5
        -10^9 ≤ nums[i] ≤ 10^9)" << endl;
    }

    static int longestConsecutive(vector<int> &nums) {
        assert (nums.size() <= pow(10, 5));
        if (nums.empty()) {
            return 0;
        }
        set<int> used;
        auto result = 1;
        for (auto num: nums) {
            assert (-pow(10, 9) <= num);
            assert (num <= pow(10, 9));
            used.insert(num);
        }
        vector<int> uniques(used.size());
        copy(used.begin(), used.end(), uniques.begin());
        auto local = 1;
        for (auto index = 0; index < uniques.size() - 1; index++) {
            if (uniques[index] + 1 == uniques[index + 1]) {
                local++;
            } else {
                result = max(result, local);
                local = 1;
            }
        }
        return max(result, local);
    }
};

#pragma clang diagnostic pop