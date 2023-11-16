#ifndef LEETCODE_TOP_INTERVIEW_150_NODES_IN_A_SUBTREE_TEST
#define LEETCODE_TOP_INTERVIEW_150_NODES_IN_A_SUBTREE_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/trees/NodesInASubtree.cpp"  // NOLINT : Ignore .cpp import

TEST(NodesInASubtreeTest, description) {
    testing::internal::CaptureStdout();
    NodesInASubtree::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(NodesInASubtreeTest, visibleNodes_1) {
    vector<int> expected{2};
    vector<NodesInASubtreeQuery> queries{{1, 'a'}};
    auto s = "aba";
    auto *root = new NodesInASubtreeNode(1);
    root->children.push_back(new NodesInASubtreeNode(2));
    root->children.push_back(new NodesInASubtreeNode(3));
    auto result = NodesInASubtree::countOfNodes(root, queries, s);
    EXPECT_EQ(expected, result);
    NodesInASubtree::deleteTree(&root);
}

TEST(NodesInASubtreeTest, visibleNodes_2) {
    vector<int> expected{4, 1, 2};
    vector<NodesInASubtreeQuery> queries{{1, 'a'},
                                         {2, 'b'},
                                         {3, 'a'}};
    auto s = "abaacab";
    auto *root = new NodesInASubtreeNode(1);
    root->children.push_back(new NodesInASubtreeNode(2));
    root->children.push_back(new NodesInASubtreeNode(3));
    root->children.push_back(new NodesInASubtreeNode(7));
    root->children[0]->children.push_back(new NodesInASubtreeNode(4));
    root->children[0]->children.push_back(new NodesInASubtreeNode(5));
    root->children[1]->children.push_back(new NodesInASubtreeNode(6));
    auto result = NodesInASubtree::countOfNodes(root, queries, s);
    EXPECT_EQ(expected, result);
    NodesInASubtree::deleteTree(&root);
}

#endif