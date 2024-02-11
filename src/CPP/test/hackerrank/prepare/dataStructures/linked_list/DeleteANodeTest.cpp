#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_LINKED_LISTS_DELETE_A_NODE_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_LINKED_LISTS_DELETE_A_NODE_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/linked_list/DeleteANode.cpp"  // NOLINT : Ignore .cpp import

TEST(HackerRank_DeleteANodeTest, description) {
    testing::internal::CaptureStdout();
    DeleteANode::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(HackerRank_DeleteANodeTest, deleteNode_1) {
    vector<int> expected{0, 1, 3};
    vector<int> source{0, 1, 2, 3};
    auto list = DeleteANode::createList(source);
    auto position = 2;
    auto updatedList = DeleteANode::deleteNode(list, position);
    auto result = DeleteANode::getlist(updatedList);
    EXPECT_EQ(expected, result);
    DeleteANode::deleteList(&updatedList);
}

TEST(HackerRank_DeleteANodeTest, deleteNode_2) {
    vector<int> expected{20, 6, 2, 7, 4, 15, 9};
    vector<int> source{20, 6, 2, 19, 7, 4, 15, 9};
    auto list = DeleteANode::createList(source);
    auto position = 3;
    auto updatedList = DeleteANode::deleteNode(list, position);
    auto result = DeleteANode::getlist(updatedList);
    EXPECT_EQ(expected, result);
    DeleteANode::deleteList(&updatedList);
}

TEST(HackerRank_DeleteANodeTest, deleteNode_3) {
    vector<int> expected{};
    vector<int> source{20};
    auto list = DeleteANode::createList(source);
    auto position = 0;
    auto updatedList = DeleteANode::deleteNode(list, position);
    auto result = DeleteANode::getlist(updatedList);
    EXPECT_EQ(expected, result);
    DeleteANode::deleteList(&updatedList);
}

TEST(HackerRank_DeleteANodeTest, deleteNode_4) {
    vector<int> expected{11, 2, 9};
    vector<int> source{11, 9, 2, 9};
    auto list = DeleteANode::createList(source);
    auto position = 1;
    auto updatedList = DeleteANode::deleteNode(list, position);
    auto result = DeleteANode::getlist(updatedList);
    EXPECT_EQ(expected, result);
    DeleteANode::deleteList(&updatedList);
}

#endif