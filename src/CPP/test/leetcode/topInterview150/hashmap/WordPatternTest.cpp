#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_WORD_PATTERN_TEST
#define LEETCODE_TOP_INTERVIEW_150_WORD_PATTERN_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/hashmap/WordPattern.cpp"

TEST(WordPatternTest, description) {
    testing::internal::CaptureStdout();
    WordPattern::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(WordPatternTest, wordPattern_1) {
    bool expected = true;
    string pattern = "abba";
    string s = "dog cat cat dog";
    bool result = WordPattern::wordPattern(pattern, s);
    EXPECT_EQ(expected, result);
}

TEST(WordPatternTest, wordPattern_2) {
    bool expected = false;
    string pattern = "abba";
    string s = "dog cat cat fish";
    bool result = WordPattern::wordPattern(pattern, s);
    EXPECT_EQ(expected, result);
}

TEST(WordPatternTest, wordPattern_3) {
    bool expected = false;
    string pattern = "aaaa";
    string s = "dog cat cat dog";
    bool result = WordPattern::wordPattern(pattern, s);
    EXPECT_EQ(expected, result);
}

TEST(WordPatternTest, wordPattern_4) {
    bool expected = false;
    string pattern = "abba";
    string s = "dog dog dog dog";
    bool result = WordPattern::wordPattern(pattern, s);
    EXPECT_EQ(expected, result);
}

TEST(WordPatternTest, wordPattern_5) {
    bool expected = false;
    string pattern = "aba";
    string s = "cat cat cat dog";
    bool result = WordPattern::wordPattern(pattern, s);
    EXPECT_EQ(expected, result);
}

TEST(WordPatternTest, wordPattern_fail_1) {
    // 1 <= pattern.length
    int size = 1 - 1;
    string pattern(size, ' ');
    string s = "dog cat cat dog";
    EXPECT_EXIT(WordPattern::wordPattern(pattern, s), ::testing::ExitedWithCode(3), "");
}

TEST(WordPatternTest, wordPattern_fail_2) {
    // pattern.length <= 300
    int size = 300 + 1;
    string pattern(size, ' ');
    string s = "dog cat cat dog";
    EXPECT_EXIT(WordPattern::wordPattern(pattern, s), ::testing::ExitedWithCode(3), "");
}

TEST(WordPatternTest, wordPattern_fail_3) {
    // 1 <= s.length
    int size = 1 - 1;
    string pattern = "abba";
    string s(size, ' ');
    EXPECT_EXIT(WordPattern::wordPattern(pattern, s), ::testing::ExitedWithCode(3), "");
}

TEST(WordPatternTest, wordPattern_fail_4) {
    // s.length <= 3000
    int size = 3000 + 1;
    string pattern = "abba";
    string s(size, ' ');
    EXPECT_EXIT(WordPattern::wordPattern(pattern, s), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop