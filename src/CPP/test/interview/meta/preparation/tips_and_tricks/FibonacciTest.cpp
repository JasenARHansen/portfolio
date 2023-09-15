#ifndef INTERVIEW_META_PREPARATION_FIBONACCI_TEST
#define INTERVIEW_META_PREPARATION_FIBONACCI_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/tips_and_tricks/Fibonacci.cpp"  // NOLINT : Ignore .cpp import

TEST(FibonacciTest, description) {
    testing::internal::CaptureStdout();
    Fibonacci::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(FibonacciTest, Fibonacci) {
    auto expected = 8;
    auto base = 6;
    auto result = Fibonacci::fibonacci(base);
    EXPECT_EQ(expected, result);
}

TEST(FibonacciTest, FibonacciRecursion) {
    auto expected = 8;
    auto base = 6;
    auto result = Fibonacci::fibonacciRecursion(base);
    EXPECT_EQ(expected, result);
}

#endif