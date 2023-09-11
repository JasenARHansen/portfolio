#ifndef INTERVIEW_META_2023_9_11_MOCK_QUESTION_1_TEST
#define INTERVIEW_META_2023_9_11_MOCK_QUESTION_1_TEST

#include "gtest/gtest.h"
#include "../../../../code/interview/meta/2023_9_11_mock/First.cpp"

TEST(FirstTest, description) {
    testing::internal::CaptureStdout();
    First::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(FirstTest, makePalindromeWithRemove_1) {
    bool expected = true;
    auto input = "tacocats";
    auto result = First::makePalindromeWithRemove(input);
    EXPECT_EQ(expected, result);
}

TEST(FirstTest, makePalindromeWithRemove_2) {
    bool expected = true;
    auto input = "racercar";
    auto result = First::makePalindromeWithRemove(input);
    EXPECT_EQ(expected, result);
}

TEST(FirstTest, makePalindromeWithRemove_3) {
    bool expected = true;
    auto input = "baaba";
    auto result = First::makePalindromeWithRemove(input);
    EXPECT_EQ(expected, result);
}

TEST(FirstTest, makePalindromeWithRemove_4) {
    bool expected = true;
    auto input = "abaab";
    auto result = First::makePalindromeWithRemove(input);
    EXPECT_EQ(expected, result);
}

TEST(FirstTest, makePalindromeWithRemove_5) {
    bool expected = false;
    auto input = "abcd";
    auto result = First::makePalindromeWithRemove(input);
    EXPECT_EQ(expected, result);
}

TEST(FirstTest, makePalindromeWithRemove_6) {
    bool expected = false;
    auto input = "btnnure";
    auto result = First::makePalindromeWithRemove(input);
    EXPECT_EQ(expected, result);
}

TEST(FirstTest, makePalindromeWithRemove_7) {
    bool expected = true;
    auto input = "aaba";
    auto result = First::makePalindromeWithRemove(input);
    EXPECT_EQ(expected, result);
}

TEST(FirstTest, makePalindromeSubstitution_1) {
    bool expected = true;
    auto input = "tacocas";
    auto result = First::makePalindromeSubstitution(input);
    EXPECT_EQ(expected, result);
}

TEST(FirstTest, makePalindromeSubstitution_2) {
    bool expected = true;
    auto input = "raXecar";
    auto result = First::makePalindromeSubstitution(input);
    EXPECT_EQ(expected, result);
}

TEST(FirstTest, makePalindromeSubstitution_3) {
    bool expected = true;
    auto input = "baaa";
    auto result = First::makePalindromeSubstitution(input);
    EXPECT_EQ(expected, result);
}

TEST(FirstTest, makePalindromeSubstitution_4) {
    bool expected = true;
    auto input = "abaabb";
    auto result = First::makePalindromeSubstitution(input);
    EXPECT_EQ(expected, result);
}

TEST(FirstTest, makePalindromeSubstitution_5) {
    bool expected = false;
    auto input = "abcd";
    auto result = First::makePalindromeSubstitution(input);
    EXPECT_EQ(expected, result);
}

TEST(FirstTest, makePalindromeSubstitution_6) {
    bool expected = false;
    auto input = "btnnure";
    auto result = First::makePalindromeSubstitution(input);
    EXPECT_EQ(expected, result);
}

TEST(FirstTest, makePalindromeSubstitution_7) {
    bool expected = true;
    auto input = "aaba";
    auto result = First::makePalindromeSubstitution(input);
    EXPECT_EQ(expected, result);
}

#endif