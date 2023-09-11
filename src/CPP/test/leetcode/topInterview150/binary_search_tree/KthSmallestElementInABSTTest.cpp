#ifndef LEETCODE_TOP_INTERVIEW_150_KTH_SMALLEST_ELEMENT_IN_BST_TEST
#define LEETCODE_TOP_INTERVIEW_150_KTH_SMALLEST_ELEMENT_IN_BST_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/binary_search_tree/KthSmallestElementInABST.cpp"

TEST(KthSmallestElementInABSTTest, description) {
    testing::internal::CaptureStdout();
    KthSmallestElementInABST::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(KthSmallestElementInABSTTest, kthSmallest_1) {
    auto expected = 1;
    vector<string> values{"3", "1", "4", "null", "2"};
    auto root = KthSmallestElementInABST::deserialize(values);
    auto k = 1;
    auto result = KthSmallestElementInABST::kthSmallest(root, k);
    EXPECT_EQ(expected, result);
    KthSmallestElementInABST::deleteTree(&root);
}

TEST(KthSmallestElementInABSTTest, kthSmallest_2) {
    auto expected = 3;
    vector<string> values{"5", "3", "6", "2", "4", "null", "null", "1"};
    auto root = KthSmallestElementInABST::deserialize(values);
    auto k = 3;
    auto result = KthSmallestElementInABST::kthSmallest(root, k);
    EXPECT_EQ(expected, result);
    KthSmallestElementInABST::deleteTree(&root);
}

TEST(KthSmallestElementInABSTTest, kthSmallest_fail_1) {
    // 1 ≤ k
    vector<string> values{"5", "3", "6", "2", "4", "null", "null", "1"};
    auto root = KthSmallestElementInABST::deserialize(values);
    auto k = 1 - 1;
    EXPECT_EXIT(KthSmallestElementInABST::kthSmallest(root, k), ::testing::ExitedWithCode(3), "");
    KthSmallestElementInABST::deleteTree(&root);
}

TEST(KthSmallestElementInABSTTest, kthSmallest_fail_2) {
    // n ≤ 10^4
    vector<string> values{"5", "3", "6", "2", "4", "null", "null", "1"};
    auto root = KthSmallestElementInABST::deserialize(values);
    auto k = (int) pow(10, 4) + 1;
    EXPECT_EXIT(KthSmallestElementInABST::kthSmallest(root, k), ::testing::ExitedWithCode(3), "");
    KthSmallestElementInABST::deleteTree(&root);
}

#endif