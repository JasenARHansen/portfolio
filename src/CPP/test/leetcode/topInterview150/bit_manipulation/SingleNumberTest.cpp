#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_SINGLE_NUMBER_TEST
#define LEETCODE_TOP_INTERVIEW_150_SINGLE_NUMBER_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/bit_manipulation/SingleNumber.cpp"

TEST(SingleNumberTest, description) {
    testing::internal::CaptureStdout();
    SingleNumber::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(SingleNumberTest, singleNumber_1) {
    int expected = 1;
    vector<int> nums{2, 2, 1};
    int result = SingleNumber::singleNumber(nums);
    EXPECT_EQ(expected, result);
}

TEST(SingleNumberTest, singleNumber_2) {
    int expected = 4;
    vector<int> nums{4, 1, 2, 1, 2};
    int result = SingleNumber::singleNumber(nums);
    EXPECT_EQ(expected, result);
}

TEST(SingleNumberTest, singleNumber_3) {
    int expected = 1;
    vector<int> nums{1};
    int result = SingleNumber::singleNumber(nums);
    EXPECT_EQ(expected, result);
}

TEST(SingleNumberTest, addBinary_fail_1) {
    // 1 <= nums.length
    int size = 1 - 1;
    vector<int> nums(size);
    EXPECT_EXIT(SingleNumber::singleNumber(nums), ::testing::ExitedWithCode(3), "");
}

TEST(SingleNumberTest, addBinary_fail_2) {
    // nums.length <= 3 * 10^4
    int size = 3 * pow(10, 4) + 1;
    vector<int> nums(size);
    EXPECT_EXIT(SingleNumber::singleNumber(nums), ::testing::ExitedWithCode(3), "");
}

TEST(SingleNumberTest, addBinary_fail_3) {
    //  -3 * 10^4 <= nums[i]
    int size = -3 * pow(10, 4) - 1;
    vector<int> nums{size};
    EXPECT_EXIT(SingleNumber::singleNumber(nums), ::testing::ExitedWithCode(3), "");
}

TEST(SingleNumberTest, addBinary_fail_4) {
    // nums[i] <= 3 * 10^4
    int size = 3 * pow(10, 4) + 1;
    vector<int> nums{size};
    EXPECT_EXIT(SingleNumber::singleNumber(nums), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop