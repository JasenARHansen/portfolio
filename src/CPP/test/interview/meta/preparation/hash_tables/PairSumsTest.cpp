#ifndef INTERVIEW_META_PREPARATION_PAIR_SUMS_TEST
#define INTERVIEW_META_PREPARATION_PAIR_SUMS_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/hash_tables/PairSums.cpp"

TEST(PairSumsTest, description) {
    testing::internal::CaptureStdout();
    PairSums::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(PairSumsTest, findMaxProduct_1) {
    int expected = 2;
    vector<int> arr{1, 2, 3, 4, 3};
    auto k = 6;
    auto result = PairSums::numberOfWays(arr, k);
    EXPECT_EQ(expected, result);
}

TEST(PairSumsTest, findMaxProduct_2) {
    int expected = 4;
    vector<int> arr{1, 5, 3, 3, 3};
    auto k = 6;
    auto result = PairSums::numberOfWays(arr, k);
    EXPECT_EQ(expected, result);
}

#endif