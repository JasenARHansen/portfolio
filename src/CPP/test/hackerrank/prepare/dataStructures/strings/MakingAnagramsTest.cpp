#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_STRING_MAKING_ANAGRAMS_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_STRING_MAKING_ANAGRAMS_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/strings/MakingAnagrams.cpp"  // NOLINT : Ignore .cpp import

TEST(HackerRank_MakingAnagramsTest, description) {
    testing::internal::CaptureStdout();
    MakingAnagrams::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(HackerRank_MakingAnagramsTest, makeAnagram_1) {
    auto expected = 2;
    auto a = "cde";
    auto b = "dcf";
    auto result = MakingAnagrams::makeAnagram(a, b);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_MakingAnagramsTest, makeAnagram_2) {
    auto expected = 4;
    auto a = "cde";
    auto b = "abc";
    auto result = MakingAnagrams::makeAnagram(a, b);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_MakingAnagramsTest, makeAnagram_3) {
    auto expected = 30;
    auto a = "fcrxzwscanmligyxyvym";
    auto b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
    auto result = MakingAnagrams::makeAnagram(a, b);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_MakingAnagramsTest, makeAnagram_4) {
    auto expected = 2;
    auto a = "showman";
    auto b = "woman";
    auto result = MakingAnagrams::makeAnagram(a, b);
    EXPECT_EQ(expected, result);
}

#endif