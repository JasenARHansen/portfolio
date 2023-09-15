#ifndef INTERVIEW_META_PREPARATION_SCOREBOARD_INFERENCE_CHAPTER_1_TEST
#define INTERVIEW_META_PREPARATION_SCOREBOARD_INFERENCE_CHAPTER_1_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/level_1/ScoreboardInference.cpp"  // NOLINT : Ignore .cpp import

TEST(ScoreboardInferenceCh1Test, description) {
    testing::internal::CaptureStdout();
    ScoreboardInference::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ScoreboardInferenceCh1Test, getMinProblemCount_1) {
    auto expected = 4;
    auto n = 10;
    vector<int> s{1, 2, 3, 4, 5, 6};
    auto result = ScoreboardInference::getMinProblemCount(n, s);
    EXPECT_EQ(expected, result);
}

TEST(ScoreboardInferenceCh1Test, getMinProblemCount_2) {
    auto expected = 4;
    auto n = 6;
    vector<int> s{1, 2, 3, 4, 5, 6};
    auto result = ScoreboardInference::getMinProblemCount(n, s);
    EXPECT_EQ(expected, result);
}

TEST(ScoreboardInferenceCh1Test, getMinProblemCount_3) {
    auto expected = 4;
    auto n = 4;
    vector<int> s{2, 4, 6, 8};
    auto result = ScoreboardInference::getMinProblemCount(n, s);
    EXPECT_EQ(expected, result);
}

TEST(ScoreboardInferenceCh1Test, getMinProblemCount_fail_1) {
    // 1 ≤ n
    auto n = 1 - 1;
    vector<int> s{1, 2, 3, 4, 5, 6};
    EXPECT_EXIT(ScoreboardInference::getMinProblemCount(n, s), ::testing::ExitedWithCode(3), "");
}

TEST(ScoreboardInferenceCh1Test, getMinProblemCount_fail_2) {
    // n ≤ 500,000
    auto n = 5 * (int) pow(10, 5) + 1;
    vector<int> s{1, 2, 3, 4, 5, 6};
    EXPECT_EXIT(ScoreboardInference::getMinProblemCount(n, s), ::testing::ExitedWithCode(3), "");
}

TEST(ScoreboardInferenceCh1Test, getMinProblemCount_fail_3) {
    // 1 ≤ si
    auto n = 10;
    auto size = 1 - 1;
    vector<int> s{size, 2, 3, 4, 5, 6};
    EXPECT_EXIT(ScoreboardInference::getMinProblemCount(n, s), ::testing::ExitedWithCode(3), "");
}

TEST(ScoreboardInferenceCh1Test, getMinProblemCount_fail_4) {
    // si ≤ 1,000,000,000
    auto n = 10;
    auto size = (int) pow(10, 9) + 1;
    vector<int> s{size, 2, 3, 4, 5, 6};
    EXPECT_EXIT(ScoreboardInference::getMinProblemCount(n, s), ::testing::ExitedWithCode(3), "");
}

#endif