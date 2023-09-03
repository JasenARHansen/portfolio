#pragma clang diagnostic push
#pragma ide diagnostic ignored "bugprone-branch-clone"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <vector>
#include <unordered_map>
#include <set>

using namespace std;

class ThreeSum {

public:

    static void description() {
        cout << R"(15. 3Sum
    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
    Notice that the solution set must not contain duplicate triplets.

    Example 1:
        Input: nums = [-1,0,1,2,-1,-4]
        Output: [[-1,-1,2],[-1,0,1]]
        Explanation:
            nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
            nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
            nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
            The distinct triplets are [-1,0,1] and [-1,-1,2].
            Notice that the order of the output and the order of the triplets does not matter.

    Example 2:
        Input: nums = [0,1,1]
        Output: []
        Explanation:
            The only possible triplet does not sum up to 0.

    Example 3:
        Input: nums = [0,0,0]
        Output: [[0,0,0]]
        Explanation:
            The only possible triplet sums up to 0.

    Constraints:
        3 <= nums.length <= 3000
        -10^5 <= nums[i] <= 10^5)" << endl;
    }

    static vector<vector<int>> threeSum(vector<int> &nums) {
        assert (3 <= nums.size());
        assert (nums.size() <= 3000);
        vector<vector<int>> result;
        unordered_map<int, vector<int>> test_map;
        for (auto index = 0; index < nums.size(); index++) {
            if (!test_map.count(nums[index])) {
                vector<int> inner;
                test_map[nums[index]] = inner;
            }
            test_map[nums[index]].push_back(index);
        }
        // Creat a set to find unique values in order of least to greatest
        set<int> keys;
        for (auto const &imap: test_map) {
            keys.insert(imap.first);
        }
        // convert to vector for easy access by index
        vector<int> values(keys.size());
        copy(keys.begin(), keys.end(), values.begin());
        // Find 3 values
        int first;
        int second;
        int third;
        // edge case of 3 0's
        if ((3 <= test_map[0].size())) {
            result.push_back({0, 0, 0});
        }
        // generate solutions in ascending order
        for (auto index1 = 0; index1 < keys.size() - 1; index1++) {
            first = values[index1];
            // generate solutions based on double first value
            if (2 <= test_map[first].size()) {
                second = first;
                third = -(first + second);
                if ((first < third) && (keys.find(third) != keys.end())) {
                    // first solution with double first values
                    result.push_back({first, second, third});
                }
            }
            // generate solutions based on second value
            for (auto index2 = index1 + 1; index2 < keys.size(); index2++) {
                second = values[index2];
                third = -(first + second);
                if (keys.find(second) != keys.end()) {
                    if ((second == third) && (2 <= test_map[second].size())) {
                        // generate solutions based on double second value
                        result.push_back({first, second, third});
                    } else if ((second < third) && (keys.find(third) != keys.end())) {
                        // generate solutions based on 3 unique values
                        result.push_back({first, second, third});
                    }
                }
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop