#ifndef LEETCODE_TOP_INTERVIEW_150_SUM_ROOT_TO_LEAF_NUMBERS_TEST
#define LEETCODE_TOP_INTERVIEW_150_SUM_ROOT_TO_LEAF_NUMBERS_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/binary_tree_general/SumRootToLeafNumbers.cpp"  // NOLINT : Ignore .cpp import

TEST(LeetCode_SumRootToLeafNumbersTest, description) {
    testing::internal::CaptureStdout();
    SumRootToLeafNumbers::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LeetCode_SumRootToLeafNumbersTest, sumNumbers_1) {
    auto expected = 25;
    vector<string> values{"1", "2", "3"};
    auto root = SumRootToLeafNumbers::deserializeTree(values);
    auto result = SumRootToLeafNumbers::sumNumbers(root);
    EXPECT_EQ(expected, result);
    SumRootToLeafNumbers::deleteTree(&root);
}

TEST(LeetCode_SumRootToLeafNumbersTest, sumNumbers_2) {
    auto expected = 1026;
    vector<string> values{"4", "9", "0", "5", "1"};
    auto root = SumRootToLeafNumbers::deserializeTree(values);
    auto result = SumRootToLeafNumbers::sumNumbers(root);
    EXPECT_EQ(expected, result);
    SumRootToLeafNumbers::deleteTree(&root);
}

#endif