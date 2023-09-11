#ifndef LEETCODE_TOP_INTERVIEW_150_PLUS_ONE_TEST
#define LEETCODE_TOP_INTERVIEW_150_PLUS_ONE_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/math/PlusOne.cpp"

TEST(PlusOneTest, description) {
    testing::internal::CaptureStdout();
    PlusOne::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(PlusOneTest, plusOne_1) {
    vector<int> expected{1, 2, 4};
    vector<int> digits{1, 2, 3};
    auto result = PlusOne::plusOne(digits);
    EXPECT_EQ(expected, result);
}

TEST(PlusOneTest, plusOne_2) {
    vector<int> expected{4, 3, 2, 2};
    vector<int> digits{4, 3, 2, 1};
    auto result = PlusOne::plusOne(digits);
    EXPECT_EQ(expected, result);
}

TEST(PlusOneTest, plusOne_3) {
    vector<int> expected{1, 0};
    vector<int> digits{9};
    auto result = PlusOne::plusOne(digits);
    EXPECT_EQ(expected, result);
}

TEST(PlusOneTest, plusOne_fail_1) {
    // 1 ≤ digits.length
    auto size = 0;
    vector<int> digits(size);
    EXPECT_EXIT(PlusOne::plusOne(digits), ::testing::ExitedWithCode(3), "");
}

TEST(PlusOneTest, plusOne_fail_2) {
    // digits.length ≤ 100
    auto size = 100 + 1;
    vector<int> digits(size);
    EXPECT_EXIT(PlusOne::plusOne(digits), ::testing::ExitedWithCode(3), "");
}

#endif