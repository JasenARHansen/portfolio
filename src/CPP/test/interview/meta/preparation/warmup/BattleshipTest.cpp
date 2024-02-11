#ifndef INTERVIEW_META_PREPARATION_BATTLESHIP_TEST
#define INTERVIEW_META_PREPARATION_BATTLESHIP_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/warmup/Battleship.cpp"  // NOLINT : Ignore .cpp import

TEST(Interview_BattleshipTest, description) {
    testing::internal::CaptureStdout();
    Battleship::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(Interview_BattleshipTest, getHitProbability_1) {
    auto expected = 0.50000000;
    auto r = 2;
    auto c = 3;
    vector<vector<int>> g{{0, 0, 1},
                          {1, 0, 1}};
    auto result = Battleship::getHitProbability(r, c, g);
    EXPECT_EQ(expected, result);
}

TEST(Interview_BattleshipTest, getHitProbability_2) {
    auto expected = 1.00000000;
    auto r = 2;
    auto c = 2;
    vector<vector<int>> g{{1, 1},
                          {1, 1}};
    auto result = Battleship::getHitProbability(r, c, g);
    EXPECT_EQ(expected, result);
}

TEST(Interview_BattleshipTest, getHitProbability_fail_1) {
    // 1 ≤ r
    auto r = 1 - 1;
    auto c = 3;
    vector<vector<int>> g{{0, 0, 1},
                          {1, 0, 1}};
    EXPECT_EXIT(Battleship::getHitProbability(r, c, g), ::testing::ExitedWithCode(3), "");
}

TEST(Interview_BattleshipTest, getHitProbability_fail_2) {
    // r ≤ 100
    auto r = 100 + 1;
    auto c = 3;
    vector<vector<int>> g{{0, 0, 1},
                          {1, 0, 1}};
    EXPECT_EXIT(Battleship::getHitProbability(r, c, g), ::testing::ExitedWithCode(3), "");
}

TEST(Interview_BattleshipTest, getHitProbability_fail_3) {
    // 1 ≤ c
    auto r = 3;
    auto c = 1 - 1;
    vector<vector<int>> g{{0, 0, 1},
                          {1, 0, 1}};
    EXPECT_EXIT(Battleship::getHitProbability(r, c, g), ::testing::ExitedWithCode(3), "");
}

TEST(Interview_BattleshipTest, getHitProbability_fail_4) {
    // c ≤ 100
    auto r = 3;
    auto c = 100 + 1;
    vector<vector<int>> g{{0, 0, 1},
                          {1, 0, 1}};
    EXPECT_EXIT(Battleship::getHitProbability(r, c, g), ::testing::ExitedWithCode(3), "");
}

TEST(Interview_BattleshipTest, getHitProbability_fail_5) {
    // 1 ≤ g.length
    auto r = 3;
    auto c = 3;
    auto size = 1 - 1;
    vector<vector<int>> g(size);
    EXPECT_EXIT(Battleship::getHitProbability(r, c, g), ::testing::ExitedWithCode(3), "");
}

TEST(Interview_BattleshipTest, getHitProbability_fail_6) {
    // g.length ≤ 100
    auto r = 3;
    auto c = 3;
    auto size = 100 + 1;
    vector<vector<int>> g(size);
    EXPECT_EXIT(Battleship::getHitProbability(r, c, g), ::testing::ExitedWithCode(3), "");
}

TEST(Interview_BattleshipTest, getHitProbability_fail_7) {
    // 1 ≤ g[i].length
    auto r = 3;
    auto c = 3;
    auto size = 1 - 1;
    vector<vector<int>> g{vector<int>(size)};
    EXPECT_EXIT(Battleship::getHitProbability(r, c, g), ::testing::ExitedWithCode(3), "");
}

TEST(Interview_BattleshipTest, getHitProbability_fail_8) {
    // g[i].length ≤ 100
    auto r = 3;
    auto c = 3;
    auto size = 100 + 1;
    vector<vector<int>> g{vector<int>(size)};
    EXPECT_EXIT(Battleship::getHitProbability(r, c, g), ::testing::ExitedWithCode(3), "");
}

#endif