#ifndef INTERVIEW_META_PREPARATION_BALANCE_BRACKETS_TEST
#define INTERVIEW_META_PREPARATION_BALANCE_BRACKETS_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/stacks/BalanceBrackets.cpp"  // NOLINT : Ignore .cpp import

TEST(BalanceBracketsTest, description) {
    testing::internal::CaptureStdout();
    BalanceBrackets::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(BalanceBracketsTest, BalanceBracketsExists_1) {
    auto expected = true;
    auto s = "{[()]}";
    auto result = BalanceBrackets::isBalanced(s);
    EXPECT_EQ(expected, result);
}

TEST(BalanceBracketsTest, BalanceBracketsExists_2) {
    auto expected = true;
    auto s = "{[()]}";
    auto result = BalanceBrackets::isBalanced(s);
    EXPECT_EQ(expected, result);
}

TEST(BalanceBracketsTest, BalanceBracketsExists_3) {
    auto expected = false;
    auto s = "{(})";
    auto result = BalanceBrackets::isBalanced(s);
    EXPECT_EQ(expected, result);
}

TEST(BalanceBracketsTest, BalanceBracketsExists_4) {
    auto expected = false;
    auto s = ")";
    auto result = BalanceBrackets::isBalanced(s);
    EXPECT_EQ(expected, result);
}

#endif