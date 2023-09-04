#ifndef LEETCODE_TOP_INTERVIEW_150_BINARY_TREE_RIGHT_SIDE_VIEW_TEST
#define LEETCODE_TOP_INTERVIEW_150_BINARY_TREE_RIGHT_SIDE_VIEW_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/binary_tree_bfs/BinaryTreeRightSideView.cpp"

TEST(BinaryTreeRightSideViewTest, description) {
    testing::internal::CaptureStdout();
    BinaryTreeRightSideView::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(BinaryTreeRightSideViewTest, rightSideView_1) {
    vector<int> expected{1, 3, 4};
    vector<string> values{"1", "2", "3", "null", "5", "null", "4"};
    auto root = BinaryTreeRightSideView::deserialize(values);
    auto result = BinaryTreeRightSideView::rightSideView(root);
    EXPECT_EQ(expected, result);
    BinaryTreeRightSideView::deleteTree(&root);
}

TEST(BinaryTreeRightSideViewTest, rightSideView_2) {
    vector<int> expected{1, 3};
    vector<string> values{"1", "null", "3",};
    auto root = BinaryTreeRightSideView::deserialize(values);
    auto result = BinaryTreeRightSideView::rightSideView(root);
    EXPECT_EQ(expected, result);
    BinaryTreeRightSideView::deleteTree(&root);
}

TEST(BinaryTreeRightSideViewTest, rightSideView_3) {
    vector<int> expected{};
    vector<string> values{};
    auto root = BinaryTreeRightSideView::deserialize(values);
    auto result = BinaryTreeRightSideView::rightSideView(root);
    EXPECT_EQ(expected, result);
    BinaryTreeRightSideView::deleteTree(&root);
}

#endif