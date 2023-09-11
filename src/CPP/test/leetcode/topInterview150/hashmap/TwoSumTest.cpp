#ifndef LEETCODE_TOP_INTERVIEW_150_TWO_SUM_TEST
#define LEETCODE_TOP_INTERVIEW_150_TWO_SUM_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/hashmap/TwoSum.cpp"

TEST(TwoSumTest, description) {
    testing::internal::CaptureStdout();
    TwoSum::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(TwoSumTest, twoSum_1) {
    vector<int> expected{0, 1};
    vector<int> nums{2, 7, 11, 15};
    auto target = 9;
    auto result = TwoSum::twoSum(nums, target);
    EXPECT_EQ(expected, result);
}

TEST(TwoSumTest, twoSum_2) {
    vector<int> expected{1, 2};
    vector<int> nums{3, 2, 4};
    auto target = 6;
    auto result = TwoSum::twoSum(nums, target);
    EXPECT_EQ(expected, result);
}

TEST(TwoSumTest, twoSum_3) {
    vector<int> expected{0, 1};
    vector<int> nums{3, 3};
    auto target = 6;
    auto result = TwoSum::twoSum(nums, target);
    EXPECT_EQ(expected, result);
}

TEST(TwoSumTest, twoSum_fail_1) {
    // 2 ≤ nums.length
    auto size = 2 - 1;
    vector<int> nums(size);
    auto target = 9;
    EXPECT_EXIT(TwoSum::twoSum(nums, target), ::testing::ExitedWithCode(3), "");
}

TEST(TwoSumTest, twoSum_fail_2) {
    // nums.length ≤ 10^4
    auto size = (int) pow(10, 4) + 1;
    vector<int> nums(size);
    auto target = 9;
    EXPECT_EXIT(TwoSum::twoSum(nums, target), ::testing::ExitedWithCode(3), "");
}

TEST(TwoSumTest, twoSum_fail_3) {
    // -10^9 ≤ nums[i]
    auto size = (int) -pow(10, 9) - 1;
    vector<int> nums{2, size};
    auto target = 9;
    EXPECT_EXIT(TwoSum::twoSum(nums, target), ::testing::ExitedWithCode(3), "");
}

TEST(TwoSumTest, twoSum_fail_4) {
    // nums[i] ≤ 10^9
    auto size = (int) pow(10, 9) + 1;
    vector<int> nums{2, size};
    auto target = 9;
    EXPECT_EXIT(TwoSum::twoSum(nums, target), ::testing::ExitedWithCode(3), "");
}

TEST(TwoSumTest, twoSum_fail_5) {
    // -10^9 ≤ target
    vector<int> nums{2, 7, 11, 15};
    auto target = (int) -pow(10, 9) - 1;
    EXPECT_EXIT(TwoSum::twoSum(nums, target), ::testing::ExitedWithCode(3), "");
}

TEST(TwoSumTest, twoSum_fail_6) {
    // target ≤ 10^9
    vector<int> nums{2, 7, 11, 15};
    auto target = (int) pow(10, 9) + 1;
    EXPECT_EXIT(TwoSum::twoSum(nums, target), ::testing::ExitedWithCode(3), "");
}

#endif