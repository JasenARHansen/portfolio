#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_STRING_SPECIAL_STRING_AGAIN_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_STRING_SPECIAL_STRING_AGAIN_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/strings/SpecialStringAgain.cpp"  // NOLINT : Ignore .cpp import

TEST(SpecialStringAgainTest, description) {
    testing::internal::CaptureStdout();
    SpecialStringAgain::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(SpecialStringAgainTest, substrCount_1) {
    auto expected = 1;
    string s = "a";
    auto n = (int) s.length();
    auto result = SpecialStringAgain::substrCount(n, s);
    EXPECT_EQ(expected, result);
}

TEST(SpecialStringAgainTest, substrCount_2) {
    auto expected = 3;
    string s = "aa";
    auto n = (int) s.length();
    auto result = SpecialStringAgain::substrCount(n, s);
    EXPECT_EQ(expected, result);
}

TEST(SpecialStringAgainTest, substrCount_3) {
    auto expected = 4;
    string s = "aba";
    auto n = (int) s.length();
    auto result = SpecialStringAgain::substrCount(n, s);
    EXPECT_EQ(expected, result);
}

TEST(SpecialStringAgainTest, substrCount_4) {
    auto expected = 12;
    string s = "mnonopoo";
    auto n = (int) s.length();
    auto result = SpecialStringAgain::substrCount(n, s);
    EXPECT_EQ(expected, result);
}

TEST(SpecialStringAgainTest, substrCount_5) {
    auto expected = 7;
    string s = "asasd";
    auto n = (int) s.length();
    auto result = SpecialStringAgain::substrCount(n, s);
    EXPECT_EQ(expected, result);
}

TEST(SpecialStringAgainTest, substrCount_6) {
    auto expected = 10;
    string s = "abcbaba";
    auto n = (int) s.length();
    auto result = SpecialStringAgain::substrCount(n, s);
    EXPECT_EQ(expected, result);
}

TEST(SpecialStringAgainTest, substrCount_7) {
    auto expected = 10;
    string s = "aaaa";
    auto n = (int) s.length();
    auto result = SpecialStringAgain::substrCount(n, s);
    EXPECT_EQ(expected, result);
}

#endif