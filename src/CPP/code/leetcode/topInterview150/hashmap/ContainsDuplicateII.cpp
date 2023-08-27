#pragma clang diagnostic push
#pragma ide diagnostic ignored "bugprone-branch-clone"
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <unordered_map>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

class ContainsDuplicateII {
public:

    static void description() {
        cout << R"(219. Contains Duplicate II
    Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

    Example 1:
        Input: nums = [1,2,3,1], k = 3
        Output: true

    Example 2:
        Input: nums = [1,0,1,1], k = 1
        Output: true

    Example 3:
        Input: nums = [1,2,3,1,2,3], k = 2
        Output: false

    Constraints:
        1 <= nums.length <= 10^5
        -10^9 <= nums[i] <= 10^9
        0 <= k <= 10^5)" << endl;
    }

    static bool containsNearbyDuplicate(vector<int>& nums, int k)  {
        assert (!nums.empty());
        assert (nums.size() <= pow(10,5));
        assert (0 <= k);
        assert (k <= pow(10,5));
        unordered_map<int, int> used;
        vector<int> digits;
        for (int index = 0; index< nums.size(); index++) {
            assert (-pow(10,9) <= nums[index]);
            assert ( nums[index] <= pow(10,9));
            if (used.count( nums[index])) {
                if ((index - used.at(nums[index])) <= k){
                    return true;
                }
            }
            used[ nums[index]] = index;
        }
        return false;
    }
};

#pragma clang diagnostic pop