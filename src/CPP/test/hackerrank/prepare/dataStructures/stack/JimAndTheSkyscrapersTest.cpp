#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_STACKS_JIM_AND_THE_SKYSCRAPERS_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_STACKS_JIM_AND_THE_SKYSCRAPERS_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/stack/JimAndTheSkyscrapers.cpp"  // NOLINT : Ignore .cpp import

TEST(HackerRank_JimAndTheSkyscrapersTest, description) {
    testing::internal::CaptureStdout();
    JimAndTheSkyscrapers::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(HackerRank_JimAndTheSkyscrapersTest, solve_1) {
    auto expected = 8;
    vector<int> arr{3, 2, 1, 2, 3, 3};
    auto result = JimAndTheSkyscrapers::solve(arr);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_JimAndTheSkyscrapersTest, solve_2) {
    auto expected = 0;
    vector<int> arr{1, 1000, 1};
    auto result = JimAndTheSkyscrapers::solve(arr);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_JimAndTheSkyscrapersTest, solve_3) {
    auto expected = 0;
    vector<int> arr{1};
    auto result = JimAndTheSkyscrapers::solve(arr);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_JimAndTheSkyscrapersTest, solve_4) {
    auto expected = 0;
    vector<int> arr{5, 4, 3, 2, 1};
    auto result = JimAndTheSkyscrapers::solve(arr);
    EXPECT_EQ(expected, result);
}

#endif