#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_LINKED_LISTS_COMPARE_TWO_LINKED_LISTS_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_LINKED_LISTS_COMPARE_TWO_LINKED_LISTS_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/linked_list/CompareTwoLinkedLists.cpp"  // NOLINT : Ignore .cpp import

TEST(CompareTwoLinkedListsTest, description) {
    testing::internal::CaptureStdout();
    CompareTwoLinkedLists::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CompareTwoLinkedListsTest, compare_lists_1) {
    auto expected = false;
    vector<int> source1{1, 2, 3};
    vector<int> source2{1, 2, 3, 4};
    auto head1 = CompareTwoLinkedLists::createList(source1);
    auto head2 = CompareTwoLinkedLists::createList(source2);
    auto result = CompareTwoLinkedLists::compare_lists(head1, head2);
    EXPECT_EQ(expected, result);
    CompareTwoLinkedLists::deleteList(&head1);
    CompareTwoLinkedLists::deleteList(&head2);
}

TEST(CompareTwoLinkedListsTest, compare_lists_2) {
    auto expected = false;
    vector<int> source1{1, 2};
    vector<int> source2{1};
    auto head1 = CompareTwoLinkedLists::createList(source1);
    auto head2 = CompareTwoLinkedLists::createList(source2);
    auto result = CompareTwoLinkedLists::compare_lists(head1, head2);
    EXPECT_EQ(expected, result);
    CompareTwoLinkedLists::deleteList(&head1);
    CompareTwoLinkedLists::deleteList(&head2);
}

TEST(CompareTwoLinkedListsTest, compare_lists_3) {
    auto expected = true;
    vector<int> source1{1, 2};
    vector<int> source2{1, 2};
    auto head1 = CompareTwoLinkedLists::createList(source1);
    auto head2 = CompareTwoLinkedLists::createList(source2);
    auto result = CompareTwoLinkedLists::compare_lists(head1, head2);
    EXPECT_EQ(expected, result);
    CompareTwoLinkedLists::deleteList(&head1);
    CompareTwoLinkedLists::deleteList(&head2);
}

TEST(CompareTwoLinkedListsTest, compare_lists_4) {
    auto expected = true;
    vector<int> source1{};
    vector<int> source2{};
    auto head1 = CompareTwoLinkedLists::createList(source1);
    auto head2 = CompareTwoLinkedLists::createList(source2);
    auto result = CompareTwoLinkedLists::compare_lists(head1, head2);
    EXPECT_EQ(expected, result);
    CompareTwoLinkedLists::deleteList(&head1);
    CompareTwoLinkedLists::deleteList(&head2);
}

TEST(CompareTwoLinkedListsTest, compare_lists_5) {
    auto expected = false;
    vector<int> source1{1};
    vector<int> source2{};
    auto head1 = CompareTwoLinkedLists::createList(source1);
    auto head2 = CompareTwoLinkedLists::createList(source2);
    auto result = CompareTwoLinkedLists::compare_lists(head1, head2);
    EXPECT_EQ(expected, result);
    CompareTwoLinkedLists::deleteList(&head1);
    CompareTwoLinkedLists::deleteList(&head2);
}

#endif