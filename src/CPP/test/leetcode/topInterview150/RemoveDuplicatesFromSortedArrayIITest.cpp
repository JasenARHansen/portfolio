#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"

#ifndef LEETCODE_TOP_INTERVIEW_150_REMOVE_DUPLICATES_FROM_SORTED_ARRAY_II_TEST
#define LEETCODE_TOP_INTERVIEW_150_REMOVE_DUPLICATES_FROM_SORTED_ARRAY_II_TEST

#include "gtest/gtest.h"
#include "../../../code/leetcode/topInterview150/RemoveDuplicatesFromSortedArrayII.cpp"

TEST(RemoveDuplicatesFromSortedArrayIITest, description) {
    testing::internal::CaptureStdout();
    RemoveDuplicatesFromSortedArrayII::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(RemoveDuplicatesFromSortedArrayIITest, removeDuplicates_1) {
    vector<int> expected{1, 1, 2, 2, 3, 0};
    int expectedCount = 5;
    vector<int> nums{1, 1, 1, 2, 2, 3};
    int result = RemoveDuplicatesFromSortedArrayII::removeDuplicates(nums);
    EXPECT_EQ(expectedCount, result);
    for (int i = 0; i < expected.size(); i++) {
        EXPECT_EQ(expected[i], nums[i]);
    }
}

TEST(RemoveDuplicatesFromSortedArrayIITest, removeDuplicates_2) {
    vector<int> expected{0, 0, 1, 1, 2, 3, 3, 0, 0};
    int expectedCount = 7;
    vector<int> nums{0, 0, 1, 1, 1, 1, 2, 3, 3};
    int result = RemoveDuplicatesFromSortedArrayII::removeDuplicates(nums);
    EXPECT_EQ(expectedCount, result);
    for (int i = 0; i < expected.size(); i++) {
        EXPECT_EQ(expected[i], nums[i]);
    }
}

TEST(RemoveDuplicatesFromSortedArrayIITest, removeDuplicates_fail_1) {
    // 1 <= nums.length
    int size = 0;
    vector<int> nums(size);
    EXPECT_EXIT(RemoveDuplicatesFromSortedArrayII::removeDuplicates(nums), ::testing::ExitedWithCode(3), "");
}

TEST(RemoveDuplicatesFromSortedArrayIITest, removeDuplicates_fail_2) {
    // nums.length <= 3 * 104
    int size = 3 * pow(10, 4) + 1;
    vector<int> nums(size);
    EXPECT_EXIT(RemoveDuplicatesFromSortedArrayII::removeDuplicates(nums), ::testing::ExitedWithCode(3), "");
}

TEST(RemoveDuplicatesFromSortedArrayIITest, removeDuplicates_fail_3) {
    // -10^4 <= nums[i]
    int value = -(pow(10, 4) + 1);
    vector<int> nums{value};
    EXPECT_EXIT(RemoveDuplicatesFromSortedArrayII::removeDuplicates(nums), ::testing::ExitedWithCode(3), "");
}

TEST(RemoveDuplicatesFromSortedArrayIITest, removeDuplicates_fail_4) {
    // nums[i] <= 10^4
    int value = pow(10, 4) + 1;
    vector<int> nums{value};
    EXPECT_EXIT(RemoveDuplicatesFromSortedArrayII::removeDuplicates(nums), ::testing::ExitedWithCode(3), "");
}

TEST(RemoveDuplicatesFromSortedArrayIITest, removeDuplicates_fail_5) {
    // nums[i] <= 10^4
    int value = pow(10, 4) + 1;
    vector<int> nums{1, value};
    EXPECT_EXIT(RemoveDuplicatesFromSortedArrayII::removeDuplicates(nums), ::testing::ExitedWithCode(3), "");
}

TEST(RemoveDuplicatesFromSortedArrayIITest, removeDuplicates_fail_6) {
    // nums is sorted in non-decreasing order
    vector<int> nums{0, 0, 1, 1, 3, 2, 2, 3, 3, 4};
    EXPECT_EXIT(RemoveDuplicatesFromSortedArrayII::removeDuplicates(nums), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop