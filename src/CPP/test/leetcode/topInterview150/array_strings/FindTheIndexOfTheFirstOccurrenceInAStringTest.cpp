#ifndef LEETCODE_TOP_INTERVIEW_150_FIND_THE_INDEX_OF_THE_FIRST_OCCURRENCE_IN_A_STRING_TEST
#define LEETCODE_TOP_INTERVIEW_150_FIND_THE_INDEX_OF_THE_FIRST_OCCURRENCE_IN_A_STRING_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/array_strings/FindTheIndexOfTheFirstOccurrenceInAString.cpp"

TEST(FindTheIndexOfTheFirstOccurrenceInAStringTest, description) {
    testing::internal::CaptureStdout();
    FindTheIndexOfTheFirstOccurrenceInAString::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(FindTheIndexOfTheFirstOccurrenceInAStringTest, stringstr_1) {
    auto expected = 0;
    auto haystack = "sadbutsad";
    auto needle = "sad";
    auto result = FindTheIndexOfTheFirstOccurrenceInAString::stringstr(haystack, needle);
    EXPECT_EQ(expected, result);
}

TEST(FindTheIndexOfTheFirstOccurrenceInAStringTest, stringstr_2) {
    auto expected = -1;
    auto haystack = "leetcode";
    auto needle = "leeto";
    auto result = FindTheIndexOfTheFirstOccurrenceInAString::stringstr(haystack, needle);
    EXPECT_EQ(expected, result);
}

TEST(FindTheIndexOfTheFirstOccurrenceInAStringTest, stringstr_3) {
    auto expected = 0;
    auto haystack = "leetcode";
    auto needle = "leetcode";
    auto result = FindTheIndexOfTheFirstOccurrenceInAString::stringstr(haystack, needle);
    EXPECT_EQ(expected, result);
}

TEST(FindTheIndexOfTheFirstOccurrenceInAStringTest, stringstr_4) {
    auto expected = 9;
    auto haystack = "I am not sad";
    auto needle = "sad";
    auto result = FindTheIndexOfTheFirstOccurrenceInAString::stringstr(haystack, needle);
    EXPECT_EQ(expected, result);
}

TEST(FindTheIndexOfTheFirstOccurrenceInAStringTest, stringstr_fail_1) {
    // 1 <= haystack.length
    auto size = 1 - 1;
    string haystack(size, 0);
    auto needle = "leetcode";
    EXPECT_EXIT(FindTheIndexOfTheFirstOccurrenceInAString::stringstr(haystack, needle), ::testing::ExitedWithCode(3),
                "");
}

TEST(FindTheIndexOfTheFirstOccurrenceInAStringTest, stringstr_fail_2) {
    // haystack.length <= 10^4
    auto size = (int) pow(10, 4) + 1;
    string haystack(size, 0);
    auto needle = "leetcode";
    EXPECT_EXIT(FindTheIndexOfTheFirstOccurrenceInAString::stringstr(haystack, needle), ::testing::ExitedWithCode(3),
                "");
}

TEST(FindTheIndexOfTheFirstOccurrenceInAStringTest, stringstr_fail_3) {
    // 1 <= needle.length
    auto size = 1 - 1;
    auto haystack = "leetcode";
    string needle(size, 0);
    EXPECT_EXIT(FindTheIndexOfTheFirstOccurrenceInAString::stringstr(haystack, needle), ::testing::ExitedWithCode(3),
                "");
}

TEST(FindTheIndexOfTheFirstOccurrenceInAStringTest, stringstr_fail_4) {
    // needle.length <= 10^4
    auto size = (int) pow(10, 4) + 1;
    auto haystack = "leetcode";
    string needle(size, 0);
    EXPECT_EXIT(FindTheIndexOfTheFirstOccurrenceInAString::stringstr(haystack, needle), ::testing::ExitedWithCode(3),
                "");
}

#endif
