#ifndef LEETCODE_TOP_INTERVIEW_150_EVALUATE_REVERSE_POLISH_NOTATION_TEST
#define LEETCODE_TOP_INTERVIEW_150_EVALUATE_REVERSE_POLISH_NOTATION_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/stack/EvaluateReversePolishNotation.cpp"

TEST(EvaluateReversePolishNotationTest, description) {
    testing::internal::CaptureStdout();
    EvaluateReversePolishNotation::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(EvaluateReversePolishNotationTest, EvaluateReversePolishNotation_1) {
    auto expected = 9;
    vector<string> tokens{"2", "1", "+", "3", "*"};
    auto result = EvaluateReversePolishNotation::evalRPN(tokens);
    EXPECT_EQ(expected, result);
}

TEST(EvaluateReversePolishNotationTest, EvaluateReversePolishNotation_2) {
    auto expected = 6;
    vector<string> tokens{"4", "13", "5", "/", "+"};
    auto result = EvaluateReversePolishNotation::evalRPN(tokens);
    EXPECT_EQ(expected, result);
}

TEST(EvaluateReversePolishNotationTest, EvaluateReversePolishNotation_3) {
    auto expected = 22;
    vector<string> tokens{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
    auto result = EvaluateReversePolishNotation::evalRPN(tokens);
    EXPECT_EQ(expected, result);
}

TEST(EvaluateReversePolishNotationTest, simplifyPath_fail_1) {
    // 1 <= tokens.length
    auto size = 1 - 1;
    vector<string> tokens(size);
    EXPECT_EXIT(EvaluateReversePolishNotation::evalRPN(tokens), ::testing::ExitedWithCode(3), "");
}

TEST(EvaluateReversePolishNotationTest, simplifyPath_fail_2) {
    // tokens.length <= 10^4
    auto size = (int) pow(10, 4) + 1;
    vector<string> tokens(size);
    EXPECT_EXIT(EvaluateReversePolishNotation::evalRPN(tokens), ::testing::ExitedWithCode(3), "");
}

TEST(EvaluateReversePolishNotationTest, simplifyPath_fail_3) {
    // -200 <= tokens[i]
    auto size = -200 - 1;
    vector<string> tokens{to_string(size)};
    EXPECT_EXIT(EvaluateReversePolishNotation::evalRPN(tokens), ::testing::ExitedWithCode(3), "");
}

TEST(EvaluateReversePolishNotationTest, simplifyPath_fail_4) {
    // tokens[i] <= 200
    auto size = 200 + 1;
    vector<string> tokens{to_string(size)};
    EXPECT_EXIT(EvaluateReversePolishNotation::evalRPN(tokens), ::testing::ExitedWithCode(3), "");
}

#endif