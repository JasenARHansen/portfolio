#pragma clang diagnostic push
#ifndef HACKERRANK_SAMPLE_TEST_FIZZ_BUZZ_TEST
#define HACKERRANK_SAMPLE_TEST_FIZZ_BUZZ_TEST

#include "gtest/gtest.h"
#include "../../../code/hackerrank/SampleTest/FizzBuzz.cpp"  // NOLINT : Ignore .cpp import

TEST(FizzBuzzTest, description) {
    testing::internal::CaptureStdout();
    FizzBuzz::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(FizzBuzzTest, fizzBuzz_1) {
    auto expected = "1\n"
                    "2\n"
                    "Fizz\n"
                    "4\n"
                    "Buzz\n"
                    "Fizz\n"
                    "7\n"
                    "8\n"
                    "Fizz\n"
                    "Buzz\n"
                    "11\n"
                    "Fizz\n"
                    "13\n"
                    "14\n"
                    "FizzBuzz\n";
    auto input = 15;
    testing::internal::CaptureStdout();
    FizzBuzz::fizzBuzz(input);
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
}

#endif
#pragma clang diagnostic pop