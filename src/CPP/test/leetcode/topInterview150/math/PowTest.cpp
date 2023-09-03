#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_POW_TEST
#define LEETCODE_TOP_INTERVIEW_150_POW_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/math/Pow.cpp"

TEST(PowTest, description) {
    testing::internal::CaptureStdout();
    Pow::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(PowTest, myPow_1) {
    double expected = 1024.00000;
    double x = 2.00000;
    int n = 10;
    double result = Pow::myPow(x, n);
    EXPECT_EQ(expected, result);
}

TEST(PowTest, myPow_2) {
    double expected = 9.26100;
    double x = 2.10000;
    int n = 3;
    double result = Pow::myPow(x, n);
    EXPECT_EQ(expected, result);
}

TEST(PowTest, myPow_3) {
    double expected = 0.25000;
    double x = 2.00000;
    int n = -2;
    double result = Pow::myPow(x, n);
    EXPECT_EQ(expected, result);
}

TEST(PowTest, myPow_4) {
    double expected = 5643.35434;
    double x = 8.66731;
    int n = 4;
    double result = Pow::myPow(x, n);
    EXPECT_EQ(expected, result);
}

TEST(PowTest, myPow_5) {
    double expected = 0;
    double x = 2.00000;
    int n = -2147483648;
    double result = Pow::myPow(x, n);
    EXPECT_EQ(expected, result);
}

TEST(PowTest, myPow_6) {
    double expected = 1;
    double x = 1.00000;
    int n = -2147483648;
    double result = Pow::myPow(x, n);
    EXPECT_EQ(expected, result);
}

TEST(PowTest, myPow_7) {
    double expected = -1;
    double x = -1.00000;
    int n = -5;
    double result = Pow::myPow(x, n);
    EXPECT_EQ(expected, result);
}

TEST(PowTest, myPow_8) {
    double expected = 1;
    double x = -1.00000;
    int n = -4;
    double result = Pow::myPow(x, n);
    EXPECT_EQ(expected, result);
}

TEST(PowTest, myPow_9) {
    double expected = 0.99978;
    double x = -1.0000000000001;
    int n = -2147483648;
    double result = Pow::myPow(x, n);
    EXPECT_EQ(expected, result);
}

TEST(PowTest, myPow_fail_1) {
    // -100.0 < x
    double x = -100.0 - 1;
    int n = 1;
    EXPECT_EXIT(Pow::myPow(x, n), ::testing::ExitedWithCode(3), "");
}

TEST(PowTest, myPow_fail_2) {
    // x < 100.0
    double x = 100.0 + 1;
    int n = 1;
    EXPECT_EXIT(Pow::myPow(x, n), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop