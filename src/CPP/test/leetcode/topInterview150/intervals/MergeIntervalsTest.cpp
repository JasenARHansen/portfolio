#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
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
    vector<vector<int>> result = MergeIntervals::merge(intervals);
    EXPECT_EQ(expected, result);
}

TEST(MergeIntervalsTest, merge_2) {
    vector<vector<int>> expected{{1, 5}};
    vector<vector<int>> intervals{{1, 4},
                                  {4, 5}};
    vector<vector<int>> result = MergeIntervals::merge(intervals);
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
    vector<vector<int>> result = MergeIntervals::merge(intervals);
    EXPECT_EQ(expected, result);
}


TEST(MergeIntervalsTest, merge_fail_1) {
    // 1 <= intervals.length
    int size = 1 - 1;
    vector<vector<int>> intervals(size);
    EXPECT_EXIT(MergeIntervals::merge(intervals), ::testing::ExitedWithCode(3), "");
}

TEST(MergeIntervalsTest, merge_fail_2) {
    // intervals.length <= 10^4
    int size = pow(10, 4) + 1;
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
    int starti = 0 - 1;
    int endi = pow(10, 4);
    vector<vector<int>> intervals{{starti, endi}};
    EXPECT_EXIT(MergeIntervals::merge(intervals), ::testing::ExitedWithCode(3), "");
}

TEST(MergeIntervalsTest, merge_fail_5) {
    // starti <= 10^4
    int starti = pow(10, 4) + 1;
    int endi = pow(10, 4);
    vector<vector<int>> intervals{{starti, endi}};
    EXPECT_EXIT(MergeIntervals::merge(intervals), ::testing::ExitedWithCode(3), "");
}

TEST(MergeIntervalsTest, merge_fail_6) {
    // 0 <= endi
    int starti = pow(10, 4);
    int endi = 0 - 1;
    vector<vector<int>> intervals{{starti, endi}};
    EXPECT_EXIT(MergeIntervals::merge(intervals), ::testing::ExitedWithCode(3), "");
}

TEST(MergeIntervalsTest, merge_fail_7) {
    // endi <= 10^4
    int starti = pow(10, 4);
    int endi = pow(10, 4) + 1;
    vector<vector<int>> intervals{{starti, endi}};
    EXPECT_EXIT(MergeIntervals::merge(intervals), ::testing::ExitedWithCode(3), "");
}

TEST(MergeIntervalsTest, merge_fail_8) {
    // starti <= endi
    int starti = pow(10, 4);
    int endi = pow(10, 4) - 1;
    vector<vector<int>> intervals{{starti, endi}};
    EXPECT_EXIT(MergeIntervals::merge(intervals), ::testing::ExitedWithCode(3), "");
}


#endif
#pragma clang diagnostic pop