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
    auto expected = false;
    auto ransomNote = "a";
    auto magazine = "b";
    auto result = RansomNote::canConstruct(ransomNote, magazine);
    EXPECT_EQ(expected, result);
}

TEST(RansomNoteTest, canConstruct_2) {
    auto expected = false;
    auto ransomNote = "aa";
    auto magazine = "ab";
    auto result = RansomNote::canConstruct(ransomNote, magazine);
    EXPECT_EQ(expected, result);
}

TEST(RansomNoteTest, canConstruct_3) {
    auto expected = true;
    auto ransomNote = "aa";
    auto magazine = "aab";
    auto result = RansomNote::canConstruct(ransomNote, magazine);
    EXPECT_EQ(expected, result);
}

TEST(RansomNoteTest, canConstruct_fail_1) {
    // 1 <= ransomNote.length
    auto size = 1 - 1;
    string ransomNote(size, ' ');
    auto magazine = "aab";
    EXPECT_EXIT(RansomNote::canConstruct(ransomNote, magazine), ::testing::ExitedWithCode(3), "");
}

TEST(RansomNoteTest, canConstruct_fail_2) {
    // magazine.length <= 10^5
    auto size = (int) pow(10, 5) + 1;
    string ransomNote(size, ' ');
    auto magazine = "aab";
    EXPECT_EXIT(RansomNote::canConstruct(ransomNote, magazine), ::testing::ExitedWithCode(3), "");
}

TEST(RansomNoteTest, canConstruct_fail_3) {
    // 1 <= magazine.length
    auto size = 1 - 1;
    auto ransomNote = "aa";
    string magazine(size, ' ');
    EXPECT_EXIT(RansomNote::canConstruct(ransomNote, magazine), ::testing::ExitedWithCode(3), "");
}

TEST(RansomNoteTest, canConstruct_fail_4) {
    // magazine.length <= 10^5
    auto size = (int) pow(10, 5) + 1;
    auto ransomNote = "aa";
    string magazine(size, ' ');
    EXPECT_EXIT(RansomNote::canConstruct(ransomNote, magazine), ::testing::ExitedWithCode(3), "");
}

#endif