#ifndef LEETCODE_PLATES_BETWEEN_CANDLES_TEST
#define LEETCODE_PLATES_BETWEEN_CANDLES_TEST

#include "gtest/gtest.h"
#include "../../code/leetcode/PlatesBetweenCandles.cpp"  // NOLINT : Ignore .cpp import

TEST(LeetCode_PlatesBetweenCandles_Test, description) {
    testing::internal::CaptureStdout();
    PlatesBetweenCandles::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LeetCode_PlatesBetweenCandles_Test, platesBetweenCandles1_1) {
    vector<int> expected{2};
    string s = "||**||**|*";
    vector<vector<int>> queries{{3, 8}};
    auto result = PlatesBetweenCandles::platesBetweenCandles1(s, queries);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(LeetCode_PlatesBetweenCandles_Test, platesBetweenCandles1_2) {
    vector<int> expected{2, 3};
    string s = "**|**|***|";
    vector<vector<int>> queries{{2, 5},
                                {5, 9}};
    auto result = PlatesBetweenCandles::platesBetweenCandles1(s, queries);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(LeetCode_PlatesBetweenCandles_Test, platesBetweenCandles1_3) {
    vector<int> expected{9, 0, 0, 0, 0};
    string s = "***|**|*****|**||**|*|";
    vector<vector<int>> queries{{1,  17},
                                {4,  5},
                                {14, 17},
                                {5,  11},
                                {15, 16}};
    auto result = PlatesBetweenCandles::platesBetweenCandles1(s, queries);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(LeetCode_PlatesBetweenCandles_Test, platesBetweenCandles1_4) {
    vector<int> expected{2, 3};
    string s = "|**|*|*";
    vector<vector<int>> queries{{0, 4},
                                {0, 5}};
    auto result = PlatesBetweenCandles::platesBetweenCandles1(s, queries);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(LeetCode_PlatesBetweenCandles_Test, platesBetweenCandles1_5) {
    vector<int> expected{0};
    string s = "*|*|";
    vector<vector<int>> queries{{0, 2}};
    auto result = PlatesBetweenCandles::platesBetweenCandles1(s, queries);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(LeetCode_PlatesBetweenCandles_Test, platesBetweenCandles1_6) {
    vector<int> expected{2};
    string s = "*|*|*|";
    vector<vector<int>> queries{{0, 5}};
    auto result = PlatesBetweenCandles::platesBetweenCandles1(s, queries);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(LeetCode_PlatesBetweenCandles_Test, platesBetweenCandles1_7) {
    vector<int> expected{0};
    string s = "********";
    vector<vector<int>> queries{{0, 5}};
    auto result = PlatesBetweenCandles::platesBetweenCandles1(s, queries);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(LeetCode_PlatesBetweenCandles_Test, platesBetweenCandles1_8) {
    vector<int> expected{0};
    string s = "|||||||||";
    vector<vector<int>> queries{{0, 5}};
    auto result = PlatesBetweenCandles::platesBetweenCandles1(s, queries);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(LeetCode_PlatesBetweenCandles_Test, platesBetweenCandles1_9) {
    vector<int> expected{0};
    string s = "|*|*";
    vector<vector<int>> queries{{3, 3}};
    auto result = PlatesBetweenCandles::platesBetweenCandles1(s, queries);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(LeetCode_PlatesBetweenCandles_Test, platesBetweenCandles2_1) {
    vector<int> expected{2};
    string s = "||**||**|*";
    vector<vector<int>> queries{{3, 8}};
    auto result = PlatesBetweenCandles::platesBetweenCandles2(s, queries);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(LeetCode_PlatesBetweenCandles_Test, platesBetweenCandles2_2) {
    vector<int> expected{2, 3};
    string s = "**|**|***|";
    vector<vector<int>> queries{{2, 5},
                                {5, 9}};
    auto result = PlatesBetweenCandles::platesBetweenCandles2(s, queries);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(LeetCode_PlatesBetweenCandles_Test, platesBetweenCandles2_3) {
    vector<int> expected{9, 0, 0, 0, 0};
    string s = "***|**|*****|**||**|*|";
    vector<vector<int>> queries{{1,  17},
                                {4,  5},
                                {14, 17},
                                {5,  11},
                                {15, 16}};
    auto result = PlatesBetweenCandles::platesBetweenCandles2(s, queries);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(LeetCode_PlatesBetweenCandles_Test, platesBetweenCandles2_4) {
    vector<int> expected{2, 3};
    string s = "|**|*|*";
    vector<vector<int>> queries{{0, 4},
                                {0, 5}};
    auto result = PlatesBetweenCandles::platesBetweenCandles2(s, queries);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(LeetCode_PlatesBetweenCandles_Test, platesBetweenCandles2_5) {
    vector<int> expected{0};
    string s = "*|*|";
    vector<vector<int>> queries{{0, 2}};
    auto result = PlatesBetweenCandles::platesBetweenCandles2(s, queries);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(LeetCode_PlatesBetweenCandles_Test, platesBetweenCandles2_6) {
    vector<int> expected{2};
    string s = "*|*|*|";
    vector<vector<int>> queries{{0, 5}};
    auto result = PlatesBetweenCandles::platesBetweenCandles2(s, queries);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(LeetCode_PlatesBetweenCandles_Test, platesBetweenCandles2_7) {
    vector<int> expected{0};
    string s = "********";
    vector<vector<int>> queries{{0, 5}};
    auto result = PlatesBetweenCandles::platesBetweenCandles2(s, queries);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(LeetCode_PlatesBetweenCandles_Test, platesBetweenCandles2_8) {
    vector<int> expected{0};
    string s = "|||||||||";
    vector<vector<int>> queries{{0, 5}};
    auto result = PlatesBetweenCandles::platesBetweenCandles2(s, queries);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(LeetCode_PlatesBetweenCandles_Test, platesBetweenCandles2_9) {
    vector<int> expected{0};
    string s = "|*|*";
    vector<vector<int>> queries{{3, 3}};
    auto result = PlatesBetweenCandles::platesBetweenCandles2(s, queries);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(LeetCode_PlatesBetweenCandles_Test, platesBetweenCandles3_1) {
    vector<int> expected{2};
    string s = "||**||**|*";
    vector<vector<int>> queries{{3, 8}};
    auto result = PlatesBetweenCandles::platesBetweenCandles3(s, queries);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(LeetCode_PlatesBetweenCandles_Test, platesBetweenCandles3_2) {
    vector<int> expected{2, 3};
    string s = "**|**|***|";
    vector<vector<int>> queries{{2, 5},
                                {5, 9}};
    auto result = PlatesBetweenCandles::platesBetweenCandles3(s, queries);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(LeetCode_PlatesBetweenCandles_Test, platesBetweenCandles3_3) {
    vector<int> expected{9, 0, 0, 0, 0};
    string s = "***|**|*****|**||**|*|";
    vector<vector<int>> queries{{1,  17},
                                {4,  5},
                                {14, 17},
                                {5,  11},
                                {15, 16}};
    auto result = PlatesBetweenCandles::platesBetweenCandles3(s, queries);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(LeetCode_PlatesBetweenCandles_Test, platesBetweenCandles3_4) {
    vector<int> expected{2, 3};
    string s = "|**|*|*";
    vector<vector<int>> queries{{0, 4},
                                {0, 5}};
    auto result = PlatesBetweenCandles::platesBetweenCandles3(s, queries);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(LeetCode_PlatesBetweenCandles_Test, platesBetweenCandles3_5) {
    vector<int> expected{0};
    string s = "*|*|";
    vector<vector<int>> queries{{0, 2}};
    auto result = PlatesBetweenCandles::platesBetweenCandles3(s, queries);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(LeetCode_PlatesBetweenCandles_Test, platesBetweenCandles3_6) {
    vector<int> expected{2};
    string s = "*|*|*|";
    vector<vector<int>> queries{{0, 5}};
    auto result = PlatesBetweenCandles::platesBetweenCandles3(s, queries);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(LeetCode_PlatesBetweenCandles_Test, platesBetweenCandles3_7) {
    vector<int> expected{0};
    string s = "********";
    vector<vector<int>> queries{{0, 5}};
    auto result = PlatesBetweenCandles::platesBetweenCandles3(s, queries);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(LeetCode_PlatesBetweenCandles_Test, platesBetweenCandles3_8) {
    vector<int> expected{0};
    string s = "|||||||||";
    vector<vector<int>> queries{{0, 5}};
    auto result = PlatesBetweenCandles::platesBetweenCandles3(s, queries);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(LeetCode_PlatesBetweenCandles_Test, platesBetweenCandles3_9) {
    vector<int> expected{0};
    string s = "|*|*";
    vector<vector<int>> queries{{3, 3}};
    auto result = PlatesBetweenCandles::platesBetweenCandles3(s, queries);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

#endif