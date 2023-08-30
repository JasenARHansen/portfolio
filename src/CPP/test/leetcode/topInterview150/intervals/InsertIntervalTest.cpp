#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_INSERT_INTERVAL_TEST
#define LEETCODE_TOP_INTERVIEW_150_INSERT_INTERVAL_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/intervals/InsertInterval.cpp"

TEST(InsertIntervalTest, description) {
    testing::internal::CaptureStdout();
    InsertInterval::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(InsertIntervalTest, insert_1) {
    vector<vector<int>> expected{{1, 5},
                                 {6, 9}};
    vector<vector<int>> intervals{{1, 3},
                                  {6, 9}};
    vector<int> newInterval = {2, 5};
    vector<vector<int>> result = InsertInterval::insert(intervals, newInterval);
    EXPECT_EQ(expected, result);
}

TEST(InsertIntervalTest, insert_2) {
    vector<vector<int>> expected{{1,  2},
                                 {3,  10},
                                 {12, 16}};
    vector<vector<int>> intervals{{1,  2},
                                  {3,  5},
                                  {6,  7},
                                  {8,  10},
                                  {12, 16}};
    vector<int> newInterval = {4, 8};
    vector<vector<int>> result = InsertInterval::insert(intervals, newInterval);
    EXPECT_EQ(expected, result);
}

TEST(InsertIntervalTest, insert_3) {
    vector<vector<int>> expected{{0, 10}};
    vector<vector<int>> intervals{{2, 5},
                                  {6, 7},
                                  {8, 9}};
    vector<int> newInterval = {0, 10};
    vector<vector<int>> result = InsertInterval::insert(intervals, newInterval);
    EXPECT_EQ(expected, result);
}

TEST(InsertIntervalTest, insert_4) {
    vector<vector<int>> expected{{1, 7}};
    vector<vector<int>> intervals{{1, 5}};
    vector<int> newInterval = {2, 7};
    vector<vector<int>> result = InsertInterval::insert(intervals, newInterval);
    EXPECT_EQ(expected, result);
}

TEST(InsertIntervalTest, insert_fail_1) {
    // intervals.length <= 10^4
    int size = pow(10, 4) + 1;
    vector<vector<int>> intervals(size);
    vector<int> newInterval = {4, 8};
    EXPECT_EXIT(InsertInterval::insert(intervals, newInterval), ::testing::ExitedWithCode(3), "");
}

TEST(InsertIntervalTest, insert_fail_2) {
    // intervals[i].length == 2
    int size = 2 - 1;
    vector<vector<int>> intervals{vector<int>(size)};
    vector<int> newInterval = {4, 8};
    EXPECT_EXIT(InsertInterval::insert(intervals, newInterval), ::testing::ExitedWithCode(3), "");
}

TEST(InsertIntervalTest, insert_fail_3) {
    //  0 <= starti
    int starti = 0 - 1;
    int endi = pow(10, 5);
    vector<vector<int>> intervals{{starti, endi}};
    vector<int> newInterval = {4, 8};
    EXPECT_EXIT(InsertInterval::insert(intervals, newInterval), ::testing::ExitedWithCode(3), "");
}

TEST(InsertIntervalTest, insert_fail_4) {
    // starti <= 10^5
    int starti = pow(10, 5) + 1;
    int endi = pow(10, 5);
    vector<vector<int>> intervals{{starti, endi}};
    vector<int> newInterval = {4, 8};
    EXPECT_EXIT(InsertInterval::insert(intervals, newInterval), ::testing::ExitedWithCode(3), "");
}

TEST(InsertIntervalTest, insert_fail_5) {
    // 0 <= endi
    int starti = pow(10, 5);
    int endi = 0 - 1;
    vector<vector<int>> intervals{{starti, endi}};
    vector<int> newInterval = {4, 8};
    EXPECT_EXIT(InsertInterval::insert(intervals, newInterval), ::testing::ExitedWithCode(3), "");
}

TEST(InsertIntervalTest, insert_fail_6) {
    // endi <= 10^5
    int starti = pow(10, 5);
    int endi = pow(10, 5) + 1;
    vector<vector<int>> intervals{{starti, endi}};
    vector<int> newInterval = {4, 8};
    EXPECT_EXIT(InsertInterval::insert(intervals, newInterval), ::testing::ExitedWithCode(3), "");
}

TEST(InsertIntervalTest, insert_fail_7) {
    // starti <= endi
    int starti = pow(10, 5);
    int endi = pow(10, 5) - 1;
    vector<vector<int>> intervals{{starti, endi}};
    vector<int> newInterval = {4, 8};
    EXPECT_EXIT(InsertInterval::insert(intervals, newInterval), ::testing::ExitedWithCode(3), "");
}

TEST(InsertIntervalTest, insert_fail_8) {
    // newInterval.length == 2
    vector<vector<int>> intervals{};
    int size = 2 - 1;
    vector<int> newInterval{size};
    EXPECT_EXIT(InsertInterval::insert(intervals, newInterval), ::testing::ExitedWithCode(3), "");
}

TEST(InsertIntervalTest, insert_fail_9) {
    //  0 <= starti
    int starti = 0 - 1;
    int endi = pow(10, 5);
    vector<vector<int>> intervals{};
    vector<int> newInterval = {starti, endi};
    EXPECT_EXIT(InsertInterval::insert(intervals, newInterval), ::testing::ExitedWithCode(3), "");
}

TEST(InsertIntervalTest, insert_fail_10) {
    // starti <= 10^5
    int starti = pow(10, 5) + 1;
    int endi = pow(10, 5);
    vector<vector<int>> intervals{};
    vector<int> newInterval = {starti, endi};
    EXPECT_EXIT(InsertInterval::insert(intervals, newInterval), ::testing::ExitedWithCode(3), "");
}

TEST(InsertIntervalTest, insert_fail_11) {
    // 0 <= endi
    int starti = pow(10, 5);
    int endi = 0 - 1;
    vector<vector<int>> intervals{};
    vector<int> newInterval = {starti, endi};
    EXPECT_EXIT(InsertInterval::insert(intervals, newInterval), ::testing::ExitedWithCode(3), "");
}

TEST(InsertIntervalTest, insert_fail_13) {
    // endi <= 10^5
    int starti = pow(10, 5);
    int endi = pow(10, 5) + 1;
    vector<vector<int>> intervals{};
    vector<int> newInterval = {starti, endi};
    EXPECT_EXIT(InsertInterval::insert(intervals, newInterval), ::testing::ExitedWithCode(3), "");
}

TEST(InsertIntervalTest, insert_fail_14) {
    // starti <= endi
    int starti = pow(10, 5);
    int endi = pow(10, 5) - 1;
    vector<vector<int>> intervals{};
    vector<int> newInterval = {starti, endi};
    EXPECT_EXIT(InsertInterval::insert(intervals, newInterval), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop