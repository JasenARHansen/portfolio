#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <unordered_map>
#include <cmath>
#include <vector>
#include <algorithm>

using namespace std;

class TwoSum {
public:
    static void description() {
        cout << R"(1. Two Sum
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.

    Example 1:
        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Explanation:
            Because nums[0] + nums[1] == 9, we return [0, 1].

    Example 2:
        Input: nums = [3,2,4], target = 6
        Output: [1,2]

    Example 3:
        Input: nums = [3,3], target = 6
        Output: [0,1]

    Constraints:
        2 ≤ nums.length ≤ 10^4
        -10^9 ≤ nums[i] ≤ 10^9
        -10^9 ≤ target ≤ 10^9
        Only one valid answer exists.
    Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?)" << endl;
    }

    static vector<int> twoSum(vector<int> &nums, int target) {
        assert (2 <= nums.size());
        assert (nums.size() <= pow(10, 4));
        assert (-pow(10, 9) <= target);
        assert (target <= pow(10, 9));
        vector<int> result;
        unordered_map<int, vector<int>> nums_map;
        for (auto index = 0; index < nums.size(); index++) {
            assert(-pow(10, 9) <= nums[index]);
            assert(nums[index] <= pow(10, 9));
            if (!nums_map.count(nums[index])) {
                nums_map[nums[index]] = vector<int>();
            }
            nums_map.at(nums[index]).push_back(index);
        }
        for (auto &myPair: nums_map) {
            auto value = target - myPair.first;
            if (nums_map.count(value)) {
                if ((value == myPair.first) && (myPair.second.size() > 1)) {
                    result.push_back(myPair.second[0]);
                    result.push_back(myPair.second[1]);
                    break;
                } else if (value != myPair.first) {
                    result.push_back(myPair.second[0]);
                    result.push_back(nums_map.at(value)[0]);
                    break;
                }
            }
        }
        sort(result.begin(), result.end(), [](int a, int b) { return a < b; });
        return result;
    }
};

#pragma clang diagnostic pop