#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_RANSOM_NOTE_TEST
#define LEETCODE_TOP_INTERVIEW_150_RANSOM_NOTE_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/hashmap/RansomNote.cpp"

TEST(RansomNoteTest, description) {
    testing::internal::CaptureStdout();
    RansomNote::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(RansomNoteTest, canConstruct_1) {
    bool expected = false;
    string ransomNote = "a";
    string magazine = "b";
    bool result = RansomNote::canConstruct(ransomNote, magazine);
    EXPECT_EQ(expected, result);
}

TEST(RansomNoteTest, canConstruct_2) {
    bool expected = false;
    string ransomNote = "aa";
    string magazine = "ab";
    bool result = RansomNote::canConstruct(ransomNote, magazine);
    EXPECT_EQ(expected, result);
}

TEST(RansomNoteTest, canConstruct_3) {
    bool expected = true;
    string ransomNote = "aa";
    string magazine = "aab";
    bool result = RansomNote::canConstruct(ransomNote, magazine);
    EXPECT_EQ(expected, result);
}

TEST(RansomNoteTest, canConstruct_fail_1) {
    // 1 <= ransomNote.length
    int size = 1 - 1;
    string ransomNote(size, ' ');
    string magazine = "aab";
    EXPECT_EXIT(bool result = RansomNote::canConstruct(ransomNote, magazine), ::testing::ExitedWithCode(3), "");
}

TEST(RansomNoteTest, canConstruct_fail_2) {
    // magazine.length <= 10^5
    int size = pow(10, 5) + 1;
    string ransomNote(size, ' ');
    string magazine = "aab";
    EXPECT_EXIT(bool result = RansomNote::canConstruct(ransomNote, magazine), ::testing::ExitedWithCode(3), "");
}

TEST(RansomNoteTest, canConstruct_fail_3) {
    // 1 <= magazine.length
    int size = 1 - 1;
    string ransomNote = "aa";
    string magazine(size, ' ');
    EXPECT_EXIT(bool result = RansomNote::canConstruct(ransomNote, magazine), ::testing::ExitedWithCode(3), "");
}

TEST(RansomNoteTest, canConstruct_fail_4) {
    // magazine.length <= 10^5
    int size = pow(10, 5) + 1;
    string ransomNote = "aa";
    string magazine(size, ' ');
    EXPECT_EXIT(bool result = RansomNote::canConstruct(ransomNote, magazine), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop