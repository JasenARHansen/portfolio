#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_LINKED_LISTS_PRINT_THE_ELEMENTS_OF_A_LINKED_LIST_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_LINKED_LISTS_PRINT_THE_ELEMENTS_OF_A_LINKED_LIST_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/linked_list/PrintTheElementsOfALinkedList.cpp"  // NOLINT : Ignore .cpp import

TEST(HackerRank_PrintTheElementsOfALinkedListTest, description) {
    testing::internal::CaptureStdout();
    PrintTheElementsOfALinkedList::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(HackerRank_PrintTheElementsOfALinkedListTest, printLinkedList_1) {
    auto expected = "1\n"
                    "2\n"
                    "4\n";
    vector<int> source{1, 2, 4};
    auto head = PrintTheElementsOfALinkedList::createList(source);
    testing::internal::CaptureStdout();
    PrintTheElementsOfALinkedList::printLinkedList(head);
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
    PrintTheElementsOfALinkedList::deleteList(&head);
}

TEST(HackerRank_PrintTheElementsOfALinkedListTest, printLinkedList_2) {
    auto expected = "16\n"
                    "13\n";
    vector<int> source{16, 13};
    auto head = PrintTheElementsOfALinkedList::createList(source);
    testing::internal::CaptureStdout();
    PrintTheElementsOfALinkedList::printLinkedList(head);
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
    PrintTheElementsOfALinkedList::deleteList(&head);
}

TEST(HackerRank_PrintTheElementsOfALinkedListTest, printLinkedList_3) {
    auto expected = "17\n"
                    "19\n"
                    "5\n"
                    "12\n";
    vector<int> source{17, 19, 5, 12};
    auto head = PrintTheElementsOfALinkedList::createList(source);
    testing::internal::CaptureStdout();
    PrintTheElementsOfALinkedList::printLinkedList(head);
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
    PrintTheElementsOfALinkedList::deleteList(&head);
}

#endif