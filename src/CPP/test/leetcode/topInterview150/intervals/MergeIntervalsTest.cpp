#ifndef LEETCODE_TOP_INTERVIEW_150_MERGE_INTERVALS_TEST
#define LEETCODE_TOP_INTERVIEW_150_MERGE_INTERVALS_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/intervals/MergeIntervals.cpp"

TEST(MergeIntervalsTest, description) {
    testing::internal::CaptureStdout();
    MergeIntervals::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(MergeIntervalsTest, merge_1) {
    vector<vector<int>> expected{{1,  6},
                                 {8,  10},
                                 {15, 18}};
    vector<vector<int>> intervals{{1,  3},
                                  {2,  6},
                                  {8,  10},
                                  {15, 18}};
    auto result = MergeIntervals::merge(intervals);
    EXPECT_EQ(expected, result);
}

TEST(MergeIntervalsTest, merge_2) {
    vector<vector<int>> expected{{1, 5}};
    vector<vector<int>> intervals{{1, 4},
                                  {4, 5}};
    auto result = MergeIntervals::merge(intervals);
    EXPECT_EQ(expected, result);
}

TEST(MergeIntervalsTest, merge_3) {
    vector<vector<int>> expected{{1,  6},
                                 {8,  10},
                                 {15, 18}};
    vector<vector<int>> intervals{{15, 18},
                                  {8,  10},
                                  {2,  6},
                                  {1,  3}};
    auto result = MergeIntervals::merge(intervals);
    EXPECT_EQ(expected, result);
}

TEST(MergeIntervalsTest, merge_fail_1) {
    // 1 <= intervals.length
    auto size = 1 - 1;
    vector<vector<int>> intervals(size);
    EXPECT_EXIT(MergeIntervals::merge(intervals), ::testing::ExitedWithCode(3), "");
}

TEST(MergeIntervalsTest, merge_fail_2) {
    // intervals.length <= 10^4
    auto size = (int) pow(10, 4) + 1;
    vector<vector<int>> intervals(size);
    EXPECT_EXIT(MergeIntervals::merge(intervals), ::testing::ExitedWithCode(3), "");
}

TEST(MergeIntervalsTest, merge_fail_3) {
    // intervals[i].length == 2
    vector<vector<int>> intervals{vector<int>()};
    EXPECT_EXIT(MergeIntervals::merge(intervals), ::testing::ExitedWithCode(3), "");
}

TEST(MergeIntervalsTest, merge_fail_4) {
    //  0 <= starti
    auto starti = 0 - 1;
    auto endi = (int) pow(10, 4);
    vector<vector<int>> intervals{{starti, endi}};
    EXPECT_EXIT(MergeIntervals::merge(intervals), ::testing::ExitedWithCode(3), "");
}

TEST(MergeIntervalsTest, merge_fail_5) {
    // starti <= 10^4
    auto starti = (int) pow(10, 4) + 1;
    auto endi = (int) pow(10, 4);
    vector<vector<int>> intervals{{starti, endi}};
    EXPECT_EXIT(MergeIntervals::merge(intervals), ::testing::ExitedWithCode(3), "");
}

TEST(MergeIntervalsTest, merge_fail_6) {
    // 0 <= endi
    auto starti = (int) pow(10, 4);
    auto endi = 0 - 1;
    vector<vector<int>> intervals{{starti, endi}};
    EXPECT_EXIT(MergeIntervals::merge(intervals), ::testing::ExitedWithCode(3), "");
}

TEST(MergeIntervalsTest, merge_fail_7) {
    // endi <= 10^4
    auto starti = (int) pow(10, 4);
    auto endi = (int) pow(10, 4) + 1;
    vector<vector<int>> intervals{{starti, endi}};
    EXPECT_EXIT(MergeIntervals::merge(intervals), ::testing::ExitedWithCode(3), "");
}

TEST(MergeIntervalsTest, merge_fail_8) {
    // starti <= endi
    auto starti = (int) pow(10, 4);
    auto endi = (int) pow(10, 4) - 1;
    vector<vector<int>> intervals{{starti, endi}};
    EXPECT_EXIT(MergeIntervals::merge(intervals), ::testing::ExitedWithCode(3), "");
}

TEST(MergeIntervalsTest, mergeNoSort_1) {
    vector<vector<int>> expected{{1,  6},
                                 {8,  10},
                                 {15, 18}};
    vector<vector<int>> intervals{{1,  3},
                                  {2,  6},
                                  {8,  10},
                                  {15, 18}};
    auto result = MergeIntervals::mergeNoSort(intervals);
    EXPECT_EQ(expected, result);
}

TEST(MergeIntervalsTest, mergeNoSort_2) {
    vector<vector<int>> expected{{1, 5}};
    vector<vector<int>> intervals{{1, 4},
                                  {4, 5}};
    auto result = MergeIntervals::mergeNoSort(intervals);
    EXPECT_EQ(expected, result);
}

TEST(MergeIntervalsTest, mergeNoSort_3) {
    vector<vector<int>> expected{{1,  6},
                                 {8,  10},
                                 {15, 18}};
    vector<vector<int>> intervals{{15, 18},
                                  {8,  10},
                                  {2,  6},
                                  {1,  3}};
    auto result = MergeIntervals::mergeNoSort(intervals);
    EXPECT_EQ(expected, result);
}

TEST(MergeIntervalsTest, mergeNoSort_fail_1) {
    // 1 <= intervals.length
    auto size = 1 - 1;
    vector<vector<int>> intervals(size);
    EXPECT_EXIT(MergeIntervals::mergeNoSort(intervals), ::testing::ExitedWithCode(3), "");
}

TEST(MergeIntervalsTest, mergeNoSort_fail_2) {
    // intervals.length <= 10^4
    auto size = (int) pow(10, 4) + 1;
    vector<vector<int>> intervals(size);
    EXPECT_EXIT(MergeIntervals::mergeNoSort(intervals), ::testing::ExitedWithCode(3), "");
}

TEST(MergeIntervalsTest, mergeNoSort_fail_3) {
    // intervals[i].length == 2
    vector<vector<int>> intervals{vector<int>()};
    EXPECT_EXIT(MergeIntervals::mergeNoSort(intervals), ::testing::ExitedWithCode(3), "");
}

TEST(MergeIntervalsTest, mergeNoSort_fail_4) {
    //  0 <= starti
    auto starti = 0 - 1;
    auto endi = (int) pow(10, 4);
    vector<vector<int>> intervals{{starti, endi}};
    EXPECT_EXIT(MergeIntervals::mergeNoSort(intervals), ::testing::ExitedWithCode(3), "");
}

TEST(MergeIntervalsTest, mergeNoSort_fail_5) {
    // starti <= 10^4
    auto starti = (int) pow(10, 4) + 1;
    auto endi = (int) pow(10, 4);
    vector<vector<int>> intervals{{starti, endi}};
    EXPECT_EXIT(MergeIntervals::mergeNoSort(intervals), ::testing::ExitedWithCode(3), "");
}

TEST(MergeIntervalsTest, mergeNoSort_fail_6) {
    // 0 <= endi
    auto starti = (int) pow(10, 4);
    auto endi = 0 - 1;
    vector<vector<int>> intervals{{starti, endi}};
    EXPECT_EXIT(MergeIntervals::mergeNoSort(intervals), ::testing::ExitedWithCode(3), "");
}

TEST(MergeIntervalsTest, mergeNoSort_fail_7) {
    // endi <= 10^4
    auto starti = (int) pow(10, 4);
    auto endi = (int) pow(10, 4) + 1;
    vector<vector<int>> intervals{{starti, endi}};
    EXPECT_EXIT(MergeIntervals::mergeNoSort(intervals), ::testing::ExitedWithCode(3), "");
}

TEST(MergeIntervalsTest, mergeNoSort_fail_8) {
    // starti <= endi
    auto starti = (int) pow(10, 4);
    auto endi = (int) pow(10, 4) - 1;
    vector<vector<int>> intervals{{starti, endi}};
    EXPECT_EXIT(MergeIntervals::mergeNoSort(intervals), ::testing::ExitedWithCode(3), "");
}

#endif