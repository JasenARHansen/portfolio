#ifndef LEETCODE_TOP_INTERVIEW_150_VALID_PARENTHESES_TEST
#define LEETCODE_TOP_INTERVIEW_150_VALID_PARENTHESES_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/stack/ValidParentheses.cpp"

TEST(ValidParenthesesTest, description) {
    testing::internal::CaptureStdout();
    ValidParentheses::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ValidParenthesesTest, isValid_1) {
    auto expected = true;
    auto s = "()";
    auto result = ValidParentheses::isValid(s);
    EXPECT_EQ(expected, result);
}

TEST(ValidParenthesesTest, isValid_2) {
    auto expected = true;
    auto s = "()[]{}";
    auto result = ValidParentheses::isValid(s);
    EXPECT_EQ(expected, result);
}

TEST(ValidParenthesesTest, isValid_3) {
    auto expected = false;
    auto s = "(]";
    auto result = ValidParentheses::isValid(s);
    EXPECT_EQ(expected, result);
}

TEST(ValidParenthesesTest, isValid_4) {
    auto expected = false;
    auto s = "(";
    auto result = ValidParentheses::isValid(s);
    EXPECT_EQ(expected, result);
}

TEST(ValidParenthesesTest, isValid_5) {
    auto expected = false;
    auto s = "]";
    auto result = ValidParentheses::isValid(s);
    EXPECT_EQ(expected, result);
}

TEST(ValidParenthesesTest, isValid_fail_1) {
    // 1 ≤ s.length
    auto size = 1 - 1;
    string s(size, ' ');
    EXPECT_EXIT(ValidParentheses::isValid(s), ::testing::ExitedWithCode(3), "");
}

TEST(ValidParenthesesTest, isValid_fail_2) {
    // s.length ≤ 10^4
    auto size = (int) pow(10, 9) + 1;
    string s(size, ' ');
    EXPECT_EXIT(ValidParentheses::isValid(s), ::testing::ExitedWithCode(3), "");
}

#endif