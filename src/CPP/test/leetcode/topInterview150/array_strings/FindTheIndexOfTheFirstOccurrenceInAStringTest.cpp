#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_FIND_THE_INDEX_OF_THE_FIRST_OCCURRENCE_IN_A_STRING_TEST
#define LEETCODE_TOP_INTERVIEW_150_FIND_THE_INDEX_OF_THE_FIRST_OCCURRENCE_IN_A_STRING_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/array_strings/FindTheIndexOfTheFirstOccurrenceInAString.cpp"

TEST(FindTheIndexOfTheFirstOccurrenceInAStringTest, description) {
    testing::internal::CaptureStdout();
    FindTheIndexOfTheFirstOccurrenceInAString::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(FindTheIndexOfTheFirstOccurrenceInAStringTest, strStr_1) {
    int expected = 0;
    string haystack = "sadbutsad";
    string needle = "sad";
    int result = FindTheIndexOfTheFirstOccurrenceInAString::strStr(haystack, needle);
    EXPECT_EQ(expected, result);
}

TEST(FindTheIndexOfTheFirstOccurrenceInAStringTest, strStr_2) {
    int expected = -1;
    string haystack = "leetcode";
    string needle = "leeto";
    int result = FindTheIndexOfTheFirstOccurrenceInAString::strStr(haystack, needle);
    EXPECT_EQ(expected, result);
}

TEST(FindTheIndexOfTheFirstOccurrenceInAStringTest, strStr_3) {
    int expected = 0;
    string haystack = "leetcode";
    string needle = "leetcode";
    int result = FindTheIndexOfTheFirstOccurrenceInAString::strStr(haystack, needle);
    EXPECT_EQ(expected, result);
}

TEST(FindTheIndexOfTheFirstOccurrenceInAStringTest, strStr_4) {
    int expected = 9;
    string haystack = "I am not sad";
    string needle = "sad";
    int result = FindTheIndexOfTheFirstOccurrenceInAString::strStr(haystack, needle);
    EXPECT_EQ(expected, result);
}

TEST(FindTheIndexOfTheFirstOccurrenceInAStringTest, strStr_fail_1) {
    // 1 <= haystack.length
    int size = 1 - 1;
    string haystack(size, 0);
    string needle = "leetcode";
    EXPECT_EXIT(FindTheIndexOfTheFirstOccurrenceInAString::strStr(haystack, needle), ::testing::ExitedWithCode(3), "");
}

TEST(FindTheIndexOfTheFirstOccurrenceInAStringTest, strStr_fail_2) {
    // haystack.length <= 10^4
    int size = pow(10, 4) + 1;
    string haystack(size, 0);
    string needle = "leetcode";
    EXPECT_EXIT(FindTheIndexOfTheFirstOccurrenceInAString::strStr(haystack, needle), ::testing::ExitedWithCode(3), "");
}

TEST(FindTheIndexOfTheFirstOccurrenceInAStringTest, strStr_fail_3) {
    // 1 <= needle.length
    int size = 1 - 1;
    string haystack = "leetcode";
    string needle(size, 0);
    EXPECT_EXIT(FindTheIndexOfTheFirstOccurrenceInAString::strStr(haystack, needle), ::testing::ExitedWithCode(3), "");
}

TEST(FindTheIndexOfTheFirstOccurrenceInAStringTest, strStr_fail_4) {
    // needle.length <= 10^4
    int size = pow(10, 4) + 1;
    string haystack = "leetcode";
    string needle(size, 0);
    EXPECT_EXIT(FindTheIndexOfTheFirstOccurrenceInAString::strStr(haystack, needle), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop
