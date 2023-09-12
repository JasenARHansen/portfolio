#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <cmath>
#include <vector>
#include <unordered_set>

using namespace std;

class TwoSumII {

public:

    static void description() {
        cout << R"(167. Two Sum II - Input Array Is Sorted
    Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 ≤ index1 < index2 ≤ numbers.length.
    Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
    The tests are generated such that there is exactly one solution. You may not use the same element twice.
    Your solution must use only constant extra space.

    Example 1:
        Input: numbers = [2,7,11,15], target = 9
        Output: [1,2]
        Explanation:
            The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

    Example 2:
        Input: numbers = [2,3,4], target = 6
        Output: [1,3]
        Explanation:
            The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

    Example 3:
        Input: numbers = [-1,0], target = -1
        Output: [1,2]
        Explanation:
            The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].

    Constraints:
        2 ≤ numbers.length ≤ 3 * 10^4
        -1000 ≤ numbers[i] ≤ 1000
        numbers is sorted in non-decreasing order.
        -1000 ≤ target ≤ 1000
        The tests are generated such that there is exactly one solution.)" << endl;
    }

    static vector<int> twoSum(vector<int> &numbers, int target) {
        assert (2 <= numbers.size());
        assert (numbers.size() <= 3 * pow(10, 4));
        assert (-1000 <= target);
        assert (target <= 1000);
        vector<int> result;
        unordered_set<int> tested;
        for (auto index1 = 0; index1 < numbers.size() - 1; index1++) {
            assert (-1000 <= numbers[index1]);
            assert (numbers[index1] <= 1000);
            if (!tested.count(numbers[index1])) {
                tested.insert(numbers[index1]);
                for (auto index2 = index1 + 1; index2 < numbers.size(); index2++) {
                    if (numbers[index1] + numbers[index2] == target) {
                        result.push_back(index1 + 1);
                        result.push_back(index2 + 1);
                    }
                }

            }
        }
        return result;
    }
};

#pragma clang diagnostic pop