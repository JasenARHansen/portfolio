#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_TREE_TOP_VIEW_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_TREE_TOP_VIEW_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/tree/TopView.cpp"  // NOLINT : Ignore .cpp import

TEST(HackerRank_TopViewTest, description) {
    testing::internal::CaptureStdout();
    TopView::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(HackerRank_TopViewTest, topView_1) {
    auto expected = "1 2 5 6\n";
    vector<string> values{"1", "null", "2", "null", "5", "3", "6", "null", "4"};
    auto root = TopView::deserializeTree(values);
    testing::internal::CaptureStdout();
    TopView::topView(root);
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
    TopView::deleteTree(&root);
}

TEST(HackerRank_TopViewTest, topView_2) {
    auto expected = "1 2 4 6 7\n";
    vector<string> values{"4", "2", "6", "1", "3", "5", "7"};
    auto root = TopView::deserializeTree(values);
    testing::internal::CaptureStdout();
    TopView::topView(root);
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
    TopView::deleteTree(&root);
}

TEST(HackerRank_TopViewTest, topView_3) {
    auto expected = "1 2 4 14 23 37 108 111 115 116 83 84 85\n";
    vector<int> values{37, 23, 108, 59, 86, 64, 94, 14, 105, 17, 111, 65, 55, 31, 79, 97, 78, 25, 50, 22, 66, 46, 104,
                       98, 81, 90, 68, 40, 103, 77, 74, 18, 69, 82, 41, 4, 48, 83, 67, 6, 2, 95, 54, 100, 99, 84, 34,
                       88, 27, 72, 32, 62, 9, 56, 109, 115, 33, 15, 91, 29, 85, 114, 112, 20, 26, 30, 93, 96, 87, 42,
                       38, 60, 7, 73, 35, 12, 10, 57, 80, 13, 52, 44, 16, 70, 8, 39, 107, 106, 63, 24, 92, 45, 75, 116,
                       5, 61, 49, 101, 71, 11, 53, 43, 102, 110, 1, 58, 36, 28, 76, 47, 113, 21, 89, 51, 19, 3};
    auto root = TopView::deserializeTree(values);
    testing::internal::CaptureStdout();
    TopView::topView(root);
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
    TopView::deleteTree(&root);
}

#endif