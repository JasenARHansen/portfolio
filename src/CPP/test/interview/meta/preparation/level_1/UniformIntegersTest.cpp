#ifndef INTERVIEW_META_PREPARATION_UNIFORM_INTEGERS_TEST
#define INTERVIEW_META_PREPARATION_UNIFORM_INTEGERS_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/level_1/UniformIntegers.cpp"

TEST(UniformIntegersTest, description) {
    testing::internal::CaptureStdout();
    UniformIntegers::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(UniformIntegersTest, getUniformIntegerCountInInterval_1) {
    auto expected = 5;
    long long a = 75;
    long long b = 300;
    auto result = UniformIntegers::getUniformIntegerCountInInterval(a, b);
    EXPECT_EQ(expected, result);
}

TEST(UniformIntegersTest, getUniformIntegerCountInInterval_2) {
    auto expected = 9;
    long long a = 1;
    long long b = 9;
    auto result = UniformIntegers::getUniformIntegerCountInInterval(a, b);
    EXPECT_EQ(expected, result);
}

TEST(UniformIntegersTest, getUniformIntegerCountInInterval_3) {
    auto expected = 1;
    long long a = 999999999999;
    long long b = 999999999999;
    auto result = UniformIntegers::getUniformIntegerCountInInterval(a, b);
    EXPECT_EQ(expected, result);
}

TEST(UniformIntegersTest, getUniformIntegerCountInInterval_4) {
    auto expected = 27;
    long long a = 1;
    long long b = 999;
    auto result = UniformIntegers::getUniformIntegerCountInInterval(a, b);
    EXPECT_EQ(expected, result);
}

TEST(UniformIntegersTest, getUniformIntegerCountInInterval_fail_1) {
    // 1 ≤ a
    long long a = 1 - 1;
    long long b = 1;
    EXPECT_EXIT(UniformIntegers::getUniformIntegerCountInInterval(a, b), ::testing::ExitedWithCode(3), "");
}

TEST(UniformIntegersTest, getUniformIntegerCountInInterval_fail_2) {
    // a ≤ b
    long long a = 10;
    long long b = a - 1;
    EXPECT_EXIT(UniformIntegers::getUniformIntegerCountInInterval(a, b), ::testing::ExitedWithCode(3), "");
}

TEST(UniformIntegersTest, getUniformIntegerCountInInterval_fail_3) {
    // b ≤ 10^12
    long long a = 10;
    long long b = (long long) pow(10, 12) + 1;
    EXPECT_EXIT(UniformIntegers::getUniformIntegerCountInInterval(a, b), ::testing::ExitedWithCode(3), "");
}

#endif