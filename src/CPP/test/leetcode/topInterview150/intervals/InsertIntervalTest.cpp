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
    vector<int> newInterval{2, 5};
    auto result = InsertInterval::insert(intervals, newInterval);
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
    vector<int> newInterval{4, 8};
    auto result = InsertInterval::insert(intervals, newInterval);
    EXPECT_EQ(expected, result);
}

TEST(InsertIntervalTest, insert_3) {
    vector<vector<int>> expected{{0, 10}};
    vector<vector<int>> intervals{{2, 5},
                                  {6, 7},
                                  {8, 9}};
    vector<int> newInterval{0, 10};
    auto result = InsertInterval::insert(intervals, newInterval);
    EXPECT_EQ(expected, result);
}

TEST(InsertIntervalTest, insert_4) {
    vector<vector<int>> expected{{1, 7}};
    vector<vector<int>> intervals{{1, 5}};
    vector<int> newInterval{2, 7};
    auto result = InsertInterval::insert(intervals, newInterval);
    EXPECT_EQ(expected, result);
}

TEST(InsertIntervalTest, insert_fail_1) {
    // intervals.length <= 10^4
    auto size = (int) pow(10, 4) + 1;
    vector<vector<int>> intervals(size);
    vector<int> newInterval{4, 8};
    EXPECT_EXIT(InsertInterval::insert(intervals, newInterval), ::testing::ExitedWithCode(3), "");
}

TEST(InsertIntervalTest, insert_fail_2) {
    // intervals[i].length == 2
    auto size = 2 - 1;
    vector<vector<int>> intervals{vector<int>(size)};
    vector<int> newInterval{4, 8};
    EXPECT_EXIT(InsertInterval::insert(intervals, newInterval), ::testing::ExitedWithCode(3), "");
}

TEST(InsertIntervalTest, insert_fail_3) {
    //  0 <= startI
    auto startI = 0 - 1;
    auto endI = (int) pow(10, 5);
    vector<vector<int>> intervals{{startI, endI}};
    vector<int> newInterval{4, 8};
    EXPECT_EXIT(InsertInterval::insert(intervals, newInterval), ::testing::ExitedWithCode(3), "");
}

TEST(InsertIntervalTest, insert_fail_4) {
    // startI <= 10^5
    auto startI = (int) pow(10, 5) + 1;
    auto endI = (int) pow(10, 5);
    vector<vector<int>> intervals{{startI, endI}};
    vector<int> newInterval{4, 8};
    EXPECT_EXIT(InsertInterval::insert(intervals, newInterval), ::testing::ExitedWithCode(3), "");
}

TEST(InsertIntervalTest, insert_fail_5) {
    // 0 <= endI
    auto startI = (int) pow(10, 5);
    auto endI = 0 - 1;
    vector<vector<int>> intervals{{startI, endI}};
    vector<int> newInterval{4, 8};
    EXPECT_EXIT(InsertInterval::insert(intervals, newInterval), ::testing::ExitedWithCode(3), "");
}

TEST(InsertIntervalTest, insert_fail_6) {
    // endI <= 10^5
    auto startI = (int) pow(10, 5);
    auto endI = (int) pow(10, 5) + 1;
    vector<vector<int>> intervals{{startI, endI}};
    vector<int> newInterval{4, 8};
    EXPECT_EXIT(InsertInterval::insert(intervals, newInterval), ::testing::ExitedWithCode(3), "");
}

TEST(InsertIntervalTest, insert_fail_7) {
    // startI <= endI
    auto startI = (int) pow(10, 5);
    auto endI = (int) pow(10, 5) - 1;
    vector<vector<int>> intervals{{startI, endI}};
    vector<int> newInterval{4, 8};
    EXPECT_EXIT(InsertInterval::insert(intervals, newInterval), ::testing::ExitedWithCode(3), "");
}

TEST(InsertIntervalTest, insert_fail_8) {
    // newInterval.length == 2
    vector<vector<int>> intervals{};
    auto size = 2 - 1;
    vector<int> newInterval{size};
    EXPECT_EXIT(InsertInterval::insert(intervals, newInterval), ::testing::ExitedWithCode(3), "");
}

TEST(InsertIntervalTest, insert_fail_9) {
    //  0 <= startI
    auto startI = 0 - 1;
    auto endI = (int) pow(10, 5);
    vector<vector<int>> intervals{};
    vector<int> newInterval{startI, endI};
    EXPECT_EXIT(InsertInterval::insert(intervals, newInterval), ::testing::ExitedWithCode(3), "");
}

TEST(InsertIntervalTest, insert_fail_10) {
    // startI <= 10^5
    auto startI = (int) pow(10, 5) + 1;
    auto endI = (int) pow(10, 5);
    vector<vector<int>> intervals{};
    vector<int> newInterval{startI, endI};
    EXPECT_EXIT(InsertInterval::insert(intervals, newInterval), ::testing::ExitedWithCode(3), "");
}

TEST(InsertIntervalTest, insert_fail_11) {
    // 0 <= endI
    auto startI = (int) pow(10, 5);
    auto endI = 0 - 1;
    vector<vector<int>> intervals{};
    vector<int> newInterval{startI, endI};
    EXPECT_EXIT(InsertInterval::insert(intervals, newInterval), ::testing::ExitedWithCode(3), "");
}

TEST(InsertIntervalTest, insert_fail_13) {
    // endI <= 10^5
    auto startI = (int) pow(10, 5);
    auto endI = (int) pow(10, 5) + 1;
    vector<vector<int>> intervals{};
    vector<int> newInterval{startI, endI};
    EXPECT_EXIT(InsertInterval::insert(intervals, newInterval), ::testing::ExitedWithCode(3), "");
}

TEST(InsertIntervalTest, insert_fail_14) {
    // startI <= endI
    auto startI = (int) pow(10, 5);
    auto endI = (int) pow(10, 5) - 1;
    vector<vector<int>> intervals{};
    vector<int> newInterval{startI, endI};
    EXPECT_EXIT(InsertInterval::insert(intervals, newInterval), ::testing::ExitedWithCode(3), "");
}

#endif