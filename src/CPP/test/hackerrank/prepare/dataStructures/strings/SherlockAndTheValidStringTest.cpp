#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_STRING_SHERLOCK_AND_THE_VALID_STRING_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_STRING_SHERLOCK_AND_THE_VALID_STRING_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/strings/SherlockAndTheValidString.cpp"  // NOLINT : Ignore .cpp import

TEST(SherlockAndTheValidStringTest, description) {
    testing::internal::CaptureStdout();
    SherlockAndTheValidString::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(SherlockAndTheValidStringTest, isValid_1) {
    auto expected = "YES";
    auto s = "abc";
    auto result = SherlockAndTheValidString::isValid(s);
    EXPECT_EQ(expected, result);
}

TEST(SherlockAndTheValidStringTest, isValid_2) {
    auto expected = "YES";
    auto s = "abcc";
    auto result = SherlockAndTheValidString::isValid(s);
    EXPECT_EQ(expected, result);
}

TEST(SherlockAndTheValidStringTest, isValid_3) {
    auto expected = "NO";
    auto s = "abccc";
    auto result = SherlockAndTheValidString::isValid(s);
    EXPECT_EQ(expected, result);
}

TEST(SherlockAndTheValidStringTest, isValid_4) {
    auto expected = "NO";
    auto s = "aabbcd";
    auto result = SherlockAndTheValidString::isValid(s);
    EXPECT_EQ(expected, result);
}

TEST(SherlockAndTheValidStringTest, isValid_5) {
    auto expected = "YES";
    auto s = "abcdefghhgfedecba";
    auto result = SherlockAndTheValidString::isValid(s);
    EXPECT_EQ(expected, result);
}

TEST(SherlockAndTheValidStringTest, isValid_6) {
    auto expected = "NO";
    auto s = "aabbccddeefghi";
    auto result = SherlockAndTheValidString::isValid(s);
    EXPECT_EQ(expected, result);
}

TEST(SherlockAndTheValidStringTest, isValid_7) {
    auto expected = "YES";
    auto s = "abcdefghhgfedecba";
    auto result = SherlockAndTheValidString::isValid(s);
    EXPECT_EQ(expected, result);
}

TEST(SherlockAndTheValidStringTest, isValid_8) {
    auto expected = "YES";
    auto s = "aabbc";
    auto result = SherlockAndTheValidString::isValid(s);
    EXPECT_EQ(expected, result);
}


#endif