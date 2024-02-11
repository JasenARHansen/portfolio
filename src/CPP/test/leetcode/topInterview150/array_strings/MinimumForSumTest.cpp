#ifndef LEETCODE_TOP_INTERVIEW_150_MINIMUM_SIZE_SUBARRAY_SUM_TEST
#define LEETCODE_TOP_INTERVIEW_150_MINIMUM_SIZE_SUBARRAY_SUM_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/array_strings/MinimumForSum.cpp"  // NOLINT : Ignore .cpp import

TEST(LeetCode_MinimumForSumTest, description) {
    testing::internal::CaptureStdout();
    MinimumForSum::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LeetCode_MinimumForSumTest, minForSum_1) {
    auto expected = 2;
    auto target = 7;
    vector<int> nums{2, 3, 1, 2, 4, 3};
    auto result = MinimumForSum::minForSum(target, nums);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_MinimumForSumTest, minForSum_2) {
    auto expected = 1;
    auto target = 4;
    vector<int> nums{1, 4, 4};
    auto result = MinimumForSum::minForSum(target, nums);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_MinimumForSumTest, minForSum_3) {
    auto expected = 0;
    auto target = 11;
    vector<int> nums{1, 1, 1, 1, 1, 1, 1, 1};
    auto result = MinimumForSum::minForSum(target, nums);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_MinimumForSumTest, minForSum_4) {
    auto expected = 5;
    auto target = 15;
    vector<int> nums{1, 2, 3, 4, 5};
    auto result = MinimumForSum::minForSum(target, nums);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_MinimumForSumTest, minForSum_5) {
    auto expected = 7;
    auto target = 213;
    vector<int> nums{12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12};
    auto result = MinimumForSum::minForSum(target, nums);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_MinimumForSumTest, minForSum_fail_1) {
    // 1 ≤ target
    auto target = 1 - 1;
    vector<int> nums{2, 3, 1, 2, 4, 3};
    EXPECT_EXIT(MinimumForSum::minForSum(target, nums), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_MinimumForSumTest, minForSum_fail_2) {
    // target ≤ 10^9
    auto target = (int) pow(10, 9) + 1;
    vector<int> nums{2, 3, 1, 2, 4, 3};
    EXPECT_EXIT(MinimumForSum::minForSum(target, nums), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_MinimumForSumTest, minForSum_fail_3) {
    // 1 ≤ nums.length
    auto target = 7;
    auto size = 1 - 1;
    vector<int> nums(size);
    EXPECT_EXIT(MinimumForSum::minForSum(target, nums), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_MinimumForSumTest, minForSum_fail_4) {
    // nums.length ≤ 10^5
    auto target = 7;
    auto size = (int) pow(10, 5) + 1;
    vector<int> nums(size);
    EXPECT_EXIT(MinimumForSum::minForSum(target, nums), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_MinimumForSumTest, minForSum_fail_5) {
    // 1 ≤ nums[i]
    auto target = 7;
    auto size = 1 - 1;
    vector<int> nums{2, 3, size, 2, 4, 3};
    EXPECT_EXIT(MinimumForSum::minForSum(target, nums), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_MinimumForSumTest, minForSum_fail_6) {
    // nums[i] ≤ 10^4
    auto target = 7;
    auto size = (int) pow(10, 4) + 1;
    vector<int> nums{2, 3, size, 2, 4, 3};
    EXPECT_EXIT(MinimumForSum::minForSum(target, nums), ::testing::ExitedWithCode(3), "");
}

#endif