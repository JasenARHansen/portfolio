#ifndef LEETCODE_TOP_INTERVIEW_150_PATH_SUM_TEST
#define LEETCODE_TOP_INTERVIEW_150_PATH_SUM_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/binary_tree_general/PathSum.cpp"  // NOLINT : Ignore .cpp import

TEST(PathSumTest, description) {
    testing::internal::CaptureStdout();
    PathSum::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(PathSumTest, hasPathSum_1) {
    auto expected = true;
    vector<string> values{"5", "4", "8", "11", "null", "13", "4", "7", "2", "null", "null", "null", "1"};
    int targetSum = 22;
    auto root = PathSum::deserializeTree(values);
    auto result = PathSum::hasPathSum(root, targetSum);
    EXPECT_EQ(expected, result);
    PathSum::deleteTree(&root);
}

TEST(PathSumTest, hasPathSum_2) {
    auto expected = false;
    vector<string> values{"1", "2", "3"};
    int targetSum = 5;
    auto root = PathSum::deserializeTree(values);
    auto result = PathSum::hasPathSum(root, targetSum);
    EXPECT_EQ(expected, result);
    PathSum::deleteTree(&root);
}

TEST(PathSumTest, hasPathSum_3) {
    auto expected = false;
    vector<string> values{};
    int targetSum = 0;
    auto root = PathSum::deserializeTree(values);
    auto result = PathSum::hasPathSum(root, targetSum);
    EXPECT_EQ(expected, result);
    PathSum::deleteTree(&root);
}

#endif