#ifndef INTERVIEW_META_PREPARATION_ENCRYPTED_WORDS_TEST
#define INTERVIEW_META_PREPARATION_ENCRYPTED_WORDS_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/recursion/EncryptedWords.cpp"

TEST(EncryptedWordsTest, description) {
    testing::internal::CaptureStdout();
    EncryptedWords::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(EncryptedWordsTest, findEncryptedWord_1) {
    auto expected = "bac";
    auto s = "abc";
    auto result = EncryptedWords::findEncryptedWord(s);
    EXPECT_EQ(expected, result);
}

TEST(EncryptedWordsTest, findEncryptedWord_2) {
    auto expected = "bacd";
    auto s = "abcd";
    auto result = EncryptedWords::findEncryptedWord(s);
    EXPECT_EQ(expected, result);
}

TEST(EncryptedWordsTest, findEncryptedWord_3) {
    auto expected = "xbacbca";
    auto s = "abcxcba";
    auto result = EncryptedWords::findEncryptedWord(s);
    EXPECT_EQ(expected, result);
}

TEST(EncryptedWordsTest, findEncryptedWord_4) {
    auto expected = "eafcobok";
    auto s = "facebook";
    auto result = EncryptedWords::findEncryptedWord(s);
    EXPECT_EQ(expected, result);
}

#endif