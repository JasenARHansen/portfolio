#ifndef INTERVIEW_META_PREPARATION_FACTORIAL_TEST
#define INTERVIEW_META_PREPARATION_FACTORIAL_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/tips_and_tricks/Factorial.cpp"  // NOLINT : Ignore .cpp import

TEST(FactorialTest, description) {
    testing::internal::CaptureStdout();
    Factorial::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(FactorialTest, factorial) {
    auto expected = 120;
    auto base = 5;
    auto result = Factorial::factorial(base);
    EXPECT_EQ(expected, result);
}

TEST(FactorialTest, factorialRecursion) {
    auto expected = 120;
    auto base = 5;
    auto result = Factorial::factorialRecursion(base);
    EXPECT_EQ(expected, result);
}

#endif