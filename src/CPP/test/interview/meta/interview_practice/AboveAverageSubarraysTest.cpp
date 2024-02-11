#ifndef INTERVIEW_META_PREPARATION_INTERVIEW_PRACTICE_ABOVE_AVERAGE_SUB_ARRAYS_TEST
#define INTERVIEW_META_PREPARATION_INTERVIEW_PRACTICE_ABOVE_AVERAGE_SUB_ARRAYS_TEST

#include "gtest/gtest.h"
#include "../../../../code/interview/meta/interview_practice/AboveAverageSubArrays.cpp"  // NOLINT : Ignore .cpp import

TEST(Interview_AboveAverageSubArraysTest, description) {
    testing::internal::CaptureStdout();
    AboveAverageSubArrays::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(Interview_AboveAverageSubArraysTest, aboveAverageSubArrays_1) {
    vector<vector<int>> expected{{1, 2},
                                 {1, 3},
                                 {2, 2}};
    vector<int> a = {3, 4, 2};
    auto result = AboveAverageSubArrays::aboveAverageSubArrays(a);
    EXPECT_EQ(expected, result);
}

#endif