#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <vector>
#include <unordered_map>
#include <iostream>
#include <cassert>
#include <cmath>

using namespace std;

class MajorityElement {

public:

    static void description() {
        cout << R"(169. Majority Element
    Given an array nums of size n, return the majority element.
    The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

    Example 1:
        Input: nums = [3,2,3]
        Output: 3

    Example 2:
        Input: nums = [2,2,1,1,1,2,2]
        Output: 2

    Constraints:
        n == nums.length
        1 ≤ n ≤ 5 * 10^4
        -10^9 ≤ nums[i] ≤ 10^9)" << endl;
    }

    static int majorityElement(vector<int> &nums) {
        assert (!nums.empty());
        assert (nums.size() <= 5 * pow(10, 4));
        unordered_map<int, int> test_map;
        // populate map to count occurrences of each value
        for (auto num: nums) {
            assert (-pow(10, 9) <= num);
            assert (num <= pow(10, 9));
            if (!test_map.count(num)) {
                test_map[num] = 0;
            }
            test_map[num]++;
        }
        int key;
        auto count = 0;
        for (auto it = test_map.begin(); it != test_map.end(); it++) {
            if (test_map[it->first] > count) {
                key = it->first;
                count = it->second;
            }
        }
        assert (count >= nums.size() / 2);
        return key;
    }
};

#pragma clang diagnostic pop