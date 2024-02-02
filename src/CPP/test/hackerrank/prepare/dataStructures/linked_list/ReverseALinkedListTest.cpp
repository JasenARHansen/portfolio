#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_LINKED_LISTS_REVERSE_A_LINKED_LIST_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_LINKED_LISTS_REVERSE_A_LINKED_LIST_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/linked_list/ReverseALinkedList.cpp"  // NOLINT : Ignore .cpp import

TEST(ReverseALinkedListTest, description) {
    testing::internal::CaptureStdout();
    ReverseALinkedList::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ReverseALinkedListTest, reverse_1) {
    vector<int> expected{3, 2, 1};
    vector<int> source{1, 2, 3};
    auto list = ReverseALinkedList::createList(source);
    auto updatedList = ReverseALinkedList::reverse(list);
    auto result = ReverseALinkedList::getlist(updatedList);
    EXPECT_EQ(expected, result);
    ReverseALinkedList::deleteList(&updatedList);
}

TEST(ReverseALinkedListTest, reverse_2) {
    vector<int> expected{5, 4, 3, 2, 1};
    vector<int> source{1, 2, 3, 4, 5};
    auto list = ReverseALinkedList::createList(source);
    auto updatedList = ReverseALinkedList::reverse(list);
    auto result = ReverseALinkedList::getlist(updatedList);
    EXPECT_EQ(expected, result);
    ReverseALinkedList::deleteList(&updatedList);
}

TEST(ReverseALinkedListTest, reverse_3) {
    vector<int> expected{};
    vector<int> source{};
    auto list = ReverseALinkedList::createList(source);
    auto updatedList = ReverseALinkedList::reverse(list);
    auto result = ReverseALinkedList::getlist(updatedList);
    EXPECT_EQ(expected, result);
    ReverseALinkedList::deleteList(&updatedList);
}

#endif