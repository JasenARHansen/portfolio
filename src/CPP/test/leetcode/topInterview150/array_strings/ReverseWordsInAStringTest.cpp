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
    auto expected = "blue is sky the";
    auto s = "the sky is blue";
    auto result = ReverseWordsInAString::reverseWords(s);
    EXPECT_EQ(expected, result);
}

TEST(ReverseWordsInAStringTest, reverseWords_2) {
    auto expected = "world hello";
    auto s = "  hello world  ";
    auto result = ReverseWordsInAString::reverseWords(s);
    EXPECT_EQ(expected, result);
}

TEST(ReverseWordsInAStringTest, reverseWords_3) {
    auto expected = "example good a";
    auto s = "a good   example";
    auto result = ReverseWordsInAString::reverseWords(s);
    EXPECT_EQ(expected, result);
}

TEST(ReverseWordsInAStringTest, reverseWords_fail_1) {
    // 1 <= s.length
    auto size = 1 - 1;
    string s(size, 0);
    EXPECT_EXIT(ReverseWordsInAString::reverseWords(s), ::testing::ExitedWithCode(3), "");
}

TEST(ReverseWordsInAStringTest, reverseWords_fail_2) {
    // s.length <= 10^4
    auto size = (int) pow(10, 4) + 1;
    string s(size, ' ');
    EXPECT_EXIT(ReverseWordsInAString::reverseWords(s), ::testing::ExitedWithCode(3), "");
}

#endif