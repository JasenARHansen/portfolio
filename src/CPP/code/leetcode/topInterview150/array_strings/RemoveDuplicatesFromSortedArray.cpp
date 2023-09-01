#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <vector>
#include <set>
#include <iostream>
#include <cassert>
#include <cmath>

using namespace std;

class RemoveDuplicatesFromSortedArray {
public:

    static void description() {
        cout << R"(26. Remove Duplicates from Sorted Array
    Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
    Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
        Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
        Return k.

    Custom Judge:
        The judge will test your solution with the following code:
            int[] nums = [...]; // Input array
            int[] expectedNums = [...]; // The expected answer with correct length
            int k = removeDuplicates(nums); // Calls your implementation
            assert k == expectedNums.length;
            for (int i = 0; i < k; i++) {
                assert nums[i] == expectedNums[i];
            }
        If all assertions pass, then your solution will be accepted.

    Example 1:
        Input: nums = [1,1,2]
        Output: 2, nums = [1,2,_]
        Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
        It does not matter what you leave beyond the returned k (hence they are underscores).

    Example 2:
        Input: nums = [0,0,1,1,1,2,2,3,3,4]
        Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
        Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
        It does not matter what you leave beyond the returned k (hence they are underscores).

    Constraints:
        1 <= nums.length <= 3 * 10^4
        -100 <= nums[i] <= 100
        nums is sorted in non-decreasing order.)" << endl;
    }

    static int removeDuplicates(vector<int> &nums) {
        assert (!nums.empty());
        assert (nums.size() <= 3 * pow(10, 4));
        set<int> test_set;
        int returnCount = 0;
        int writeIndex = 0;
        bool previous = false;
        // add assert for non-decreasing order
        for (int index = 0; index < nums.size(); index++) {
            assert (-100 <= nums[index]);
            assert (nums[index] <= 100);
            if (!test_set.count(nums[index])) {
                test_set.insert(nums[index]);
                returnCount++;
                if (previous) {
                    assert(nums[writeIndex - 1] <= nums[index]);
                }
                previous = true;
                nums[writeIndex++] = nums[index];
            }
        }
        // I do not like dead data so I am setting the excess to zero
        for (int index = writeIndex; index < nums.size(); index++) {
            nums[index] = 0;
        }
        return returnCount;
    }
};

#pragma clang diagnostic pop