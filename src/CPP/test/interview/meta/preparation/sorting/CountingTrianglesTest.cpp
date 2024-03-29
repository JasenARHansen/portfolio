#ifndef INTERVIEW_META_PREPARATION_COUNTING_TRIANGLES_TEST
#define INTERVIEW_META_PREPARATION_COUNTING_TRIANGLES_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/sorting/CountingTriangles.cpp"  // NOLINT : Ignore .cpp import

TEST(Interview_CountingTrianglesTest, description) {
    testing::internal::CaptureStdout();
    CountingTriangles::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(Interview_CountingTrianglesTest, countDistinctTriangles_1) {
    auto expected = 2;
    vector<sides> arr{{2, 2, 3},
                      {3, 2, 2},
                      {2, 5, 6}};
    auto result = CountingTriangles::countDistinctTriangles(arr);
    EXPECT_EQ(expected, result);
}

TEST(Interview_CountingTrianglesTest, countDistinctTriangles_2) {
    auto expected = 3;
    vector<sides> arr{{8,   4,   6},
                      {100, 101, 102},
                      {84,  93,  173}};
    auto result = CountingTriangles::countDistinctTriangles(arr);
    EXPECT_EQ(expected, result);
}

TEST(Interview_CountingTrianglesTest, countDistinctTriangles_3) {
    auto expected = 1;
    vector<sides> arr{{5, 8, 9},
                      {5, 9, 8},
                      {9, 5, 8},
                      {9, 8, 5},
                      {8, 9, 5},
                      {8, 5, 9}};
    auto result = CountingTriangles::countDistinctTriangles(arr);
    EXPECT_EQ(expected, result);
}

TEST(Interview_CountingTrianglesTest, error_1) {
    // 1 ≤ arr.size()
    auto size = 1 - 1;
    vector<sides> arr(size);
    EXPECT_EXIT(CountingTriangles::countDistinctTriangles(arr), ::testing::ExitedWithCode(3), "");
}

TEST(Interview_CountingTrianglesTest, error_2) {
    // arr.size() ≤ 1,000,000,000
    auto size = (int) pow(10, 6) + 1;
    vector<sides> arr(size);
    EXPECT_EXIT(CountingTriangles::countDistinctTriangles(arr), ::testing::ExitedWithCode(3), "");
}

#endif