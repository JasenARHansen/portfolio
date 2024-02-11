#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_LINKED_LISTS_REVERSE_DOUBLY_LINKED_LIST_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_LINKED_LISTS_REVERSE_DOUBLY_LINKED_LIST_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/linked_list/ReverseDoublyLinkedList.cpp"  // NOLINT : Ignore .cpp import

TEST(HackerRank_ReverseDoublyLinkedListTest, description) {
    testing::internal::CaptureStdout();
    ReverseDoublyLinkedList::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(HackerRank_ReverseDoublyLinkedListTest, reverse_1) {
    vector<int> expected{4, 3, 2, 1};
    vector<int> source{1, 2, 3, 4};
    auto list = ReverseDoublyLinkedList::createList(source);
    auto updatedList = ReverseDoublyLinkedList::reverse(list);
    auto result = ReverseDoublyLinkedList::getlist(updatedList);
    EXPECT_EQ(expected, result);
    ReverseDoublyLinkedList::deleteList(&list);
}

TEST(HackerRank_ReverseDoublyLinkedListTest, reverse_2) {
    vector<int> expected{};
    vector<int> source{};
    auto list = ReverseDoublyLinkedList::createList(source);
    auto updatedList = ReverseDoublyLinkedList::reverse(list);
    auto result = ReverseDoublyLinkedList::getlist(updatedList);
    EXPECT_EQ(expected, result);
    ReverseDoublyLinkedList::deleteList(&list);
}

TEST(HackerRank_ReverseDoublyLinkedListTest, reverse_3) {
    vector<int> expected{1};
    vector<int> source{1};
    auto list = ReverseDoublyLinkedList::createList(source);
    auto updatedList = ReverseDoublyLinkedList::reverse(list);
    auto result = ReverseDoublyLinkedList::getlist(updatedList);
    EXPECT_EQ(expected, result);
    ReverseDoublyLinkedList::deleteList(&list);
}

#endif