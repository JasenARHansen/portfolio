#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_HAPPY_NUMBER_TEST
#define LEETCODE_TOP_INTERVIEW_150_HAPPY_NUMBER_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/hashmap/HappyNumber.cpp"

TEST(HappyNumberTest, description) {
    testing::internal::CaptureStdout();
    HappyNumber::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(HappyNumberTest, isHappy_1) {
    bool expected = true;
    int n = 19;
    bool result = HappyNumber::isHappy(n);
    EXPECT_EQ(expected, result);
}

TEST(HappyNumberTest, isHappy_2) {
    bool expected = false;
    int n = 2;
    bool result = HappyNumber::isHappy(n);
    EXPECT_EQ(expected, result);
}

TEST(HappyNumberTest, isHappy_fail_1) {
    // 1 <= n
    int n = 1 - 1;
    EXPECT_EXIT(HappyNumber::isHappy(n), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop