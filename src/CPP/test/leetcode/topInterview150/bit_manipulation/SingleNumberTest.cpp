#ifndef LEETCODE_TOP_INTERVIEW_150_SINGLE_NUMBER_TEST
#define LEETCODE_TOP_INTERVIEW_150_SINGLE_NUMBER_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/bit_manipulation/SingleNumber.cpp"  // NOLINT : Ignore .cpp import

TEST(LeetCode_SingleNumberTest, description) {
    testing::internal::CaptureStdout();
    SingleNumber::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LeetCode_SingleNumberTest, singleNumber_1) {
    auto expected = 1;
    vector<int> nums{2, 2, 1};
    auto result = SingleNumber::singleNumber(nums);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_SingleNumberTest, singleNumber_2) {
    auto expected = 4;
    vector<int> nums{4, 1, 2, 1, 2};
    auto result = SingleNumber::singleNumber(nums);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_SingleNumberTest, singleNumber_3) {
    auto expected = 1;
    vector<int> nums{1};
    auto result = SingleNumber::singleNumber(nums);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_SingleNumberTest, addBinary_fail_1) {
    // 1 ≤ nums.length
    auto size = 1 - 1;
    vector<int> nums(size);
    EXPECT_EXIT(SingleNumber::singleNumber(nums), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_SingleNumberTest, addBinary_fail_2) {
    // nums.length ≤ 3 * 10^4
    auto size = 3 * (int) pow(10, 4) + 1;
    vector<int> nums(size);
    EXPECT_EXIT(SingleNumber::singleNumber(nums), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_SingleNumberTest, addBinary_fail_3) {
    // -3 * 10^4 ≤ nums[i]
    auto size = -3 * (int) pow(10, 4) - 1;
    vector<int> nums{size};
    EXPECT_EXIT(SingleNumber::singleNumber(nums), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_SingleNumberTest, addBinary_fail_4) {
    // nums[i] ≤ 3 * 10^4
    auto size = 3 * (int) pow(10, 4) + 1;
    vector<int> nums{size};
    EXPECT_EXIT(SingleNumber::singleNumber(nums), ::testing::ExitedWithCode(3), "");
}

#endif