#ifndef INTERVIEW_META_PREPARATION_ABCS_TEST
#define INTERVIEW_META_PREPARATION_ABCS_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/warmup/ABCs.cpp"  // NOLINT : Ignore .cpp import

TEST(ABCsTest, description) {
    testing::internal::CaptureStdout();
    ABCs::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ABCsTest, getSum_1) {
    auto expected = 6;
    auto a = 1;
    auto b = 2;
    auto c = 3;
    auto result = ABCs::getSum(a, b, c);
    EXPECT_EQ(expected, result);
}

TEST(ABCsTest, getSum_2) {
    auto expected = 300;
    auto a = 100;
    auto b = 100;
    auto c = 100;
    auto result = ABCs::getSum(a, b, c);
    EXPECT_EQ(expected, result);
}

TEST(ABCsTest, getSum_3) {
    auto expected = 194;
    auto a = 85;
    auto b = 16;
    auto c = 93;
    auto result = ABCs::getSum(a, b, c);
    EXPECT_EQ(expected, result);
}

TEST(ABCsTest, getSum_fail_1) {
    // 1 ≤ a
    auto a = 1 - 1;
    auto b = 1;
    auto c = 1;
    EXPECT_EXIT(ABCs::getSum(a, b, c), ::testing::ExitedWithCode(3), "");
}

TEST(ABCsTest, getSum_fail_2) {
    // a ≤ 100
    auto a = 100 + 1;
    auto b = 100;
    auto c = 100;
    EXPECT_EXIT(ABCs::getSum(a, b, c), ::testing::ExitedWithCode(3), "");
}

TEST(ABCsTest, getSum_fail_3) {
    // 1 ≤ b
    auto a = 1;
    auto b = 1 - 1;
    auto c = 1;
    EXPECT_EXIT(ABCs::getSum(a, b, c), ::testing::ExitedWithCode(3), "");
}

TEST(ABCsTest, getSum_fail_4) {
    // b ≤ 100
    auto a = 100;
    auto b = 100 + 1;
    auto c = 100;
    EXPECT_EXIT(ABCs::getSum(a, b, c), ::testing::ExitedWithCode(3), "");
}

TEST(ABCsTest, getSum_fail_5) {
    // 1 ≤ C
    auto a = 1;
    auto b = 1;
    auto c = 1 - 1;
    EXPECT_EXIT(ABCs::getSum(a, b, c), ::testing::ExitedWithCode(3), "");
}

TEST(ABCsTest, getSum_fail_6) {
    // c ≤ 100
    auto a = 100;
    auto b = 100;
    auto c = 100 + 1;
    EXPECT_EXIT(ABCs::getSum(a, b, c), ::testing::ExitedWithCode(3), "");
}

#endif