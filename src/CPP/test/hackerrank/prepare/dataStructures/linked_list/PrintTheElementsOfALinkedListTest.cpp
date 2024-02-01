#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_LINKED_LISTS_PrintTheElementsOfALinkedList_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_LINKED_LISTS_DETECT_CYCLE_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/linked_list/PrintTheElementsOfALinkedList.cpp"  // NOLINT : Ignore .cpp import

TEST(PrintTheElementsOfALinkedListTest, description) {
    testing::internal::CaptureStdout();
    PrintTheElementsOfALinkedList::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(PrintTheElementsOfALinkedListTest, has_cycle_1) {
    auto expected = "Animals array size: 192\n"
                    "Animals row size: 96\n"
                    "Animal size: 32\n"
                    "Animals Row 0: Fox Cat Dog\n"
                    "Animals Row 1: Mouse Squirrel Parrot\n";
    vector<int> source{1, 2, 4};
    auto head = PrintTheElementsOfALinkedList::createList(source);
    testing::internal::CaptureStdout();
    PrintTheElementsOfALinkedList::printLinkedList(head);
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
}

#endif