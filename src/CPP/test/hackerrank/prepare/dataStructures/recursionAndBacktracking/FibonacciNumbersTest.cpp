#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_RECURSION_AND_BACKTRACKING_FIBONACCI_NUMBERS_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_RECURSION_AND_BACKTRACKING_FIBONACCI_NUMBERS_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/recursionAndBacktracking/FibonacciNumbers.cpp"  // NOLINT : Ignore .cpp import

TEST(FibonacciNumbersTest, description) {
    testing::internal::CaptureStdout();
    FibonacciNumbers::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(FibonacciNumbersTest, fibonacci_1) {
    auto expected = 0;
    auto source = 0;
    auto result = FibonacciNumbers::fibonacci(source);
    EXPECT_EQ(expected, result);
}

TEST(FibonacciNumbersTest, fibonacci_2) {
    auto expected = 1;
    auto source = 1;
    auto result = FibonacciNumbers::fibonacci(source);
    EXPECT_EQ(expected, result);
}

TEST(FibonacciNumbersTest, fibonacci_3) {
    auto expected = 1;
    auto source = 2;
    auto result = FibonacciNumbers::fibonacci(source);
    EXPECT_EQ(expected, result);
}

TEST(FibonacciNumbersTest, fibonacci_4) {
    auto expected = 5;
    auto source = 5;
    auto result = FibonacciNumbers::fibonacci(source);
    EXPECT_EQ(expected, result);
}

TEST(FibonacciNumbersTest, fibonacci_5) {
    auto expected = 144;
    auto source = 12;
    auto result = FibonacciNumbers::fibonacci(source);
    EXPECT_EQ(expected, result);
}

TEST(FibonacciNumbersTest, fibonacci_6) {
    auto expected = 1597;
    auto source = 17;
    auto result = FibonacciNumbers::fibonacci(source);
    EXPECT_EQ(expected, result);
}

#endif