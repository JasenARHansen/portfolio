#ifndef LEETCODE_TOP_INTERVIEW_150_HAPPY_NUMBER_TEST
#define LEETCODE_TOP_INTERVIEW_150_HAPPY_NUMBER_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/hashmap/HappyNumber.cpp"  // NOLINT : Ignore .cpp import

TEST(HappyNumberTest, description) {
    testing::internal::CaptureStdout();
    HappyNumber::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(HappyNumberTest, isHappy_1) {
    auto expected = true;
    auto n = 19;
    auto result = HappyNumber::isHappy(n);
    EXPECT_EQ(expected, result);
}

TEST(HappyNumberTest, isHappy_2) {
    auto expected = false;
    auto n = 2;
    auto result = HappyNumber::isHappy(n);
    EXPECT_EQ(expected, result);
}

TEST(HappyNumberTest, isHappy_fail_1) {
    // 1 ≤ n
    auto n = 1 - 1;
    EXPECT_EXIT(HappyNumber::isHappy(n), ::testing::ExitedWithCode(3), "");
}

#endif