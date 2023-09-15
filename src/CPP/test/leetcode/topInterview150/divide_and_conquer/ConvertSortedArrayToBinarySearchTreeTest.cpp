#ifndef LEETCODE_TOP_INTERVIEW_150_CONVERT_SORTED_ARRAY_TO_BINARY_SEARCH_TREE_TEST
#define LEETCODE_TOP_INTERVIEW_150_CONVERT_SORTED_ARRAY_TO_BINARY_SEARCH_TREE_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/divide_and_conquer/ConvertSortedArrayToBinarySearchTree.cpp"  // NOLINT : Ignore .cpp import

TEST(ConvertSortedArrayToBinarySearchTreeTest, description) {
    testing::internal::CaptureStdout();
    ConvertSortedArrayToBinarySearchTree::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ConvertSortedArrayToBinarySearchTreeTest, climbStairs_1) {
    vector<string> expected{"0", "-3", "9", "-10", "null", "5"};
    vector<int> nums{-10, -3, 0, 5, 9};
    auto head = ConvertSortedArrayToBinarySearchTree::sortedArrayToBST(nums);
    auto result = ConvertSortedArrayToBinarySearchTree::serializeTree(head);
    EXPECT_EQ(expected, result);
    ConvertSortedArrayToBinarySearchTree::deleteTree(&head);
}

TEST(ConvertSortedArrayToBinarySearchTreeTest, climbStairs_2) {
    vector<string> expected{"3", "1"};
    vector<int> nums{1, 3};
    auto head = ConvertSortedArrayToBinarySearchTree::sortedArrayToBST(nums);
    auto result = ConvertSortedArrayToBinarySearchTree::serializeTree(head);
    EXPECT_EQ(expected, result);
    ConvertSortedArrayToBinarySearchTree::deleteTree(&head);
}

TEST(ConvertSortedArrayToBinarySearchTreeTest, climbStairs_fail_1) {
    // 1 ≤ nums.length
    int size = 1 - 1;
    vector<int> nums(size);
    EXPECT_EXIT(ConvertSortedArrayToBinarySearchTree::sortedArrayToBST(nums), ::testing::ExitedWithCode(3), "");
}

TEST(ConvertSortedArrayToBinarySearchTreeTest, climbStairs_fail_2) {
    // nums.length ≤ 10^4
    int size = (int) pow(10, 4) + 1;
    vector<int> nums(size);
    EXPECT_EXIT(ConvertSortedArrayToBinarySearchTree::sortedArrayToBST(nums), ::testing::ExitedWithCode(3), "");
}

TEST(ConvertSortedArrayToBinarySearchTreeTest, climbStairs_fail_3) {
    // -10^4 ≤ nums[i]
    int size = (int) -pow(10, 4) - 1;
    vector<int> nums{size};
    EXPECT_EXIT(ConvertSortedArrayToBinarySearchTree::sortedArrayToBST(nums), ::testing::ExitedWithCode(3), "");
}

TEST(ConvertSortedArrayToBinarySearchTreeTest, climbStairs_fail_4) {
    // nums[i] ≤ 10^4
    int size = (int) pow(10, 4) + 1;
    vector<int> nums{size};
    EXPECT_EXIT(ConvertSortedArrayToBinarySearchTree::sortedArrayToBST(nums), ::testing::ExitedWithCode(3), "");
}

#endif