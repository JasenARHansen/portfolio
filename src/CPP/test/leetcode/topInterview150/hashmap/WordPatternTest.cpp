#ifndef LEETCODE_TOP_INTERVIEW_150_WORD_PATTERN_TEST
#define LEETCODE_TOP_INTERVIEW_150_WORD_PATTERN_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/hashmap/WordPattern.cpp"  // NOLINT : Ignore .cpp import

TEST(LeetCode_WordPatternTest, description) {
    testing::internal::CaptureStdout();
    WordPattern::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LeetCode_WordPatternTest, wordPattern_1) {
    auto expected = true;
    auto pattern = "abba";
    auto s = "dog cat cat dog";
    auto result = WordPattern::wordPattern(pattern, s);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_WordPatternTest, wordPattern_2) {
    auto expected = false;
    auto pattern = "abba";
    auto s = "dog cat cat fish";
    auto result = WordPattern::wordPattern(pattern, s);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_WordPatternTest, wordPattern_3) {
    auto expected = false;
    auto pattern = "aaaa";
    auto s = "dog cat cat dog";
    auto result = WordPattern::wordPattern(pattern, s);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_WordPatternTest, wordPattern_4) {
    auto expected = false;
    auto pattern = "abba";
    auto s = "dog dog dog dog";
    auto result = WordPattern::wordPattern(pattern, s);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_WordPatternTest, wordPattern_5) {
    auto expected = false;
    auto pattern = "aba";
    auto s = "cat cat cat dog";
    auto result = WordPattern::wordPattern(pattern, s);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_WordPatternTest, wordPattern_fail_1) {
    // 1 ≤ pattern.length
    auto size = 1 - 1;
    string pattern(size, ' ');
    auto s = "dog cat cat dog";
    EXPECT_EXIT(WordPattern::wordPattern(pattern, s), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_WordPatternTest, wordPattern_fail_2) {
    // pattern.length ≤ 300
    auto size = 300 + 1;
    string pattern(size, ' ');
    auto s = "dog cat cat dog";
    EXPECT_EXIT(WordPattern::wordPattern(pattern, s), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_WordPatternTest, wordPattern_fail_3) {
    // 1 ≤ s.length
    auto size = 1 - 1;
    auto pattern = "abba";
    string s(size, ' ');
    EXPECT_EXIT(WordPattern::wordPattern(pattern, s), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_WordPatternTest, wordPattern_fail_4) {
    // s.length ≤ 3000
    auto size = 3000 + 1;
    auto pattern = "abba";
    string s(size, ' ');
    EXPECT_EXIT(WordPattern::wordPattern(pattern, s), ::testing::ExitedWithCode(3), "");
}

#endif