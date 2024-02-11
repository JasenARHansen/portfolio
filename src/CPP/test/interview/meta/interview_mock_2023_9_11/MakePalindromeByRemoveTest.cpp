#ifndef INTERVIEW_META_INTERVIEW_MOCK_2023_9_11_MAKE_PALINDROME_BY_REMOVE_TEST
#define INTERVIEW_META_INTERVIEW_MOCK_2023_9_11_MAKE_PALINDROME_BY_REMOVE_TEST

#include "gtest/gtest.h"
#include "../../../../code/interview/meta/interview_mock_2023_9_11/MakePalindromeByRemove.cpp"  // NOLINT : Ignore .cpp import

TEST(Interview_MakePalindromeByRemoveTest, description) {
    testing::internal::CaptureStdout();
    MakePalindromeByRemove::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(Interview_MakePalindromeByRemoveTest, makePalindromeWithRemove_1) {
    auto expected = true;
    auto input = "tacocats";
    auto result = MakePalindromeByRemove::makePalindromeWithRemove(input);
    EXPECT_EQ(expected, result);
}

TEST(Interview_MakePalindromeByRemoveTest, makePalindromeWithRemove_2) {
    auto expected = true;
    auto input = "racercar";
    auto result = MakePalindromeByRemove::makePalindromeWithRemove(input);
    EXPECT_EQ(expected, result);
}

TEST(Interview_MakePalindromeByRemoveTest, makePalindromeWithRemove_3) {
    auto expected = true;
    auto input = "baaba";
    auto result = MakePalindromeByRemove::makePalindromeWithRemove(input);
    EXPECT_EQ(expected, result);
}

TEST(Interview_MakePalindromeByRemoveTest, makePalindromeWithRemove_4) {
    auto expected = true;
    auto input = "abaab";
    auto result = MakePalindromeByRemove::makePalindromeWithRemove(input);
    EXPECT_EQ(expected, result);
}

TEST(Interview_MakePalindromeByRemoveTest, makePalindromeWithRemove_5) {
    auto expected = false;
    auto input = "abcd";
    auto result = MakePalindromeByRemove::makePalindromeWithRemove(input);
    EXPECT_EQ(expected, result);
}

TEST(Interview_MakePalindromeByRemoveTest, makePalindromeWithRemove_6) {
    auto expected = false;
    auto input = "btnnure";
    auto result = MakePalindromeByRemove::makePalindromeWithRemove(input);
    EXPECT_EQ(expected, result);
}

TEST(Interview_MakePalindromeByRemoveTest, makePalindromeWithRemove_7) {
    auto expected = true;
    auto input = "aaba";
    auto result = MakePalindromeByRemove::makePalindromeWithRemove(input);
    EXPECT_EQ(expected, result);
}

TEST(Interview_MakePalindromeByRemoveTest, makePalindromeSubstitution_1) {
    auto expected = true;
    auto input = "tacocas";
    auto result = MakePalindromeByRemove::makePalindromeSubstitution(input);
    EXPECT_EQ(expected, result);
}

TEST(Interview_MakePalindromeByRemoveTest, makePalindromeSubstitution_2) {
    auto expected = true;
    auto input = "raXecar";
    auto result = MakePalindromeByRemove::makePalindromeSubstitution(input);
    EXPECT_EQ(expected, result);
}

TEST(Interview_MakePalindromeByRemoveTest, makePalindromeSubstitution_3) {
    auto expected = true;
    auto input = "baaa";
    auto result = MakePalindromeByRemove::makePalindromeSubstitution(input);
    EXPECT_EQ(expected, result);
}

TEST(Interview_MakePalindromeByRemoveTest, makePalindromeSubstitution_4) {
    auto expected = true;
    auto input = "abaabb";
    auto result = MakePalindromeByRemove::makePalindromeSubstitution(input);
    EXPECT_EQ(expected, result);
}

TEST(Interview_MakePalindromeByRemoveTest, makePalindromeSubstitution_5) {
    auto expected = false;
    auto input = "abcd";
    auto result = MakePalindromeByRemove::makePalindromeSubstitution(input);
    EXPECT_EQ(expected, result);
}

TEST(Interview_MakePalindromeByRemoveTest, makePalindromeSubstitution_6) {
    auto expected = false;
    auto input = "btnnure";
    auto result = MakePalindromeByRemove::makePalindromeSubstitution(input);
    EXPECT_EQ(expected, result);
}

TEST(Interview_MakePalindromeByRemoveTest, makePalindromeSubstitution_7) {
    auto expected = true;
    auto input = "aaba";
    auto result = MakePalindromeByRemove::makePalindromeSubstitution(input);
    EXPECT_EQ(expected, result);
}

#endif