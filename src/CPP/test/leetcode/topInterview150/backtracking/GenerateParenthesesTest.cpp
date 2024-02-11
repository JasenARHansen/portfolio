#ifndef LEETCODE_TOP_INTERVIEW_150_GENERATE_PARENTHESES_TEST
#define LEETCODE_TOP_INTERVIEW_150_GENERATE_PARENTHESES_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/backtracking/GenerateParentheses.cpp"  // NOLINT : Ignore .cpp import

TEST(LeetCode_GenerateParenthesesTest, description) {
    testing::internal::CaptureStdout();
    GenerateParentheses::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LeetCode_GenerateParenthesesTest, generateParenthesis_1) {
    vector<string> expected{"((()))", "(()())", "(())()", "()(())", "()()()"};
    int n = 3;
    auto result = GenerateParentheses::generateParenthesis(n);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_GenerateParenthesesTest, generateParenthesis_2) {
    vector<string> expected{"()"};
    int n = 1;
    auto result = GenerateParentheses::generateParenthesis(n);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_GenerateParenthesesTest, generateParenthesis_3) {
    vector<string> expected{"(((())))", "((()()))", "((())())", "((()))()", "(()(()))", "(()()())", "(()())()",
                            "(())(())", "(())()()", "()((()))", "()(()())", "()(())()", "()()(())", "()()()()"};
    int n = 4;
    auto result = GenerateParentheses::generateParenthesis(n);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_GenerateParenthesesTest, generateParenthesis_fail_1) {
    // 1 ≤ n
    int n = 1 - 1;
    EXPECT_EXIT(GenerateParentheses::generateParenthesis(n), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_GenerateParenthesesTest, generateParenthesis_fail_2) {
    // n ≤ 8
    int n = 8 + 1;
    EXPECT_EXIT(GenerateParentheses::generateParenthesis(n), ::testing::ExitedWithCode(3), "");
}

#endif