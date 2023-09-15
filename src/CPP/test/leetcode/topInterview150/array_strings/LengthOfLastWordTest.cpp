#ifndef LEETCODE_TOP_INTERVIEW_150_LENGTH_OF_LAST_WORD_TEST
#define LEETCODE_TOP_INTERVIEW_150_LENGTH_OF_LAST_WORD_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/array_strings/LengthOfLastWord.cpp"  // NOLINT : Ignore .cpp import

TEST(LengthOfLastWordTest, description) {
    testing::internal::CaptureStdout();
    LengthOfLastWord::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LengthOfLastWordTest, lengthOfLastWord_1) {
    auto expected = 5;
    auto s = "Hello World";
    auto result = LengthOfLastWord::lengthOfLastWord(s);
    EXPECT_EQ(expected, result);
}

TEST(LengthOfLastWordTest, lengthOfLastWord_2) {
    auto expected = 4;
    auto s = "   fly me   to   the moon  ";
    auto result = LengthOfLastWord::lengthOfLastWord(s);
    EXPECT_EQ(expected, result);
}

TEST(LengthOfLastWordTest, lengthOfLastWord_3) {
    auto expected = 6;
    auto s = "luffy is still joyboy";
    auto result = LengthOfLastWord::lengthOfLastWord(s);
    EXPECT_EQ(expected, result);
}

TEST(LengthOfLastWordTest, lengthOfLastWord_5) {
    auto expected = 5;
    auto s = " \t\n  Hello World  ";
    auto result = LengthOfLastWord::lengthOfLastWord(s);
    EXPECT_EQ(expected, result);
}

TEST(LengthOfLastWordTest, lengthOfLastWord_6) {
    auto expected = 5;
    auto s = " \t\n  Hello\nWorld \n ";
    auto result = LengthOfLastWord::lengthOfLastWord(s);
    EXPECT_EQ(expected, result);
}

TEST(LengthOfLastWordTest, lengthOfLastWord_7) {
    auto expected = 5;
    auto s = "Hello";
    auto result = LengthOfLastWord::lengthOfLastWord(s);
    EXPECT_EQ(expected, result);
}

TEST(LengthOfLastWordTest, lengthOfLastWord_fail_1) {
    // 1 ≤ s.length
    auto size = 1 - 1;
    string s(size, 0);
    EXPECT_EXIT(LengthOfLastWord::lengthOfLastWord(s), ::testing::ExitedWithCode(3), "");
}

TEST(LengthOfLastWordTest, lengthOfLastWord_fail_2) {
    // s.length ≤ 10^4
    auto size = (int) pow(10, 4) + 1;
    string s(size, 0);
    EXPECT_EXIT(LengthOfLastWord::lengthOfLastWord(s), ::testing::ExitedWithCode(3), "");
}

#endif