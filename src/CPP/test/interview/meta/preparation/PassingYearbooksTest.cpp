#ifndef INTERVIEW_META_PREPARATION_PASSING_YEARBOOKS_TEST
#define INTERVIEW_META_PREPARATION_PASSING_YEARBOOKS_TEST

#include "gtest/gtest.h"
#include "../../../../code/interview/meta/preparation/PassingYearbooks.cpp"

TEST(PassingYearbooksTest, description) {
    testing::internal::CaptureStdout();
    PassingYearbooks::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(PassingYearbooksTest, findSignatureCounts_1) {
    vector<int> expected{2, 2};
    vector<int> arr{2, 1};
    auto result = PassingYearbooks::findSignatureCounts(arr);
    EXPECT_EQ(expected, result);
}

TEST(PassingYearbooksTest, findSignatureCounts_2) {
    vector<int> expected{1, 1};
    vector<int> arr{1, 2};
    auto result = PassingYearbooks::findSignatureCounts(arr);
    EXPECT_EQ(expected, result);
}

TEST(PassingYearbooksTest, findSignatureCounts_3) {
    vector<int> expected{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    vector<int> arr{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    auto result = PassingYearbooks::findSignatureCounts(arr);
    EXPECT_EQ(expected, result);
}

TEST(PassingYearbooksTest, findSignatureCounts_4) {
    vector<int> expected{2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
    vector<int> arr{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    auto result = PassingYearbooks::findSignatureCounts(arr);
    EXPECT_EQ(expected, result);
}

TEST(PassingYearbooksTest, findSignatureCounts_5) {
    vector<int> expected{};
    vector<int> arr{};
    auto result = PassingYearbooks::findSignatureCounts(arr);
    EXPECT_EQ(expected, result);
}

TEST(PassingYearbooksTest, findSignatureCounts_6) {
    vector<int> expected{3, 3, 3};
    vector<int> arr{3, 1, 2};
    auto result = PassingYearbooks::findSignatureCounts(arr);
    EXPECT_EQ(expected, result);
}

TEST(PassingYearbooksTest, findSignatureCounts_7) {
    vector<int> expected{2, 2, 1};
    vector<int> arr{2, 1, 3};
    auto result = PassingYearbooks::findSignatureCounts(arr);
    EXPECT_EQ(expected, result);
}

#endif