#ifndef LEETCODE_TOP_INTERVIEW_150_FLATTEN_BINARY_TREE_TO_LINKED_LIST_TEST
#define LEETCODE_TOP_INTERVIEW_150_FLATTEN_BINARY_TREE_TO_LINKED_LIST_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/binary_tree_general/FlattenBinaryTreeToLinkedList.cpp"

TEST(FlattenBinaryTreeToLinkedListTest, description) {
    testing::internal::CaptureStdout();
    FlattenBinaryTreeToLinkedList::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(FlattenBinaryTreeToLinkedListTest, connect_1) {
    vector<string> expected{"1", "null", "2", "null", "3", "null", "4", "null", "5", "null", "6"};
    vector<string> values{"1", "2", "5", "3", "4", "null", "6"};
    auto root = FlattenBinaryTreeToLinkedList::deserialize(values);
    FlattenBinaryTreeToLinkedList::flatten(root);
    auto result = FlattenBinaryTreeToLinkedList::serializeTree(root);
    EXPECT_EQ(expected, result);
    FlattenBinaryTreeToLinkedList::deleteTree(&root);
}

TEST(FlattenBinaryTreeToLinkedListTest, connect_2) {
    vector<string> expected{};
    vector<string> values{};
    auto root = FlattenBinaryTreeToLinkedList::deserialize(values);
    FlattenBinaryTreeToLinkedList::flatten(root);
    auto result = FlattenBinaryTreeToLinkedList::serializeTree(root);
    EXPECT_EQ(expected, result);
    FlattenBinaryTreeToLinkedList::deleteTree(&root);
}

TEST(FlattenBinaryTreeToLinkedListTest, connect_3) {
    vector<string> expected{"0"};
    vector<string> values{"0"};
    auto root = FlattenBinaryTreeToLinkedList::deserialize(values);
    FlattenBinaryTreeToLinkedList::flatten(root);
    auto result = FlattenBinaryTreeToLinkedList::serializeTree(root);
    EXPECT_EQ(expected, result);
    FlattenBinaryTreeToLinkedList::deleteTree(&root);
}

#endif