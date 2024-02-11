#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_STRING_ALTERNATING_CHARACTERS_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_STRING_ALTERNATING_CHARACTERS_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/strings/AlternatingCharacters.cpp"  // NOLINT : Ignore .cpp import

TEST(HackerRank_AlternatingCharactersTest, description) {
    testing::internal::CaptureStdout();
    AlternatingCharacters::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(HackerRank_AlternatingCharactersTest, alternatingCharacters_1) {
    auto expected = 2;
    auto s = "AABAAB";
    auto result = AlternatingCharacters::alternatingCharacters(s);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_AlternatingCharactersTest, alternatingCharacters_2) {
    auto expected = 3;
    auto s = "AAAA";
    auto result = AlternatingCharacters::alternatingCharacters(s);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_AlternatingCharactersTest, alternatingCharacters_3) {
    auto expected = 4;
    auto s = "BBBBB";
    auto result = AlternatingCharacters::alternatingCharacters(s);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_AlternatingCharactersTest, alternatingCharacters_4) {
    auto expected = 0;
    auto s = "ABABABAB";
    auto result = AlternatingCharacters::alternatingCharacters(s);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_AlternatingCharactersTest, alternatingCharacters_5) {
    auto expected = 0;
    auto s = "BABABA";
    auto result = AlternatingCharacters::alternatingCharacters(s);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_AlternatingCharactersTest, alternatingCharacters_6) {
    auto expected = 4;
    auto s = "AAABBB";
    auto result = AlternatingCharacters::alternatingCharacters(s);
    EXPECT_EQ(expected, result);
}

#endif