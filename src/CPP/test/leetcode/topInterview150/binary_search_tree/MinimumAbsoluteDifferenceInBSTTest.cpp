#ifndef LEETCODE_TOP_INTERVIEW_150_MINIMUM_ABSOLUTE_DIFFERENCE_IN_BST_TEST
#define LEETCODE_TOP_INTERVIEW_150_MINIMUM_ABSOLUTE_DIFFERENCE_IN_BST_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/binary_search_tree/MinimumAbsoluteDifferenceInBST.cpp"

TEST(MinimumAbsoluteDifferenceInBSTTest, description) {
    testing::internal::CaptureStdout();
    MinimumAbsoluteDifferenceInBST::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(MinimumAbsoluteDifferenceInBSTTest, getMinimumDifference_1) {
    auto expected = 1;
    vector<int> numbers{4, 2, 6, 1, 3};
    auto root = MinimumAbsoluteDifferenceInBST::generateTree(numbers);
    auto result = MinimumAbsoluteDifferenceInBST::getMinimumDifference(root);
    EXPECT_EQ(expected, result);
    MinimumAbsoluteDifferenceInBST::deleteTree(&root);
}

TEST(MinimumAbsoluteDifferenceInBSTTest, getMinimumDifference_2) {
    auto expected = 1;
    vector<int> numbers{1, 0, 48, 12, 49};
    auto root = MinimumAbsoluteDifferenceInBST::generateTree(numbers);
    auto result = MinimumAbsoluteDifferenceInBST::getMinimumDifference(root);
    EXPECT_EQ(expected, result);
    MinimumAbsoluteDifferenceInBST::deleteTree(&root);
}

TEST(MinimumAbsoluteDifferenceInBSTTest, getMinimumDifference_3) {
    auto expected = 9;
    vector<int> numbers{236, 104, 227, 701, 911};
    auto root = MinimumAbsoluteDifferenceInBST::generateTree(numbers);
    auto result = MinimumAbsoluteDifferenceInBST::getMinimumDifference(root);
    EXPECT_EQ(expected, result);
    MinimumAbsoluteDifferenceInBST::deleteTree(&root);
}

#endif