#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_LINKED_LISTS_DETECT_CYCLE_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_LINKED_LISTS_DETECT_CYCLE_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/linked_list/DetectCycle.cpp"  // NOLINT : Ignore .cpp import

TEST(HackerRank_DetectCycleTest, description) {
    testing::internal::CaptureStdout();
    DetectCycle::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(HackerRank_DetectCycleTest, has_cycle_1) {
    auto expected = false;
    vector<int> source{1, 2, 4};
    auto head = DetectCycle::createList(source);
    auto result = DetectCycle::has_cycle(head);
    EXPECT_EQ(expected, result);
    DetectCycle::deleteList(&head);
}

TEST(HackerRank_DetectCycleTest, has_cycle_2) {
    auto expected = false;
    vector<int> source{};
    auto head = DetectCycle::createList(source);
    auto result = DetectCycle::has_cycle(head);
    EXPECT_EQ(expected, result);
    DetectCycle::deleteList(&head);
}

TEST(HackerRank_DetectCycleTest, has_cycle_3) {
    auto expected = false;
    vector<int> source{1};
    auto head = DetectCycle::createList(source);
    auto result = DetectCycle::has_cycle(head);
    EXPECT_EQ(expected, result);
    DetectCycle::deleteList(&head);
}

TEST(HackerRank_DetectCycleTest, has_cycle_4) {
    auto expected = true;
    vector<int> source{1, 2, 3};
    auto head = DetectCycle::createList(source);
    // make a cycle
    auto working = head;
    while (working->next != nullptr) {
        working = working->next;
    }
    working->next = head->next;
    auto result = DetectCycle::has_cycle(head);
    EXPECT_EQ(expected, result);
    DetectCycle::deleteList(&head);
}

#endif