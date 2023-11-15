#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_LINKED_LISTS_FIND_MERGE_POINT_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_LINKED_LISTS_FIND_MERGE_POINT_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/linkedlist/FindMergePoint.cpp"  // NOLINT : Ignore .cpp import

TEST(FindMergePointTest, description) {
    testing::internal::CaptureStdout();
    FindMergePoint::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(FindMergePointTest, findMergeNode_1) {
    auto expected = 2;
    vector<int> source1{1, 2, 3};
    vector<int> source2{1};
    auto head1 = FindMergePoint::createList(source1);
    auto head2 = FindMergePoint::createList(source2);
    head2->next = head1->next;
    auto result = FindMergePoint::findMergeNode(head1, head2);
    EXPECT_EQ(expected, result);
}

TEST(FindMergePointTest, findMergeNode_2) {
    auto expected = 3;
    vector<int> source1{1, 2, 3};
    vector<int> source2{1};
    auto head1 = FindMergePoint::createList(source1);
    auto head2 = FindMergePoint::createList(source2);
    head2->next = head1->next->next;
    auto result = FindMergePoint::findMergeNode(head1, head2);
    EXPECT_EQ(expected, result);
}

#endif