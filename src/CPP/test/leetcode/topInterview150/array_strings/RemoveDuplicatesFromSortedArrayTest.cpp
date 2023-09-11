#ifndef LEETCODE_TOP_INTERVIEW_150_REMOVE_DUPLICATES_FROM_SORTED_ARRAY_TEST
#define LEETCODE_TOP_INTERVIEW_150_REMOVE_DUPLICATES_FROM_SORTED_ARRAY_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/array_strings/RemoveDuplicatesFromSortedArray.cpp"

TEST(RemoveDuplicatesFromSortedArrayTest, description) {
    testing::internal::CaptureStdout();
    RemoveDuplicatesFromSortedArray::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(RemoveDuplicatesFromSortedArrayTest, removeDuplicates_1) {
    vector<int> expected{1, 2, 0};
    auto expectedCount = 2;
    vector<int> nums{1, 1, 2};
    auto result = RemoveDuplicatesFromSortedArray::removeDuplicates(nums);
    EXPECT_EQ(expectedCount, result);
    for (auto i = 0; i < expected.size(); i++) {
        EXPECT_EQ(expected[i], nums[i]);
    }
}

TEST(RemoveDuplicatesFromSortedArrayTest, removeDuplicates_2) {
    vector<int> expected{0, 1, 2, 3, 4, 0, 0, 0, 0, 0};
    auto expectedCount = 5;
    vector<int> nums{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    auto result = RemoveDuplicatesFromSortedArray::removeDuplicates(nums);
    EXPECT_EQ(expectedCount, result);
    for (auto i = 0; i < expected.size(); i++) {
        EXPECT_EQ(expected[i], nums[i]);
    }
}

TEST(RemoveDuplicatesFromSortedArrayTest, removeDuplicates_fail_1) {
    // 1 ≤ nums.length
    auto size = 0;
    vector<int> nums(size);
    EXPECT_EXIT(RemoveDuplicatesFromSortedArray::removeDuplicates(nums), ::testing::ExitedWithCode(3), "");
}

TEST(RemoveDuplicatesFromSortedArrayTest, removeDuplicates_fail_2) {
    // nums.length ≤ 3 * 10^4
    auto size = 3 * (int) pow(10, 4) + 1;
    vector<int> nums(size);
    EXPECT_EXIT(RemoveDuplicatesFromSortedArray::removeDuplicates(nums), ::testing::ExitedWithCode(3), "");
}

TEST(RemoveDuplicatesFromSortedArrayTest, removeDuplicates_fail_3) {
    // -100 ≤ nums[i]
    vector<int> nums{-101};
    EXPECT_EXIT(RemoveDuplicatesFromSortedArray::removeDuplicates(nums), ::testing::ExitedWithCode(3), "");
}

TEST(RemoveDuplicatesFromSortedArrayTest, removeDuplicates_fail_4) {
    // nums[i] ≤ 100
    vector<int> nums{101};
    EXPECT_EXIT(RemoveDuplicatesFromSortedArray::removeDuplicates(nums), ::testing::ExitedWithCode(3), "");
}

TEST(RemoveDuplicatesFromSortedArrayTest, removeDuplicates_fail_5) {
    // nums[i] ≤ 100
    vector<int> nums{1, 101};
    EXPECT_EXIT(RemoveDuplicatesFromSortedArray::removeDuplicates(nums), ::testing::ExitedWithCode(3), "");
}

TEST(RemoveDuplicatesFromSortedArrayTest, removeDuplicates_fail_6) {
    // nums is sorted in non-decreasing order
    vector<int> nums{0, 0, 1, 1, 3, 2, 2, 3, 3, 4};
    EXPECT_EXIT(RemoveDuplicatesFromSortedArray::removeDuplicates(nums), ::testing::ExitedWithCode(3), "");
}

#endif