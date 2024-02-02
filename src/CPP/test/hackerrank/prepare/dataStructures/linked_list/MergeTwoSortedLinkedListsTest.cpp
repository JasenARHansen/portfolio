#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_LINKED_LISTS_COMPARE_TWO_LINKED_LISTS_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_LINKED_LISTS_COMPARE_TWO_LINKED_LISTS_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/linked_list/MergeTwoSortedLinkedLists.cpp"  // NOLINT : Ignore .cpp import

TEST(MergeTwoSortedLinkedListsTest, description) {
    testing::internal::CaptureStdout();
    MergeTwoSortedLinkedLists::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(MergeTwoSortedLinkedListsTest, mergeLists_1) {
    vector<int> expected{1, 1, 2, 3, 7};
    vector<int> source1{1, 3, 7};
    vector<int> source2{1, 2};
    auto head1 = MergeTwoSortedLinkedLists::createList(source1);
    auto head2 = MergeTwoSortedLinkedLists::createList(source2);
    auto updatedList = MergeTwoSortedLinkedLists::mergeLists(head1, head2);
    auto result = MergeTwoSortedLinkedLists::getlist(updatedList);
    EXPECT_EQ(expected, result);
    MergeTwoSortedLinkedLists::deleteList(&updatedList);
}

TEST(MergeTwoSortedLinkedListsTest, mergeLists_2) {
    vector<int> expected{};
    vector<int> source1{};
    vector<int> source2{};
    auto head1 = MergeTwoSortedLinkedLists::createList(source1);
    auto head2 = MergeTwoSortedLinkedLists::createList(source2);
    auto updatedList = MergeTwoSortedLinkedLists::mergeLists(head1, head2);
    auto result = MergeTwoSortedLinkedLists::getlist(updatedList);
    EXPECT_EQ(expected, result);
    MergeTwoSortedLinkedLists::deleteList(&updatedList);
}

TEST(MergeTwoSortedLinkedListsTest, mergeLists_3) {
    vector<int> expected{1, 2, 3, 3, 4};
    vector<int> source1{1, 2, 3};
    vector<int> source2{3, 4};
    auto head1 = MergeTwoSortedLinkedLists::createList(source1);
    auto head2 = MergeTwoSortedLinkedLists::createList(source2);
    auto updatedList = MergeTwoSortedLinkedLists::mergeLists(head1, head2);
    auto result = MergeTwoSortedLinkedLists::getlist(updatedList);
    EXPECT_EQ(expected, result);
    MergeTwoSortedLinkedLists::deleteList(&updatedList);
}

TEST(MergeTwoSortedLinkedListsTest, mergeLists_4) {
    vector<int> expected{1, 2, 3};
    vector<int> source1{1, 2, 3};
    vector<int> source2{};
    auto head1 = MergeTwoSortedLinkedLists::createList(source1);
    auto head2 = MergeTwoSortedLinkedLists::createList(source2);
    auto updatedList = MergeTwoSortedLinkedLists::mergeLists(head1, head2);
    auto result = MergeTwoSortedLinkedLists::getlist(updatedList);
    EXPECT_EQ(expected, result);
    MergeTwoSortedLinkedLists::deleteList(&updatedList);
}

TEST(MergeTwoSortedLinkedListsTest, mergeLists_5) {
    vector<int> expected{1, 2, 3};
    vector<int> source1{};
    vector<int> source2{1, 2, 3};
    auto head1 = MergeTwoSortedLinkedLists::createList(source1);
    auto head2 = MergeTwoSortedLinkedLists::createList(source2);
    auto updatedList = MergeTwoSortedLinkedLists::mergeLists(head1, head2);
    auto result = MergeTwoSortedLinkedLists::getlist(updatedList);
    EXPECT_EQ(expected, result);
    MergeTwoSortedLinkedLists::deleteList(&updatedList);
}

#endif