#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_REVERSE_WORDS_IN_A_STRING_TEST
#define LEETCODE_TOP_INTERVIEW_150_REVERSE_WORDS_IN_A_STRING_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/array_strings/ReverseWordsInAString.cpp"

TEST(ReverseWordsInAStringTest, description) {
    testing::internal::CaptureStdout();
    ReverseWordsInAString::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ReverseWordsInAStringTest, reverseWords_1) {
    string expected = "blue is sky the";
    string s = "the sky is blue";
    string result = ReverseWordsInAString::reverseWords(s);
    EXPECT_EQ(expected, result);
}

TEST(ReverseWordsInAStringTest, reverseWords_2) {
    string expected = "world hello";
    string s = "  hello world  ";
    string result = ReverseWordsInAString::reverseWords(s);
    EXPECT_EQ(expected, result);
}

TEST(ReverseWordsInAStringTest, reverseWords_3) {
    string expected = "example good a";
    string s = "a good   example";
    string result = ReverseWordsInAString::reverseWords(s);
    EXPECT_EQ(expected, result);
}

TEST(ReverseWordsInAStringTest, reverseWords_fail_1) {
    // 1 <= s.length
    int size = 1 - 1;
    string s(size, 0);
    EXPECT_EXIT(ReverseWordsInAString::reverseWords(s), ::testing::ExitedWithCode(3), "");
}

TEST(ReverseWordsInAStringTest, reverseWords_fail_2) {
    // s.length <= 10^4
    int size = pow(10, 4) + 1;
    string s(size, 0);
    EXPECT_EXIT(ReverseWordsInAString::reverseWords(s), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop