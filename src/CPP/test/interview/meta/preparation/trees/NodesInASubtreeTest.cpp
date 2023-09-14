#ifndef LEETCODE_TOP_INTERVIEW_150_NODES_IN_A_SUBTREE_TEST
#define LEETCODE_TOP_INTERVIEW_150_NODES_IN_A_SUBTREE_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/trees/NodesInASubtree.cpp"

TEST(NodesInASubtreeTest, description) {
    testing::internal::CaptureStdout();
    NodesInASubtree::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(NodesInASubtreeTest, visibleNodes_1) {
    vector<int> expected{2};
    vector<Query> queries{{1, 'a'}};
    auto s = "aba";
    Node *root = new Node(1);
    root->children.push_back(new Node(2));
    root->children.push_back(new Node(3));
    auto result = NodesInASubtree::countOfNodes(root, queries, s);
    EXPECT_EQ(expected, result);
    NodesInASubtree::deleteTree(&root);
}

TEST(NodesInASubtreeTest, visibleNodes_2) {
    vector<int> expected{4, 1, 2};
    vector<Query> queries{{1, 'a'},
                          {2, 'b'},
                          {3, 'a'}};
    auto s = "abaacab";
    Node *root = new Node(1);
    root->children.push_back(new Node(2));
    root->children.push_back(new Node(3));
    root->children.push_back(new Node(7));
    root->children[0]->children.push_back(new Node(4));
    root->children[0]->children.push_back(new Node(5));
    root->children[1]->children.push_back(new Node(6));
    auto result = NodesInASubtree::countOfNodes(root, queries, s);
    EXPECT_EQ(expected, result);
    NodesInASubtree::deleteTree(&root);
}

#endif