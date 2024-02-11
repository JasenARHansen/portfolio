#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef HACKERRANK_PREPARE_ALGORITHMS_SEARCH_PAIRS_TEST
#define HACKERRANK_PREPARE_ALGORITHMS_SEARCH_PAIRS_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/algorithms/search/Pairs.cpp"  // NOLINT : Ignore .cpp import

TEST(HackerRank_PairsTest, description) {
    testing::internal::CaptureStdout();
    Pairs::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(HackerRank_PairsTest, description_non_unique) {
    testing::internal::CaptureStdout();
    Pairs::description_non_unique();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(HackerRank_PairsTest, pairs_1) {
    auto expected = 3;
    auto k = 1;
    vector<int> arr{1, 2, 3, 4};
    auto result = Pairs::pairs(k, arr);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_PairsTest, pairs_2) {
    auto expected = 3;
    auto k = 2;
    vector<int> arr{1, 5, 3, 4, 2};
    auto result = Pairs::pairs(k, arr);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_PairsTest, pairs_3) {
    auto expected = 5;
    auto k = 2;
    vector<int> arr{1, 3, 5, 8, 6, 4, 2};
    auto result = Pairs::pairs(k, arr);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_PairsTest, pairs_4) {
    auto expected = 0;
    auto k = 1;
    vector<int> arr{363374326, 364147530, 61825163, 1073065718, 1281246024, 1399469912, 428047635, 491595254, 879792181,
                    1069262793};
    auto result = Pairs::pairs(k, arr);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_PairsTest, pairs_non_unique_1) {
    auto expected = 3;
    auto k = 1;
    vector<int> arr{1, 2, 3, 4};
    auto result = Pairs::pairs_non_unique(k, arr);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_PairsTest, pairs_non_unique_2) {
    auto expected = 6;
    auto k = 2;
    vector<int> arr{1, 3, 1, 3, 1};
    auto result = Pairs::pairs_non_unique(k, arr);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_PairsTest, pairs_non_unique_3) {
    auto expected = 18;
    auto k = 2;
    vector<int> arr{1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 2, 3};
    auto result = Pairs::pairs_non_unique(k, arr);
    EXPECT_EQ(expected, result);
}

#endif
#pragma clang diagnostic pop