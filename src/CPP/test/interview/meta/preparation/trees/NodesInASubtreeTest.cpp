#ifndef LEETCODE_TOP_INTERVIEW_150_NODES_IN_A_SUBTREE_TEST
#define LEETCODE_TOP_INTERVIEW_150_NODES_IN_A_SUBTREE_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/trees/NodesInASubtree.cpp"  // NOLINT : Ignore .cpp import

TEST(Interview_NodesInASubtreeTest, description) {
    testing::internal::CaptureStdout();
    NodesInASubtree::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(Interview_NodesInASubtreeTest, visibleNodes_1) {
    vector<int> expected{2};
    vector<NodesInASubtree::Query> queries{{1, 'a'}};
    auto s = "aba";
    auto *root = new NodesInASubtree::Node(1);
    root->children.push_back(new NodesInASubtree::Node(2));
    root->children.push_back(new NodesInASubtree::Node(3));
    auto result = NodesInASubtree::countOfNodes(root, queries, s);
    EXPECT_EQ(expected, result);
    NodesInASubtree::deleteTree(&root);
}

TEST(Interview_NodesInASubtreeTest, visibleNodes_2) {
    vector<int> expected{4, 1, 2};
    vector<NodesInASubtree::Query> queries{{1, 'a'},
                                           {2, 'b'},
                                           {3, 'a'}};
    auto s = "abaacab";
    auto *root = new NodesInASubtree::Node(1);
    root->children.push_back(new NodesInASubtree::Node(2));
    root->children.push_back(new NodesInASubtree::Node(3));
    root->children.push_back(new NodesInASubtree::Node(7));
    root->children[0]->children.push_back(new NodesInASubtree::Node(4));
    root->children[0]->children.push_back(new NodesInASubtree::Node(5));
    root->children[1]->children.push_back(new NodesInASubtree::Node(6));
    auto result = NodesInASubtree::countOfNodes(root, queries, s);
    EXPECT_EQ(expected, result);
    NodesInASubtree::deleteTree(&root);
}

#endif