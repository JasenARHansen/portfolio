#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_ARRAYS_SPARSE_ARRAY_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_ARRAYS_SPARSE_ARRAY_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/arrays/SparseArray.cpp"  // NOLINT : Ignore .cpp import

TEST(HackerRank_SparseArrayTest, description) {
    testing::internal::CaptureStdout();
    SparseArray::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(HackerRank_SparseArrayTest, matchingStrings_1) {
    vector<int> expected{2, 1, 0};
    vector<string> stringList{"ab", "ab", "abc"};
    vector<string> queries{"ab", "abc", "bc"};
    auto result = SparseArray::matchingStrings(stringList, queries);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_SparseArrayTest, matchingStrings_2) {
    vector<int> expected{2, 1, 0};
    vector<string> stringList{"aba", "baba", "aba", "xzxb"};
    vector<string> queries{"aba", "xzxb", "ab"};
    auto result = SparseArray::matchingStrings(stringList, queries);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_SparseArrayTest, matchingStrings_3) {
    vector<int> expected{1, 0, 1};
    vector<string> stringList{"def", "de", "fgh"};
    vector<string> queries{"de", "lmn", "fgh"};
    auto result = SparseArray::matchingStrings(stringList, queries);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_SparseArrayTest, matchingStrings_4) {
    vector<int> expected{1, 3, 4, 3, 2};
    vector<string> stringList{"abcde", "sdaklfj", "asdjf", "na", "basdn", "sdaklfj", "asdjf", "na", "asdjf", "na",
                              "basdn", "sdaklfj", "asdjf"};
    vector<string> queries{"abcde", "sdaklfj", "asdjf", "na", "basdn"};
    auto result = SparseArray::matchingStrings(stringList, queries);
    EXPECT_EQ(expected, result);
}

#endif
#pragma clang diagnostic pop