#ifndef LEETCODE_TOP_INTERVIEW_150_POW_TEST
#define LEETCODE_TOP_INTERVIEW_150_POW_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/math/Pow.cpp"  // NOLINT : Ignore .cpp import

TEST(PowTest, description) {
    testing::internal::CaptureStdout();
    Pow::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(PowTest, myPow_1) {
    auto expected = 1024.00000;
    auto x = 2.00000;
    auto n = 10;
    auto result = Pow::myPow(x, n);
    EXPECT_EQ(expected, result);
}

TEST(PowTest, myPow_2) {
    auto expected = 9.26100;
    auto x = 2.10000;
    auto n = 3;
    auto result = Pow::myPow(x, n);
    EXPECT_EQ(expected, result);
}

TEST(PowTest, myPow_3) {
    auto expected = 0.25000;
    auto x = 2.00000;
    auto n = -2;
    auto result = Pow::myPow(x, n);
    EXPECT_EQ(expected, result);
}

TEST(PowTest, myPow_4) {
    auto expected = 5643.35434;
    auto x = 8.66731;
    auto n = 4;
    auto result = Pow::myPow(x, n);
    EXPECT_EQ(expected, result);
}

TEST(PowTest, myPow_5) {
    auto expected = 0;
    auto x = 2.00000;
    int n = -2147483648;
    auto result = Pow::myPow(x, n);
    EXPECT_EQ(expected, result);
}

TEST(PowTest, myPow_6) {
    auto expected = 1;
    auto x = 1.00000;
    int n = -2147483648;
    auto result = Pow::myPow(x, n);
    EXPECT_EQ(expected, result);
}

TEST(PowTest, myPow_7) {
    auto expected = -1;
    auto x = -1.00000;
    auto n = -5;
    auto result = Pow::myPow(x, n);
    EXPECT_EQ(expected, result);
}

TEST(PowTest, myPow_8) {
    auto expected = 1;
    auto x = -1.00000;
    auto n = -4;
    auto result = Pow::myPow(x, n);
    EXPECT_EQ(expected, result);
}

TEST(PowTest, myPow_9) {
    auto expected = 0.99978;
    auto x = -1.0000000000001;
    int n = -2147483648;
    auto result = Pow::myPow(x, n);
    EXPECT_EQ(expected, result);
}

TEST(PowTest, myPow_fail_1) {
    // -100.0 < x
    auto x = -100.0 - 1;
    auto n = 1;
    EXPECT_EXIT(Pow::myPow(x, n), ::testing::ExitedWithCode(3), "");
}

TEST(PowTest, myPow_fail_2) {
    // x < 100.0
    auto x = 100.0 + 1;
    auto n = 1;
    EXPECT_EXIT(Pow::myPow(x, n), ::testing::ExitedWithCode(3), "");
}

#endif