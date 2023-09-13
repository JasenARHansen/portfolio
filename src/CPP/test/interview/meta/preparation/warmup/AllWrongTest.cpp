#ifndef INTERVIEW_META_PREPARATION_ALL_WRONG_TEST
#define INTERVIEW_META_PREPARATION_ALL_WRONG_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/warmup/AllWrong.cpp"

TEST(AllWrongTest, description) {
    testing::internal::CaptureStdout();
    AllWrong::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(AllWrongTest, getWrongAnswers_1) {
    auto expected = "BAB";
    auto n = 3;
    auto c = "ABA";
    auto result = AllWrong::getWrongAnswers(n, c);
    EXPECT_EQ(expected, result);
}

TEST(AllWrongTest, getWrongAnswers_2) {
    auto expected = "AAAAA";
    auto n = 5;
    auto c = "BBBBB";
    auto result = AllWrong::getWrongAnswers(n, c);
    EXPECT_EQ(expected, result);
}

TEST(AllWrongTest, getWrongAnswers_fail_1) {
    // 1 ≤ n
    auto n = 1 - 1;
    auto c = "ABA";
    EXPECT_EXIT(AllWrong::getWrongAnswers(n, c), ::testing::ExitedWithCode(3), "");
}

TEST(AllWrongTest, getWrongAnswers_fail_2) {
    // a ≤ 100
    auto n = 100 + 1;
    auto c = "ABA";
    EXPECT_EXIT(AllWrong::getWrongAnswers(n, c), ::testing::ExitedWithCode(3), "");
}

TEST(AllWrongTest, getWrongAnswers_fail_3) {
    // Ci∈{'A','B'}
    auto n = 3;
    auto c = "C";
    EXPECT_EXIT(AllWrong::getWrongAnswers(n, c), ::testing::ExitedWithCode(3), "");
}

#endif