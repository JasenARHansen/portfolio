#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <cassert>
#include <cmath>
#include <set>

using namespace std;

class SingleNumberII {
public:
    static void description() {
        cout << R"(137. Single Number II
    Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
    You must implement a solution with a linear runtime complexity and use only constant extra space.

    Example 1:
        Input: nums = [2,2,3,2]
        Output: 3

    Example 2:
        Input: nums = [0,1,0,1,0,1,99]
        Output: 99

    Constraints:
        1 ≤ nums.length ≤ 3 * 10^4
        -2^31 ≤ nums[i] ≤ 2^31 - 1
        Each element in nums appears exactly three times except for one element which appears once.

    Note: I am using a number trick that takes advantage of math.
        1. Iterate over the inputs and generate a sum
        2. While iterating, generate a list of all unique numbers
        3. use formula: (3 * (sum of uniques) - (sum of values)) / 2 = dingle entry)" << endl;
    }

    static int singleNumber(vector<int> &nums) {
        assert (!nums.empty());
        assert (nums.size() <= 3 * pow(10, 4));
        set<int> uniques;
        long int numbersSum = 0;
        long int uniquesSum = 0;
        for (auto number: nums) {
            uniques.insert(number);
            numbersSum += number;
        }
        for (auto number: uniques) {
            uniquesSum += number;
        }
        return (3 * uniquesSum - numbersSum) / 2;
    }
};

#pragma clang diagnostic pop