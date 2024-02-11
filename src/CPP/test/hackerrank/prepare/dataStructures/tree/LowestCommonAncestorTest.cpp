#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_TREE_LOWEST_COMMON_ANCESTOR_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_TREE_LOWEST_COMMON_ANCESTOR_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/tree/LowestCommonAncestor.cpp"  // NOLINT : Ignore .cpp import

TEST(HackerRank_LowestCommonAncestorTest, description) {
    testing::internal::CaptureStdout();
    LowestCommonAncestor::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(HackerRank_LowestCommonAncestorTest, lca_1) {
    auto expected = 4;
    vector<int> values{4, 2, 3, 1, 7, 6};
    auto root = LowestCommonAncestor::deserializeTree(values);
    auto v1 = 1;
    auto v2 = 7;
    auto node = LowestCommonAncestor::lca(root, v1, v2);
    auto result = node->data;
    EXPECT_EQ(expected, result);
    LowestCommonAncestor::deleteTree(&root);
}

TEST(HackerRank_LowestCommonAncestorTest, lca_2) {
    auto expected = 1;
    vector<int> values{1, 2};
    auto root = LowestCommonAncestor::deserializeTree(values);
    auto v1 = 1;
    auto v2 = 2;
    auto node = LowestCommonAncestor::lca(root, v1, v2);
    auto result = node->data;
    EXPECT_EQ(expected, result);
    LowestCommonAncestor::deleteTree(&root);
}

TEST(HackerRank_LowestCommonAncestorTest, lca_3) {
    auto expected = 5;
    vector<int> values{5, 3, 8, 2, 4, 6, 7};
    auto root = LowestCommonAncestor::deserializeTree(values);
    auto v1 = 7;
    auto v2 = 3;
    auto node = LowestCommonAncestor::lca(root, v1, v2);
    auto result = node->data;
    EXPECT_EQ(expected, result);
    LowestCommonAncestor::deleteTree(&root);
}

#endif