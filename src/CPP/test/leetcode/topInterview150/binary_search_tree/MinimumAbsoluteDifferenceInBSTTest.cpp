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
    vector<string> values{"4", "2", "6", "1", "3"};
    auto root = MinimumAbsoluteDifferenceInBST::deserializeTree(values);
    auto result = MinimumAbsoluteDifferenceInBST::getMinimumDifference(root);
    EXPECT_EQ(expected, result);
    MinimumAbsoluteDifferenceInBST::deleteTree(&root);
}

TEST(MinimumAbsoluteDifferenceInBSTTest, getMinimumDifference_2) {
    auto expected = 1;
    vector<string> values{"1", "0", "48", "null", "null", "12", "49"};
    auto root = MinimumAbsoluteDifferenceInBST::deserializeTree(values);
    auto result = MinimumAbsoluteDifferenceInBST::getMinimumDifference(root);
    EXPECT_EQ(expected, result);
    MinimumAbsoluteDifferenceInBST::deleteTree(&root);
}

#endif