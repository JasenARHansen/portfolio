#ifndef INTERVIEW_META_PREPARATION_PRACTICE_INTERVIEW_ABOVE_AVERAGE_SUB_ARRAYS_TEST
#define INTERVIEW_META_PREPARATION_PRACTICE_INTERVIEW_ABOVE_AVERAGE_SUB_ARRAYS_TEST

#include "gtest/gtest.h"
#include "../../../../code/interview/meta/practice_interview/AboveAverageSubArrays.cpp"

TEST(AboveAverageSubArraysTest, description) {
    testing::internal::CaptureStdout();
    AboveAverageSubArrays::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(AboveAverageSubArraysTest, aboveAverageSubArrays_1) {
    vector<vector<int>> expected{{1, 2},
                                 {1, 3},
                                 {2, 2}};
    vector<int> a = {3, 4, 2};
    auto result = AboveAverageSubArrays::aboveAverageSubArrays(a);
    EXPECT_EQ(expected, result);
}

#endif