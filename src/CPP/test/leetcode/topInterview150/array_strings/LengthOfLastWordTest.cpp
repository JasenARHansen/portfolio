#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_LENGTH_OF_LAST_WORD_TEST
#define LEETCODE_TOP_INTERVIEW_150_LENGTH_OF_LAST_WORD_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/array_strings/LengthOfLastWord.cpp"

TEST(LengthOfLastWordTest, description) {
    testing::internal::CaptureStdout();
    LengthOfLastWord::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LengthOfLastWordTest, lengthOfLastWord_1) {
    int expected = 5;
    string s = "Hello World";
    int result = LengthOfLastWord::lengthOfLastWord(s);
    EXPECT_EQ(expected, result);
}

TEST(LengthOfLastWordTest, lengthOfLastWord_2) {
    int expected = 4;
    string s = "   fly me   to   the moon  ";
    int result = LengthOfLastWord::lengthOfLastWord(s);
    EXPECT_EQ(expected, result);
}

TEST(LengthOfLastWordTest, lengthOfLastWord_3) {
    int expected = 6;
    string s = "luffy is still joyboy";
    int result = LengthOfLastWord::lengthOfLastWord(s);
    EXPECT_EQ(expected, result);
}

TEST(LengthOfLastWordTest, lengthOfLastWord_5) {
    int expected = 5;
    string s = " \t\n  Hello World  ";
    int result = LengthOfLastWord::lengthOfLastWord(s);
    EXPECT_EQ(expected, result);
}

TEST(LengthOfLastWordTest, lengthOfLastWord_6) {
    int expected = 5;
    string s = " \t\n  Hello\nWorld \n ";
    int result = LengthOfLastWord::lengthOfLastWord(s);
    EXPECT_EQ(expected, result);
}

TEST(LengthOfLastWordTest, lengthOfLastWord_7) {
    int expected = 5;
    string s = "Hello";
    int result = LengthOfLastWord::lengthOfLastWord(s);
    EXPECT_EQ(expected, result);
}

TEST(LengthOfLastWordTest, lengthOfLastWord_fail_1) {
    // 1 <= s.length
    int size = 1 - 1;
    string s(size, 0);
    EXPECT_EXIT(LengthOfLastWord::lengthOfLastWord(s), ::testing::ExitedWithCode(3), "");
}

TEST(LengthOfLastWordTest, lengthOfLastWord_fail_2) {
    // s.length <= 10^4
    int size = pow(10, 4) + 1;
    string s(size, 0);
    EXPECT_EXIT(LengthOfLastWord::lengthOfLastWord(s), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop