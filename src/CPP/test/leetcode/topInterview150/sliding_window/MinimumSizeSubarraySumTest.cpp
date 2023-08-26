#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_MINIMUM_SIZE_SUBARRAY_SUM_TEST
#define LEETCODE_TOP_INTERVIEW_150_MINIMUM_SIZE_SUBARRAY_SUM_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/sliding_window/MinimumSizeSubarraySum.cpp"

TEST(MinimumSizeSubarraySumTest, description) {
    testing::internal::CaptureStdout();
    MinimumSizeSubarraySum::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(MinimumSizeSubarraySumTest, minSubArrayLen_1) {
    int expected = 2;
    int target = 7;
    vector<int> nums{2, 3, 1, 2, 4, 3};
    int result = MinimumSizeSubarraySum::minSubArrayLen(target, nums);
    EXPECT_EQ(expected, result);
}

TEST(MinimumSizeSubarraySumTest, minSubArrayLen_2) {
    int expected = 1;
    int target = 4;
    vector<int> nums{1, 4, 4};
    int result = MinimumSizeSubarraySum::minSubArrayLen(target, nums);
    EXPECT_EQ(expected, result);
}

TEST(MinimumSizeSubarraySumTest, minSubArrayLen_3) {
    int expected = 0;
    int target = 11;
    vector<int> nums{1, 1, 1, 1, 1, 1, 1, 1};
    int result = MinimumSizeSubarraySum::minSubArrayLen(target, nums);
    EXPECT_EQ(expected, result);
}

TEST(MinimumSizeSubarraySumTest, minSubArrayLen_4) {
    int expected = 5;
    int target = 15;
    vector<int> nums{1, 2, 3, 4, 5};
    int result = MinimumSizeSubarraySum::minSubArrayLen(target, nums);
    EXPECT_EQ(expected, result);
}

TEST(MinimumSizeSubarraySumTest, minSubArrayLen_5) {
    int expected = 8;
    int target = 213;
    vector<int> nums{12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12};
    int result = MinimumSizeSubarraySum::minSubArrayLen(target, nums);
    EXPECT_EQ(expected, result);
}

TEST(MinimumSizeSubarraySumTest, minSubArrayLen_6) {
    int expected = 3;
    int target = 11;
    vector<int> nums{1, 2, 3, 4, 5};
    int result = MinimumSizeSubarraySum::minSubArrayLen(target, nums);
    EXPECT_EQ(expected, result);
}

TEST(MinimumSizeSubarraySumTest, minSubArrayLen_fail_1) {
    // 1 <= target
    int target = 1 - 1;
    vector<int> nums{2, 3, 1, 2, 4, 3};
    EXPECT_EXIT(MinimumSizeSubarraySum::minSubArrayLen(target, nums), ::testing::ExitedWithCode(3), "");
}

TEST(MinimumSizeSubarraySumTest, minSubArrayLen_fail_2) {
    // target <= 10^9
    int target = pow(10, 9) + 1;
    vector<int> nums{2, 3, 1, 2, 4, 3};
    EXPECT_EXIT(MinimumSizeSubarraySum::minSubArrayLen(target, nums), ::testing::ExitedWithCode(3), "");
}

TEST(MinimumSizeSubarraySumTest, minSubArrayLen_fail_3) {
    // 1 <= nums.length
    int target = 7;
    int size = 1 - 1;
    vector<int> nums(size);
    EXPECT_EXIT(MinimumSizeSubarraySum::minSubArrayLen(target, nums), ::testing::ExitedWithCode(3), "");
}

TEST(MinimumSizeSubarraySumTest, minSubArrayLen_fail_4) {
    // nums.length <= 10^5
    int target = 7;
    int size = pow(10, 5) + 1;
    vector<int> nums(size);
    EXPECT_EXIT(MinimumSizeSubarraySum::minSubArrayLen(target, nums), ::testing::ExitedWithCode(3), "");
}

TEST(MinimumSizeSubarraySumTest, minSubArrayLen_fail_5) {
    // 1 <= nums[i]
    int target = 7;
    int size = 1 - 1;
    vector<int> nums{2, 3, size, 2, 4, 3};
    EXPECT_EXIT(MinimumSizeSubarraySum::minSubArrayLen(target, nums), ::testing::ExitedWithCode(3), "");
}

TEST(MinimumSizeSubarraySumTest, minSubArrayLen_fail_6) {
    // nums[i] <= 10^4
    int target = 7;
    int size = pow(10, 4) + 1;
    vector<int> nums{2, 3, size, 2, 4, 3};
    EXPECT_EXIT(MinimumSizeSubarraySum::minSubArrayLen(target, nums), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop