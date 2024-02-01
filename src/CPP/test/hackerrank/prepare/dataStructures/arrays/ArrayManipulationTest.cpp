#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_ARRAYS_ARRAY_MANIPULATION_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_ARRAYS_ARRAY_MANIPULATION_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/arrays/ArrayManipulation.cpp"  // NOLINT : Ignore .cpp import

TEST(ArrayManipulationTest, description) {
    testing::internal::CaptureStdout();
    ArrayManipulation::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ArrayManipulationTest, arrayManipulation_1) {
    long expected = 10;
    auto n = 10;
    vector<vector<int>> queries{{1, 5, 3},
                                {4, 8, 7},
                                {6, 9, 1}};
    auto result = ArrayManipulation::arrayManipulation(n, queries);
    EXPECT_EQ(expected, result);
}

TEST(ArrayManipulationTest, arrayManipulation_2) {
    long expected = 200;
    auto n = 5;
    vector<vector<int>> queries{{1, 2, 100},
                                {2, 5, 100},
                                {3, 4, 100}};
    auto result = ArrayManipulation::arrayManipulation(n, queries);
    EXPECT_EQ(expected, result);
}

TEST(ArrayManipulationTest, arrayManipulation_3) {
    long expected = 200;
    auto n = 5;
    vector<vector<int>> queries{{1, 2, 100},
                                {2, 5, 100},
                                {3, 4, 100}};
    auto result = ArrayManipulation::arrayManipulation(n, queries);
    EXPECT_EQ(expected, result);
}

TEST(ArrayManipulationTest, arrayManipulation_4) {
    long expected = 31;
    auto n = 10;
    vector<vector<int>> queries{{2, 6, 8},
                                {3, 5, 7},
                                {1, 8, 1},
                                {5, 9, 15}};
    auto result = ArrayManipulation::arrayManipulation(n, queries);
    EXPECT_EQ(expected, result);
}

TEST(ArrayManipulationTest, arrayManipulation2_1) {
    long expected = 10;
    auto n = 10;
    vector<vector<int>> queries{{1, 5, 3},
                                {4, 8, 7},
                                {6, 9, 1}};
    auto result = ArrayManipulation::arrayManipulation2(n, queries);
    EXPECT_EQ(expected, result);
}

TEST(ArrayManipulationTest, arrayManipulation2_2) {
    long expected = 200;
    auto n = 5;
    vector<vector<int>> queries{{1, 2, 100},
                                {2, 5, 100},
                                {3, 4, 100}};
    auto result = ArrayManipulation::arrayManipulation2(n, queries);
    EXPECT_EQ(expected, result);
}

TEST(ArrayManipulationTest, arrayManipulation2_3) {
    long expected = 200;
    auto n = 5;
    vector<vector<int>> queries{{1, 2, 100},
                                {2, 5, 100},
                                {3, 4, 100}};
    auto result = ArrayManipulation::arrayManipulation2(n, queries);
    EXPECT_EQ(expected, result);
}

TEST(ArrayManipulationTest, arrayManipulation2_4) {
    long expected = 31;
    auto n = 10;
    vector<vector<int>> queries{{2, 6, 8},
                                {3, 5, 7},
                                {1, 8, 1},
                                {5, 9, 15}};
    auto result = ArrayManipulation::arrayManipulation2(n, queries);
    EXPECT_EQ(expected, result);
}


#endif
#pragma clang diagnostic pop