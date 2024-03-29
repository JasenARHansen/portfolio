#ifndef LEETCODE_TOP_INTERVIEW_150_SINGLE_NUMBER_II_TEST
#define LEETCODE_TOP_INTERVIEW_150_SINGLE_NUMBER_II_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/bit_manipulation/SingleNumberII.cpp"  // NOLINT : Ignore .cpp import

TEST(LeetCode_SingleNumberIITest, description) {
    testing::internal::CaptureStdout();
    SingleNumberII::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LeetCode_SingleNumberIITest, singleNumber_1) {
    auto expected = 3;
    vector<int> nums{2, 2, 3, 2};
    auto result = SingleNumberII::singleNumber(nums);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_SingleNumberIITest, singleNumber_2) {
    auto expected = 99;
    vector<int> nums{0, 1, 0, 1, 0, 1, 99};
    auto result = SingleNumberII::singleNumber(nums);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_SingleNumberIITest, addBinary_fail_1) {
    // 1 ≤ nums.length
    auto size = 1 - 1;
    vector<int> nums(size);
    EXPECT_EXIT(SingleNumberII::singleNumber(nums), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_SingleNumberIITest, addBinary_fail_2) {
    // nums.length ≤ 3 * 10^4
    auto size = 3 * (int) pow(10, 4) + 1;
    vector<int> nums(size);
    EXPECT_EXIT(SingleNumberII::singleNumber(nums), ::testing::ExitedWithCode(3), "");
}

#endif