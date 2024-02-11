#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_HEAP_FIND_THE_RUNNING_MEDIAN_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_HEAP_FIND_THE_RUNNING_MEDIAN_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/heap/FindTheRunningMedian.cpp"  // NOLINT : Ignore .cpp import

TEST(HackerRank_FindTheRunningMedianTest, description) {
    testing::internal::CaptureStdout();
    FindTheRunningMedian::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(HackerRank_FindTheRunningMedianTest, runningMedian_1) {
    vector<double> expected{7, 5, 5, 4};
    vector<int> inputs{7, 3, 5, 2};
    auto result = FindTheRunningMedian::runningMedian(inputs);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_FindTheRunningMedianTest, runningMedian_2) {
    vector<double> expected{12, 8, 5, 4.5, 5, 6};
    vector<int> inputs{12, 4, 5, 3, 8, 7};
    auto result = FindTheRunningMedian::runningMedian(inputs);
    EXPECT_EQ(expected, result);
}

#endif