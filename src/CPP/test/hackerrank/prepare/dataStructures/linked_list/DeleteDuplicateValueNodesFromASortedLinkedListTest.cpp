#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_LINKED_LISTS_DELETE_DUPLICATE_VALUE_NODES_FROM_A_SORTED_LINKED_LIST_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_LINKED_LISTS_DELETE_DUPLICATE_VALUE_NODES_FROM_A_SORTED_LINKED_LIST_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/linked_list/DeleteDuplicateValueNodesFromASortedLinkedList.cpp"  // NOLINT : Ignore .cpp import

TEST(DeleteDuplicateValueNodesFromASortedLinkedListTest, description) {
    testing::internal::CaptureStdout();
    DeleteDuplicateValueNodesFromASortedLinkedList::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(DeleteDuplicateValueNodesFromASortedLinkedListTest, removeDuplicates_1) {
    vector<int> expected{1, 2, 3};
    vector<int> source{1, 2, 2, 3, 3, 3};
    auto list = DeleteDuplicateValueNodesFromASortedLinkedList::createList(source);
    auto updatedList = DeleteDuplicateValueNodesFromASortedLinkedList::removeDuplicates(list);
    auto result = DeleteDuplicateValueNodesFromASortedLinkedList::getlist(updatedList);
    EXPECT_EQ(expected, result);
    DeleteDuplicateValueNodesFromASortedLinkedList::deleteList(&updatedList);
}

TEST(DeleteDuplicateValueNodesFromASortedLinkedListTest, removeDuplicates_2) {
    vector<int> expected{1, 2, 3, 4};
    vector<int> source{1, 2, 2, 3, 4};
    auto list = DeleteDuplicateValueNodesFromASortedLinkedList::createList(source);
    auto updatedList = DeleteDuplicateValueNodesFromASortedLinkedList::removeDuplicates(list);
    auto result = DeleteDuplicateValueNodesFromASortedLinkedList::getlist(updatedList);
    EXPECT_EQ(expected, result);
    DeleteDuplicateValueNodesFromASortedLinkedList::deleteList(&updatedList);
}

TEST(DeleteDuplicateValueNodesFromASortedLinkedListTest, removeDuplicates_3) {
    vector<int> expected{};
    vector<int> source{};
    auto list = DeleteDuplicateValueNodesFromASortedLinkedList::createList(source);
    auto updatedList = DeleteDuplicateValueNodesFromASortedLinkedList::removeDuplicates(list);
    auto result = DeleteDuplicateValueNodesFromASortedLinkedList::getlist(updatedList);
    EXPECT_EQ(expected, result);
    DeleteDuplicateValueNodesFromASortedLinkedList::deleteList(&updatedList);
}

#endif