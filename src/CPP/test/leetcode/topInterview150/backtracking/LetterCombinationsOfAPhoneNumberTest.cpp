#ifndef LEETCODE_TOP_INTERVIEW_150_LETTER_COMBINATIONS_OF_A_PHONE_NUMBER_TEST
#define LEETCODE_TOP_INTERVIEW_150_LETTER_COMBINATIONS_OF_A_PHONE_NUMBER_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/backtracking/LetterCombinationsOfAPhoneNumber.cpp"  // NOLINT : Ignore .cpp import

TEST(LetterCombinationsOfAPhoneNumberTest, description) {
    testing::internal::CaptureStdout();
    LetterCombinationsOfAPhoneNumber::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LetterCombinationsOfAPhoneNumberTest, letterCombinations_1) {
    vector<string> expected{"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"};
    string digits = "23";
    auto result = LetterCombinationsOfAPhoneNumber::letterCombinations(digits);
    EXPECT_EQ(expected, result);
}

TEST(LetterCombinationsOfAPhoneNumberTest, letterCombinations_2) {
    vector<string> expected{};
    string digits;
    auto result = LetterCombinationsOfAPhoneNumber::letterCombinations(digits);
    EXPECT_EQ(expected, result);
}

TEST(LetterCombinationsOfAPhoneNumberTest, letterCombinations_3) {
    vector<string> expected{"a", "b", "c"};
    string digits = "2";
    auto result = LetterCombinationsOfAPhoneNumber::letterCombinations(digits);
    EXPECT_EQ(expected, result);
}

#endif