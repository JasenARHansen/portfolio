#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_LINKED_LISTS_INSERT_INTO_SORTED_DOUBLY_LINKED_LIST_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_LINKED_LISTS_INSERT_INTO_SORTED_DOUBLY_LINKED_LIST_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/linked_list/InsertIntoSortedDoublyLinkedList.cpp"  // NOLINT : Ignore .cpp import

TEST(InsertIntoSortedDoublyLinkedListTest, description) {
    testing::internal::CaptureStdout();
    InsertIntoSortedDoublyLinkedList::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(InsertIntoSortedDoublyLinkedListTest, sortedInsert_1) {
    vector<int> expected{1, 2, 3, 4};
    vector<int> source{1, 2, 4};
    auto list = InsertIntoSortedDoublyLinkedList::createList(source);
    auto data = 3;
    auto updatedList = InsertIntoSortedDoublyLinkedList::sortedInsert(list, data);
    auto result = InsertIntoSortedDoublyLinkedList::getlist(updatedList);
    EXPECT_EQ(expected, result);
    InsertIntoSortedDoublyLinkedList::deleteList(&updatedList);
}

TEST(InsertIntoSortedDoublyLinkedListTest, sortedInsert_2) {
    vector<int> expected{1};
    vector<int> source{};
    auto list = InsertIntoSortedDoublyLinkedList::createList(source);
    auto data = 1;
    auto updatedList = InsertIntoSortedDoublyLinkedList::sortedInsert(list, data);
    auto result = InsertIntoSortedDoublyLinkedList::getlist(updatedList);
    EXPECT_EQ(expected, result);
    InsertIntoSortedDoublyLinkedList::deleteList(&updatedList);
}

TEST(InsertIntoSortedDoublyLinkedListTest, sortedInsert_3) {
    vector<int> expected{1, 2};
    vector<int> source{2};
    auto list = InsertIntoSortedDoublyLinkedList::createList(source);
    auto data = 1;
    auto updatedList = InsertIntoSortedDoublyLinkedList::sortedInsert(list, data);
    auto result = InsertIntoSortedDoublyLinkedList::getlist(updatedList);
    EXPECT_EQ(expected, result);
    InsertIntoSortedDoublyLinkedList::deleteList(&updatedList);
}

TEST(InsertIntoSortedDoublyLinkedListTest, sortedInsert_4) {
    vector<int> expected{1, 2};
    vector<int> source{1};
    auto list = InsertIntoSortedDoublyLinkedList::createList(source);
    auto data = 2;
    auto updatedList = InsertIntoSortedDoublyLinkedList::sortedInsert(list, data);
    auto result = InsertIntoSortedDoublyLinkedList::getlist(updatedList);
    EXPECT_EQ(expected, result);
    InsertIntoSortedDoublyLinkedList::deleteList(&updatedList);
}

TEST(InsertIntoSortedDoublyLinkedListTest, sortedInsert_5) {
    vector<int> expected{1, 3, 4, 5, 10};
    vector<int> source{1, 3, 4, 10};
    auto list = InsertIntoSortedDoublyLinkedList::createList(source);
    auto data = 5;
    auto updatedList = InsertIntoSortedDoublyLinkedList::sortedInsert(list, data);
    auto result = InsertIntoSortedDoublyLinkedList::getlist(updatedList);
    EXPECT_EQ(expected, result);
    InsertIntoSortedDoublyLinkedList::deleteList(&updatedList);
}

#endif